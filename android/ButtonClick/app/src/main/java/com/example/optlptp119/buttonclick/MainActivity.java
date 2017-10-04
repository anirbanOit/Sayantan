package com.example.optlptp119.buttonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mText;
    private EditText mEdit;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView)findViewById(R.id.myText);
        mButton = (Button)findViewById(R.id.myButton);
        mEdit = (EditText)findViewById(R.id.myInput);

        mButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        //mText.setText("hi");
                        //code not running
                        
                        if(mEdit.getText().toString().equals(null)) {
                            mText.setText("ah! You did it.");
                        }
                        else{
                            mText.setText(mEdit.getText().toString());
                        }
                    }
                }
        );
    }
}
