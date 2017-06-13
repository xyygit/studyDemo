package com.fn.demo.test;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fn.demo.R;
import com.fn.demo.base.BaseActivity;
import com.fn.demo.db.MyDatabaseHelper;
import com.fn.demo.db.SharePreferenceHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import lib.core.annotation.inject.ViewInject;
import lib.core.bean.TitleBar;
import lib.core.utils.ExToastUtil;

/**
 * Created by yayun.xia on 2017/6/12.
 */

public class DataBaseActivity extends BaseActivity implements View.OnClickListener{
    @ViewInject(R.id.btn_save)
    private Button btnSave;
    @ViewInject(R.id.btn_read)
    private Button btnRead;
    @ViewInject(R.id.edt_date)
    private EditText editText;
    @ViewInject(R.id.edt_user)
    private EditText edtUser;
    @ViewInject(R.id.edt_pwd)
    private EditText edtPwd;
    @ViewInject(R.id.btn_sp_save)
    private Button btnSpSave;
    @ViewInject(R.id.btn_sp_read)
    private Button btnSpRead;
    @ViewInject(R.id.btn_db_create)
    private Button btnDbCreate;
    @ViewInject(R.id.btn_db_add)
    private Button btnDbAdd;
    @ViewInject(R.id.btn_db_update)
    private Button btnDbUpdate;
    @ViewInject(R.id.btn_db_del)
    private Button btnDbDel;
    @ViewInject(R.id.btn_db_query)
    private Button btnDbQurey;

    private MyDatabaseHelper dbHelper;
    private String dbBook = "BookStore.db";

    /**
     * Method_初始化布局 ：对展示布局进行设置
     *
     * @return 布局资源 ID
     */
    @Override
    protected int exInitLayout() {
        return R.layout.activity_database;
    }

    /**
     * Method_初始化控件参数： 在该方法中，可以对已绑定的控件数据初始化
     */
    @Override
    protected void exInitView() {
        super.exInitView();

        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);

        btnSpRead.setOnClickListener(this);
        btnSpSave.setOnClickListener(this);

        btnDbCreate.setOnClickListener(this);
        btnDbAdd.setOnClickListener(this);
        btnDbUpdate.setOnClickListener(this);
        btnDbDel.setOnClickListener(this);
        btnDbQurey.setOnClickListener(this);

        dbHelper = new MyDatabaseHelper(this,dbBook,null,1);
    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    @Override
    protected void exInitToolbar(TitleBar toolbar) {
        super.exInitToolbar(toolbar);
        toolbar.setTitle("数据库测试");
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_save:
                save();
                break;
            case R.id.btn_read:
                ExToastUtil.showLong(load());
                break;
            case R.id.btn_sp_save:
                SharePreferenceHelper.getInstance().putString("username",edtUser.getText().toString());
                SharePreferenceHelper.getInstance().putString("pwd",edtPwd.getText().toString());
                ExToastUtil.showLong("保存成功！");
                break;
            case R.id.btn_sp_read:
                ExToastUtil.showLong("user:"+SharePreferenceHelper.getInstance().getString("username")+
                                      "\n"+"pwd:"+SharePreferenceHelper.getInstance().getString("pwd"));
                break;
            case R.id.btn_db_create:
                dbHelper.getWritableDatabase();
                break;
            case R.id.btn_db_add:
                break;
            case R.id.btn_db_update:
                break;
            case R.id.btn_db_del:
                break;
            case R.id.btn_db_query:
                break;

            default:
                break;
        }
    }

    private void save(){

        String data = "Data to save";
        if(editText.getText() != null){
            data = editText.getText().toString();
        }

        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
            ExToastUtil.showLong("保存成功！");
            editText.getText().clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ExToastUtil.showLong("保存失败！"+e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            ExToastUtil.showLong("保存失败！"+e.toString());
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                ExToastUtil.showLong("异常！"+e.toString());
            }
        }
    }

    private String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null){
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save();
    }
}
