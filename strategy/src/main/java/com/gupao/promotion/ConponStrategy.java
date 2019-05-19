package com.gupao.promotion;

public class ConponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {

        System.out.println("领取优惠券，课程价格直接减优惠券面值抵扣");
    }
}
