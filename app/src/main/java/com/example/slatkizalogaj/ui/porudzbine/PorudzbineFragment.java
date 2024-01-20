package com.example.slatkizalogaj.ui.porudzbine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.slatkizalogaj.databinding.FragmentPorudzbineBinding;

public class PorudzbineFragment extends Fragment {

    private FragmentPorudzbineBinding binding;
    private KorpaViewModel korpa;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        korpa =
                new ViewModelProvider(requireActivity()).get(KorpaViewModel.class);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        binding = FragmentPorudzbineBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        korpa.getText().observe(requireActivity(),s -> {
            if (s.equals("nova") && binding!=null){
                binding.nova.setText(s);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}