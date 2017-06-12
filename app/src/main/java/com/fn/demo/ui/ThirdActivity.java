package com.fn.demo.ui;

import com.fn.demo.R;
import com.fn.demo.base.BaseActivity;

import lib.core.bean.TitleBar;
import lib.core.utils.ExAcitivityCollector;
import lib.core.utils.ExLogUtil;

public class ThirdActivity extends BaseActivity {

    /**
     * Method_初始化布局 ：对展示布局进行设置
     *
     * @return 布局资源 ID
     */
    @Override
    protected int exInitLayout() {
        return R.layout.activity_third;
    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    @Override
    protected void exInitToolbar(TitleBar toolbar) {
        super.exInitToolbar(toolbar);
        toolbar.setTitle("ThirdActivity");
    }

    /**
     * Method_初始化控件参数： 在该方法中，可以对已绑定的控件数据初始化
     */
    @Override
    protected void exInitView() {
        super.exInitView();
        ExLogUtil.d("ThirdActivity -----> Task id is: "+getTaskId());
    }

    @Override
    protected void back() {
        super.back();
        ExAcitivityCollector.finishAll();
    }
}
