package com.example.slatkizalogaj.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slatkizalogaj.R;
import com.example.slatkizalogaj.databinding.FragmentDetaljiBinding;
import com.example.slatkizalogaj.databinding.FragmentPocetnaBinding;
import com.example.slatkizalogaj.ui.comments.CommentsFragment;
import com.example.slatkizalogaj.ui.porudzbine.KorpaViewModel;

public class Detalji extends Fragment {


    private FragmentDetaljiBinding binding;
    private KorpaViewModel korpa;

    public Detalji() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetaljiBinding.inflate(inflater, container, false);
        korpa=new ViewModelProvider(requireActivity()).get(KorpaViewModel.class);


        binding.dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                korpa.setmText("nova");
            }
        });

        binding.komentari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentsDialog();
            }
        });

        return binding.getRoot();
    }

    private void showCommentsDialog() {
        CommentsFragment dialogFragment = new CommentsFragment();
        dialogFragment.show(requireActivity().getSupportFragmentManager(), "CommentsDialogFragment");
    }
}