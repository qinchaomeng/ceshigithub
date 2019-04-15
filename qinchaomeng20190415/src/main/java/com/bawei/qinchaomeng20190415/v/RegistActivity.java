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

public class RegistActivity extends AppCompatActivity implements ContractInteface.ProductInteface {

    private EditText regist_phone,regist_pswd;
    private TextView regist_login;
    private Button regist_zhuce;
ContractInteface.PresenterInteface presenterInteface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        presenterInteface=new MyPresenter(this);
        //初始化Id
         regist_phone = findViewById(R.id.regist_phone);
        regist_pswd=findViewById(R.id.regist_pswd);
         regist_login = findViewById(R.id.regist_login);
        regist_zhuce = findViewById(R.id.regist_zhuce);

        //点击跳转
        regist_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //点击注册
        regist_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonsee = regist_phone.getText().toString();
                String pswdee = regist_pswd.getText().toString();
                presenterInteface.toRegist(phonsee,pswdee);
            }
        });
    }

    @Override
    public void Login(String str) {

    }

    @Override
    public void Regist(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
