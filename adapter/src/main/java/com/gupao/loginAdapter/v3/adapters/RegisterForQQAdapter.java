package com.gupao.loginAdapter.v3.adapters;

import com.gupao.loginAdapter.ResultMsg;

public class RegisterForQQAdapter extends RegisterAdapter {
    @Override
    boolean support(Object adapter) {
        return adapter instanceof RegisterAdapter;
    }

    @Override
    ResultMsg login(String id, Object adapter) {
        return null;
    }
}
