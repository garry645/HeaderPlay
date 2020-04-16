package com.example.headerplay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.headerplay.databinding.FragmentOneBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class OneFragment extends Fragment {

    private FragmentOneBinding binding;
    protected static AppBarConfiguration appBarConfiguration;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);

    MainActivity.disableNavDrawer();
/*


        NavController navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.navHostFrag);
      */
/*  appBarConfiguration = new AppBarConfiguration.Builder(R.id.oneFragment, R.id.twoFragment)
                .setDrawerLayout(MainActivity.drawerLayout)
                .build();*//*


        NavigationUI.setupActionBarWithNavController((AppCompatActivity) getActivity(), navController, MainActivity.drawerLayout);

        //NavigationUI.setupActionBarWithNavController((AppCompatActivity) getActivity(), navController, appBarConfiguration);

*/



        binding.fragOneBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   ((AppCompatActivity) getActivity()).getSupportActionBar().hide();*/
                Navigation.findNavController(view).navigate(R.id.action_oneFragment_to_twoFragment);
            }
        });
       /* Navigation.createNavigateOnClickListener(Objects.requireNonNull((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        R.id.action_oneFragment_to_twoFragment));*/

        return binding.getRoot();
    }


}
