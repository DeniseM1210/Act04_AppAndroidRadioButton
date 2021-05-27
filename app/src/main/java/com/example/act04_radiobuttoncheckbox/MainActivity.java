package com.example.act04_radiobuttoncheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton radioD, radioB, radioO, radioH;
    CheckBox cbBin, cbOct, cbHex;
    EditText cajaNum, cajaBin, cajaOct, cajaHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioD = findViewById(R.id.radio_decimal);
        radioB = findViewById(R.id.radio_binario);
        radioO = findViewById(R.id.radio_octal);
        radioH = findViewById(R.id.radio_hexa);

        cbBin = findViewById(R.id.checkBox_binario);
        cbOct = findViewById(R.id.checkBox_octal);
        cbHex = findViewById(R.id.checkBox_hexa);

        cajaNum = findViewById(R.id.caja_numero);
        cajaBin = findViewById(R.id.cajaBinario);
        cajaOct = findViewById(R.id.cajaOctal);
        cajaHex = findViewById(R.id.cajaHexa);

    }

    @Override
    public void onClick(View v) {
        if(radioD.isChecked()){
            if(cbBin.isChecked()){
                if(cajaNum.getText().equals("")){
                    Toast.makeText(this, "ERROR!", Toast.LENGTH_LONG).show();
                }else{
                    cajaBin.setText(convertirDecimalaBinario());
                }

            }else if(cbOct.isChecked()){
               String valor = cajaNum.getText().toString();
               int decimal = Integer.parseInt(valor);

               cajaOct.setText(convertirDecimalOctal(decimal));
            }else if(cbHex.isChecked()){
                String valor = cajaNum.getText().toString();
                int decimal = Integer.parseInt(valor);

                cajaHex.setText(convertirDecimalAHexadecimal(decimal));
            }
        }else if(radioB.isChecked()){
            if(cbBin.isChecked()) {
                String valor = cajaNum.getText().toString();
                int binario = Integer.parseInt(valor);
                if(validarBinario(binario) == true){
                    cajaBin.setText(valor);
                }else{
                    Toast.makeText(this, "ERROR! No es Binario", Toast.LENGTH_LONG).show();
                }
            }else if(cbOct.isChecked()){
                String valor = cajaNum.getText().toString();
                int binario = Integer.parseInt(valor);
                if(validarBinario(binario) == true){
                    cajaBin.setText(valor);
                }else{
                    Toast.makeText(this, "ERROR! No es Binario", Toast.LENGTH_LONG).show();
                }
            }



        }

    }

    public static boolean validarBinario(int binario) {
        // Comprobar si solo se compone de unos y ceros
        String binarioComoCadena = String.valueOf(binario);
        for (int i = 0; i < binarioComoCadena.length(); i++) {
            char caracter = binarioComoCadena.charAt(i);
            if (caracter != '0' && caracter != '1') {
                return false;
            }
        }
        return true;
    }

    public String convertirDecimalaBinario(){
        long decimal = Long.parseLong(cajaNum.getText().toString());
        return(Long.toBinaryString(decimal));
    }

    public String convertirDecimalOctal(int decimal){
        String octal = "";
        String caracteresOctales = "01234567";
        while (decimal > 0) {
            int residuo = decimal % 8;
            octal = (caracteresOctales.charAt(residuo) + octal);
            decimal /= 8;
        }
        return octal;
    }

    public static String convertirDecimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789abcdef";
        while (decimal > 0) {
            int residuo = decimal % 16;
            hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal;
            decimal /= 16;
        }
        return hexadecimal;
    }







}