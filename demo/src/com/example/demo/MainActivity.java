package com.example.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.example.InfiniteVerticalViewPager.InfiniteVerticalPagerAdapter;
import com.example.InfiniteVerticalViewPager.InfiniteVerticalViewPager;
import com.example.InfiniteVerticalViewPager.VerticalFragmentPagerAdapter;

public class MainActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initView();
    }

    private void initView() {

        VerticalFragmentPagerAdapter adapter = new VerticalFragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                // To keep work normally, at least four
                // When your real count is ">= 4", just return your real count.
                return 4;
            }

            @Override
            public Fragment getItem(int position) {
                if (position % 2 == 0) { // depend on yours
                    return new Fragment1();
                } else {
                    return new Fragment2();
                }
            }
        };

        InfiniteVerticalPagerAdapter wrappedAdapter = new InfiniteVerticalPagerAdapter(adapter);

        InfiniteVerticalViewPager pager = (InfiniteVerticalViewPager) findViewById(R.id.pager);
        pager.setAdapter(wrappedAdapter);
    }

}
