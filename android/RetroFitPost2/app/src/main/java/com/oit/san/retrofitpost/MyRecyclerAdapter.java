package com.oit.san.retrofitpost;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oit.san.retrofitpost.data.model.Student;

import java.util.List;

/**
 * Created by OPTLPTP119 on 06-09-2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<Student> userList;

    public MyRecyclerAdapter(List<Student> userList) {
        this.userList = userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(userList.get(position).getFirstName()+" "+userList.get(position).getLastName());
        holder.dob.setText(userList.get(position).getDob());
        holder.department.setText(userList.get(position).getDept());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,dob,department;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            dob = (TextView)itemView.findViewById(R.id.dob);
            department = (TextView)itemView.findViewById(R.id.department);
        }
    }
}
