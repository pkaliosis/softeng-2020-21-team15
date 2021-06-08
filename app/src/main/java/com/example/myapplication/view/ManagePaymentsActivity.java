package com.example.myapplication.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.model.DAO;
import com.example.myapplication.model.Flat;
import com.example.myapplication.model.R;

import java.util.ArrayList;

/**
 * <p>
 * This class is responsible to show the list of users, so that the admin can choose one to manage his payments
 * </p>
 */
public class ManagePaymentsActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 25;
    private static final String AMOUNT = "amount";
    public static final String FID = "fid";
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    Button btnBackToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_payments);

//        for (int i=0; i<DAO.DAOflats.size(); i++){
//            arrayList.add("Flat ID: " + DAO.DAOflats.get(i).getId() + "Flats User ID: " + DAO.DAOflats.get(i).getUserId() +
//                    "Flats Balance: " + DAO.DAOflats.get(i).getBalance().getAmount());
//        }
       listView = (ListView) findViewById(R.id.listviewPayments);

       ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, DAO.DAOflats);
       listView.setAdapter(arrayAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(ManagePaymentsActivity.this, "Clicked on flat: " + DAO.DAOflats.get(position).getId(),
                       Toast.LENGTH_SHORT).show();
               int fid = DAO.DAOflats.get(position).getId();
               System.out.println(fid);
               Intent intent11 = new Intent(ManagePaymentsActivity.this, EditPaymentActivity.class);
               intent11.putExtra(FID, fid);
               startActivityForResult(intent11, REQUEST_CODE);
           }
       });

       btnBackToMain = (Button) findViewById(R.id.finishManagement);

       btnBackToMain.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               Intent intent12 = new Intent(ManagePaymentsActivity.this, AdminMainActivity.class);
               startActivity(intent12);
           }

       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                double amount = data.getDoubleExtra(AMOUNT, -1);
                int flid = data.getIntExtra(FID, -1);
                System.out.println("----REDUCTION AMOUNT: " + amount);
                System.out.println("----FLAT ID TO BE REDUCTED FROM: " + flid);
                for (int i = 0; i < DAO.DAOflats.size(); i++) {
                    if (DAO.DAOflats.get(i).getId() == flid) {
                        DAO.DAOflats.get(i).getBalance().setAmount(DAO.DAOflats.get(i).getBalance().getAmount() - amount);
                    }
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, DAO.DAOflats);
                listView.setAdapter(arrayAdapter);
            }
        }
    }
}