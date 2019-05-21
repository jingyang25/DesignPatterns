package com.gupao.loginAdapter.v3.adapters;

import com.gupao.loginAdapter.ResultMsg;


public class LoginForTelAdapter extends LoginAdapter{
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {

        return null;
    }
}
