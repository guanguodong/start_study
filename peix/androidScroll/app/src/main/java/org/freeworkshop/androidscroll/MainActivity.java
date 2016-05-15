package org.freeworkshop.androidscroll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnTouchListener, View.OnClickListener {

    private LinearLayout ll_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_line = (LinearLayout)findViewById(R.id.ll_line);

        ll_line.setOnTouchListener(this);
    }

    float startX = 0;
    int currentLeft = 0;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE: {
                Log.d("leftMargin", "event:" + event);
                float distance = event.getRawX() - startX;
                Log.d("leftMargin", "eventX:" + event.getX() + " startX:" + startX + " distance:" + distance);
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ll_line.getLayoutParams();
                lp.leftMargin = currentLeft + (int) distance;
                Log.d("leftMargin", "leftMargin:" + lp.leftMargin + " view:" + v.getId());
                ll_line.setLayoutParams(lp);
                break;
            }
            case MotionEvent.ACTION_UP: {
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ll_line.getLayoutParams();
                currentLeft = lp.leftMargin;
                startX = 0;
                break;
            }
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_left:
                startActivity(new Intent(this,ScrollLeft.class));
                break;
            case R.id.bt_tab:
                startActivity(new Intent(this,TabActivity.class));
                break;
            case R.id.bt_tab2:
                break;
        }
    }
}
