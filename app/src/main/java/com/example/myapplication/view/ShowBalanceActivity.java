package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.model.DAO;
import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible to show the current balance of a user
 * </p>
 */
public class ShowBalanceActivity extends AppCompatActivity {

    private static final String ID = "id";
    TextView balanceAmount;
    double balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_balance);
        setTitle("My Balance");

        Intent gIntent = getIntent();
        int userid = gIntent.getIntExtra(ID, -1);

        balanceAmount = (TextView) findViewById(R.id.textViewBalanceAmount);
        //balance = Double.parseDouble(balanceAmount.getText().toString());
        for (int i=0; i< DAO.DAOflats.size(); i++) {
            if (DAO.DAOflats.get(i).getUserId() == userid) {
                balance = DAO.DAOflats.get(i).getBalance().getAmount();
            }
        }
        balanceAmount.setText("Amount: " + balance + "euros.");

        getString(R.string.User_MyBalanceAmount);
    }
}