package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("PROCESS", getLocalClassName() + ".onCreate() chamado.");

        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        Log.i("PROCESS", getLocalClassName() + ".onStart() chamado.");
    }

    protected void onResume() {
        super.onResume();
        Log.i("PROCESS", getLocalClassName() + ".onResume() chamado.");
    }

    protected void onPause() {
        super.onPause();
        Log.i("PROCESS", getLocalClassName() + ".onPause() chamado.");
    }

    protected void onStop() {
        super.onStop();
        Log.i("PROCESS", getLocalClassName() + ".onStop() chamado.");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("PROCESS", getLocalClassName() + ".onDestroy() chamado.");
    }

    public void navigate(View v) {
        EditText name = (EditText) findViewById(R.id.name);
        EditText age = (EditText) findViewById(R.id.age);
        EditText weight =(EditText)  findViewById(R.id.weight);
        EditText height = (EditText) findViewById(R.id.height);

        if(name.getText().toString().equals("")) {
            Log.i("PROCESS", "ERROR: NULL NAME");
            return;
        }
        if(age.getText().toString().equals("")) {
            Log.i("PROCESS", "ERROR: NULL AGE");
            return;
        }
        if(weight.getText().toString().equals("")) {
            Log.i("PROCESS", "ERROR: NULL WEIGHT");
            return;
        }
        if(height.getText().toString().equals("")) {
            Log.i("PROCESS", "ERROR: NULL HEIGHT");
            return;
        }

        Double imc = Double.parseDouble(weight.getText().toString()) / (Double.parseDouble(height.getText().toString()) * Double.parseDouble(height.getText().toString()));

        Intent it = new Intent(this, SecondActivity.class);
        Bundle params = new Bundle();

        params.putString("name", name.getText().toString());
        params.putInt("age", Integer.parseInt(age.getText().toString()));
        params.putDouble("weight", Double.parseDouble(weight.getText().toString()));
        params.putDouble("height", Double.parseDouble(height.getText().toString()));
        params.putDouble("imc", imc);

        it.putExtras(params);
        startActivity(it);
    }
}