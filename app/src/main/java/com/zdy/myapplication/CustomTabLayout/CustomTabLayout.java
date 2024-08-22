package com.zdy.myapplication.CustomTabLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zdy.myapplication.R;

public class CustomTabLayout extends TabLayout {

    public CustomTabLayout(Context context) {
        this(context, null);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        initCustomTab();
    }

    @SuppressWarnings({ "ConstantConditions" })
    private void initCustomTab() {
        int totalTab = getTabCount();
        for (int i = 0; i < totalTab; i++) {
            Tab tab = getTabAt(i);
            if (tab == null) continue;
            View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_custom_tab, this, false);
            tab.setCustomView(view);
        }
    }
}
