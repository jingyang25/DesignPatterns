package com.gupao.promotion;

public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无优惠,没有折扣");
    }
}
