package com.example.admin.exam;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.admin.exam.adapter.MainPagerAdapter;
import com.example.admin.exam.bean.DbBean;
import com.example.admin.exam.fragment.AttentionFragment;
import com.example.admin.exam.fragment.HotFragment;
import com.example.admin.exam.model.ModelQuery;
import com.example.admin.exam.presenter.PresenterQuery;
import com.example.admin.exam.utils.DbHelper;
import com.example.admin.exam.view.DbView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HotFragment());
        fragments.add(new AttentionFragment());

        ArrayList<String> title = new ArrayList<>();
        title.add("热门");
        title.add("关注");

        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments, title);

        mVp.setAdapter(mainPagerAdapter);

        mTab.setupWithViewPager(mVp);

        for (int i = 0; i < 30; i++) {
            DbBean dbBean1 = new DbBean();
            dbBean1.setTitle("标题"+i);
            dbBean1.setContent("内容："+i);
            dbBean1.setHtmls("https://www.wanandroid.com/project/list/1/json?cid=294");
            dbBean1.setImg("https://www.wanandroid.com/resources/image/pc/default_project_img.jpg");
            DbHelper.getDbHelper().insert(dbBean1);
        }


    }

}
