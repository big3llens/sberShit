package sberApi.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ResidentialComplexGetter {
    public static String getResidentialComplex (String token) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://dev.api.sberbank.ru/ru/prod/v2/escrow/residential-complex")
                .get()
                .addHeader("x-ibm-client-id", "0a46d7fc-bc05-4a38-ab1d-355b13c5ba32")
//                Сюда подставлять токен
                .addHeader("authorization", "Bearer " + token)
                .addHeader("x-introspect-rquid", "1e10c472a8be11ebbcbc0242ac130002")
                .addHeader("accept", "application/xml")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
