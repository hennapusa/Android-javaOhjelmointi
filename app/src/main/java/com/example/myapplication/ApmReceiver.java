package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ApmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        boolean state = intent.getBooleanExtra("state", false);

        Log.e("Toimiiko", String.valueOf(state));

        //Context context = getApplicationContext();
        CharSequence text = "Lentokone tila päällä!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        if(state){
            state = true; //ON
    }
        else{
            state =false; //OFF
        }
    }
}