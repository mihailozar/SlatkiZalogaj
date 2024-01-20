package com.example.slatkizalogaj.ui.kategorije;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.slatkizalogaj.R;
import com.example.slatkizalogaj.databinding.FragmentKategorijeBinding;

public class KategorijeFragment extends Fragment {

    private FragmentKategorijeBinding binding;
    private NavController navController;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentKategorijeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        navController= Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);


        View.OnClickListener imageClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the action ID with the actual ID of your action
                navController.navigate(R.id.action_navigation_dashboard_to_detalji);
            }
        };
       binding.image1.setOnClickListener(imageClickListener);
       binding.image2.setOnClickListener(imageClickListener);
       binding.image3.setOnClickListener(imageClickListener);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}