package com.example.huynhanhtien;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    private ArrayList<Question> questionsList;


    public DetailsAdapter(ArrayList<Question> questionsList) {
        this.questionsList = questionsList;
    }
    @NonNull
    @Override
    public DetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContent;
        private TextView tvAnswer;

        public ViewHolder(View view) {
            super(view);




        }

    }
}
