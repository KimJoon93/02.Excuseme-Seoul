package joon.seoul.excusme.excusemeseoul.MainFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import joon.seoul.excusme.excusemeseoul.Askeditdata;
import joon.seoul.excusme.excusemeseoul.Questionviewpage;
import joon.seoul.excusme.excusemeseoul.R;
import joon.seoul.excusme.excusemeseoul.Storeadapter;

public class StoreListfrag extends Fragment {

    ArrayList<Askeditdata> storedataset;
    String username;
    String userid;

    public StoreListfrag() {
    }

    public static StoreListfrag newInstance() {
        StoreListfrag fragment = new StoreListfrag();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_listfrag, container, false);
        TextView userstorename = view.findViewById(R.id.userstorename);
        ListView storelist = view.findViewById(R.id.storelistview);
        storedataset = new ArrayList<>();

        Bundle bundle = getArguments();
        username = bundle.getString("username");
        userid = bundle.getString("userid");
        userstorename.setText(username);

        final Storeadapter storeadapter = new Storeadapter(getContext(), userid);
        storelist.setAdapter(storeadapter);
        storelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = getArguments();

                Intent intent = new Intent(getContext(), Questionviewpage.class);
                intent.putExtra("picktitle", storedataset.get(i).getTitle());
                intent.putExtra("pickbody",storedataset.get(i).getBody());
                intent.putExtra("pickcontextid",storedataset.get(i).getContextID());
                intent.putExtra("viewusername", username);
                intent.putExtra("viewuserid",userid);
                startActivity(intent);
            }
        });

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference("Question");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot item : dataSnapshot.getChildren()) {
                    if(item.child("writerID").getValue().toString().equals(userid)){
                        Askeditdata data= item.getValue(Askeditdata.class);
                        storeadapter.addstoreDataSet(data);
                        storedataset.add(data);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
