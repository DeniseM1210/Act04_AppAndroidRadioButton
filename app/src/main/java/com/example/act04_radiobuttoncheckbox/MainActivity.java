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
                String valor = cajaNum.getText().toString();
                int decimal = Integer.parseInt(valor);

                cajaBin.setText(convertirDecimalABinario(decimal));
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
                    int decimal = convertirBinarioADecimal(binario);
                    cajaOct.setText(convertirDecimalOctal(decimal));
                }else{
                    Toast.makeText(this, "ERROR! No es Binario", Toast.LENGTH_LONG).show();
                }
            }else if(cbHex.isChecked()){
                String valor = cajaNum.getText().toString();
                int binario = Integer.parseInt(valor);
                if(validarBinario(binario) == true){
                    int decimal = convertirBinarioADecimal(binario);
                    cajaHex.setText(convertirDecimalAHexadecimal(decimal));
                }else{
                    Toast.makeText(this, "ERROR! No es Binario", Toast.LENGTH_LONG).show();
                }
            }
        }else if(radioO.isChecked()){
            if(cbBin.isChecked()){
                String valor = cajaNum.getText().toString();
                int octal = Integer.parseInt(valor);
                if(validarOctal(octal) == true){
                    int decimal = convertirOctalADecimal(octal);
                    cajaBin.setText(convertirDecimalABinario(decimal));
                }else{
                    Toast.makeText(this, "ERROR! No es Octal", Toast.LENGTH_LONG).show();
                }
            }else if(cbOct.isChecked()){
                String valor = cajaNum.getText().toString();
                int octal = Integer.parseInt(valor);
                if(validarOctal(octal) == true){
                    cajaOct.setText(valor);
                }else{
                    Toast.makeText(this, "ERROR! No es Octal", Toast.LENGTH_LONG).show();
                }
            }else if(cbHex.isChecked()){
                String valor = cajaNum.getText().toString();
                int octal = Integer.parseInt(valor);
                if(validarOctal(octal) == true){
                    int decimal = convertirOctalADecimal(octal);
                    cajaHex.setText(convertirDecimalAHexadecimal(decimal));
                }else{
                    Toast.makeText(this, "ERROR! No es Octal", Toast.LENGTH_LONG).show();
                }
            }

        }else if(radioH.isChecked()){
            if(cbBin.isChecked()){
                String valor = cajaNum.getText().toString();
                if(validarHexadecimal(valor) == true){
                    int decimal = convertirHexadecimalADecimal(valor);
                    cajaBin.setText(convertirDecimalABinario(decimal));
                }else{
                    Toast.makeText(this, "ERROR! No es Hexadecimal", Toast.LENGTH_LONG).show();
                }
            }else if(cbOct.isChecked()){
                String valor = cajaNum.getText().toString();
                if(validarHexadecimal(valor) == true){
                    int decimal = convertirHexadecimalADecimal(valor);
                    cajaOct.setText(convertirDecimalOctal(decimal));
                }else{
                    Toast.makeText(this, "ERROR! No es Hexadecimal", Toast.LENGTH_LONG).show();
                }
            }else if(cbHex.isChecked()){
                String valor = cajaNum.getText().toString();
                if(validarHexadecimal(valor) == true){
                    cajaHex.setText(cajaNum.getText().toString());
                }else{
                    Toast.makeText(this, "ERROR! No es Hexadecimal", Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    public static boolean validarBinario(int binario) {
        String binarioComoCadena = String.valueOf(binario);
        for (int i = 0; i < binarioComoCadena.length(); i++) {
            char caracter = binarioComoCadena.charAt(i);
            if (caracter != '0' && caracter != '1') {
                return false;
            }
        }
        return true;
    }

    public static boolean validarOctal(int octal) {
        String octalComoCadena = String.valueOf(octal);
        String caracteresOctales = "01234567";
        for (int i = 0; i < octalComoCadena.length(); i++) {
            char caracter = octalComoCadena.charAt(i);
            if (caracteresOctales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean validarHexadecimal(String hexadecimal){
        String caracteresHexadecimales = "0123456789ABCDEF";
        for (int i = 0; i < hexadecimal.length(); i++){
            char caracter = hexadecimal.charAt(i);

            if(caracteresHexadecimales.indexOf(caracter) == -1){
                return false;
            }
        }
        return true;
    }

    public String convertirDecimalABinario(int decimal) {
        String binario = "";
        while (decimal > 0) {
            binario = decimal % 2 + binario;
            decimal = decimal / 2;
        }
        return binario;
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

    public String convertirDecimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789ABCDEF";
        while (decimal > 0) {
            int residuo = decimal % 16;
            hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal;
            decimal /= 16;
        }
        return hexadecimal;
    }

    public static int convertirBinarioADecimal(int binario) {
        int decimal = 0;
        int potencia = 0;
        while (true) {
            if (binario == 0) {
                break;
            } else {
                int temp = binario % 10;
                decimal += temp * Math.pow(2, potencia);
                binario = binario / 10;
                potencia++;
            }
        }
        return decimal;
    }

    public static int convertirOctalADecimal(int octal) {
        int decimal = 0;
        int potencia = 0;
        while (true) {
            if (octal == 0) {
                break;
            } else {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, potencia);
                octal = octal / 10;
                potencia++;
            }
        }
        return decimal;
    }

    public int convertirHexadecimalADecimal(String hexadecimal){
        String caracteresHexadecimales = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++){
            char caracter = hexadecimal.charAt(i);
            int posicionEnCaracteres = caracteresHexadecimales.indexOf(caracter);
            decimal = 16 * decimal + posicionEnCaracteres;
        }

        return decimal;
    }








}