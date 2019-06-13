package com.example.admin.exam.utils;

import com.example.admin.exam.bean.DbBean;
import com.example.admin.exam.dao.DaoMaster;
import com.example.admin.exam.dao.DaoSession;
import com.example.admin.exam.dao.DbBeanDao;

import java.util.List;

public class DbHelper {

    private static volatile DbHelper dbHelper;
    private final DbBeanDao mDbBeanDao;

    public static DbHelper getDbHelper() {
        if (dbHelper==null){
            synchronized (DbHelper.class){
                if (dbHelper == null) {
                    dbHelper=new DbHelper();
                }
            }
        }
        return dbHelper;
    }

    public DbHelper(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(DbApp.getDbApp(), "hot.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mDbBeanDao = daoSession.getDbBeanDao();
    }


    public void insert(DbBean dbBean){
        mDbBeanDao.insertOrReplace(dbBean);
    }

    public List<DbBean> query(){
        return mDbBeanDao.queryBuilder().list();
    }

}
