package com.example.myapplication.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.model.DAO;
import com.example.myapplication.model.Flat;
import com.example.myapplication.model.R;
import com.example.myapplication.model.User;

import java.util.ArrayList;

/**
 * <p>
 * This class is responsible for the interface of the initialization of a new user
 * </p>
 */
public class UsersInitActivity extends AppCompatActivity {

    private static final int REQUEST_CODE2 = 24;
    public static final String USER = "user";
    public static final String FLATS_ARRAYLIST = "FLATS ARRAYLIST";
    ListView listView;
    private ArrayList<String> arrayListUsers = new ArrayList<>();
    ArrayList<User> registeredUsers = new ArrayList<>();
    ArrayList<Parcelable> registeredFlats = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_init);
        setTitle("Building's Users");
        Intent gIntent = getIntent();
        //registeredFlats = gIntent.getParcelableArrayExtra(FLATS_ARRAYLIST);
        registeredFlats = gIntent.getParcelableArrayListExtra(FLATS_ARRAYLIST);
        System.out.println("GOT THE ARRAYLIST OF FLATS IN USERINITACTIVITY: " + registeredFlats);

        listView = (ListView)findViewById(R.id.listview);



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListUsers);
        listView.setAdapter(arrayAdapter);


        Button btnAddUser = (Button) findViewById(R.id.btn_addUsers);

        btnAddUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent7 = new Intent(UsersInitActivity.this, AddUserActivity.class);
                intent7.putExtra(FLATS_ARRAYLIST, registeredFlats);
                startActivityForResult(intent7, REQUEST_CODE2);
                //intent3.putExtra(BUILDING, (Serializable) b);
                //startActivityForResult(intent3, REQUEST_CODE);


                //presenter.showFlats();

            }
        });

        Button btnFinishUsers = (Button) findViewById(R.id.finishUsers);

        btnFinishUsers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent8 = new Intent(UsersInitActivity.this, MainActivity.class);
                startActivity(intent8);
                //intent3.putExtra(BUILDING, (Serializable) b);
                //startActivityForResult(intent3, REQUEST_CODE1);


                //presenter.showFlats();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE2) {
            if(resultCode == RESULT_OK){
                User user = data.getParcelableExtra(USER);
                System.out.println("MOTHERFUCKING: " + user.getClass());
                arrayListUsers.add("User ID: " + Integer.toString(user.getId()) + ", Username: " + user.getUsername() + ", Flat's ID: " + user.getFlatId());
                registeredUsers.add(user);
                DAO.addUser(user);
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListUsers);
                listView.setAdapter(arrayAdapter);
            }
        }
    }
}