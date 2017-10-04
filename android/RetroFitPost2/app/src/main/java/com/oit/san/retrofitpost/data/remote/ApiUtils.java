package com.oit.san.retrofitpost.data.remote;

/**
 * Created by OPTLPTP119 on 06-09-2017.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://profile.getsandbox.com";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}