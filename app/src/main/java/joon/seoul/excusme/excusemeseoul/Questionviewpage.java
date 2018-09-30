package joon.seoul.excusme.excusemeseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class Questionviewpage extends AppCompatActivity {

    String picktitle;
    String pickbody;
    String pickcontextid;
    String loginusername;
    String loginuserid;
    TextView viewusername;
    EditText commentedit;
    CommentAdapter commentAdapter;
    ListView commentlist;
    ArrayList<Commenteditdata> commentdataset;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionviewpage);

        Intent intent = getIntent();
        picktitle = intent.getStringExtra("picktitle");
        pickbody = intent.getStringExtra("pickbody");
        pickcontextid = intent.getStringExtra("pickcontextid");
        loginusername = intent.getStringExtra("viewusername");
        loginuserid = intent.getStringExtra("viewuserid");

        firebaseDatabase = FirebaseDatabase.getInstance();
        commentdataset = new ArrayList<>();

        //카드뷰
        ListView onecardview = findViewById(R.id.onecardview);
        CommentcardviewAdapter commentcardviewAdapter = new CommentcardviewAdapter(this, picktitle, pickbody,pickcontextid);
        onecardview.setAdapter(commentcardviewAdapter);

        //댓글 리스트
        commentlist = findViewById(R.id.commentlist);
        commentAdapter = new CommentAdapter(this);
        commentlist.setAdapter(commentAdapter);

        DatabaseReference commentdatareference = firebaseDatabase.getReference("Comment").child(pickcontextid);
        commentdatareference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot item : dataSnapshot.getChildren()) {
                    Commenteditdata commenteditdata = item.getValue(Commenteditdata.class);
                    commentAdapter.addDataSet(commenteditdata);
                    commentdataset.add(commenteditdata);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //댓글 작성자 이름
        viewusername = findViewById(R.id.viewusername);
        viewusername.setText(loginusername);

        //댓글 작성
        commentedit = findViewById(R.id.commentedit);
        commentedit.setSingleLine();

        Button commentclick = findViewById(R.id.commentclick);
        commentclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(commentedit.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Check the comment is empty.",Toast.LENGTH_SHORT).show();
                }else{
                    DatabaseReference databaseReference = firebaseDatabase.getReference("Comment");
                    DatabaseReference insertdata = databaseReference.push();
                    Commenteditdata commenteditdata = new Commenteditdata(commentedit.getText().toString(),pickcontextid,loginusername,loginuserid);
                    databaseReference.child(pickcontextid).push().setValue(commenteditdata);
                    commentedit.setText("");
                    commentAdapter = new CommentAdapter(getApplicationContext());
                    commentlist.setAdapter(commentAdapter);
                    commentAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}