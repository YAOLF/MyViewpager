package com.android.fragmentviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/2.
 */
public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.item,null);
        ListView lv= (ListView) v.findViewById(R.id.lv);
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("说我爱你20遍"+i+"遍");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,list);
        lv.setAdapter(adapter);
        return v;
    }
}
