package falcons.atiqamtia.fun.login.retrofit.json.retrofitlogin.Api;

import falcons.atiqamtia.fun.login.retrofit.json.retrofitlogin.Models.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Atiq on 12/27/2016.
 */

public interface Api {

    @FormUrlEncoded
    @POST("Login/Check")
    Call<LoginResponse> checkLogin(@Field("email") String email, @Field("password") String password);

}
