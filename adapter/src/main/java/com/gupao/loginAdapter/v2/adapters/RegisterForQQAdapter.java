package com.gupao.loginAdapter.v2.adapters;

import com.gupao.loginAdapter.ResultMsg;

public class RegisterForQQAdapter implements  RegistAdapter,LoginAdapter{


    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }

    @Override
    public boolean support(Object adapter) {
        return false;
    }


}
