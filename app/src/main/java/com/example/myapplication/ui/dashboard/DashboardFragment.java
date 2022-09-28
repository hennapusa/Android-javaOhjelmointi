package com.example.myapplication.ui.dashboard;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDashboardBinding;

import java.util.List;
import java.util.Locale;


public class DashboardFragment extends Fragment implements LocationListener {

    private FragmentDashboardBinding binding;

    LocationManager locationManager;
    //DashboardViewModel dashboardViewModel;
    Location lastLocation;
    Locale finnish = new Locale("fi", "FI");
    private TextView locationLatitude;
    private TextView locationLongitude;
    private TextView locationAddress;
    private static final String TAG = "KÄÄÄK";
    private Button button_button;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        locationLatitude = root.findViewById(R.id.textView_latitude);
        locationLongitude = root.findViewById(R.id.textView_longnitude);
        locationAddress = root.findViewById(R.id.textView_address);
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        button_button= root.findViewById(R.id.button_button);


        //final TextView textView = binding.textView1;
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        button_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
         Uri gmmIntentUri = Uri.parse("geo:" + lastLocation.getLatitude() + "," + lastLocation.getLongitude());
         Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
         mapIntent.setPackage("com.google.android.apps.maps");


         startActivity(mapIntent);
         }
         });

        return root;

    }


    @Override
    public void onStart() {
        super.onStart();

        //sijaintitiedot
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.


            //ActivityCompat.requestPermissions(getActivity(), permissions, REQUEST_FINE_LOCATION);
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);

        lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (lastLocation != null) {
            Log.e(TAG, Double.toString(lastLocation.getLatitude()));
            Log.e(TAG, Double.toString(lastLocation.getLongitude()));
            locationLatitude.setText(Double.toString(lastLocation.getLatitude()));
            locationLongitude.setText(Double.toString(lastLocation.getLongitude()));


        }
        try {
            Geocoder geocoder;
            List<Address> addresses;
            //Locale finnish = new Locale("fi", "FI");
            geocoder = new Geocoder(getContext(), finnish);
            addresses = geocoder.getFromLocation(lastLocation.getLatitude(), lastLocation.getLongitude(),
                    1);

            Address address = addresses.get(0);
            String currentLocation = addresses.get(0).getAddressLine(0);
            locationAddress.setText(currentLocation);

            //String city = addresses.get(0).getLocality();
            // String country = addresses.get(0).getCountryName();
            //String postalCode = addresses.get(0).getPostalCode();


        } catch (Exception e) {
            Log.e(TAG, "EI ADDRESS TOIMI!!!!!!!!");
        }
    }


    @Override
    public void onStop() {
        super.onStop();

        locationManager.removeUpdates(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        Log.e(TAG, Double.toString(location.getLatitude()));
        Log.e(TAG, Double.toString(location.getLongitude()));
        locationLatitude.setText(Double.toString(location.getLatitude()));
        locationLongitude.setText(Double.toString(location.getLongitude()));


        try {
            Geocoder geocoder;
            List<Address> addresses;
            //Locale finnish = new Locale("fi", "FI");
            geocoder = new Geocoder(getContext(), finnish);
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),
                    1);

            Address address = addresses.get(0);
            String currentLocation = addresses.get(0).getAddressLine(0);
            locationAddress.setText(currentLocation);

            //String city = addresses.get(0).getLocality();
            // String country = addresses.get(0).getCountryName();
            //String postalCode = addresses.get(0).getPostalCode();


        } catch (Exception e) {

        }
    }

}
