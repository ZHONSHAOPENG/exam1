package com.example.admin.exam.view;

import com.example.admin.exam.bean.DbBean;

import java.util.List;

public interface DbView {

    void onSuccess(List<DbBean> dbBean);
    void onFail(String msg);
}
