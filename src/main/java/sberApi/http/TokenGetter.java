package sberApi.http;

import java.io.IOException;

import okhttp3.*;
import sberApi.parsers.JsonParserr;

public class TokenGetter {
    private static int count;
    public static String getToken(){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=rezohb&scope=https://api.sberbank.ru/escrow");
        Request request = new Request.Builder()
                .url("https://dev.api.sberbank.ru/ru/prod/tokens/v2/oauth")
                .post(body)
                .addHeader("x-ibm-client-id", "0a46d7fc-bc05-4a38-ab1d-355b13c5ba32")
                .addHeader("authorization", "Basic MGE0NmQ3ZmMtYmMwNS00YTM4LWFiMWQtMzU1YjEzYzViYTMyOmVFNmdKMXBZM25DMnBUNGxNMnhVN2lYOGFKN25VNGlXMWZVMGRYMWZRM21KMXhQMmtY")
                .addHeader("rquid", "1e10c472a8be11ebbcbc0242ac130002")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("accept", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful() && count < 3){
                count ++;
                try {
                    System.out.println(response.body().string());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getToken();
            } else if (!response.isSuccessful()) System.out.println("так и не удалось получить токен");
            return JsonParserr.parser(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
