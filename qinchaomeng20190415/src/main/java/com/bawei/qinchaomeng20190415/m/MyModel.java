package com.bawei.qinchaomeng20190415.m;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import com.bawei.qinchaomeng20190415.util.OkHttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Time:2019/4/15
 * Author:秦超蒙
 * Description:
 */
public class MyModel {
    MyCallBack myCallBack;

    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String json= (String) msg.obj;
            try {
                JSONObject object=new JSONObject(json);
                String s = object.getString("message");
                myCallBack.success(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    //获取数据
    public void PostRequest(String url,String username,String pswd){
        OkHttpUtil util=OkHttpUtil.getInstance();
        util.PostData(url, username, pswd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
String json=response.body().string();
                Message message=new Message();
                message.obj=json;
                handler.sendMessage(message);
            }
        });
    }


    public void setMyCallBack(MyCallBack myCallBack){
        this.myCallBack=myCallBack;
    }

    public interface  MyCallBack{
        void success(Object o);
    }
}
