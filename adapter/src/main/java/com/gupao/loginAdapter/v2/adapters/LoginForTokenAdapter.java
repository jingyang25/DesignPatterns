package com.gupao.loginAdapter.v2.adapters;

import com.gupao.loginAdapter.ResultMsg;

public class LoginForTokenAdapter implements LoginAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
