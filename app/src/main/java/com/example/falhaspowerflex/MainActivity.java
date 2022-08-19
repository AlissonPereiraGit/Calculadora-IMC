package com.example.falhaspowerflex;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.falhaspowerflex.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        textResultado = findViewById(R.id.textResultado);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);

    }
    @SuppressLint("SetTextI18n")
    public void calcularImc(View v){

        DecimalFormat dec = new DecimalFormat("##.00");

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble((editAltura.getText()).toString());
        double resultado = Double.parseDouble(dec.format((peso / (altura*altura))));

        if (resultado < 19){
            textResultado.setText("Resultado = " + resultado + "  Abaixo do peso.");
        }
        else if (resultado == 19 || resultado < 25){
            textResultado.setText("Resultado = "+ resultado + "  Peso normal.");
        }
        else if (resultado == 25 || resultado < 30){
            textResultado.setText("Resultado = "+ resultado + "  Sobrepeso.");
        }
        else if (resultado == 30 || resultado < 40){
            textResultado.setText("Resultado = "+ resultado + "  Obesidade tipo 1.");
        }
        else if (resultado >= 40 ){
            textResultado.setText("Resultado = "+ resultado + "  Obesidade tipo 2.");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






}