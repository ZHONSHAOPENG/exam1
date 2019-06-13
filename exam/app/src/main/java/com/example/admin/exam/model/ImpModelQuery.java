package com.example.admin.exam.model;

import com.example.admin.exam.bean.DbBean;
import com.example.admin.exam.callback.DbCallBack;

public interface ImpModelQuery {
    void getData(DbCallBack callBack);
}
