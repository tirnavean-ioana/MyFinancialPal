package com.example.myfinancialpal.FirebaseConnection;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myfinancialpal.MainActivity;
import com.example.myfinancialpal.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseInstance extends AsyncTask<Void, Void, Void>{ // Singleton design pattern


    private static FirebaseInstance myFirebaseInstance = null;

    private FirebaseDatabase database = null;
    private DatabaseReference databaseReference = null;

    private static String pushId;


    private FirebaseInstance() {

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }


    public static FirebaseInstance getDatabaseInstance() {
        if(myFirebaseInstance == null){
            myFirebaseInstance = new FirebaseInstance();
        }
        return myFirebaseInstance;
    }


    public void pushUserToDatabase(String username, String password){

        if (databaseReference != null) {

            // Incarca datele in baza de date
            // Genereaza un id unic de tip String
            pushId = databaseReference.push().getKey();


            //adauga userul in baza de date
            databaseReference.child(pushId).child("userData").child("password").setValue(password);
            databaseReference.child(pushId).child("userData").child("username").setValue(username);


            Log.i("FirebaseInstance", "User adaugat in baza de date cu succes");
        }
        else {
            Log.w("Null Firebase reference", "In class FirebaseInstance.java DatabaseReference object is null");
        }
    }

    public boolean userDataExist(String username, String password){

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              //TODO: Post post = dataSnapshot.getValue(Post.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        /*
        if (databaseReference != null){

            //TODO verific existenta userului in baza de date

            String user = String.valueOf(databaseReference.child("userData").child("username").equalTo(username));
            String pass = String.valueOf(databaseReference.child("userData").equalTo("password", password));

            Log.i("FI.java userDataExist()", user + " " + pass);

            return true;

        }
        else {
            Log.w("Null Firebase reference", "In class FirebaseInstance.java DatabaseReference object is null");
        }
        return false;
        */
        return true;
    }

    public static String getPushId(){
        if(pushId != null){
            return pushId;
        }
        return "No id found";
    }

}