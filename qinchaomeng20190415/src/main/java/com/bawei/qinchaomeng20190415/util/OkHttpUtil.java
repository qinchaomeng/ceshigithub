package com.bawei.qinchaomeng20190415.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Time:2019/4/15
 * Author:秦超蒙
 * Description:
 */
public class OkHttpUtil {
    static OkHttpUtil util;
    OkHttpClient okHttpClient;

    //网络判断
    public boolean isConnected(Context context){
        if (context!=null){
            ConnectivityManager service =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = service.getActiveNetworkInfo();
            if (info!=null){
               return info.isConnected();
            }
        }
        return false;
    }


    //构造方法私有化
    private OkHttpUtil(){
        okHttpClient=new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request();
                Response response=chain.proceed(request);
                return response;
            }
        }).build();
    }
    //单例模式
    public static OkHttpUtil getInstance(){
        if (util==null){
            util=new OkHttpUtil();
        }
        return util;
    }

    //请求数据
    public void PostData(String url,String username,String pswd, Callback callback){
        FormBody.Builder builder=new FormBody.Builder();
        builder.add("username",username);
        builder.add("pswd",pswd);

        RequestBody body=builder.build();

        Request request=new Request.Builder().url(url)
                .post(body)
                .build();

        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
        }
    }

