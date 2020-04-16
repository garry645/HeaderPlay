package com.example.headerplay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.headerplay.databinding.FragmentTwoBinding;

public class TwoFragment extends Fragment {

    FragmentTwoBinding binding;
    AppBarConfiguration appBarConfiguration;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false);

        MainActivity.enableNavDrawer();

    /*    NavController navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.navHostFrag);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.oneFragment, R.id.twoFragment)
                .build();


        NavigationUI.setupActionBarWithNavController((AppCompatActivity) getActivity(), navController, appBarConfiguration);*/
        binding.fragmentTwoBT.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_twoFragment_to_oneFragment));

        return binding.getRoot();
    }
}
