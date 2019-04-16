package com.jxc.common.util.httpclient.request;


import com.jxc.common.util.httpclient.exception.MethodNotSupportException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.*;
import org.apache.http.message.BasicHeader;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Request with body, support request method "GET", "HEAD", "OPTIONS"
 * mailto:xiaobenma020@gmail.com
 */
public class Request {
    private String url;
    private RequestMethod method;
    private Map<String, Object> urlParams; //param in query string
    private Map<String, Header> headerMap;
    private String requestCharset = "UTF-8";
    private String responseDefaultCharset = "UTF-8";
    private boolean useSSL;


    public Request(String url, RequestMethod method) throws MethodNotSupportException {
        this.url = url;
        checkMethod(method);
        this.method = method;
        urlParams =  new LinkedHashMap<>();
        headerMap = new LinkedHashMap<>();
    }

    public Request(String url) throws MethodNotSupportException {
        this(url, RequestMethod.GET);
    }

    //Check request method, "GET", "HEAD", "OPTIONS" is supported
    protected Request checkMethod(RequestMethod method) throws MethodNotSupportException {
        if (null == method) {
            throw new MethodNotSupportException(null);
        }
        if (!RequestMethod.GET.equals(method) && !RequestMethod.HEAD.equals(method) && !RequestMethod.OPTIONS.equals(method)) {
            throw new MethodNotSupportException(method.name());
        }
        return this;
    }

    public String getUrl() {
        return url;
    }


    public Map<String, Object> getUrlParams() {
        return urlParams;
    }

    public Request addUrlParam(String name, Object value) {
        urlParams.put(name, value);
        return this;
    }

    public Request addUrlParams(Map<String, Object> urlParams) {
        if (null != urlParams && !urlParams.isEmpty()) {
            this.urlParams.putAll(urlParams);
        }
        return this;
    }

    public Request removeUrlParam(String name) {
        urlParams.remove(name);
        return this;
    }

    public Request addHeaders(Map<String, String> headers) {
        if (null != headers && !headers.isEmpty()) {
            headers.forEach(this::addHeader);
        }
        return this;
    }

    public Request addHeader(String name, String value) {
        headerMap.put(name, new BasicHeader(name, value));
        return this;
    }

    public Request removeHeader(String name) {
        headerMap.remove(name);
        return this;
    }

    public Header getHeader(String name) {
        return headerMap.get(name);
    }

    public Header[] getAllHeaders() {
        return headerMap.values().toArray(new Header[headerMap.size()]);
    }

    public String getRequestCharset() {
        return requestCharset;
    }

    public Request setRequestCharset(String requestCharset) {
        this.requestCharset = requestCharset;
        return this;
    }

    public String getResponseDefaultCharset() {
        return responseDefaultCharset;
    }

    public Request setResponseDefaultCharset(String responseDefaultCharset) {
        this.responseDefaultCharset = responseDefaultCharset;
        return this;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public Request setMethod(RequestMethod method) throws MethodNotSupportException {
        checkMethod(method);
        this.method = method;
        return this;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public Request setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
        return this;
    }

    public String getQueryString() {
        if (urlParams.isEmpty()) {
            return "";
        }
        StringBuilder queryStr = new StringBuilder();
        urlParams.forEach((key, value) -> {
            try {
                queryStr.append("&").append(key)
                        .append("=")
                        .append(null == value ? "" : URLEncoder.encode(value.toString(), requestCharset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
        return queryStr.toString().substring(1);
    }

    public String getUrlWithQueryString() {
        String apiUrl = url;
        String queryStr = getQueryString();
        if (!StringUtils.isBlank(queryStr)) {
            apiUrl = apiUrl + (apiUrl.contains("?") ? "&" : "?") + queryStr;
        }
        return apiUrl;
    }


    public HttpRequestBase getHttpRequest() throws MethodNotSupportException {
        String apiUrl = getUrlWithQueryString();
        switch (method) {
            case GET:
                return new HttpGet(apiUrl);
            case POST:
                return new HttpPost(apiUrl);
            case HEAD:
                return new HttpHead(apiUrl);
            case OPTIONS:
                return new HttpOptions(apiUrl);
            case PUT:
                return new HttpPut(apiUrl);
            case PATCH:
                return new HttpPatch(apiUrl);
        }
        throw new MethodNotSupportException(method.name());
    }

}
