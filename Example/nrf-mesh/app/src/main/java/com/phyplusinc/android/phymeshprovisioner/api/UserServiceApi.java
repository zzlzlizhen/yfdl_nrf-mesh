package com.phyplusinc.android.phymeshprovisioner.api;

import com.phyplusinc.android.phymeshprovisioner.entity.UserEntity;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface UserServiceApi {
    //不包含基地址
    //Bean是返回数据的实体类
    //@QueryMap代表传入多个参数 不确定个数 以Map<key,value>形式
    @POST("sys/user/login")
    @FormUrlEncoded
    Call<UserEntity> login(@Field("username") String username,
                           @Field("password") String password);
    @GET("/sys/user/userList")
    Flowable<List<UserEntity>> getUserList(Map<String, Object> params);
}
