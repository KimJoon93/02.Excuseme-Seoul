package joon.seoul.excusme.excusemeseoul;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import joon.seoul.excusme.excusemeseoul.MainFragment.Askingfrag;

public class Loginpage extends AppCompatActivity {

    EditText loginid;
    EditText loginpswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        loginid = findViewById(R.id.loginid);
        loginpswd = findViewById(R.id.loginpswd);

    }

    public void loginclick(View view){
        if(view.getId() == R.id.signinbtn){
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            final DatabaseReference databaseReference = firebaseDatabase.getReference("User");
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot user:dataSnapshot.getChildren()) {
                        Userdata searchUser = user.getValue(Userdata.class);
                        if(searchUser.email.equals(loginid.getText().toString()) && searchUser.password.equals(loginpswd.getText().toString())) {
                            Intent intent = new Intent(getApplicationContext(), Mainpage.class);
                            intent.putExtra("userid",searchUser.contextid);
                            intent.putExtra("username",searchUser.name);
                            intent.putExtra("useremail",searchUser.email);

                            startActivity(intent);
                            finish();
                        } else if(loginid.getText().toString().isEmpty() || loginpswd.getText().toString().isEmpty()){
                            Toast.makeText(getApplicationContext(),"Check the login again",Toast.LENGTH_SHORT).show();
                        }else {
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });
        }else if(view.getId() == R.id.gotocreatepagetext){
            Intent intent = new Intent(getApplicationContext(), CreateIdpage.class);
            startActivity(intent);
        }
    }
}
