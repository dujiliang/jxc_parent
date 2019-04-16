package com.jxc.common.util.httpclient.request;


import com.jxc.common.util.httpclient.exception.MethodNotSupportException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.util.CharsetUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Request for multi-part form data
 * mailto:xiaobenma020@gmail.com
 */
public class MultiPartFormRequest extends BaseEntityRequest {

    private Map<String, Object> parts;

    public MultiPartFormRequest(String url, RequestMethod method) throws MethodNotSupportException {
        super(url, method);
        this.parts = new LinkedHashMap<>();
    }

    public MultiPartFormRequest(String url) throws MethodNotSupportException {
        super(url);
        this.parts = new LinkedHashMap<>();
    }

    @Override
    public HttpEntity getEntity()  {
        try {
            Charset charset = CharsetUtils.get(getRequestCharset());
            //Run in browser-compatible mode to prevent file names from being garbled.
            MultipartEntityBuilder builder = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .setCharset(charset);
            parts.forEach((key, value) -> {
                if (null != value && value instanceof File) { //for file
                    FileBody fileBody = new FileBody((File) value);
                    builder.addPart(key, fileBody);
                } else {
                    StringBody stringBody = new StringBody(null == value ? "" : value.toString()
                            , ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
                    builder.addPart(key, stringBody);
                }
            });
            return builder.build();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Charset '" + getRequestCharset() + "' is unsupported!");
        }
    }

    public MultiPartFormRequest addPart(String name, Object body) {
        parts.put(name, body);
        return this;
    }

    public MultiPartFormRequest addParts(Map<String, Object> parts) {
        if (null != parts && !parts.isEmpty()) {
            this.parts.putAll(parts);
        }
        return this;
    }

    public MultiPartFormRequest removePart(String name) {
        parts.remove(name);
        return this;
    }

    @Override
    protected MultiPartFormRequest checkMethod(RequestMethod method) throws MethodNotSupportException {
        if (null == method) {
            throw new MethodNotSupportException(null);
        }
        if (!RequestMethod.GET.equals(method) && !RequestMethod.POST.equals(method) && !RequestMethod.HEAD.equals(method) && !RequestMethod.OPTIONS.equals(method)) {
            throw new MethodNotSupportException(method.name());
        }
        return this;
    }

    public Map<String, Object> getParts() {
        return parts;
    }
}
