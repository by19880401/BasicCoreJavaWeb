package org.hicola;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.niws.client.http.RestClient;

import java.net.URI;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/9/2
 * @
 */
public class client {
    public static void main(String [] args) throws Exception {
        // 获取客户端（如果获取不到，可通过getNamedClient方法自动创建）
        RestClient client = (RestClient) ClientFactory.getNamedClient("simple-client");
        // 创建request对象
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("/getPerson")).build();// 写入将要访问的接口

        // 模拟多次访问
        for (int i = 0; i < 10; i++) {
            // 创建response对象
            HttpResponse response = client.executeWithLoadBalancer(request);
            // 接收请求结果
            String json = response.getEntity(String.class);
            // 打印结果
            System.out.println(json);
        }
    }
}
