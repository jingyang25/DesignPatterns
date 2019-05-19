package com.gupao.pay.payport;

public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBlance(String uid) {
        return 400;
    }
}
