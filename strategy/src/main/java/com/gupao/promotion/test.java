package com.gupao.promotion;

public class test {

    public static void main(String [] args){

        PromotionActivity promotionActivity = new PromotionActivity( new ConponStrategy());

        PromotionActivity promotionActivity1 = new PromotionActivity(new CashbackStrategy());


        promotionActivity.excute();
        promotionActivity1.excute();
    }
}
