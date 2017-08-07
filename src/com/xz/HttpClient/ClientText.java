package com.xz.HttpClient;


import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Administrator on 2017/8/7.
 */
public class ClientText {
    public static void main(String[] args) throws Exception {
        // 使用 HttpClient.createDefault 创建httpClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URI url= new URIBuilder("https://www.baidu.com/").build();
        HttpGet get=new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()==200){
            System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
        }
        response.close();
        httpClient.close();
    }
}
