package com.hm_tahir.classtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.GetDataActivity;
import com.Person;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Person objPerson;
    FirebaseFirestore db;
    Button btnSend;
    DocumentReference documentationReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend=findViewById(R.id.send);
        db=FirebaseFirestore.getInstance();
        objPerson=new Person();
        objPerson.setPersonName("HM TAhir");

        documentationReference=db.collection("Persons").document("abc");
        sendData(objPerson.getPersonName());
    }

    public void moveData(View view){
        try{
            Bundle objBundle=new Bundle();
          //  objBundle.putString("name","HM TAhir");

            Intent objIntent=new Intent(this, GetDataActivity.class);
           // objIntent.putExtra("name","HM TAhir");
           // objIntent.putExtra("intValue",123);
           // objIntent.putExtras(objBundle);
            objIntent.putExtra("name",objPerson);

            startActivity(objIntent);

        }catch (Exception e){
            Toast.makeText(this,"moveData"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public void sendData(Object obj){

        Map user =new HashMap<>();
        user.put("Name",obj);
        documentationReference
                .set(user)
                .addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(MainActivity.this,"Data added successfully",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
