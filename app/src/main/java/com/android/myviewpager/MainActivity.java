package com.android.myviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TextView mTextView;
    private LinearLayout mLayout;
    private List<ImageView> list;
    private int preposition = 0;
    private int[] imgs = {R.drawable.a, R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    private String[] text = {"骚1", "骚2", "骚3", "骚4", "骚5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
        setListener();
    }

    private void setListener() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTextView.setText(text[position%list.size()]);
                mLayout.getChildAt(position%list.size()).setBackgroundResource(R.drawable.dot_enable);
                mLayout.getChildAt(preposition).setBackgroundResource(R.drawable.dot_normal);
                preposition = position%list.size();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setData() {
        list = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(imgs[i]);
            list.add(iv);
            final View view = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
            params.leftMargin = 5;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.dot_normal);
            view.setTag(i);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
int current=mViewPager.getCurrentItem();
                    int num=current/5;
                    int item = (Integer) view.getTag();
                    int position=num*5+item;
                    mViewPager.setCurrentItem(position);
                }
            });
            mLayout.addView(view);
        }
        mTextView.setText(text[0]);
        mLayout.getChildAt(0).setBackgroundResource(R.drawable.dot_enable);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View v=list.get(position%list.size());
                if(v.getParent()!=null){
                    ViewGroup vg= (ViewGroup) v.getParent();
                    vg.removeView(v);
                }
                container.removeView(v);
                container.addView(v);

                return v;
            }

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position%list.size()));
            }
        });
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mTextView = (TextView) findViewById(R.id.tv);
        mLayout = (LinearLayout) findViewById(R.id.llPoints);
    }
}
