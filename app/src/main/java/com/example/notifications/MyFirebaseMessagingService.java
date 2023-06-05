package com.example.notifications;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.application.isradeleon.notify.Notify;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    String from, to, phone, email;

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.i("newToken", token);
        //Add your token in your sharepreferences.
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("fcm_token", token).apply();
    }

    public static String getToken(Context context) {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString("fcm_token", "empty");
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        Log.i("mesggg", message.getFrom());
        try{
            Map<String, String> params= message.getData();
            JSONObject object= new JSONObject(params);
            from= object.getString("ffrom");
            to= object.getString("tto");
            phone= object.getString("ph");
            email= object.getString("email");
            Notify.build(this)
                    .setTitle(from)
                    .setContent(to)
                    .show();

        }catch (Exception e){}


    }
}
