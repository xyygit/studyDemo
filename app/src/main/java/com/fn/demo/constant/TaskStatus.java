package com.fn.demo.constant;

/**
 * Created by yayun.xia on 2017/6/8.
 */
public enum TaskStatus {

    UN_KNOW(-1,"未知","#84807f"),
    UN_START(0,"未开始","#e2d512"),
    PROGRESSING(1,"进行中","#12ea2f"),
    COMPLETED(2,"已完成","#c30910");

    public int mStatus;
    public String mDesc;
    public String mColor;

    TaskStatus(int status, String desc, String color){
        this.mStatus = status;
        this.mDesc = desc;
        this.mColor = color;
    }

    public static TaskStatus getTaskStatus(int status){
        for (TaskStatus taskStatus : values()){
            if(status == taskStatus.mStatus){
                return taskStatus;
            }
        }
        return UN_KNOW;
    }

}
