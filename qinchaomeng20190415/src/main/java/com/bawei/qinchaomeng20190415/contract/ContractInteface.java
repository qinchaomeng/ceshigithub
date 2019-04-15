package com.bawei.qinchaomeng20190415.contract;

/**
 * Time:2019/4/15
 * Author:秦超蒙
 * Description:
 */
public interface ContractInteface {

    //view层
    public interface ProductInteface{
        //登陆
        public void Login(String str);
        //注册
        public void Regist(String str);
    }
    //P层
    public interface PresenterInteface{
        //登陆方法
        public void toLogin(String username,String pswd);
        //注册方法
        public void toRegist(String username,String pswd);
    }

}
