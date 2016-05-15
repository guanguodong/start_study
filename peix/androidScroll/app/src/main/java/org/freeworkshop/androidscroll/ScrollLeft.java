package org.freeworkshop.androidscroll;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/5/14.
 */
public class ScrollLeft extends Activity implements GestureDetector.OnGestureListener{

    private RelativeLayout rl_left_line;
    GestureDetector gestureDetector;
    private View v_line1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        rl_left_line = (RelativeLayout)findViewById(R.id.rl_left_line);

//        rl_left_line.setOnTouchListener(this);
        gestureDetector = new GestureDetector(this,this);

        //获得屏幕宽度，让v_line1正好一屏宽
        WindowManager wm = this.getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        v_line1 = findViewById(R.id.v_line1);
        ViewGroup.LayoutParams lp = v_line1.getLayoutParams();
        lp.width = width;
        v_line1.setLayoutParams(lp);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //判断如果左拉至100px以上就显示全部 -200px
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) rl_left_line.getLayoutParams();
            if(lp.leftMargin <= -100){
                lp.leftMargin = -200;
            }else{
                lp.leftMargin = 0;
            }
            rl_left_line.setLayoutParams(lp);

        }
        return super.onTouchEvent(event);
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        gestureDetector.onTouchEvent(event);
//        return true;
//    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d("onScroll", "distanceX:" + distanceX);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) rl_left_line.getLayoutParams();
        lp.leftMargin -= (int) distanceX;
        rl_left_line.setLayoutParams(lp);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
