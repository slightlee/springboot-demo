package com.demain.test;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 以 EchartsData 示例中 getBar() 数据为例，将生成的Echarts数据转为base64图片
 *
 * @author demain_lee
 * @since  2022/12/28
 */
public class EchartData2Base64 {


    public static void main(String[] args) throws IOException {

        String jsonData = "{\"xAxis\":[{\"type\":\"category\",\"data\":[\"Matcha Latte\",\"Milk Tea\",\"Cheese Cocoa\",\"Walnut Brownie\"]}],\"yAxis\":[{\"type\":\"value\"}],\"tooltip\":{\"trigger\":\"item\"},\"legend\":{},\"series\":[{\"type\":\"bar\",\"name\":\"2020\",\"data\":[43.3,83.1,86.4,72.4]},{\"type\":\"bar\",\"name\":\"2021\",\"data\":[85.8,73.4,65.2,53.9]},{\"type\":\"bar\",\"name\":\"2022\",\"data\":[93.7,55.1,82.5,39.1]}]}";


        // PhantomJS 服务器地址
        String url = "http://localhost:9090";
        Map<String, String> map = new HashMap<>();
        jsonData = jsonData.replaceAll("\\s+", "").replaceAll("\"", "'");
        map.put("opt", jsonData);
        String resultData = post(url, map, "utf-8");
        System.out.println(resultData);

    }

    public static String post(String url, Map<String, String> map, String encoding) throws IOException {
        String body = "";

        // 创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        // 装填参数
        List<NameValuePair> nvp = new ArrayList<>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvp.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        // 设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvp, encoding));

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        // 获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            // 按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        // naps
        response.close();
        return body;
    }
}
