package com.android.fragmentviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private TextView tvTou,tvBai,tvNews,tvJY,tvZX;
    private ImageView ivT,ivB,ivN,ivJ,ivZ;
    private ViewPager mPager;
    private MyAdapter adapter;
    private List<ImageView> ivList;
    private List<TextView> tvList;
    private List<Fragment> fgList;
    private int preposition=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
        setListener();
    }

    private void setListener() {
        tvTou.setOnClickListener(this);
        tvBai.setOnClickListener(this);
        tvNews.setOnClickListener(this);
        tvJY.setOnClickListener(this);
        tvZX.setOnClickListener(this);
    }

    private void setData() {
        ivList=new ArrayList<>();
        ivList.add(ivT);
        ivList.add(ivB);
        ivList.add(ivN);
        ivList.add(ivJ);
        ivList.add(ivZ);
        tvList=new ArrayList<>();
        tvList.add(tvTou);
        tvList.add(tvBai);
        tvList.add(tvNews);
        tvList.add(tvJY);
        tvList.add(tvZX);
        fgList=new ArrayList<>();
        for (int i = 0; i <ivList.size() ; i++) {
            fgList.add(new MyFragment());
        }
        adapter=new MyAdapter(getSupportFragmentManager(),fgList);
        mPager.setAdapter(adapter);
    }

    private void initView() {
        tvTou= (TextView) findViewById(R.id.txtToutiao);
        tvBai= (TextView) findViewById(R.id.txtBaike);
        tvNews= (TextView) findViewById(R.id.txtData);
        tvJY= (TextView) findViewById(R.id.txtJingying);
        tvZX= (TextView) findViewById(R.id.txtZixun);
        ivT= (ImageView) findViewById(R.id.ivToutiao);
        ivB= (ImageView) findViewById(R.id.ivBaike);
        ivN= (ImageView) findViewById(R.id.ivData);
        ivJ= (ImageView) findViewById(R.id.ivJingying);
        ivZ= (ImageView) findViewById(R.id.ivZixun);
        mPager= (ViewPager) findViewById(R.id.vpShow);
        mPager.setOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtToutiao:
                mPager.setCurrentItem(0);
                break;
            case R.id.txtBaike:
                mPager.setCurrentItem(1);
                break;
            case R.id.txtData:
                mPager.setCurrentItem(2);
                break;
            case R.id.txtJingying:
                mPager.setCurrentItem(3);
                break;
            case R.id.txtZixun:
                mPager.setCurrentItem(4);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ivList.get(position).setBackgroundColor(Color.RED);
        ivList.get(preposition).setBackgroundColor(Color.WHITE);
        tvList.get(position).setTextColor(Color.BLUE);
        tvList.get(preposition).setTextColor(Color.BLACK);
        preposition=position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
