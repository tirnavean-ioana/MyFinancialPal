package com.example.myfinancialpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfinancialpal.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    Button login;
    Button register;

    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);

        login = (Button) findViewById(R.id.button_login);
        register = (Button) findViewById(R.id.button_register);


    //database

        User user = new User(username.getText().toString(), password.getText().toString());

        Log.i("user data: ", user.getUsername() + " " + user.getPassword());


        databaseReference = FirebaseDatabase.getInstance().getReference();


        Log.i("Firebsase", databaseReference.toString());


        databaseReference.child("user").child("username").setValue(user.getUsername());
        databaseReference.child("user").child("password").setValue(user.getPassword());


        btnLogin_clicked();
        btnRegister_clicked();

    }


    private void btnLogin_clicked(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // verificare functionalitate - de sters ulterior
                String tag = "LoginButton";
                String message = "Campurile sunt: " + username.getText() + " " + password.getText();

                Log.i(tag, message);


                // TODO
                //verificarea existentei datelor introduse in baza de date


                //redirectionare catre MsinActivityNavigation
                Intent intent = new Intent(MainActivity.this, MainActivityNavigation.class);

                startActivity(intent);
            }
        });
    }

    private void btnRegister_clicked() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                //  inregistrare user in baza de date
            }
        });
    }

}
