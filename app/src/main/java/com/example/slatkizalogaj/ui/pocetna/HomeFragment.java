package com.example.slatkizalogaj.ui.pocetna;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.slatkizalogaj.databinding.FragmentPocetnaBinding;

public class HomeFragment extends Fragment {

    private FragmentPocetnaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentPocetnaBinding.inflate(inflater, container, false);
//
        binding.galleryGridView.setAdapter(new ImageAdapter(requireContext()));

        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}