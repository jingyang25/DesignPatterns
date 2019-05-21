package com.gupao.loginAdapter.v3.adapters;

import com.gupao.loginAdapter.ResultMsg;

public class LoginForQQAdapter extends LoginAdapter{
    @Override
    boolean support(Object adapter) {
        return  adapter instanceof LoginForQQAdapter;
    }

    @Override
    ResultMsg login(String id, Object adapter) {
        return null;
    }
}
