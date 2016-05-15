package org.freeworkshop.androidscroll;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
//        getFragmentManager()
//
//        tabHost.addTab(tabHost.newTabSpec("tab1")
//                .setIndicator("tab1 indicator").setContent(R.id.linearLayout1));
//        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab2")
//                .setContent(R.id.linearLayout2));
//        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab3")
//                .setContent(R.id.linearLayout3));
    }
}
