package com.gupao.loginAdapter.v1.service;

import com.gupao.loginAdapter.ResultMsg;

public class SinginForThirdService extends SiginService{

    public ResultMsg loginForQQ(String openId){

        //

        return loginForRegist(openId,null);

    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        return null;
    }

    public ResultMsg loginForTelphone(String telphone,String code){
        return null;
    }


    public  ResultMsg loginForRegist(String username, String password) {

        super.regist(username,null);
        return super.login(username,null);
    }
}
