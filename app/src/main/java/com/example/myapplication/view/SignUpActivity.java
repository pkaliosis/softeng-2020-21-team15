package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.model.Admin;
import com.example.myapplication.model.Building;
import com.example.myapplication.model.DAO;
import com.example.myapplication.model.R;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the interface of the initialization of a new building
 * </p>
 */
public class SignUpActivity extends AppCompatActivity {

    public static final String BUILDING = "building";
    EditText inputAddress;
    EditText inputNumOfFloors;
    EditText inputNumOfFlats;
    RadioButton rb;
    RadioButton rb2;
    RadioGroup rg;
    RadioGroup rg2;
    Button btnSubmit;
    boolean elev_bool = false;

    String address;
    int numOfFloors;
    int numOfFlats;
    String heatingType;
    boolean elevator;

    String elevatorString;
    public static Building building;
    public static Admin admin;

    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public ArrayList<Building> buildings = new ArrayList<Building>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");

        inputAddress = findViewById(R.id.editTextBuildingAddress);
        inputNumOfFloors = findViewById(R.id.editTextBuildingFloors);
        inputNumOfFlats = findViewById(R.id.editTextNumberOfFlats);

        rg = (RadioGroup) findViewById(R.id.radioGroupHT);
        rg2 = (RadioGroup) findViewById(R.id.radioGroupElevator);
        btnSubmit = (Button) findViewById(R.id.buttonBuildingSubmitData);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = rg.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                rb = (RadioButton) findViewById(selectedId);

                //Toast.makeText(SignUpActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();

                // get selected radio button from radioGroup
                int selectedId2 = rg2.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                rb2 = (RadioButton) findViewById(selectedId2);

                //Toast.makeText(SignUpActivity.this, rb2.getText(), Toast.LENGTH_SHORT).show();


                address = inputAddress.getText().toString();
                numOfFloors = Integer.valueOf(inputNumOfFloors.getText().toString());
                numOfFlats = Integer.valueOf(inputNumOfFlats.getText().toString());

                heatingType = rb.getText().toString();

                elevatorString = rb2.getText().toString();

                if (elevatorString.equals("Yes")){
                    elevator = true;
                }
                else{
                    elevator = false;
                }

                building = new Building(address, numOfFloors, heatingType, elevator, numOfFlats);
                DAO.setBuilding(building);
                //Toast.makeText(SignUpActivity.this, building.getAddress(), Toast.LENGTH_SHORT).show();
                buildings.add(building);
                admin = new Admin(0, "admin", "admin", building);
                DAO.setAdminUsername(admin.getUsername());
                DAO.setAdminPassword(admin.getPassword());
                admins.add(admin);
                Toast.makeText(SignUpActivity.this, building.getAddress(), Toast.LENGTH_SHORT).show();


                Intent intent2 = new Intent(SignUpActivity.this, Activity_intialize_flat.class);
                //intent2.putExtra(BUILDING, (Serializable) building);
                startActivity(intent2);
                //SignUpActivity.this.finish();
            }

        });


        /*
        //---------------Admin (not real) init for my purposes--------------------------
        int id =0;
        String username = "admin";
        String password = "123456";

        //------------------------------------------------------------------------------\

         */
    }
}