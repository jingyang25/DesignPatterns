package com.gupao.promotion;

public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {

        System.out.println("拼团，满20人成团");
    }
}
