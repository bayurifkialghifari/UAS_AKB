package com.uas.notes.helper;

import android.content.Context;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;

public class FCMHelper {

    public static String token = "keren";
    public static String getToken(Context ctx) {
        String TAG = "GGWP";

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                        return;
                    }

                    // Get new FCM registration token
                    token = task.getResult();

                    // Log and toast
                    Log.d(TAG, token);
                });

        return token;
    }

    public static void sendNotifNewNote(String token) {

    }
}
