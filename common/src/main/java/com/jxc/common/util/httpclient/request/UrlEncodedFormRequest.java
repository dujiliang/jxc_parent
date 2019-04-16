package com.jxc.common.util.httpclient.request;


import com.jxc.common.util.httpclient.exception.MethodNotSupportException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Request for UrlEncodedForm
 * mailto:xiaobenma020@gmail.com
 */
public class UrlEncodedFormRequest extends BaseEntityRequest {

    private Map<String, Object> params;

    public UrlEncodedFormRequest(String url, RequestMethod method) throws MethodNotSupportException {
        super(url, method);
        params = new LinkedHashMap<>();
    }

    public UrlEncodedFormRequest(String url) throws MethodNotSupportException {
        super(url);
        params = new LinkedHashMap<>();
    }

    @Override
    public HttpEntity getEntity() {
        List<NameValuePair> pairList = new ArrayList<>(params.size());
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                    .getValue().toString());
            pairList.add(pair);
        }

        return new UrlEncodedFormEntity(pairList, Charset.forName(getRequestCharset()));
    }

    public UrlEncodedFormRequest addParam(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public UrlEncodedFormRequest addParams(Map<String, Object> params) {
        if (null != params && !params.isEmpty()) {
            this.params.putAll(params);
        }
        return this;
    }

    public UrlEncodedFormRequest removeParam(String name) {
        params.remove(name);
        return this;
    }

    @Override
    protected UrlEncodedFormRequest checkMethod(RequestMethod method) throws MethodNotSupportException {
        if (null == method) {
            throw new MethodNotSupportException(null);
        }
        if (!RequestMethod.GET.equals(method) && !RequestMethod.POST.equals(method) && !RequestMethod.HEAD.equals(method) && !RequestMethod.OPTIONS.equals(method)) {
            throw new MethodNotSupportException(method.name());
        }
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
