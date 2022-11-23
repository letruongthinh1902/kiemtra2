package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText txt_user,txt_password;
    Button btn_signIn,btn_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txt_password = (EditText) findViewById(R.id.txtPassword);
        txt_user=(EditText) findViewById(R.id.txt_user);
        btn_signIn=(Button) findViewById(R.id.btnSignIn);
        btn_signUp=(Button) findViewById(R.id.btnSignIn_SignUp);

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_user.getText().length()!=0&&txt_password.getText().length()!=0){
                    if(txt_user.getText().toString().equals("letruongthinh") &&  txt_password.getText().toString().equals("123")){
                        Intent intent = new Intent(SignIn.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(SignIn.this, "Dang nhap thanh cong!!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SignIn.this, "Sai tai  khoan hoac mat khau!!", Toast.LENGTH_SHORT).show();
                        txt_user.setText("");
                        txt_password.setText("");
                    }
                }else{
                    Toast.makeText(SignIn.this, "Nhap day du thong tin!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent= new Intent(SignIn.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
    
}