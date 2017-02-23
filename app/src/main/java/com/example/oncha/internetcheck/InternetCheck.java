package com.example.oncha.internetcheck;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InternetCheck extends AppCompatActivity implements View.OnClickListener {
Button check;
    public boolean isThereInternetConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isThereInternetConnection = false;

        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        isThereInternetConnection =  isNetworkConnected();
        if(isThereInternetConnection == true){
            Toast.makeText(this, "INTERNET CONNECTION AVAILABLE", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "NO NETWORK CONNECTION", Toast.LENGTH_LONG).show();
        }
    }


    private boolean isNetworkConnected() {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo == null){
                return false;
            }
            else {
                return true;
            }
    }
}
