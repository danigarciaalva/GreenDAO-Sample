package io.dflabs.grenndaosample;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import dflabs.io.dao.DaoMaster;
import dflabs.io.dao.DaoSession;
import dflabs.io.dao.PostDao;

/**
 * Created by danielgarcia on 7/12/15.
 */
public class DAOApp extends Application{

    public static PostDao getPostDao() {
        return postDao;
    }

    static PostDao postDao;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "post-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        postDao = daoSession.getPostDao();
    }
}
