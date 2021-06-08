package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.model.DAO;
import com.example.myapplication.model.Flat;
import com.example.myapplication.model.Payment;
import com.example.myapplication.model.PaymentType;
import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the appearance of the online payment
 * </p>
 */
public class MakePaymentActivity extends AppCompatActivity {

    private static final String ID = "id";
    EditText inputPaymentAmount;
    EditText inputPaymentDate;
    Button btnMakePayment;

    double paymentAmount;
    String paymentDate;

    Payment payment;
    int userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        setTitle("Make Online Payment");

        Intent gIntent = getIntent();
        userid = gIntent.getIntExtra(ID, -1);
        System.out.println("FUCKING USERID 2: " + userid);

        inputPaymentAmount = findViewById(R.id.editTextPaymentAmount);
        inputPaymentDate = findViewById(R.id.editTextPaymentDate);

        btnMakePayment = (Button) findViewById(R.id.btn_makePayment);

        btnMakePayment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paymentAmount = Double.parseDouble(inputPaymentAmount.getText().toString());
                paymentDate = inputPaymentDate.getText().toString();

                payment = new Payment(paymentAmount, userid, PaymentType.ONLINE, paymentDate);
                System.out.println("Payment ID: " + payment.getPId());
                System.out.println("Payment User ID: " + payment.getUserId());
                System.out.println("Payment PaymentType: " + payment.getType());
                System.out.println("Payment Date: " + payment.getDate());

                for (int i=0; i<DAO.DAOflats.size(); i++) {
                    if (DAO.DAOflats.get(i).getUserId() == userid) {
                        System.out.println("BEFORE PAYMENT: " + DAO.DAOflats.get(i).getBalance().getAmount());
                        DAO.DAOflats.get(i).getBalance().setAmount(DAO.DAOflats.get(i).getBalance().getAmount() - paymentAmount);
                        System.out.println("AFTER PAYMENT: " + DAO.DAOflats.get(i).getBalance().getAmount());
                    }
                }
                Toast.makeText(MakePaymentActivity.this, "PAYMENT DONE WITH ID: " + payment.getPId(), Toast.LENGTH_SHORT).show();



                Intent intent13 = new Intent(MakePaymentActivity.this, UserMainActivity.class);
                intent13.putExtra(ID, userid);
                startActivity(intent13);



        }
        });

    }
}