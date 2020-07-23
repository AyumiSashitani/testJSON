package com.example.testjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import javax.security.auth.callback.Callback;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Service implements Callback {
    //通信処理
    public Data execute() throws IOException, JSONException {
        //Client作成
        OkHttpClient client = new OkHttpClient();

        // request作成
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .get()
                .build();
        Response response = client.newCall(request).execute();

        //取得結果のBodyを文字列として取り出し
        final String jsonStr = response.body().string();

        ObjectMapper mapper = new ObjectMapper();
        Data data = mapper.readValue(jsonStr, Data.class);

        //Dataオブジェクト生成
//        Data data = new Data();

        //取得結果をDataにセット
//        data.setUserId(json.getString("userId"));
//        data.setId(json.getString("id"));
//        data.setBody(json.getString("title"));
//        data.setTitle(json.getString("body"));

        return data;
    }
}
