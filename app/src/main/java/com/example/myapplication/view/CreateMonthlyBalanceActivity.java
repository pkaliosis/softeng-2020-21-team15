package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.model.Building;
import com.example.myapplication.model.DAO;
import com.example.myapplication.model.Notification;
import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the interface of the creation of the monthly balance
 * </p>
 */
public class CreateMonthlyBalanceActivity extends AppCompatActivity {

    Building mybuilding;

    EditText inputBalanceElectricity;
    EditText inputBalanceElevator;
    EditText inputBalanceCleaning;
    EditText inputBalanceHeating;
    ImageView btnSubmitMonthlyBalance;

    double electricity;
    double elevator;
    double cleaning;
    double heating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_monthly_balance);

        inputBalanceElectricity = findViewById(R.id.editTextBalanceElectricity);
        inputBalanceElevator = findViewById(R.id.editTextBalanceElevator);
        inputBalanceCleaning = findViewById(R.id.editTextBalanceCleaning);
        inputBalanceHeating = findViewById(R.id.editTextBalanceHeating);

        btnSubmitMonthlyBalance = (ImageView) findViewById(R.id.imageViewBtnAddMonthlyBalance);

        mybuilding = DAO.getBuilding();

        btnSubmitMonthlyBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                electricity = Double.parseDouble(inputBalanceElectricity.getText().toString());
                elevator = Double.parseDouble(inputBalanceElevator.getText().toString());
                cleaning = Double.parseDouble(inputBalanceCleaning.getText().toString());
                heating = Double.parseDouble(inputBalanceHeating.getText().toString());


                System.out.println("ELECTRICITY: " + electricity);
                System.out.println("ELEVATOR " + elevator);
                System.out.println("CLEANING: " + cleaning);
                System.out.println("HEATING: " + heating);

                for (int i=0; i< DAO.DAOflats.size(); i++){
                    mybuilding.calculateMonthlyBalance(electricity, elevator, cleaning, heating, DAO.DAOflats.get(i));
                }

                for (int i=0; i< DAO.DAOflats.size(); i++){
                    System.out.println(DAO.DAOflats.get(i).getBalance().getAmount());
                }



                Intent intent11 = new Intent(CreateMonthlyBalanceActivity.this, AdminMainActivity.class);
                startActivity(intent11);
            }
        });


    }
}