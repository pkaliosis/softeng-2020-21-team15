package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.model.DAO;
import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the appearance of the notifications list
 * </p>
 */
public class ShowNotificationsActivity extends AppCompatActivity {

    private static final String ID = "id";
    ListView listView;
    Button btnBackToMainScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notifications);
        setTitle("Users Notifications");

        Intent gIntent = getIntent();
        int userid = gIntent.getIntExtra(ID, -1);

        listView = (ListView)findViewById(R.id.listviewNotifications);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, DAO.DAOnotifications);
        listView.setAdapter(arrayAdapter);


        btnBackToMainScreen = (Button) findViewById(R.id.backToUserMainActivity);

        btnBackToMainScreen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent13 = new Intent(ShowNotificationsActivity.this, UserMainActivity.class);
                intent13.putExtra(ID, userid);
                startActivity(intent13);
            }
        });
    }
}