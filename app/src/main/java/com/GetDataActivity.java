package com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.hm_tahir.classtask.R;

public class GetDataActivity extends AppCompatActivity {

    private TextView objTextView;
    private Bundle getBundle;
    private Intent objIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        objTextView=findViewById(R.id.TV);

        getDataFromPreviousScreen();
    }

    private void   getDataFromPreviousScreen(){
        try{
             if(getIntent()!=null){
                objIntent=getIntent();
               // getBundle=objIntent.getExtras();

               // String name=getBundle.getString("name");
                //String name=objIntent.getStringExtra("name");
                //int intSomeValue=objIntent.getIntExtra("intValue",0);

                 Person personName=objIntent.getParcelableExtra("name");
                objTextView.setText(personName.getPersonName());
             }else {
                 Toast.makeText(this,"No data retrieved",Toast.LENGTH_SHORT).show();
             }


        }catch (Exception e){
            Toast.makeText(this,"getDataFromPreviousScreen"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
