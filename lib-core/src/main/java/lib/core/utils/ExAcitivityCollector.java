package lib.core.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yayun.xia on 2017/6/9.
 */

public class ExAcitivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        if(activities != null){
            activities.add(activity);
        }

    }

    public static void removeActivity(Activity activity){
        if(!ExCommonUtil.isEmpty(activities)){
            activities.remove(activity);
        }
    }

    public static void finishAll(){
        if(!ExCommonUtil.isEmpty(activities)){
            for (Activity activity : activities){
                if(!activity.isFinishing()){
                    activity.finish();
                }
            }
            activities.clear();
            android.os.Process.killProcess(android.os.Process.myPid());
        }

    }
}
