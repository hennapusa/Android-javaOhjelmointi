package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Guess;
import com.example.myapplication.Interface;
import com.example.myapplication.R;
import com.example.myapplication.Tentti;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Button welcomeButton;
    private View welcomeTextView;
    private Button gameButton;
    private Button ytjButton;
    private Button TenttiButton;
    public static final String TAG ="MyAppMessage";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Log.e(TAG, "activating play view");
        welcomeButton = root.findViewById(R.id.hello_button);
        welcomeTextView =root.findViewById(R.id.textView);
        welcomeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                handleClickEvents(v);

            }
        });
        gameButton = root.findViewById(R.id.gameButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handleClickEvents(view);
            }
        });
        ytjButton = root.findViewById(R.id.ytjButton);
        ytjButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handleClickEvents(view);
            }
        });
        TenttiButton = root.findViewById(R.id.tenttiButton);
        TenttiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handleClickEvents(view);
            }
        });


        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void handleClickEvents(View v){
        switch(v.getId()){
            case R.id.gameButton:
                Intent i= new Intent(getActivity(), Guess.class);
                startActivity(i);

                break;

            case R.id.ytjButton:
                Intent I= new Intent(getActivity(), Interface.class);
                startActivity(I);

                break;

            case R.id.tenttiButton:
                Intent O= new Intent(getActivity(), Tentti.class);
                startActivity(O);

                break;

            case R.id.hello_button:
                if (welcomeTextView.getVisibility() == View.VISIBLE)
                    welcomeTextView.setVisibility(View.INVISIBLE);

                else if(welcomeTextView.getVisibility() == View.INVISIBLE)
                    welcomeTextView.setVisibility(View.VISIBLE);
        }
    }
}