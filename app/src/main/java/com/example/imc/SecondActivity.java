package com.example.imc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("PROCESS", "On Create " + "Tela 2");

        Intent it = getIntent();
        Bundle params = it.getExtras();

        TextView nome = findViewById(R.id.nome);
        TextView idade = findViewById(R.id.idade);
        TextView peso = findViewById(R.id.peso);
        TextView altura = findViewById(R.id.altura);
        TextView imc = findViewById(R.id.imc);
        TextView classificacao = findViewById(R.id.classificacao);

        Double imc_value = params.getDouble("imc");

        nome.setText( nome.getText() + params.getString("name"));
        idade.setText(idade.getText().toString() + params.getInt("age"));
        peso.setText(peso.getText().toString() + params.getDouble("weight"));
        altura.setText(altura.getText().toString() + params.getDouble("height"));
        imc.setText(imc.getText().toString() + imc_value);

        if(imc_value < 18.5) {
            classificacao.setText(classificacao.getText().toString() + "Abaixo do Peso");
        } else if(imc_value < 24.9) {
            classificacao.setText(classificacao.getText().toString() + "Saudável");
        } else if(imc_value < 29.9) {
            classificacao.setText(classificacao.getText().toString() + "Sobrepeso");
        } else if(imc_value < 34.9) {
            classificacao.setText(classificacao.getText().toString() + "Obesidade Grau I");
        } else if(imc_value < 39.9) {
            classificacao.setText(classificacao.getText().toString() + "Obesidade Grau II (severa)");
        } else {
            classificacao.setText(classificacao.getText().toString() + "Obesidade Grau III (mórbida)");
        }
        Log.i("PROCESS", "On Create " + "dados lidos.");
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

    public void getBack(View v) {
        finish();
    }
}
