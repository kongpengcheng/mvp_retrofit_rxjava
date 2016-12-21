package com.haier.mvp_retrofit_rxjava.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
*自定义的gridview 为了使gridview不能滑动
*/
public class AutoGridView extends GridView {

	public AutoGridView(Context context, AttributeSet attrs, int defStyle) {
		 super(context, attrs, defStyle);
	}

	public AutoGridView(Context context, AttributeSet attrs) {
		 super(context, attrs);
	}

	public AutoGridView(Context context) {
		 super(context);
	}

	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		 int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		 super.onMeasure(widthMeasureSpec, expandSpec);

	}

}
