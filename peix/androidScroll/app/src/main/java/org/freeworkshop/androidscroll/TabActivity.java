package org.freeworkshop.androidscroll;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import org.freeworkshop.androidscroll.fragement.Fragement1;
import org.freeworkshop.androidscroll.fragement.Fragement2;

public class TabActivity extends Activity implements View.OnClickListener{
    Fragement1 fragement1;
    Fragement2 fragement2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        fragement1 = new Fragement1();
        fragement2 = new Fragement2();
        tx.add(R.id.fl_1,fragement1);
        tx.add(R.id.fl_1,fragement2);
        tx.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1: {
                FragmentTransaction tx = getFragmentManager().beginTransaction();
                tx.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_left);
                tx.show(fragement1);
                tx.hide(fragement2);
                tx.commit();
                break;
            }
            case R.id.btn_2: {
                FragmentTransaction tx = getFragmentManager().beginTransaction();
                tx.show(fragement2);
                tx.hide(fragement1);
                tx.commit();
                break;
            }
            case R.id.btn_3:
                break;
        }
    }
}
