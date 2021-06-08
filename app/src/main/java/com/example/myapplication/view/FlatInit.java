package com.example.myapplication.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.Admin;
import com.example.myapplication.model.Building;
import com.example.myapplication.model.Flat;
import com.example.myapplication.model.FlatInitPresenter;
import com.example.myapplication.model.FlatInitView;
import com.example.myapplication.model.R;
import com.example.myapplication.view.flats.FlatFragment;

import java.io.Serializable;
import java.util.ArrayList;

//public class FlatInit extends AppCompatActivity implements FlatFragment.onFragmentInteractionListener, FlatInitView {
public class FlatInit extends AppCompatActivity{

    private static final String BUILDING = "building";
    public static final int REQUEST_CODE = 1;
    Building b = SignUpActivity.admin.getBuilding();
    //FlatInitPresenter presenter;

    TextView txtFlatId;

    Button btnAddFlat;
    Flat f;
    //Building b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_init);
        setTitle("Building's Flat");
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

        Button btnAddFlat = (Button) findViewById(R.id.btn_addFlat);

        btnAddFlat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Toast.makeText(FlatInit.this, b.getAddress(), Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(FlatInit.this, AddFlatActivity.class);
                startActivity(intent3);
                //intent3.putExtra(BUILDING, (Serializable) b);
                //startActivityForResult(intent3, REQUEST_CODE);


                //presenter.showFlats();

            }
        });

    }
}















//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE) {
//            if (resultCode == RESULT_OK) {
//                f = (Flat) data.getSerializableExtra(AddFlatActivity.FLAT);
//                b.myFlats.add(f);
//                presenter.showFlatsResult();
//                //Toast.makeText(FlatInit.this, "Flats floor is: " + f.getFloor(), Toast.LENGTH_SHORT).show();
//            }
//        }
//
//    }
//
//    @Override
//    public ArrayList<Flat> getFlats() {
//        return b.myFlats;
//    }
//
//    @Override
//    public void showFlats() {
//        Toast.makeText(FlatInit.this, b.getAddress(), Toast.LENGTH_SHORT).show();
//        Intent intent3 = new Intent(FlatInit.this, AddFlatActivity.class);
//        //intent3.putExtra(BUILDING, (Serializable) b);
//        startActivityForResult(intent3, REQUEST_CODE);
//    }
//
//    @Override
//    public void showFlatsResult() {
//        txtFlatId.setText(f.getUserId());
//        Toast.makeText(FlatInit.this, txtFlatId.getText().toString(), Toast.LENGTH_SHORT).show();
//    }
//}