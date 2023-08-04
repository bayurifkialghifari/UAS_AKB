package com.uas.notes.helper;

import com.google.firebase.database.DatabaseReference;
import com.uas.notes.model.User;

public class DBHelper {
    public static void saveUser(DatabaseReference DB, String userId, String name, String email) {
        User user = new User(name, email);

        DB.child("users").child(userId).setValue(user);
    }
}
