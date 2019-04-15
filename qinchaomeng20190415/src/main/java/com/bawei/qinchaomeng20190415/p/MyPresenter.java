package com.bawei.qinchaomeng20190415.p;

import com.bawei.qinchaomeng20190415.contract.ContractInteface;
import com.bawei.qinchaomeng20190415.m.MyModel;

/**
 * Time:2019/4/15
 * Author:秦超蒙
 * Description:
 */
public class MyPresenter implements ContractInteface.PresenterInteface {
    ContractInteface.ProductInteface productInteface;
    MyModel myModel;

    public MyPresenter(ContractInteface.ProductInteface productInteface) {
        this.productInteface = productInteface;
        myModel=new MyModel();
    }

    @Override
    public void toLogin(String username, String pswd) {
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                productInteface.Login((String) o);
            }
        });
myModel.PostRequest("http://172.17.8.100/small/user/v1/login",username,pswd);
    }

    @Override
    public void toRegist(String username, String pswd) {
myModel.setMyCallBack(new MyModel.MyCallBack() {
    @Override
    public void success(Object o) {
        productInteface.Regist((String) o);
    }
});
myModel.PostRequest("http://172.17.8.100/small/user/v1/register",username,pswd);
    }
}
