package com.home.san.meme;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by OPTLPTP119 on 28-08-2017.
 */

public class TopSectionFragment extends Fragment {

    private static EditText mTopText;
    private static EditText mBottomText;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top, String bottom);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCommander = (TopSectionListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        mTopText = (EditText) view.findViewById(R.id.topText);
        mBottomText = (EditText) view.findViewById(R.id.bottomText);
        final Button mButton = (Button) view.findViewById(R.id.createBtn);

        mButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttonClicked(v);
                    }
                }
        );


        return view;
    }

    public void buttonClicked(View view){
        activityCommander.createMeme(mTopText.getText().toString(),mBottomText.getText().toString());
    }
}
