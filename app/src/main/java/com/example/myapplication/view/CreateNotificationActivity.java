package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.model.DAO;
import com.example.myapplication.model.Notification;
import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the interface of the creation of a notification
 * </p>
 */
public class CreateNotificationActivity extends AppCompatActivity {

    EditText inputNotifId;
    EditText inputNotifDate;
    EditText inputNotifDescription;
    ImageView btnSubmitNotif;

    int notifId;
    String notifDate;
    String notifDescription;

    Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notification);

        inputNotifId = findViewById(R.id.editTextNotifId);
        inputNotifDate = findViewById(R.id.editTextNotifDate);
        inputNotifDescription = findViewById(R.id.editTextNotifDescription);

        btnSubmitNotif = (ImageView) findViewById(R.id.imageViewSubmitNotif);

        btnSubmitNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifId = Integer.valueOf(inputNotifId.getText().toString());
                notifDate = inputNotifDate.getText().toString();
                notifDescription = inputNotifDescription.getText().toString();

                notification = new Notification(notifId, notifDescription, notifDate);

                System.out.println("NOTIFICATION ID: " + notification.getNId());
                System.out.println("NOTIFICATION DATE: " + notification.getDate());
                System.out.println("NOTIFICATION DESCRIPTION: " + notification.getDescription());

                DAO.addNotification(notification);

                Intent intent10 = new Intent(CreateNotificationActivity.this, AdminMainActivity.class);
                startActivity(intent10);
            }
        });
    }
}