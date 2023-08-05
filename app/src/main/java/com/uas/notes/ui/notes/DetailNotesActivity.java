/**
 * NIM : 10120003
 * NAMA : BAYU RIFKI ALGHIFARI
 * KELAS : IF-1
 */
package com.uas.notes.ui.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uas.notes.MainActivity;
import com.uas.notes.R;

public class DetailNotesActivity extends AppCompatActivity {

    private String category;
    private FloatingActionButton bBack;
    private FloatingActionButton bAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notes);
        Intent intent = getIntent();

        // Set component
        bAdd = findViewById(R.id.note_detail_add_btn);
        bBack = findViewById(R.id.note_detail_back_btn);

        // Set category
        this.category = intent.getStringExtra("category");

        // Set title for this activity
        this.setTitle("Note " + this.category);

        // Move to previous activity
        bBack.setOnClickListener(v -> {
            Intent moveToMain = new Intent(this, MainActivity.class);
            moveToMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(moveToMain);
            finish();
        });

        // Add button on click
        bAdd.setOnClickListener(v -> {
            Intent moveToAdd = new Intent(this, AddNotesActivity.class);
            moveToAdd.putExtra("backTo", "note_detail");
            moveToAdd.putExtra("category", this.category);
            moveToAdd.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(moveToAdd);
            finish();
        });
    }
}