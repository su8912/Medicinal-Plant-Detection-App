package com.example.imdetect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main_page extends AppCompatActivity {
    Button move1 , move2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);
        move1 = findViewById(R.id.button3);





        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_page.this, home_page.class);

                startActivity(intent);
            }


        });
        move2 = findViewById(R.id.button4);

        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_page.this, about_us.class);
                startActivity(intent);
            }
        });



    }
}