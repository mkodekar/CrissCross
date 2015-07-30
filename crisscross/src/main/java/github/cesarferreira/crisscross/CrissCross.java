package github.cesarferreira.crisscross;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.rebound.BaseSpringSystem;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

public class CrissCross extends LinearLayout {

    private final BaseSpringSystem mSpringSystem = SpringSystem.create();
    private final RotateSpringListener mSpringListener = new RotateSpringListener();

    private Spring mSpring;

    int currentEndValue = 0;

    View mSideA;
    View mSideB;

    private int mBarColor = Color.WHITE;
    private int mCircleColor = Color.YELLOW;
    private float mBarWidth = R.dimen.cc_bar_width_dimen;
    private float mBarHeight = R.dimen.cc_bar_height_dimen;
    private RelativeLayout mCircle;
    private double mAngleA = -45.0;
    private double mAngleB = 225.0;

    public CrissCross(Context context) {
        super(context);
        init(null, context, 0);
    }

    public CrissCross(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, context, 0);
    }

    public CrissCross(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, context, defStyle);
    }

    private void init(AttributeSet attrs, Context context, int defStyle) {

        // Create the animation spring.
        mSpring = mSpringSystem.createSpring();
        mSpring.addListener(mSpringListener);

        // Load attributes
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CrissCross, defStyle, 0);


        // colors
        mCircleColor = a.getColor(R.styleable.CrissCross_cc_circle_color, mCircleColor);
        mBarColor = a.getColor(R.styleable.CrissCross_cc_bar_color, mBarColor);

        // dimens
        mBarWidth = a.getDimension(R.styleable.CrissCross_cc_bar_width, R.dimen.cc_bar_width_dimen);
        mBarHeight = a.getDimension(R.styleable.CrissCross_cc_bar_height, R.dimen.cc_bar_height_dimen);

        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.criss_cross_layout, this, true);

        mCircle = (RelativeLayout) getChildAt(0);
        mSideA = mCircle.getChildAt(0);
        mSideB = mCircle.getChildAt(1);

        GradientDrawable rectangleShape = (GradientDrawable) context.getResources().getDrawable(R.drawable.rectangle_shape);
        rectangleShape.setColor(mBarColor);
        rectangleShape.setStroke(4, mBarColor);

        GradientDrawable circleBackground = (GradientDrawable) context.getResources().getDrawable(R.drawable.circle_background);
        circleBackground.setColor(mCircleColor);
        circleBackground.setStroke(5, mCircleColor);

        // set the colors
        mSideA.setBackground(rectangleShape);
        mSideB.setBackground(rectangleShape);
        mCircle.setBackground(circleBackground);


        // set the sizes
        mSideA.getLayoutParams().width = Math.round(mBarWidth);
        mSideB.getLayoutParams().width = Math.round(mBarWidth);
        mSideA.getLayoutParams().height = Math.round(mBarHeight);
        mSideB.getLayoutParams().height = Math.round(mBarHeight);

        invalidate();
    }

    public void toggle() {
        mSpring.setEndValue(currentEndValue = currentEndValue == 0 ? 1 : 0);
    }

    public void animate(double angleA, double angleB) {

        // descubrir os angulos actuais e calcular a distancia
        mAngleA = angleA;
        mAngleB = angleB;
        mSpring.setCurrentValue(0);
        mSpring.setEndValue(1);
    }

    public void transform(float angleA, float angleB) {
        mSideA.setRotation(angleA);
        mSideB.setRotation(angleB);
    }

    public void setCircleColor(int mCircleColor) {
        this.mCircleColor = mCircleColor;
        invalidate();
        requestLayout();
    }

    public void setBarWidth(float mBarWidth) {
        this.mBarWidth = mBarWidth;
        invalidate();
        requestLayout();
    }

    public void setBarHeight(float mBarHeight) {
        this.mBarHeight = mBarHeight;
        invalidate();
        requestLayout();
    }

    public int getBarColor() {
        return mBarColor;
    }

    public int getCircleColor() {
        return mCircleColor;
    }

    public float getBarWidth() {
        return mBarWidth;
    }

    public float getBarHeight() {
        return mBarHeight;
    }

    public void setBarColor(int mBarColor) {
        this.mBarColor = mBarColor;
        invalidate();
        requestLayout();
    }


    private class RotateSpringListener extends SimpleSpringListener {
        @Override
        public void onSpringUpdate(Spring spring) {
            float mappedValueA = (float) SpringUtil.mapValueFromRangeToRange(spring.getCurrentValue(), 0, 1, 0, mAngleA);
            float mappedValueB = (float) SpringUtil.mapValueFromRangeToRange(spring.getCurrentValue(), 0, 1, 0, mAngleB);

            mSideA.setRotation(mappedValueA);
            mSideB.setRotation(mappedValueB);

        }
    }

}
