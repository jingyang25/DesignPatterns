package com.gupao.loginAdapter.v2;

import com.gupao.loginAdapter.ResultMsg;
import com.gupao.loginAdapter.v1.service.SiginService;
import com.gupao.loginAdapter.v2.adapters.LoginAdapter;
import com.gupao.loginAdapter.v2.adapters.LoginForQQAdapter;
import com.gupao.loginAdapter.v2.adapters.LoginForTelAdapter;

public class PassportForThirdAdapter extends SiginService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }



    @Override
    public ResultMsg loginForTelphone(String phone, String code) {
        return processLogin(phone, LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {

        super.regist(username,passport);
        return  super.login(username,passport);
    }


    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {

        try {
            LoginAdapter adapter = clazz.newInstance();

            if (adapter.support(adapter)) {
                return adapter.login(key, adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
