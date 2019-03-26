package techo.apps.isi.uca.com.android_aps.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macyarin on 10/4/18.
 */

public class Api {
    public static final int OK_CODE = 200 ;
    private final static String URL = "http://165.98.12.158:8080/PSEUCA/api/v1.0";

    public static String getBase() {
        return URL + "/";
    }

    public static ApiInterface instance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.getBase())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }
}
