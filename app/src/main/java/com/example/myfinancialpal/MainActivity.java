package com.example.myfinancialpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfinancialpal.FirebaseConnection.FirebaseInstance;
import com.example.myfinancialpal.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    Button login;
    Button register;

    private User user;
    private FirebaseInstance myDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);

        login = (Button) findViewById(R.id.button_login);
        register = (Button) findViewById(R.id.button_register);


    //database
        myDatabase = FirebaseInstance.getDatabaseInstance();


        btnLogin_clicked();
        btnRegister_clicked();
    }


    private void btnLogin_clicked(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Verifica daca au fost introduse date in ambele campuri: username si password
                if(!editText_isEmpty()){

                    // TODO verifica in baza de date existenta datelor introduse

                    //redirectionare catre MsinActivityNavigation
                    Intent intent = new Intent(MainActivity.this, MainActivityNavigation.class);

                    startActivity(intent);
                }
               // else Toast.makeText(this, "Completati ambele campuri", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void btnRegister_clicked() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //daca EditText-urile nu sunt goale
                if(!editText_isEmpty()) {

                    user = new User(String.valueOf(username.getText()), password.getText().toString());

                    Log.i("user data: ", user.getUsername() + " " + user.getPassword());

                    //  inregistrare user in baza de date

                    myDatabase.pushUserToDatabase(user.getUsername(), user.getPassword());
                    Log.i("user data uploaded: ", user.getUsername() + " " + user.getPassword());
                }
             //   else{ Toast.makeText(this, "Completati toate campurie", Toast.LENGTH_SHORT).show(); }

            }
        });
    }

    private boolean editText_isEmpty() {
        //daca EditText-urile pentru username si password nu sunt goale
        if (!TextUtils.isEmpty(username.getText()) && !TextUtils.isEmpty(password.getText())) {
            return false;  //returneaza fals

        } else return false; //daca EditText-urile sunt goale, returneaza true
    }

}
