package joon.seoul.excusme.excusemeseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class CreateIdpage extends AppCompatActivity {

    EditText createname;
    EditText creatteemail;
    EditText createpasswd;
    EditText createrepasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_idpage);

        createname = findViewById(R.id.makename);
        creatteemail = findViewById(R.id.makeemail);
        createpasswd = findViewById(R.id.makepasswd);
        createrepasswd = findViewById(R.id.makerepasswd);


    }

    public void createidclick(View view){
        if(view.getId() == R.id.createidsignin){
            Intent intent = new Intent(getApplicationContext(), Loginpage.class);
            startActivity(intent);
            finish();

        }else if(view.getId() == R.id.createidbtn){
            //비밀번호 일치 여부
            if(!createpasswd.getText().toString().equals(createrepasswd.getText().toString())){
                Toast.makeText(this,"Check the Password is right",Toast.LENGTH_SHORT).show();
            //빈칸 여부
            }else if(createname.getText().toString().isEmpty() || creatteemail.getText().toString().isEmpty() || creatteemail.getText().toString().isEmpty() || createpasswd.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"There is empty space",Toast.LENGTH_SHORT).show();
            //비밀번호 6자리 이상 여부
            }else if(createpasswd.getText().toString().length() <= 6){
                Toast.makeText(this,"Check the Password is at least 6 words",Toast.LENGTH_SHORT).show();
             //아이디 일치 여부 확인해야함(추후예정)

             // 아이디 생성
            }else{
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference("User");
                DatabaseReference insertdata = databaseReference.push();
                Userdata userdata = new Userdata(creatteemail.getText().toString(), createpasswd.getText().toString(), createname.getText().toString(),insertdata.getKey(),new ArrayList<String>());
                insertdata.setValue(userdata);
                Intent intent = new Intent(getApplicationContext(),Loginpage.class);
                startActivity(intent);

            }
        }
    }
}
