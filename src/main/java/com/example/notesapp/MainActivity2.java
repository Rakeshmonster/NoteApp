package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText edTitle, edContent;

    Button button;

    NoteHelper noteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edTitle = findViewById(R.id.edTitle);
        edContent = findViewById(R.id.edContent);
        button = findViewById(R.id.addButton);
        noteHelper = new NoteHelper(MainActivity2.this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edTitle.length()>0&& edContent.length()>0){

                    noteHelper.insertData(edTitle.getText().toString(), edContent.getText().toString());
                    Toast.makeText(MainActivity2.this,"The Note Successfully Added",Toast.LENGTH_SHORT).show();
                    edContent.setText("");
                    edTitle.setText("");
                    startActivity(new Intent(MainActivity2.this,MainActivity.class));

                }else {

                    Toast.makeText(MainActivity2.this,"The Edit Note Box is empty",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity2.this,MainActivity.class));
        super.onBackPressed();

    }

}

