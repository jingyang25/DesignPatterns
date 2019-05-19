package com.gupao.promotion;

//促销活动
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void excute(){
        promotionStrategy.doPromotion();
    }
}
