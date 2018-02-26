package com.blackphoenix.pxcirclemenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.util.Log;

public class CircleMenuButton extends CircleButton {

    private int colorNormal;
    private String hintText;
    private int buttonHeight;
    private int buttonWidth;

    public CircleMenuButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.CircleMenuButton, 0, 0);
        colorNormal = attr.getColor(R.styleable.CircleMenuButton_colorNormal, getResources().getColor(R.color.circle_menu_button_color_normal));
        int colorPressed = attr.getColor(R.styleable.CircleMenuButton_colorPressed, getResources().getColor(R.color.circle_menu_button_color_pressed));
        hintText = attr.getString(R.styleable.CircleMenuButton_hintText);
        buttonWidth = (int) attr.getDimension(R.styleable.CircleMenuButton_button_width, getResources().getDimension(R.dimen.circle_menu_button_size));
        buttonHeight = (int) attr.getDimension(R.styleable.CircleMenuButton_button_height, getResources().getDimension(R.dimen.circle_menu_button_size));
        int iconId = attr.getResourceId(R.styleable.CircleMenuButton_icon, 0);
        attr.recycle();

        Log.e("CircleMenuButton"," Height: "+buttonHeight+" Width: "+buttonWidth);

        setBackgroundCompat(createBackgroundDrawable(colorNormal, colorPressed));

        if (iconId != 0) {
            setImageResource(iconId);
        } else {
            setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

   /* @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
      //  Log.e("CircleMenuButton","onMeasure Override - "+widthMeasureSpec + " x " + heightMeasureSpec);
        setMeasuredDimension(buttonWidth,buttonHeight);
    }*/

    int getColorNormal() {
        return colorNormal;
    }

    public String getHintText() {
        return hintText;
    }



}
