package com.gupao.pay;

import com.gupao.pay.payport.PayStrategy;

public class PayStrategyTest {
    public static void main(String [] args){

        Order order = new Order("1","2018031101200009",324);

        order.pay(PayStrategy.ALI_PAY);

        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
