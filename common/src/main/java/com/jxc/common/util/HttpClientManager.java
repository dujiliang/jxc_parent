package com.jxc.common.util;

import com.jxc.common.util.httpclient.exception.MethodNotSupportException;
import com.jxc.common.util.httpclient.request.BaseEntityRequest;
import com.jxc.common.util.httpclient.request.Request;
import com.jxc.common.util.httpclient.response.Response;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class HttpClientManager {

    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_CONNECT_TIMEOUT = 120*1000;
    private static final int MAX_SOCKET_TIMEOUT = 120*1000;
    private static final int MAX_CONNECT_REQUEST_TIMEOUT = 120*1000;
    private static final int MAX_TOTAL = 1000;

    private static HttpClientManager httpClientManager;
    
    /**
     * 提供单例模式
     * @return
     */
    public static HttpClientManager getInstance(){
       if(httpClientManager==null) 
          synchronized (HttpClientManager.class) {
             if(httpClientManager==null) httpClientManager=new HttpClientManager();
          }
       return httpClientManager;
    }
    
    public  HttpClientManager() {
        // connecting pools
        connMgr = new PoolingHttpClientConnectionManager();

        //pool size
        connMgr.setMaxTotal(MAX_TOTAL);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();

        // timeout unit : milliseconds
        configBuilder.setConnectTimeout(MAX_CONNECT_TIMEOUT);
        configBuilder.setSocketTimeout(MAX_SOCKET_TIMEOUT);
        configBuilder.setConnectionRequestTimeout(MAX_CONNECT_REQUEST_TIMEOUT);

        // check availability
        //configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }

    /**
     * Do http request
     * @param request request object
     * @return response object
     */
    public Response doRequest(Request request) {
        try {
            HttpRequestBase baseRequest = request.getHttpRequest();

            Header[] headers = request.getAllHeaders();
            if (null != headers && headers.length > 0) {
                baseRequest.setHeaders(headers);
            }
            baseRequest.setConfig(requestConfig);
            if (request instanceof BaseEntityRequest) { //to post entity
                ((HttpEntityEnclosingRequestBase) baseRequest).setEntity(((BaseEntityRequest) request).getEntity());
            }

            return toXHttpResponse(baseRequest, request.getResponseDefaultCharset(), request.isUseSSL());
        } catch (IOException e) {
            e.printStackTrace();
            return getErrorXResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (MethodNotSupportException mnse) {
            return getErrorXResponse(HttpServletResponse.SC_METHOD_NOT_ALLOWED, mnse.getMessage());
        }
    }

    private  Response getErrorXResponse(int code, String errorMsg) {
        return new Response(code, errorMsg, null, null, null);
    }

    private  Response toXHttpResponse(HttpUriRequest request, String defaultCharset
            , boolean useSSL) throws IOException {

        try (CloseableHttpClient httpClient = useSSL
                ? getHttpsClient()
                : HttpClients.createDefault()) {
            HttpResponse response = httpClient.execute(request);
            Response result = new Response(response.getStatusLine().getStatusCode(), response.getAllHeaders());
            HttpEntity entity = response.getEntity();
            if (entity != null) {

                //content encoding
                String charset = (null == entity.getContentEncoding()) ? defaultCharset : entity.getContentEncoding().getValue();
                result.setContentEncoding(charset);

                //content type
                try {
                    result.setResponseText(EntityUtils.toString(entity, defaultCharset));
                } finally {
                    try {
                        EntityUtils.consume(response.getEntity());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }
    }

    private  CloseableHttpClient getHttpsClient() {
        return HttpClients.custom()
                .setSSLSocketFactory(createSSLConnSocketFactory())
                .setConnectionManager(connMgr)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    //create SSLConnectionSocketFactory to trust all
    private  SSLConnectionSocketFactory createSSLConnSocketFactory() {
        try {
            SSLContext sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(null, (TrustStrategy) (chain, authType) -> true)
                    .build();
            return new SSLConnectionSocketFactory(sslcontext,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            e.printStackTrace();
        }
        return null;
    }
}
