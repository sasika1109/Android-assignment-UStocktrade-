package com.example.ustocktrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mTextUsername,mTextPassword,mTextConPassword;
    Button mButton;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextUsername = (EditText) findViewById(R.id.editText_username);
        mTextPassword = (EditText) findViewById(R.id.editText_password);
        mTextConPassword = (EditText) findViewById(R.id.editText_Conpassword);
        mButton = (Button) findViewById(R.id.button_register);
        db = new DBHelper(this);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mTextUsername.getText().toString();
                String password = mTextPassword.getText().toString();
                String Conpassword = mTextConPassword.getText().toString();

                if(password.equals(Conpassword) && email.equals("test@test.com")) {

                    boolean result = db.addUser(email,password);

                    if(result) {
                        Toast.makeText(getApplicationContext(),"You have Registered",Toast.LENGTH_LONG).show();
                        dashboard();
                    }else{
                        Toast.makeText(getApplicationContext(),"Error in Registering",Toast.LENGTH_LONG).show();
                    }


                }
                else {

                    Toast.makeText(getApplicationContext(),"Enter valid input",Toast.LENGTH_LONG).show();

                }

            }
        });


    }

    public void dashboard() {
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}
