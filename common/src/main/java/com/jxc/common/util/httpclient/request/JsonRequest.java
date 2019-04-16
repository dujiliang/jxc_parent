package com.jxc.common.util.httpclient.request;


import com.alibaba.fastjson.JSONObject;
import com.jxc.common.util.httpclient.exception.MethodNotSupportException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Request for Json
 * mailto:xiaobenma020@gmail.com
 *
 */
public class JsonRequest extends BaseEntityRequest {

    private Object jsonObject;

    private static final String JSON_CONTENT_TYPE = "application/json";

    public JsonRequest(String url, RequestMethod method) throws MethodNotSupportException {
        super(url, method);
    }

    public JsonRequest(String url) throws MethodNotSupportException {
        super(url);
    }

    public Object getJsonObject() {
        return jsonObject;
    }

    public JsonRequest setJsonObject(Object jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    @Override
    protected JsonRequest checkMethod(RequestMethod method) throws MethodNotSupportException {
        if (null == method) {
            throw new MethodNotSupportException(null);
        }
        if (!RequestMethod.GET.equals(method) && !RequestMethod.POST.equals(method) && !RequestMethod.HEAD.equals(method) && !RequestMethod.OPTIONS.equals(method)) {
            throw new MethodNotSupportException(method.name());
        }
        return this;
    }

    @Override
    public HttpEntity getEntity() {
        StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(jsonObject), getRequestCharset());
        stringEntity.setContentEncoding(getResponseDefaultCharset());
        stringEntity.setContentType(JSON_CONTENT_TYPE);
        return stringEntity;
    }
}
