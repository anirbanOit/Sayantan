package com.oit.san.sansapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by OPTLPTP119 on 01-09-2017.
 */

public class CustomAdapter extends BaseAdapter {

    private Context oContext;
    private ArrayList<HashMap<String, String>> userList;

    public CustomAdapter(Context oContext, ArrayList<HashMap<String, String>> userList) {
        this.oContext = oContext;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int pos) {
        return userList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {

    HashMap<String,String> stringStringHashMap = userList.get(pos);

        //if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) oContext.getSystemService(oContext.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, viewGroup,false);
        //}

        TextView oText1 = convertView.findViewById(R.id.name);
        oText1.setText(stringStringHashMap.get("name"));

        TextView oText2 = convertView.findViewById(R.id.dob);
        oText2.setText(stringStringHashMap.get("dob"));

        TextView oText3 = convertView.findViewById(R.id.department);
        oText3.setText(stringStringHashMap.get("dept"));

        //stringStringHashMap.get("name");
        byte[] imageBytes = Base64.decode(stringStringHashMap.get("photo"), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

        ImageView oImage = convertView.findViewById(R.id.profileImage);

        oImage.setImageBitmap(decodedImage);
        return convertView;
    }
}
