package com.example.tarea2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }


    public void setupUI(){

        final String TurningON= "This is turning ON";
        final String TurningOFF= "This is turning OFF";

        final Button mButtonON = (Button)findViewById(R.id.btnON);
        final Button mButtonOFF = (Button)findViewById(R.id.btnOFF);
        //final EditText mHistory = (EditText)findViewById(R.id.editHistory);;

        mButtonON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(getApplicationContext(),"Turning ON the Bluetooth", Toast.LENGTH_SHORT).show();
                    //mHistory.setText(TurningON);
            }
        });

        mButtonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(getApplicationContext(),"Turning OFF the Bluetooth", Toast.LENGTH_SHORT).show();
                    //mHistory.setText(TurningOFF);

            }
        });


    }
}
