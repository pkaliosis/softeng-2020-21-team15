package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.DAO;
import com.example.myapplication.model.R;

/**
 * <p>
 * This class is responsible for the appearance of the starting page, including the log in forms and the sign up option
 * </p>
 */
public class MainActivity extends AppCompatActivity {

    private static final String ID = "id";
    EditText inputAdminUsername;
    EditText inputAdminPassword;
    Button adminLogin;

    EditText inputUserUsername;
    EditText inputUserPassword;
    Button userLogin;

    String adminUsername;
    String adminPassword;

    String userUsername;
    String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("LeAdmin Launcher Page");
        for (int i=0; i< DAO.DAOflats.size(); i++){
            System.out.println(DAO.DAOflats.get(i).getId());
        }

        for (int i=0; i< DAO.DAOusers.size(); i++){
            System.out.println(DAO.DAOusers.get(i).getUsername());
        }

        System.out.println(DAO.getAdminUsername());
        System.out.println(DAO.getAdminPassword());

        inputAdminUsername = findViewById(R.id.editTextAdminUsername);
        inputAdminPassword = findViewById(R.id.editTextAdminPassword);
        adminLogin = (Button) findViewById(R.id.btnAdminLogin);

        adminLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                adminUsername = inputAdminUsername.getText().toString();
                adminPassword = inputAdminPassword.getText().toString();
                if (DAO.getAdminUsername().equals(adminUsername)){
                    if (DAO.getAdminPassword().equals(adminPassword)){
                        System.out.println("Admin looks fine, log him in.");
                        Intent intent = new Intent(MainActivity.this, AdminMainActivity.class);
                        startActivity(intent);
                    }
                }

            }
        });

        inputUserUsername = findViewById(R.id.editTextUserUsername);
        inputUserPassword = findViewById(R.id.editTextUserPassword);
        userLogin = (Button) findViewById(R.id.btnUserLogin);

        userLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userUsername = inputUserUsername.getText().toString();
                userPassword = inputUserPassword.getText().toString();
                boolean flag=false;
                for (int i=0; i<DAO.DAOusers.size(); i++) {
                    if (DAO.DAOusers.get(i).getUsername().equals(userUsername)){
                        if (DAO.DAOusers.get(i).getPassword().equals(userPassword)){
                            System.out.println("User looks fine, log him in.");
                            flag =true;
                            System.out.println("Get in there champ!");
                            Intent intent = new Intent(MainActivity.this, UserMainActivity.class);
                            intent.putExtra(ID, DAO.DAOusers.get(i).getId());
                            startActivity(intent);
                        }
                    }
                }
                if (flag == false){
                    Toast.makeText(MainActivity.this, "Wrong credentials. Please try again!", Toast.LENGTH_SHORT).show();
                    System.out.println("Wrong credentials. Please try again!");
                }
            }
        });




        TextView signupText = (TextView) findViewById(R.id.textSignUpAsBtn);

        signupText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}