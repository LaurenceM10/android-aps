package techo.apps.isi.uca.com.android_aps.api;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import techo.apps.isi.uca.com.android_aps.models.UserModel;

/**
 * Created by macyarin on 10/4/18.
 */

public interface ApiInterface {
    //Make all the request to the endpoints
    //Method GET

    //Method Post

    @POST("auth")
    Call<UserModel> loginUser(@Body UserModel userModel);


}
