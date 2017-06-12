package com.fn.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fn.demo.R;

import java.util.List;

import bean.TestClass;

/**
 * Created by yayun.xia on 2017/6/12.
 */

public class TestClassAdapter extends BaseAdapter {

    private Context mContext;
    private List<TestClass> mList;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public TestClassAdapter(Context context){
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TestClass testClass = mList.get(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = inflater.inflate(R.layout.list_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.tv_title);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.tvTitle.setText(testClass.title);
        viewHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.itemClick(testClass);
            }
        });
        return view;
    }

    class ViewHolder{
        TextView tvTitle;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public void setList(List<TestClass> list) {
        this.mList = list;
    }

    public List<TestClass> getList() {
        return mList;
    }

    public void add(TestClass t) {
        this.mList.add(t);
        notifyDataSetChanged();
    }

    public void addAll(List<TestClass> list) {
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        this.mList.remove(position);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mList.clear();
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void itemClick(TestClass testClass);
    }
}
