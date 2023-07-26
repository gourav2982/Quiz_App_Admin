package com.example.quizadmin.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizadmin.ApiModel.Quiz_topic;
import com.example.quizadmin.QusAdd;
import com.example.quizadmin.R;
import com.example.quizadmin.TopicAdd;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class Selection_Adapter extends RecyclerView.Adapter<Selection_Adapter.ViewHolder> {

    ArrayList<Quiz_topic> qs = new ArrayList<>();
    Context context;

    public Selection_Adapter(ArrayList<Quiz_topic> qs, Context context) {
        this.qs = qs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.quiz_topic_selector, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int a= position;
        holder.textView.setText(qs.get(position).getTitle());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, QusAdd.class);
                i.putExtra("QusId",qs.get(a).getId());
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return qs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.quizTitle);
            button = itemView.findViewById(R.id.start_btn);

        }
    }

}
