package com.example.admin.exam.callback;

import com.example.admin.exam.bean.DbBean;

import java.util.List;

public interface DbCallBack {
    void onSuccess(List<DbBean> dbBean);
    void onFail(String msg);
}
