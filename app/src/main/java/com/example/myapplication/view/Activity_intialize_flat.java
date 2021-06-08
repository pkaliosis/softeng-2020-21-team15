package com.example.myapplication.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.Building;
import com.example.myapplication.model.DAO;
import com.example.myapplication.model.Flat;
import com.example.myapplication.model.R;

import java.util.ArrayList;

/**
 * <p>
 * This class is responsible for the interface of the initialization of flats
 * </p>
 */
public class Activity_intialize_flat extends AppCompatActivity {

    private static final String BUILDING = "building";
    public static final int REQUEST_CODE = 1;
    private static final String FLAT = "flat";
    public static final int REQUEST_CODE1 = 23;
    public static final String FLATS_ARRAYLIST = "FLATS ARRAYLIST";
    Building b = SignUpActivity.admin.getBuilding();
    //FlatInitPresenter presenter;
    double tsq=0;

    TextView txtFlatId;

    Button btnAddFlat;
    Flat f;
    //Building b;

    ListView listView;
    Flat flat;
    ArrayList<Flat> registeredFlats = new ArrayList<>();

    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intialize_flat);
        setTitle("Building's Flat");
        System.out.println("ADDREEEEESSSS: " + b.getAddress());

//        if (getIntent().getParcelableExtra(FLAT) != null) {
//            Flat flat = getIntent().getParcelableExtra(FLAT);
//            System.out.println("MOTHERFUCKING: " + flat.getClass());
//            arrayList.add(Integer.toString(flat.getId()) + ", " + Integer.toString(flat.getUserId()) + ", " + Integer.toString(flat.getFloor()));
//        }
        listView = (ListView)findViewById(R.id.listview);



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        //ListDisplay view1 = new ListDisplay();
//        presenter = new FlatInitPresenter(this);
//
//        presenter.showFlats();
//
//        txtFlatId = findViewById((R.id.textViewFlatId));

        //Building b = SignUpActivity.admin.getBuilding();

        /*
        Intent intent5 = getIntent();
        b = (Building) intent5.getSerializableExtra(SignUpActivity.BUILDING);

         */

        Button btnAddFlat = (Button) findViewById(R.id.btn_addFlat2);

        btnAddFlat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Toast.makeText(Activity_intialize_flat.this, b.getAddress(), Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Activity_intialize_flat.this, AddFlatActivity.class);
                startActivityForResult(intent3, REQUEST_CODE1);
                //intent3.putExtra(BUILDING, (Serializable) b);
                //startActivityForResult(intent3, REQUEST_CODE);


                //presenter.showFlats();

            }
        });

        Button btnFinishFlats = (Button) findViewById(R.id.finishFlats2);

        btnFinishFlats.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                for (int i=0; i<DAO.DAOflats.size(); i++) {
                    tsq += DAO.DAOflats.get(i).getArea();
                }
                DAO.getBuilding().setTotalSquareArea(tsq);
                //Toast.makeText(Activity_intialize_flat.this, b.getAddress(), Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(Activity_intialize_flat.this, UsersInitActivity.class);
                intent6.putExtra(FLATS_ARRAYLIST, registeredFlats);
                startActivity(intent6);
                //intent3.putExtra(BUILDING, (Serializable) b);
                //startActivityForResult(intent3, REQUEST_CODE1);


                //presenter.showFlats();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE1) {
            if(resultCode == RESULT_OK){
                Flat flat = data.getParcelableExtra(FLAT);
                System.out.println("----FLAT ID: " + flat.getId());
                System.out.println("----USER ID: " + flat.getUserId());
                System.out.println("----FLOOR: " + flat.getFloor());
                System.out.println("----AREA: " + flat.getArea());
                System.out.println("----HEATING PCT: " + flat.getHeatingPercentage());
                System.out.println("MOTHERFUCKING: " + flat.getClass());
                arrayList.add("Flat ID: " + Integer.toString(flat.getId()) + ", User ID: " + Integer.toString(flat.getUserId()) + ", Flat's Floor: " + Integer.toString(flat.getFloor()));
                registeredFlats.add(flat);
                DAO.addFlat(flat);
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(arrayAdapter);
            }
        }
    }
}