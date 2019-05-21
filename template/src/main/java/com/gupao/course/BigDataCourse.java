package com.gupao.course;

public class BigDataCourse extends NetworkCourse {

    private boolean needHomeworkFlag = false;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    void checkHomework() {

        System.out.println("检查大数据作业");
    }

    protected boolean needHomework(){
        return this.needHomeworkFlag;
    }
}
