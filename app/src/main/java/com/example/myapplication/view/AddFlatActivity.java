package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.model.Admin;
import com.example.myapplication.model.Building;
import com.example.myapplication.model.Flat;
import com.example.myapplication.model.R;

import java.io.Serializable;

/**
 * <p>
 * This class is responsible for the insertion of the flat elements and the addition of the flat to the list
 * </p>
 */
public class AddFlatActivity extends AppCompatActivity {

    private static final String BUILDING = "building";
    public static final String FLAT = "flat";
    EditText inputFlatId;
    EditText inputUserId;
    EditText inputFloor;
    EditText inputArea;
    EditText inputHP;
    Button btnSubmitFlat;

    int flatid;
    int userid;
    int floor;
    double area;
    double heatingPct;

    Flat flat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flat);
        setTitle("Create Flat");


        inputFlatId = findViewById(R.id.editTextFlatFlatId);
        inputUserId = findViewById(R.id.editTextFlatUserId);
        inputFloor = findViewById(R.id.editTextFloor);
        inputArea = findViewById(R.id.editTextFlatArea);
        inputHP = findViewById(R.id.editTextHP);

        btnSubmitFlat = (Button) findViewById(R.id.btn_addFlatSubmit);

        btnSubmitFlat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                flatid = Integer.valueOf(inputFlatId.getText().toString());
                userid = Integer.valueOf(inputUserId.getText().toString());
                floor = Integer.valueOf(inputFloor.getText().toString());
                area = Double.parseDouble(inputArea.getText().toString());
                heatingPct = Double.parseDouble(inputHP.getText().toString());


                flat = new Flat(flatid, userid, floor, area, heatingPct);
                System.out.println("FLAT ID: " + flat.getId());
                System.out.println("USER ID: " + flat.getUserId());
                System.out.println("FLOOR: " + flat.getFloor());
                System.out.println("AREA: " + flat.getArea());
                System.out.println("HEATING PCT: " + flat.getHeatingPercentage());
                //Toast.makeText(AddFlatActivity.this, flat.getUserId(), Toast.LENGTH_SHORT).show();

                returnToFlatsList();

                /*
                Intent intent = new Intent();
                intent.putExtra(FLAT, (Serializable) flat);
                setResult(RESULT_OK, intent);

                 */

                /*
                Intent intent4 = new Intent(AddFlatActivity.this, FlatInit.class);
                intent4.putExtra(BUILDING, (Serializable) flat);
                startActivity(intent4);

                 */
            }

        });
    }

    /*
    @Override
    public void onBackPressed() {
        returnToFlatsList();
        super.onBackPressed();
    }

     */

    protected void returnToFlatsList() {
        //Toast.makeText(AddFlatActivity.this, flat.getUserId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra(FLAT, flat);
        //Toast.makeText(AddFlatActivity.this, flat.getUserId(), Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, intent);
        finish();
//        Intent intent5 = new Intent(AddFlatActivity.this, Activity_intialize_flat.class);
//        intent5.putExtra(FLAT, flat);
//        startActivity(intent5);
    }
}