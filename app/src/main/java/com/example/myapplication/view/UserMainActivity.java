package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the appearance of the user's main page
 * </p>
 */
public class UserMainActivity extends AppCompatActivity {

    private static final String ID = "id";
    public static final int REQUEST_CODE = 26;
    ImageView notificationsBtn;
    ImageView paymentsBtn;
    ImageView balanceBtn;
    int userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        Intent gIntent = getIntent();
        userid = gIntent.getIntExtra(ID, -1);
        System.out.println("FUCKING USERID: " + userid);

        notificationsBtn = (ImageView) findViewById(R.id.imageViewUserNotificationsImg);
        paymentsBtn = (ImageView) findViewById(R.id.imageViewUserPaymentsImg);
        balanceBtn = (ImageView) findViewById(R.id.imageViewBalanceBtn);

        notificationsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(UserMainActivity.this, ShowNotificationsActivity.class);
                intent12.putExtra(ID, userid);
                startActivity(intent12);
            }
        });

        paymentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(UserMainActivity.this, MakePaymentActivity.class);
                intent12.putExtra(ID, userid);
                startActivity(intent12);
            }
        });

        balanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent14 = new Intent(UserMainActivity.this, ShowBalanceActivity.class);
                intent14.putExtra(ID, userid);
                startActivity(intent14);
            }
        });
    }
}