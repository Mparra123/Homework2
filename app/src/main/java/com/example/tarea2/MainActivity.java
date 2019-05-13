package com.example.tarea2;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.bluetooth.BluetoothAdapter.getDefaultAdapter;

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

        final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        final Button mButtonON = (Button)findViewById(R.id.btnON);
        final Button mButtonOFF = (Button)findViewById(R.id.btnOFF);
        final EditText mHistory = (EditText)findViewById(R.id.editHistory);;


        mButtonON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if(mBluetoothAdapter == null)
                    {
                        Toast.makeText(getApplicationContext(),"Bluetooth Not Supported",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(!mBluetoothAdapter.isEnabled()){
                            startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),1);
                            Toast.makeText(getApplicationContext(),"Bluetooth Turned ON",Toast.LENGTH_SHORT).show();
                            mHistory.setText(TurningON);
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error exception", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(),"Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();
                    mHistory.setText(TurningOFF);

            }
        });

    }
}
