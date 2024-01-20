package com.example.slatkizalogaj.ui.comments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.slatkizalogaj.R;

import java.util.ArrayList;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>  {
    private final List<String> commentsList;

    public CommentsAdapter() {
        this.commentsList = new ArrayList<>();
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.bind(commentsList.get(position));
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public void addComment(String comment) {
        commentsList.add(comment);
        notifyDataSetChanged();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewComment;

        CommentViewHolder(View itemView) {
            super(itemView);
            textViewComment = itemView.findViewById(R.id.textViewComment);
        }

        void bind(String comment) {
            textViewComment.setText(comment);
        }
    }
}
