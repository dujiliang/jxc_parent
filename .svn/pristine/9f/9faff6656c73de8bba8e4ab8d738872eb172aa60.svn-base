package com.jxc.short_message.util;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jxc.short_message.exception.JerseyServerException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Component
public class JerseyUtil {

    static Logger log = LoggerFactory.getLogger(JerseyUtil.class);

    public static String username = "api";
    public static String password = "key-c6d78daa8c1dba43c023138125d0cd8a";
    public static String url = "http://sms-api.luosimao.com/v1/send.json";

    public static String send(MultivaluedMapImpl formData) throws Exception{
        // just replace key here
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(username,password));
        WebResource webResource = client.resource(url);

        ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED ).
                post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        if(status != 200){
            String error_msg = "螺丝帽官方服务器异常";
            log.error(error_msg);
            throw new JerseyServerException(error_msg);
        }
        return textEntity;
    }


}
