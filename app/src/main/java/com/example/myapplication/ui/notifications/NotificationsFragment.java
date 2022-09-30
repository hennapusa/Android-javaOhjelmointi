package com.example.myapplication.ui.notifications;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentNotificationsBinding;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    // private static final long START_TIME_IN_MILLIS = 60000;
    //private Button buttonStart;
    //private Button buttonStop;
    //private Button buttonPause;
    private CountDownTimer cdt;
    int valueOnPicker1 =0;
    NumberPicker numPicker;
    private MaterialButtonToggleGroup materialButtonToggleGroup;
    public static final String TAG ="MyAppMessage";
    private TextView textView;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        String[] myValues = new String[61];
        for (int i = 0; i < myValues.length; i++) {
            myValues[i] = i+ " s";
        }
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        textView = root.findViewById(R.id.text_notifications);
        numPicker = root.findViewById(R.id.numberpicker);
        numPicker.setDisplayedValues(myValues);
        numPicker.setMinValue(0);
        numPicker.setMaxValue(60);
        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                valueOnPicker1 = numberPicker.getValue();
                Log.e(TAG, "painettu" + "");
            }
        });
        materialButtonToggleGroup = root.findViewById(R.id.toggleGroup);
        materialButtonToggleGroup.addOnButtonCheckedListener(
                new MaterialButtonToggleGroup.OnButtonCheckedListener() {
                    @Override
                    public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                        if (isChecked) {
                            if (checkedId == R.id.buttonPause) {
                                Log.e(TAG, "pausea painettu" + String.valueOf(numPicker.getValue()));
                                //numPicker.getValue();
                                cdt.cancel();

                            } else if (checkedId == R.id.buttonStart) {
                                Log.e(TAG, "starttia painettu"+ String.valueOf(numPicker.getValue()));
                                cdt = new CountDownTimer(numPicker.getValue() * 1000, 1000) {
                                    @Override
                                    public void onTick(long l) {
                                        textView.setText("seconds remaining: " + l / 1000);
                                    }

                                    @Override
                                    public void onFinish() {
                                        textView.setText("done!");
                                    }

                                }.start();

                            } else if (checkedId == R.id.buttonStop) {
                               // Log.e(TAG, "stop painettu"+ String.valueOf(numPicker.setVa));
                                numPicker.setValue(0);
                                cdt.cancel();
                            }
                        }
                    }
                });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}