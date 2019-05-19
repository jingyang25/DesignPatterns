package com.gupao.pay.payport;

public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBlance(String uid) {
        return 1000;
    }
}
