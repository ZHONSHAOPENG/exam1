package com.example.admin.exam.presenter;

import com.example.admin.exam.bean.DbBean;
import com.example.admin.exam.callback.DbCallBack;
import com.example.admin.exam.model.ImpModelQuery;
import com.example.admin.exam.view.DbView;

import java.util.List;

public class PresenterQuery implements ImpPersenterQuery, DbCallBack {

    private ImpModelQuery mImpModelQuery;
    private DbView mDbView;

    public PresenterQuery(ImpModelQuery impModelQuery, DbView dbView) {
        mImpModelQuery = impModelQuery;
        mDbView = dbView;
    }

    @Override
    public void getData() {
        if (mImpModelQuery!=null){
            mImpModelQuery.getData(this);
        }
    }

    @Override
    public void onSuccess(List<DbBean> dbBean) {
        if (mDbView!=null){
            mDbView.onSuccess(dbBean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mDbView!=null){
            mDbView.onFail(msg);
        }
    }
}
