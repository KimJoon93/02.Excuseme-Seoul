package joon.seoul.excusme.excusemeseoul;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import joon.seoul.excusme.excusemeseoul.MainFragment.Askingfrag;
import joon.seoul.excusme.excusemeseoul.MainFragment.Infofrag;
import joon.seoul.excusme.excusemeseoul.MainFragment.Questionlistfrag;
import joon.seoul.excusme.excusemeseoul.MainFragment.Settingfrag;
import joon.seoul.excusme.excusemeseoul.MainFragment.StoreListfrag;

public class Mainpage extends AppCompatActivity {
    FragmentTransaction tr;
    String userid;
    String username;
    String useremail;
    Askingfrag askingfrag;
    StoreListfrag storeListfrag;
    Settingfrag settingfrag;
    Questionlistfrag questionlistfrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        Intent intent = getIntent();
        userid = intent.getStringExtra("userid");
        username = intent.getStringExtra("username");
        useremail = intent.getStringExtra("useremail");

        askingfrag = new Askingfrag();
        storeListfrag = new StoreListfrag();
        settingfrag = new Settingfrag();
        questionlistfrag = new Questionlistfrag();

        Bundle bundle = new Bundle();
        bundle.putString("userid",userid);
        bundle.putString("username",username);
        bundle.putString("useremail",useremail);

        askingfrag.setArguments(bundle);
        storeListfrag.setArguments(bundle);
        settingfrag.setArguments(bundle);
        questionlistfrag.setArguments(bundle);

    }

    public void Selectingfrag(View view){
        tr = getSupportFragmentManager().beginTransaction();
        if(view.getId() == R.id.qusetionlistbtn){
            tr.replace(R.id.mainfrag, questionlistfrag).addToBackStack(null);
        }else if(view.getId() == R.id.storelistbtn){
            tr.replace(R.id.mainfrag, storeListfrag).addToBackStack(null);
        }else if(view.getId() == R.id.askingbtn){
            tr.replace(R.id.mainfrag, askingfrag).addToBackStack(null);
        }else if(view.getId() == R.id.infobtn){
            tr.replace(R.id.mainfrag, new Infofrag()).addToBackStack(null);
        }else if(view.getId() == R.id.settingbtn){
            tr.replace(R.id.mainfrag, settingfrag).addToBackStack(null);
        }
        tr.commit();
    }
}
