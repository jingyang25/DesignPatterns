package com.gupao.loginAdapter.v3.adapters;

import com.gupao.loginAdapter.ResultMsg;

public abstract class LoginAdapter {

    abstract boolean support(Object adapter);

    abstract ResultMsg login(String id, Object adapter);


}
