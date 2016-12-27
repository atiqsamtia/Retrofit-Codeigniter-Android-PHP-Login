package falcons.atiqamtia.fun.login.retrofit.json.retrofitlogin.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import falcons.atiqamtia.fun.login.retrofit.json.retrofitlogin.Api.Api;
import falcons.atiqamtia.fun.login.retrofit.json.retrofitlogin.Api.ApiClient;
import falcons.atiqamtia.fun.login.retrofit.json.retrofitlogin.Models.LoginResponse;
import falcons.atiqamtia.fun.login.retrofit.json.retrofitlogin.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Login(View v){

        EditText email = (EditText) findViewById(R.id.editText);
        EditText password = (EditText) findViewById(R.id.editText2);

        if(email.getText().length() < 1 || password.getText().length() < 6){
            Toast.makeText(this,"Check fields",Toast.LENGTH_SHORT).show();
            return;
        }



        Call<LoginResponse> login = api.checkLogin(email.getText().toString(),password.getText().toString());

        showProgress("Please wait");
        login.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                dismissProgress();
                if(response.isSuccessful()){
                    LoginResponse r = response.body();
                    if(r.isLogin()){
                        showToast("Hello " + r.getName() + " You have successfully logged in");
                    } else {
                        showToast(r.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                dismissProgress();
                showAlert("Your Internet is down Kindly try later.");

            }
        });



    }
}
