package com.gupao.loginAdapter.v2.adapters;

import com.gupao.loginAdapter.ResultMsg;

public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id,Object adapter);

}
