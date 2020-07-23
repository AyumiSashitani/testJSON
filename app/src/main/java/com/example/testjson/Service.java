package com.example.testjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import javax.security.auth.callback.Callback;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Service implements Callback {
    //通信処理
    public Data execute() throws IOException {
        //Client作成
        OkHttpClient client = new OkHttpClient();

        // request作成
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .get()
                .build();

        //通信処理
        Response response = client.newCall(request).execute();

        //取得結果のBodyを文字列として取り出し
        final String jsonStr = response.body().string();

        //パース処理
        ObjectMapper mapper = new ObjectMapper();
        Data data = mapper.readValue(jsonStr, Data.class);

        return data;
    }
}
