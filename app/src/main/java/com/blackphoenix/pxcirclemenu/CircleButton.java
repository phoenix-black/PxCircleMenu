package com.blackphoenix.pxcirclemenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;

class CircleButton extends AppCompatImageButton {

    private int buttonSize;
    private int buttonHeight;
    private int buttonWidth;

    public CircleButton(Context context) {
        this(context, null);
    }

    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CircleMenu);
        try {
            buttonSize = (int) getResources().getDimension(R.dimen.circle_menu_button_size);
           /* buttonWidth = (int) typedArray.getDimension(R.styleable.CircleMenuButton_button_width, getResources().getDimension(R.dimen.circle_menu_button_size));
            buttonHeight = (int) typedArray.getDimension(R.styleable.CircleMenuButton_button_height, getResources().getDimension(R.dimen.circle_menu_button_size));*/
            Log.e("CircleButton"," Height: "+buttonSize+" Width: "+buttonSize);

        }finally {
            Log.e("CircleButton","Recycling");
            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
      //  Log.e("CircleButton","Init Measure "+ widthMeasureSpec + " x " + heightMeasureSpec);
      //  setMeasuredDimension(buttonWidth, buttonHeight);
    }

    StateListDrawable createBackgroundDrawable(int colorNormal, int colorPressed) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_pressed}, createCircleDrawable(colorPressed));
        drawable.addState(new int[]{-android.R.attr.state_enabled}, createCircleDrawable(colorNormal));
        drawable.addState(StateSet.WILD_CARD, createCircleDrawable(colorNormal));
        return drawable;
    }

    private Drawable createCircleDrawable(int color) {
        ShapeDrawable ovalDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = ovalDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        return ovalDrawable;
    }

    void setBackgroundCompat(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

}
