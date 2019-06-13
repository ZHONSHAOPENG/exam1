package com.example.admin.exam.model;

import com.example.admin.exam.bean.DbBean;
import com.example.admin.exam.callback.DbCallBack;
import com.example.admin.exam.utils.DbHelper;

import java.util.List;

public class ModelQuery implements ImpModelQuery {
    @Override
    public void getData(DbCallBack callBack) {
        List<DbBean> query = DbHelper.getDbHelper().query();
        if (query!=null&&query.size()>0){
            callBack.onSuccess(query);
        }else {
            callBack.onFail("返回数据为空");
        }
    }
}
