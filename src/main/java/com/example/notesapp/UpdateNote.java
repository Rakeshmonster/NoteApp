package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateNote extends AppCompatActivity {

    EditText updateTitle, updateContent;
    Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updateBtn = findViewById(R.id.updateBtn);
        updateTitle = findViewById(R.id.updateTitle);
        updateContent = findViewById(R.id.updateContent);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("description");
        int id = getIntent().getIntExtra("id",0);
        updateTitle.setText(title);
        updateContent.setText(desc);

        String sId = String.valueOf(id);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (updateTitle.length()>0&& updateContent.length()>0){

                    NoteHelper noteHelper = new NoteHelper(UpdateNote.this);
                    noteHelper.updateData(updateTitle.getText().toString(), updateContent.getText().toString(),sId);
                    Toast.makeText(UpdateNote.this,"The Data is Successfully Updated",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateNote.this,MainActivity.class));

                }else {

                    Toast.makeText(UpdateNote.this,"The Edit Note Box is empty",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(UpdateNote.this,MainActivity.class));
        super.onBackPressed();

    }
}

