package com.appimc;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = findViewById(R.id.textViewResult);
        TextView textViewMessage = findViewById(R.id.textViewMessage);
        ImageView imageViewEmoji = findViewById(R.id.imageViewEmoji);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        double imc = intent.getDoubleExtra("IMC_RESULT", 0.0);

        textViewResult.setText(String.format("IMC: %.2f", imc));

        String text;
        int resId;

        if (imc == 0) {
            text = "Ocorreu algum erro.";
            resId = R.drawable.error;
        } else if (imc < 18.5) {
            text = "Classificação: Magreza";
            resId = R.drawable.underweight;
        } else if (imc < 25) {
            text = "Classificação: Normal";
            resId = R.drawable.regular;
        } else if (imc < 30) {
            text = "Classificação: Sobrepeso";
            resId = R.drawable.overweight;
        } else if (imc < 35){
            text = "Classificação: Obesidade Grau I";
            resId = R.drawable.obesityi;
        } else if (imc < 40){
            text = "Classificação: Obesidade Grau II";
            resId = R.drawable.obesityii;
        } else {
            text = "Classificação: Obesidade Grau III";
            resId = R.drawable.obesityiii;
        }

        textViewMessage.setText(text);
        imageViewEmoji.setImageResource(resId);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

