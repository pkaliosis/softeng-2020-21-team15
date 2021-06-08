package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.model.DAO;
import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the appearance of the admin's main page
 * </p>
 */
public class AdminMainActivity extends AppCompatActivity {

    Button btnCreateNotification;
    Button btnCreateMonthlyBalance;
    Button btnManagePayments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        for (int i=0; i< DAO.DAOnotifications.size(); i++){
            System.out.println(DAO.DAOnotifications.get(i).getDescription());
        }

        btnCreateNotification = (Button) findViewById(R.id.Admin_newNotif);

        btnCreateNotification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent9 = new Intent(AdminMainActivity.this, CreateNotificationActivity.class);
                startActivity(intent9);
            }
        });

        btnCreateMonthlyBalance = (Button) findViewById(R.id.btn_newMonthlyBalance);

        btnCreateMonthlyBalance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent10 = new Intent(AdminMainActivity.this, CreateMonthlyBalanceActivity.class);
                startActivity(intent10);
            }
        });

        btnManagePayments = (Button) findViewById(R.id.btnManagePayments);

        btnManagePayments.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent11 = new Intent(AdminMainActivity.this, ManagePaymentsActivity.class);
                startActivity(intent11);
            }
        });
    }
}