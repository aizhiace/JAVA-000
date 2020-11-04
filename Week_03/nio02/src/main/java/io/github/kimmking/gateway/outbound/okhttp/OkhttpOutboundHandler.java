package io.github.kimmking.gateway.outbound.okhttp;

import com.squareup.okhttp.*;
import io.netty.handler.codec.http.HttpHeaders;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OkhttpOutboundHandler {

    public static Response get(String url, HttpHeaders httpHeaders) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder().url(url);

        List<Map.Entry<String, String>> entries = httpHeaders.entries();
        entries.forEach(entry -> requestBuilder.addHeader(entry.getKey(), entry.getValue()));

        Request request = requestBuilder.build();

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
