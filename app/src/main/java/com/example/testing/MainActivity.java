package com.example.testing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;




public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.Aadharno);
        textView1=findViewById(R.id.fullName);
        textView2=findViewById(R.id.dob);
        textView3=findViewById(R.id.gender);
        textView4=findViewById(R.id.address);

//     ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
   }
    public void Scanbutton(View view){
        IntentIntegrator intentIntegrator= new IntentIntegrator(this);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (intentResult!=null){
            if (intentResult.getContents()==null){
                textView.setText("Cancelled");
                String qrData = intentResult.getContents();


            }
            else{
                String substring = intentResult.getContents().toString().substring(68,80);
                textView.setText(String.valueOf(substring));


                String substring1 = intentResult.getContents().toString().substring(88,116);
                textView1.setText(String.valueOf(substring1));

                String substring2 = intentResult.getContents().toString().substring(341,351);
                textView2.setText(String.valueOf(substring2));


                String substring3 = intentResult.getContents().toString().substring(103,104);
                textView3.setText(String.valueOf(substring3));

                String substring4 = intentResult.getContents().toString().substring(124,164);
                textView4.setText(String.valueOf(substring4));







//                textView.setText(intentResult.getContents());
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void handleResult(Result rawResult) {
        // Do something with the result here

        Log.e("handler", rawResult.getText()); // Prints scan results
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();

        // If you would like to resume scanning, call this method below:
//        mScannerView.resumeCameraPreview(this);
    }

}