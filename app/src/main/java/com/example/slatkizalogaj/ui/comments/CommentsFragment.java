package com.example.slatkizalogaj.ui.comments;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.slatkizalogaj.R;
import androidx.recyclerview.widget.RecyclerView;


public class CommentsFragment extends DialogFragment {

    private CommentsViewModel mViewModel;

    private RecyclerView recyclerViewComments;
    private EditText editTextComment;
    private Button buttonAddComment;
    private CommentsAdapter commentsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);

        recyclerViewComments = view.findViewById(R.id.recyclerViewComments);
        editTextComment = view.findViewById(R.id.editTextComment);
        buttonAddComment = view.findViewById(R.id.buttonAddComment);

        // Initialize RecyclerView
        commentsAdapter = new CommentsAdapter();
        recyclerViewComments.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewComments.setAdapter(commentsAdapter);

        // Add comment button click listener
        buttonAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newComment = editTextComment.getText().toString().trim();
                if (!newComment.isEmpty()) {
                    commentsAdapter.addComment(newComment);
                    // Clear the EditText after adding a comment
                    editTextComment.getText().clear();
                }
            }
        });

        return view;
    }
}