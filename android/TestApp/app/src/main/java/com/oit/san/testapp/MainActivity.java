package com.oit.san.testapp;

import android.app.Fragment;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout oLinear;
    Fragment oFragment1;
    Fragment oFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        oFragment1 = getFragmentManager().findFragmentById(R.id.fragment);
        oFragment2 = getFragmentManager().findFragmentById(R.id.fragment2);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT)
        {
            oLinear = (LinearLayout)findViewById(R.id.main_layout);

            Log.d("san","Welcome to Landscape view");
            oLinear.setOrientation(LinearLayout.VERTICAL);
            /*
            ViewGroup.LayoutParams params = oFragment1.getView().getLayoutParams();
            params.width = ActionBar.LayoutParams.MATCH_PARENT;
            oFragment1.getView().setLayoutParams(params);*/
        }
        else if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE)
        {
            Log.d("san","Welcome to Portrait view");
            oLinear = (LinearLayout)findViewById(R.id.main_layout);
            oLinear.setOrientation(LinearLayout.HORIZONTAL);

            ViewGroup.LayoutParams params1 = oFragment1.getView().getLayoutParams();
            ViewGroup.LayoutParams params2 = oFragment2.getView().getLayoutParams();
            params1.height = ActionBar.LayoutParams.MATCH_PARENT;
            params1.width = 260;
            params2.height = ActionBar.LayoutParams.MATCH_PARENT;
            params2.width = 260;
            oFragment1.getView().setLayoutParams(params1);
            oFragment2.getView().setLayoutParams(params1);

        }
    }
}
