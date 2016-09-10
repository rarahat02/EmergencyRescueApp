package com.example.rahat_pdm.emergencyrescueandpolicehelperapp;


import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.Toast;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class


HelpMain extends AppCompatActivity
{

    public static final String TAG = "Lattitude";

    Button police, fire;
    EditText crimeClue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_main);

        police = (Button) findViewById(R.id.police);

        crimeClue = (EditText) findViewById(R.id.clue_of_crime);

        fire = (Button) findViewById(R.id.firebutton);


        Typeface font = Typeface.createFromAsset(getAssets(), "siyamrupali.ttf");
        police.setTypeface(font);
        fire.setTypeface(font);

        crimeClue.setTypeface(font);

    }

    /* public  void fireHelp(View v)
     {
         Intent intent = new Intent(getApplicationContext(),AndroidLocationActivity.class);
         startActivity(intent);
     }*/


    public void policeHelp(View v)
    {

        /*Double latitude = 0.0;
        Double longitude = 0.0;*/

        GPSTracker mGPS = new GPSTracker(this);

        if (mGPS.canGetLocation)
        {
            mGPS.getLocation();
            Double latitude = mGPS.getLatitude();
            Double longitude= mGPS.getLongitude();

            Double truncatedLatitude = new BigDecimal(latitude)
                    .setScale(2, BigDecimal.ROUND_HALF_UP)
                    .doubleValue();

            Double truncatedLongitude = new BigDecimal(longitude)
                    .setScale(2, BigDecimal.ROUND_HALF_UP)
                    .doubleValue();


            String ph = "01967517180";

            showToast(truncatedLatitude.toString() + "  " + truncatedLongitude.toString() + " " + crimeClue.getText().toString());

            /*SmsManager smsManager = SmsManager.getDefault();

            Log.d(TAG, "From: " + truncatedLatitude);

            smsManager.sendTextMessage(ph, null, truncatedLatitude + "," + truncatedLongitude
                    + "-", null, null);*/

            /*smsManager.sendTextMessage(ph, null, latitude + "," + longitude
                    + "-" + crimeClue.getText().toString(), null, null);*/
        }


    }

    public void fireServiceHelp(View v)
    {
        Double latitude = 0.0;
        Double longitude = 0.0;

        GPSTracker mGPS = new GPSTracker(this);

        if (mGPS.canGetLocation)
        {
            mGPS.getLocation();
            latitude = mGPS.getLatitude();
            longitude = mGPS.getLongitude();

            Double truncatedLatitude = new BigDecimal(latitude)
                    .setScale(2, BigDecimal.ROUND_HALF_UP)
                    .doubleValue();

            Double truncatedLongitude = new BigDecimal(longitude)
                    .setScale(2, BigDecimal.ROUND_HALF_UP)
                    .doubleValue();


            String ph = "01967517180";

            showToast(truncatedLatitude.toString() + truncatedLongitude.toString());

            /*SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(ph, null, truncatedLatitude + "," + truncatedLongitude
                    + "-", null, null);*/
           // smsManager.sendTextMessage(ph, null, truncatedLatitude + "," + truncatedLongitude, null, null);
            /*smsManager.sendTextMessage(ph, null, latitude + "," + longitude, null, null);*/
        }
    }

    private void showToast(String str)
    {
        Toast.makeText(getApplicationContext(), str , Toast.LENGTH_LONG).show();
    }
}
