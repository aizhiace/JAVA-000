package com.czh.geek.homework.nio;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * @author Caizh
 * @date 2020/11/4
 */
public class CustomOkhttp {

    public static void main(String[] args) {
        try {
            Response response = get("http://localhost:8901/hello?name=xy");

            ResponseBody body = response.body();
            byte[] bytes = body.bytes();
            String s = new String(bytes);
            System.out.println("响应信息： " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Response get(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response;
    }

    public static Response post(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(new FormEncodingBuilder()
                        .add("pageNo", "0")  //参数1
                        .add("pageSize", "10")  //参数二
                        .build())
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

}
