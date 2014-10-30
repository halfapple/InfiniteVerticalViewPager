package com.example.InfiniteVerticalViewPager;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Administrator on 14-10-30.
 *
 */
public class InfiniteVerticalViewPager extends VerticalViewPager {

    public InfiniteVerticalViewPager(Context context) {
        super(context);
    }

    public InfiniteVerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(VerticalPagerAdapter adapter) {
        super.setAdapter(adapter);
        // offset first element so that we can scroll to the left
        setCurrentItem(0);
    }

    @Override
    public void setCurrentItem(int item) {
        // offset the current item to ensure there is space to scroll
        setCurrentItem(item, false);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        item = getOffsetAmount() + (item % getAdapter().getCount());
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public int getCurrentItem() {
        int position = super.getCurrentItem();

        if (getAdapter() instanceof InfiniteVerticalPagerAdapter) {
            InfiniteVerticalPagerAdapter infAdapter = (InfiniteVerticalPagerAdapter) getAdapter();
            // Return the actual item position in the data backing InfinitePagerAdapter
            return (position % infAdapter.getRealCount());
        } else {
            return super.getCurrentItem();
        }
    }

    private int getOffsetAmount() {
        if (getAdapter() instanceof InfiniteVerticalPagerAdapter) {
            InfiniteVerticalPagerAdapter infAdapter = (InfiniteVerticalPagerAdapter) getAdapter();
            // allow for 100 back cycles from the beginning
            // should be enough to create an illusion of infinity
            // warning: scrolling to very high values (1,000,000+) results in
            // strange drawing behaviour
            return infAdapter.getRealCount() * 100;
        } else {
            return 0;
        }
    }
}
