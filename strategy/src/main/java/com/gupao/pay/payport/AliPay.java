package com.gupao.pay.payport;

public class AliPay extends Payment {


    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBlance(String uid) {

        return 900;
    }
}
