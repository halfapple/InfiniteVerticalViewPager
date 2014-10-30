package com.example.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 14-10-30.
 *
 */
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        LinearLayout linear = (LinearLayout)rootView.findViewById(R.id.linear1);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "child linear1 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = (Button)rootView.findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "button1 clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
