package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;

import org.json.JSONArray;

import java.text.DecimalFormat;

public class Tentti extends AppCompatActivity {

    private MaterialButtonToggleGroup materialButtonToggleGroup;
    public static final String TAG ="MyAppMessage";
    private TextView textView;

    private String fromCurr;
    private String toCurr;
    double value0;
    double value1;
    double value2;
    double value3;
    private DecimalFormat f = new DecimalFormat("##.###");
    private JSONArray exchangeValues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentti);


        value0 = 0;
        value1 = 0.09968;
        value2 = 0.10288;
        value3 = 0.13440;
        DecimalFormat f = new DecimalFormat("##.###");

        //value1 = findViewById(R.id.buttonSek);
        //value2 = findViewById(R.id.buttonDkk);
        //value3 = findViewById(R.id.buttonNok);

        textView = findViewById(R.id.resultBox);
        materialButtonToggleGroup = findViewById(R.id.toggleGroup);
        materialButtonToggleGroup.addOnButtonCheckedListener(
                new MaterialButtonToggleGroup.OnButtonCheckedListener() {
                    @Override
                    public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                        if (isChecked) {
                            if (checkedId == R.id.buttonSek) {
                                //Log.e(TAG, "painettu" + String.valueOf(value1.getValue()));
                                //value1.getValue();


                            } else if (checkedId == R.id.buttonNok) {
                                //Log.e(TAG, "painettu" + String.valueOf(value2.getValue()));
                                int value0 = 0;
                                if (value1 > 0) {
                                } else {

                                }


                            } else if (checkedId == R.id.buttonDkk) {
                                //Log.e(TAG, "painettu" + String.valueOf(value3.getValue()));
                                textView.setText("Total");

                            }

                        }
                    }
                });
       // public void defaultValues () {
          //  String currency = this.;

         //   switch (currency) {

            //    case "Euro":
                   // this.exchangeValues.put("SEK", 0.09968);
                  //  this.exchangeValues.put("NOK", 0.10288);
                   // this.exchangeValues.put("DKK", 0.13440);

                   // break;
            }
   // public static ArrayList<Currency> init() {
        //ArrayList<Currency> currencies = new ArrayList<Currency>();

        //currencies.add( new Currency("", "DKK") );
        //currencies.add( new Currency("", "NOK") );
       // currencies.add( new Currency("", "SEK") );

        //for (Integer i =0; i < currencies.size(); i++) {
            //currencies.get(i).defaultValues();
        //}

        //return currencies;
        public static Double convert(Double amount, Double exchangeValue) {
            Double price;
            price = amount * exchangeValue;
            price = Math.round(price * 100d) / 100d;

            return price;
        }
    }

