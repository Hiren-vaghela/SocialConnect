package org.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import org.glassfish.jersey.internal.util.collection.StringIgnoreCaseKeyComparator;
import org.json.simple.JSONValue;

public class FlockSender {

    private static CloseableHttpClient client = null;
    private static String url = "https://api.flock.com/hooks/sendMessage/88e00f4f-eb77-407f-9f6d-a79565178efe";

    FlockSender() throws IOException {
        client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        String user = "Hiren";
        String message = "Hey!";

        Map obj=new HashMap();
        obj.put("user", user);
        obj.put("message", message);
        String jsonText = JSONValue.toJSONString(obj);
        StringEntity entity = new StringEntity(jsonText);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);

        client.close();
    }

}