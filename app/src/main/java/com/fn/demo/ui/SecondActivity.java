package com.fn.demo.ui;

import android.content.Intent;
import android.view.View;

import com.fn.demo.R;
import com.fn.demo.base.BaseActivity;

import lib.core.bean.TitleBar;
import lib.core.utils.ExLogUtil;

public class SecondActivity extends BaseActivity {
    /**
     * Method_初始化布局 ：对展示布局进行设置
     *
     * @return 布局资源 ID
     */
    @Override
    protected int exInitLayout() {
        return R.layout.activity_second;
    }

    /**
     * Method_初始化控件参数： 在该方法中，可以对已绑定的控件数据初始化
     */
    @Override
    protected void exInitView() {
        super.exInitView();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
        ExLogUtil.d("SecondActivity -----> Task id is: "+getTaskId());
    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    @Override
    protected void exInitToolbar(TitleBar toolbar) {
        super.exInitToolbar(toolbar);
        toolbar.setTitle("SecondActivity");
    }
}
