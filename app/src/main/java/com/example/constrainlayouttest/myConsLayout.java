package com.example.constrainlayouttest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class myConsLayout extends ConstraintLayout {
    public myConsLayout(@NonNull Context context) {
        super(context);
    }

    public myConsLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public myConsLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int radius = getWidth() / 2;
        super.onLayout(changed, left, top, right, bottom);
        int childCount = getChildCount();
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            constraintSet.constrainCircle(view.getId(), this.getId(), radius, layoutParams.circleAngle);

        }
        constraintSet.applyTo(this);
    }
}
