package com.fn.demo.constant;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lib.core.utils.ExToastUtil;

/**
 * Created by yayun.xia on 2017/6/8.
 */

public class TaskHelper {

    public static void doSth(@TaskStatus int status){
        switch (status){
            case TaskStatus.UN_KNOW:
                //do something
                ExToastUtil.showLong("TaskStatus.UN_KNOW---"+status);
                break;
            case TaskStatus.UN_START:
                ExToastUtil.showLong("TaskStatus.UN_START---"+status);
                break;
            case TaskStatus.PROGRESSING:
                ExToastUtil.showLong("TaskStatus.PROGRESSING---"+status);
                break;
            case TaskStatus.COMPLETED:
                ExToastUtil.showLong("TaskStatus.COMPLETED---"+status);
                break;
            default:
                ExToastUtil.showLong("Other---"+status);
                break;
        }
    }

    @IntDef({
            TaskStatus.UN_KNOW,
            TaskStatus.UN_START,
            TaskStatus.PROGRESSING,
            TaskStatus.COMPLETED
    })

    @Retention(RetentionPolicy.SOURCE)
    public @interface TaskStatus {
        int UN_KNOW = -1;
        int UN_START = 0;
        int PROGRESSING = 1;
        int COMPLETED = 2;
    }
}
