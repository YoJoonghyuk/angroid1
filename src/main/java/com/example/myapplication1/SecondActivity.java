package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewGreeting;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewGreeting = findViewById(R.id.textViewGreeting);
        editTextName = findViewById(R.id.editTextName);
        Button buttonOkName = findViewById(R.id.buttonOkName);

        String greeting = getIntent().getStringExtra("GREETING");
        textViewGreeting.setText(greeting);

        buttonOkName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String fullGreeting = greeting + ", " + name + "!";
                Intent returnIntent = new Intent();
                returnIntent.putExtra("FULL_GREETING", fullGreeting);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
