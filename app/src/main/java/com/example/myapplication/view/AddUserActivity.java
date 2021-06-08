package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.model.Flat;
import com.example.myapplication.model.R;
import com.example.myapplication.model.User;

import java.util.ArrayList;

/**
 * <p>
 * This class is responsible for the insertion of the user's elements and the addition of the user to the list
 * </p>
 */
public class AddUserActivity extends AppCompatActivity {

    public static final String FLATS_ARRAYLIST = "FLATS ARRAYLIST";
    public static final String USER = "user";

    ArrayList<Parcelable> registeredFlats = new ArrayList<>();

    EditText inputUserUserId;
    EditText inputUserUsername;
    EditText inputUserPassword;
    EditText inputUserFlatId;
    Button btnSubmitUser;

    int userid;
    String username;
    String password;
    int flatid;

    User user;
    Flat userflat;
    Flat theflat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Intent gIntent2 = getIntent();
        registeredFlats = gIntent2.getParcelableArrayListExtra(FLATS_ARRAYLIST);
        System.out.println("GOT THE ARRAYLIST OF FLATS IN ADDUSERACTIVITY: " + registeredFlats);

        inputUserUserId = findViewById(R.id.editTextUserId);
        inputUserUsername = findViewById(R.id.editTextUsername);
        inputUserPassword = findViewById(R.id.editTextUserPassword);
        inputUserFlatId = findViewById(R.id.editTextFlatId);

        btnSubmitUser = (Button) findViewById(R.id.btn_addUserSubmit);

        btnSubmitUser.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    userid = Integer.valueOf(inputUserUserId.getText().toString());
                    username = inputUserUsername.getText().toString();
                    password = inputUserPassword.getText().toString();
                    flatid = Integer.valueOf(inputUserFlatId.getText().toString());
                    for (int i=0; i<registeredFlats.size(); i++) {
                        theflat = (Flat) registeredFlats.get(i);
                        System.out.println("the flat id: " + theflat.getId());
                        System.out.println("the id: " + flatid);
                        if (theflat.getUserId() == userid) {
                            userflat = theflat;
                        }
                    }

                    user = new User(userid, username, password, flatid, userflat);
                    System.out.println("Created User: " + user.getUsername() + " " + user.getFlatId());
                    //Toast.makeText(AddFlatActivity.this, flat.getUserId(), Toast.LENGTH_SHORT).show();

                    returnToUsersList();

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



        protected void returnToUsersList() {
            //Toast.makeText(AddFlatActivity.this, flat.getUserId(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra(USER, user);
            //Toast.makeText(AddFlatActivity.this, flat.getUserId(), Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK, intent);
            finish();
//        Intent intent5 = new Intent(AddFlatActivity.this, Activity_intialize_flat.class);
//        intent5.putExtra(FLAT, flat);
//        startActivity(intent5);
        }
}
