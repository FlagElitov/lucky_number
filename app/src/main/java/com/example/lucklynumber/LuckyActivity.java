package com.example.lucklynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        textView = findViewById(R.id.luckyTextView);
        button = findViewById(R.id.shareButton);

        String userName = getIntent().getStringExtra("userName");
        int randomNumber = generateRandomNumber();
        textView.setText(String.valueOf(randomNumber));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareLuckyNumber(userName, randomNumber);
            }
        });
    }
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public void shareLuckyNumber(String userName, int randomNumber){
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String number = String.valueOf(randomNumber);
        intent.putExtra(Intent.EXTRA_SUBJECT, userName);
        intent.putExtra(Intent.EXTRA_TEXT, "Your lucky number is: " + number);
        startActivity(Intent.createChooser(intent,"Choose a platform"));
    }
}