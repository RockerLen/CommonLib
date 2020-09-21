package com.common.library.util;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CommonInterceptor implements Interceptor {

    private static final boolean IS_LOG = true;

    private static final String TAG = "REQUEST";
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final Gson gson = new Gson();

    @Override
    public Response intercept(Chain chain) throws IOException {
        rebuildRequest(chain.request());

        return null;
    }

    /**
     * 添加公共请求参数，或加解密
     *
     * @param request
     */
    public void rebuildRequest(Request request) {
        logRequest(request);
    }

    private void logRequest(Request request) {
        String url = request.url().toString();
        String method = request.method();

        if (IS_LOG) {
            if (GET.equals(method)) {
                Log.w(TAG, "GET_URL:" + url);
            } else if (POST.equals(method)) {
                RequestBody originalRequestBody = request.body();
                HashMap<String, String> params = new HashMap<>();
                if (originalRequestBody instanceof FormBody) {
                    FormBody requestBody = (FormBody) request.body();
                    int fieldSize = requestBody == null ? 0 : requestBody.size();
                    if (fieldSize > 0) {
                        for (int i = 0; i < fieldSize; i++) {
                            params.put(requestBody.name(i), requestBody.value(i));
                        }
                    }
                }else if (originalRequestBody instanceof MultipartBody) {
                    MultipartBody requestBody = (MultipartBody) request.body();
                    int fieldSize = requestBody == null ? 0 : requestBody.size();
                    if (fieldSize > 0){
                        for (int i = 0; i < fieldSize; i++) {
                            MultipartBody.Part part = requestBody.part(i);
                            MediaType mediaType = part.body().contentType();
                        }
                    }
                }else {

                }
                Log.w(TAG, "POST_URL:" + url + ", PARAMS:" + gson.toJson(params));
            }
        }
    }
}
