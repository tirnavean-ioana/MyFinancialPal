package com.example.myfinancialpal.FirebaseConnection;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseInstance {

    public static final String firebaseAPIKey = "AIzaSyB2GTlqFYQDqDCbgw8M3EVUyR0rZOlsM7k";

    /*
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference; = database.getReference("message");

    reference.setValue("meergi");
    */

    private  DatabaseReference databaseReference;

    public DatabaseReference getDatabaseReference() {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        return databaseReference;
    }



}
