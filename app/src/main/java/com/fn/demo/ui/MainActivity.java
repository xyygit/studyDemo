package com.fn.demo.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.fn.demo.R;
import com.fn.demo.adapter.TestClassAdapter;
import com.fn.demo.base.BaseActivity;
import com.fn.demo.test.BroadCastActivity;
import com.fn.demo.test.DataBaseActivity;
import com.fn.demo.test.PercentLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import bean.TestClass;
import lib.core.bean.TitleBar;
import lib.core.utils.ExToastUtil;

public class MainActivity extends BaseActivity implements TestClassAdapter.OnItemClickListener{

    private ListView list;
    private List<TestClass> mClsList = new ArrayList<>();
    Class[] classArray = {
            FirstActivity.class,
            PercentLayoutActivity.class
    };
    @Override
    protected void exProcessOnCreateBefore(Bundle savedInstanceState) {
        super.exProcessOnCreateBefore(savedInstanceState);
    }

    @Override
    protected int exInitLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean exInterceptOnCreate(Bundle savedInstanceState) {
        return super.exInterceptOnCreate(savedInstanceState);
    }

    @Override
    protected boolean exInterceptInit() {
        return super.exInterceptInit();
    }

    @Override
    protected void exInitView() {
        super.exInitView();
        list = (ListView) findViewById(R.id.list);
//        String[] data = getResources().getStringArray(R.array.data);
//        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_item,data);
//        list.setAdapter(adapter);

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position < classArray.length){
//                    lauch(MainActivity.this,classArray[position]);
//                }
//            }
//        });
        initTestClass();
        TestClassAdapter adapter = new TestClassAdapter(this);
        adapter.setList(mClsList);
        adapter.setOnItemClickListener(this);
        list.setAdapter(adapter);
    }

    private void initTestClass() {
        mClsList.add(new TestClass(FirstActivity.class, "activity启动模式"));
        mClsList.add(new TestClass(PercentLayoutActivity.class, "百分比布局"));
        mClsList.add(new TestClass(BroadCastActivity.class, "自定义广播"));
        mClsList.add(new TestClass(DataBaseActivity.class, "数据库测试"));

    }

    @Override
    protected void applicationBackground() {
        super.applicationBackground();
    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    @Override
    protected void exInitToolbar(TitleBar toolbar) {
        super.exInitToolbar(toolbar);
        toolbar.setTitle("测试");
        toolbar.inflateMenu(R.menu.menu_main);
        Menu menu = toolbar.getMenu();
        MenuItem menuHome = menu.findItem(R.id.action_settings);
        MenuItem menuShare = menu.findItem(R.id.action_share);

        menuHome.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                ExToastUtil.showLong("1111111111");
                return false;
            }
        });

        menuShare.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                ExToastUtil.showLong("22222222222");
                return false;
            }
        });
    }

    @Override
    public void itemClick(TestClass testClass) {
        lauch(MainActivity.this,testClass.cls);
    }
}
