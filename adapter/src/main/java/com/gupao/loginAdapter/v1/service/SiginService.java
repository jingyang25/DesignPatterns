package com.gupao.loginAdapter.v1.service;

import com.gupao.loginAdapter.Member;
import com.gupao.loginAdapter.ResultMsg;
import com.gupao.loginAdapter.v3.adapters.LoginAdapter;
import com.gupao.loginAdapter.v3.adapters.LoginForTelAdapter;

//转接头
public class SiginService {

    public ResultMsg regist(String username,String password){

        return new ResultMsg(200,"注册成功", new Member());
    }

    public ResultMsg login(String username, String password){

        LoginAdapter adapter = new LoginForTelAdapter();
        return null;
    }
}
