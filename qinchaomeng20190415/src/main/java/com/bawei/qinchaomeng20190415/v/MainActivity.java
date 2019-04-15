package com.bawei.qinchaomeng20190415.v;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.qinchaomeng20190415.R;
import com.bawei.qinchaomeng20190415.contract.ContractInteface;
import com.bawei.qinchaomeng20190415.p.MyPresenter;
import com.bawei.qinchaomeng20190415.util.OkHttpUtil;

public class MainActivity extends AppCompatActivity implements ContractInteface.ProductInteface {
ContractInteface.PresenterInteface presenterInteface;
    private EditText edit_phone,edit_pswd;
    private TextView text_zhuce;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化Id
         edit_phone = findViewById(R.id.edit_phone);
         edit_pswd=findViewById(R.id.edit_pswd);
         text_zhuce = findViewById(R.id.text_zhuce);
         btn_login = findViewById(R.id.btn_login);

         presenterInteface=new MyPresenter(this);

        OkHttpUtil util=OkHttpUtil.getInstance();
       if(util.isConnected(this)) {
           Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
        }else {
           Toast.makeText(this, "没网", Toast.LENGTH_SHORT).show();
       }
         //点击注册
        text_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistActivity.class);
                startActivity(intent);
            }
        });
        //点击登陆
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoness = edit_phone.getText().toString();
                String pswdss = edit_pswd.getText().toString();
                if (phoness.isEmpty()&&pswdss.isEmpty()){
                    Toast.makeText(MainActivity.this, "手机号或密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    presenterInteface.toLogin(phoness,pswdss);
                }

            }
        });
    }

    @Override
    public void Login(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, TuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void Regist(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
