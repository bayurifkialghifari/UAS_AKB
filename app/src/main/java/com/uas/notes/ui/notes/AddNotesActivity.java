/**
 * NIM : 10120003
 * NAMA : BAYU RIFKI ALGHIFARI
 * KELAS : IF-1
 */
package com.uas.notes.ui.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.uas.notes.Config;
import com.uas.notes.MainActivity;
import com.uas.notes.R;
import com.uas.notes.auth.LoginActivity;
import com.uas.notes.helper.DBHelper;

public class AddNotesActivity extends AppCompatActivity {

    private DatabaseReference DB;
    private FirebaseAuth Auth;
    private EditText fTitle;
    private EditText fCategory;
    private EditText fNote;
    private Button bSave;
    private Button bBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        DB = FirebaseDatabase.getInstance(Config.getDB_URL()).getReference("notes");
        Auth = FirebaseAuth.getInstance();

        // Set component
        fTitle = findViewById(R.id.add_note_title);
        fCategory = findViewById(R.id.add_note_category);
        fNote = findViewById(R.id.add_note_description);
        bSave = findViewById(R.id.add_note_save_btn);
        bBack = findViewById(R.id.add_note_back_btn);

        // Save button on click
        bSave.setOnClickListener(v -> {
            DBHelper.saveNotes(DB,
                        Auth.getCurrentUser().getUid(),
                        fTitle.getText().toString(),
                        fCategory.getText().toString(),
                        fNote.getText().toString()
                    );

            // Make alert
            Toast.makeText(AddNotesActivity.this, "Data created !",
                    Toast.LENGTH_SHORT).show();
        });

        // Back button on click
        bBack.setOnClickListener(v -> {
            Intent intent = new Intent(AddNotesActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}