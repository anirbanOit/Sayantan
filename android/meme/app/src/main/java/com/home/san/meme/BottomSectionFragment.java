package com.home.san.meme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by OPTLPTP119 on 28-08-2017.
 */

public class BottomSectionFragment extends Fragment {
    private static TextView mTopView;
    private static TextView mBottomView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);
        mTopView = (TextView) view.findViewById(R.id.topTextView);
        mBottomView = (TextView) view.findViewById(R.id.bottomTextView);
        return view;
    }

    public void memeText(String top, String bottom){
        mTopView.setText(top);
        mTopView.setText(bottom);
    }
}
