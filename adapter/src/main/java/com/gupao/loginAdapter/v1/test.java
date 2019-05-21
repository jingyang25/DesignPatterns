package com.gupao.loginAdapter.v1;

import com.gupao.loginAdapter.v1.service.SinginForThirdService;

public class test {

    public static void main(String [] args){

        SinginForThirdService service = new SinginForThirdService();
        service.login("tom","123456");
        service.loginForQQ("heferkjdg");
        service.loginForWechat("oyuiewgferlo");

    }
}
