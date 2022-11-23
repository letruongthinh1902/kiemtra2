package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText tenbai, tencasi, mota, turl;
    Button btnAdd, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tenbai = (EditText)findViewById(R.id.txttenbai);
        tencasi = (EditText)findViewById(R.id.txttencasi);
        mota = (EditText)findViewById(R.id.txtmota);
        turl = (EditText)findViewById(R.id.txtimage);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void insertData(){
        Map<String,Object> map = new HashMap<>();
        map.put("tenbai",tenbai.getText().toString());
        map.put("tencasi",tencasi.getText().toString());
        map.put("mota",mota.getText().toString());
        map.put("image",turl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Music").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data Inserted Seccessfullly", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity.this, "Error While Insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll(){
        tenbai.setText("");
        tencasi.setText("");
        mota.setText("");
        turl.setText("");
    }
}