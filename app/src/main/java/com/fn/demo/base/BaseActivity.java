package com.fn.demo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.fn.demo.R;

import lib.core.ExActivity;
import lib.core.bean.TitleBar;
import lib.core.utils.ExAcitivityCollector;
import lib.core.utils.ExLogUtil;

/**
 * Created by yayun.xia on 2017/6/6.
 */

public class BaseActivity extends ExActivity {

    /**
     * Method ：在 OnCreate 前执行
     *
     * @param savedInstanceState
     */
    @Override
    protected void exProcessOnCreateBefore(Bundle savedInstanceState) {

    }

    /**
     * Method_拦截 ：对 OnCreate 拦截处理
     *
     * @param savedInstanceState
     * @return 是否拦截 OnCreate
     */
    @Override
    protected boolean exInterceptOnCreate(Bundle savedInstanceState) {
        return false;
    }

    /**
     * Method_初始化布局 ：对展示布局进行设置
     *
     * @return 布局资源 ID
     */
    @Override
    protected int exInitLayout() {
        return 0;
    }

    @Override
    protected boolean exInterceptInit() {
        return false;
    }

    /**
     * Method_初始化控件参数： 在该方法中，可以对已绑定的控件数据初始化
     */
    @Override
    protected void exInitView() {

        ExLogUtil.d("BaseActivity----->当前活动的页面："+getClass().getSimpleName());
        ExAcitivityCollector.addActivity(this);
    }

    /**
     * Method_初始化控件参数： 在该方法中，可以对已绑定的控件数据初始化
     */
    @Override
    protected void applicationBackground() {

    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    @Override
    protected void exInitToolbar(TitleBar toolbar) {
        super.exInitToolbar(toolbar);
        toolbar.setNavigationIcon(R.drawable.menu_back);
        toolbar.getToolbarShadow().setBackgroundColor(getResources().getColor(R.color.color_line));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ExAcitivityCollector.removeActivity(this);
    }

    protected void lauch(Context context,Class cls){
        startActivity(new Intent(context,cls));
    }
}
