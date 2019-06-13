package com.example.admin.exam.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.exam.R;
import com.example.admin.exam.WebActivity;
import com.example.admin.exam.adapter.RlvHotAdapter;
import com.example.admin.exam.bean.DbBean;
import com.example.admin.exam.model.ModelQuery;
import com.example.admin.exam.presenter.PresenterQuery;
import com.example.admin.exam.utils.DbHelper;
import com.example.admin.exam.view.DbView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment implements DbView {

    private View view;
    private RecyclerView mRlv;
    private PresenterQuery mPresenterQuery;
    private ArrayList<DbBean> mList1;
    private RlvHotAdapter mRlvHotAdapter;
    private List<DbBean> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        mPresenterQuery = new PresenterQuery(new ModelQuery(), this);
        initData();
        initView(inflate);
        return inflate;
    }

    private void initData() {
        mPresenterQuery.getData();
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = DbHelper.getDbHelper().query();
        mList1 = new ArrayList<>();
        mRlvHotAdapter = new RlvHotAdapter(getContext(), mList);
        mRlv.setAdapter(mRlvHotAdapter);
        mRlvHotAdapter.setOnClickListener(new RlvHotAdapter.setOnCLickListener() {
            @Override
            public void onListener(View v, int position) {
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra("link",mList.get(position).getHtmls());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(List<DbBean> dbBean) {
        if (dbBean!=null){
            //mList.addAll(dbBean);
//            Log.d("tag",dbBean+"");
////            mRlvHotAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(String msg) {
        Log.d("tag",msg);
    }
}
