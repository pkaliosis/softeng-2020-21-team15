package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.model.Flat;
import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the interface of the subtraction of the amount that has been payed by the renter
 * </p>
 */
public class EditPaymentActivity extends AppCompatActivity {

    public static final String AMOUNT = "amount";
    private static final String FID = "fid";
    EditText inputAmount;
    ImageView btnSubmitEdit;

    double amount;
    int fid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_payment);
        setTitle("Edit Payment");
        Intent gIntent3 =getIntent();
        fid = gIntent3.getIntExtra(FID, -1);

        inputAmount = findViewById(R.id.editTextEditAmount);
        btnSubmitEdit = (ImageView) findViewById(R.id.imageButtonSubmitEdit);

        btnSubmitEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                amount = Double.parseDouble(inputAmount.getText().toString());

                returnToEditPaymentsList();

            }

        });
    }

    protected void returnToEditPaymentsList() {
        //Toast.makeText(AddFlatActivity.this, flat.getUserId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra(AMOUNT, amount);
        intent.putExtra(FID, fid);
        //Toast.makeText(AddFlatActivity.this, flat.getUserId(), Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, intent);
        finish();
    }
}
