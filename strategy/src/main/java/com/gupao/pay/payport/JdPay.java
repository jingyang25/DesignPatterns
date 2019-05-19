package com.gupao.pay.payport;

public class JdPay extends Payment {
    @Override
    public String getName() {
        return "京东";
    }

    @Override
    protected double queryBlance(String uid) {
        return 500;
    }
}
