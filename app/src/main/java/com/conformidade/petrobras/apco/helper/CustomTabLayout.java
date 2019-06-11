package com.conformidade.petrobras.apco.helper;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

public class CustomTabLayout extends TabLayout {

    public CustomTabLayout(Context context) {
        super(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        ViewGroup tabLayout = (ViewGroup)getChildAt(0);
        int childCount = tabLayout.getChildCount();

        if( childCount != 0 ) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            int tabMinWidth = displayMetrics.widthPixels/childCount;

            for(int i = 0; i < childCount; ++i){
                tabLayout.getChildAt(i).setMinimumWidth(tabMinWidth);
            }
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
