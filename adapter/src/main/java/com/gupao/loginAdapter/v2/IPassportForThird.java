package com.gupao.loginAdapter.v2;

import com.gupao.loginAdapter.ResultMsg;

public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForTelphone(String phone,String code);

    ResultMsg loginForRegist(String username,String passport);
}
