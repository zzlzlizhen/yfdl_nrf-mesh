package com.phyplusinc.android.phymeshprovisioner.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProvider;

import com.phyplusinc.android.phymeshprovisioner.MainActivity;
import com.phyplusinc.android.phymeshprovisioner.R;
import com.phyplusinc.android.phymeshprovisioner.api.RetrofitHelper;
import com.phyplusinc.android.phymeshprovisioner.api.UserServiceApi;
import com.phyplusinc.android.phymeshprovisioner.di.Injectable;
import com.phyplusinc.android.phymeshprovisioner.entity.UserEntity;
import com.phyplusinc.android.phymeshprovisioner.provisioners.dialogs.DialogFragmentProvisionerName;
import com.phyplusinc.android.phymeshprovisioner.viewmodels.LoginViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements Injectable {
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    @BindView(R.id.container)
    CoordinatorLayout container;
    UserServiceApi userServiceApi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
        init();
    }
    private void init(){
        final EditText login_et_username = findViewById(R.id.login_et_username);
        final EditText login_et_pwd = findViewById(R.id.login_et_pwd);
        final Button login_btn_ok = findViewById(R.id.login_btn_ok);


        final LoginViewModel viewModel = new ViewModelProvider(LoginActivity.this, mViewModelFactory).get(LoginViewModel.class);

        login_btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = login_et_username.getText().toString();
                String password = login_et_pwd.getText().toString();
                if(("").equals(username)){
                    Toast.makeText(LoginActivity.this,"请输入用户名",Toast.LENGTH_LONG).show();
                    return;
                }
                if(("").equals(password)){
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_LONG).show();
                    return;
                }
                userServiceApi = RetrofitHelper.getInstance().create(UserServiceApi.class);

                userServiceApi.login(username,password).enqueue(new Callback<UserEntity>() {
                    @Override
                    public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                        UserEntity userEntity = response.body();
                        if(userEntity.getCode() == 400){
                            Toast.makeText(LoginActivity.this,userEntity.getMsg(),Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(userEntity.getUser()!=null){
                            viewModel.getNetworkLiveData().observe(LoginActivity.this, meshNetworkLiveData -> {
                                if(meshNetworkLiveData != null && meshNetworkLiveData.getMeshNetwork() != null) {
                                    navigateActivity();
                                }
                            });
                        }
                    }
                    @Override
                    public void onFailure(Call<UserEntity> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

            }
        });
    }
    private void navigateActivity(){
        final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        // We don't want the splash screen to be interrupted
    }
}
