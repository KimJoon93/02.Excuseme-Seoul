package joon.seoul.excusme.excusemeseoul.MainFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import joon.seoul.excusme.excusemeseoul.Askeditdata;
import joon.seoul.excusme.excusemeseoul.R;

public class Askingfrag extends Fragment {
    EditText titleedit;
    EditText askingedit;
    Button addaskbtn;
    FragmentTransaction fragmentTransaction;

    public Askingfrag() {
        // Required empty public constructor
    }

    public static Askingfrag newInstance() {
        Askingfrag fragment = new Askingfrag();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_askingfrag, container, false);
        titleedit = view.findViewById(R.id.titleedittext);
        askingedit = view.findViewById(R.id.askingedit);
        addaskbtn = view.findViewById(R.id.addaskbtn);
        titleedit.setSingleLine();
        fragmentTransaction =getFragmentManager().beginTransaction();

        addaskbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference("Question");
                DatabaseReference insertdata = databaseReference.push();
                Bundle bundle = getArguments();
                String userid = bundle.getString("userid");
                Askeditdata askeditdata = new Askeditdata(titleedit.getText().toString(), askingedit.getText().toString(),userid,insertdata.getKey());
                insertdata.setValue(askeditdata);
                fragmentTransaction.replace(R.id.mainfrag,new Questionlistfrag()).addToBackStack(null).commit();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
