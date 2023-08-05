/**
 * NIM : 10120003
 * NAMA : BAYU RIFKI ALGHIFARI
 * KELAS : IF-1
 */
package com.uas.notes.helper;

import com.google.firebase.database.DatabaseReference;
import com.uas.notes.model.Note;
import com.uas.notes.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHelper {
    public static void saveUser(DatabaseReference DB, String userId, String name, String email) {
        User user = new User(name, email);

        DB.child("users").child(userId).setValue(user);
    }

    public static void saveNotes(DatabaseReference DB, String userId, String title, String category, String note) {
        SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
        String now = ISO_8601_FORMAT.format(new Date());

        Note notes = new Note(userId, title, note, category, now, now);

        DB.child(userId).setValue(notes);
    }

}
