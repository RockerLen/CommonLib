package com.my.library.test;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("machine/apk/version")
    Call<VersionBack> updateVersion(@Field("code") String deviceNumber, @Field("version") String versionCode);
}
