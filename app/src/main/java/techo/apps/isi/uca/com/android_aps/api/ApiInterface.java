package techo.apps.isi.uca.com.android_aps.api;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import techo.apps.isi.uca.com.android_aps.models.AccessToken;
import techo.apps.isi.uca.com.android_aps.models.Person;
import techo.apps.isi.uca.com.android_aps.models.Student;
import techo.apps.isi.uca.com.android_aps.models.UserModel;

/**
 * Created by macyarin on 10/4/18.
 */

public interface ApiInterface {
    //Make all the request to the endpoints
    //Method GET

    @GET("GET/People")
    Call<List<Person>> getPeople(@Header("Authorization") String authorization);

    @GET("/GET/Students?id={id}")
    Call<List<Student>> getStudentById(@Query("id") int id, @Header("Authorization") String Authorization);
    
    //Method Post

    @POST("auth")
    Call<AccessToken> loginUser(@Body UserModel userModel);


}
