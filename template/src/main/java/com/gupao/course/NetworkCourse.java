package com.gupao.course;

//模板模式有一个或者多个未实现方法
public abstract class NetworkCourse {

    protected final void createCourse(){

        this.postPreResource();

        this.createPPT();

        this.liveVideo();

        this.postNote();

        if(needHomework()){
            checkHomework();
        }
    }

    final void postNote() {
        System.out.println("提交课件和笔记");
    }

    final void liveVideo() {
        System.out.println("直播授课");
    }


    final void createPPT() {
        System.out.println("创建备课PPT");
    }

    final  void postPreResource(){
        System.out.println("分发预习资料");
    }


    abstract void checkHomework();

    protected boolean needHomework(){

        return false;
    }


}
