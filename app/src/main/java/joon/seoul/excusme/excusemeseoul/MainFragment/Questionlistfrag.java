package joon.seoul.excusme.excusemeseoul.MainFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import joon.seoul.excusme.excusemeseoul.Askeditdata;
import joon.seoul.excusme.excusemeseoul.CardviewAdapter;
import joon.seoul.excusme.excusemeseoul.Questionviewpage;
import joon.seoul.excusme.excusemeseoul.R;

public class Questionlistfrag extends Fragment {
    CardviewAdapter cardviewAdapter;
    EditText findingedit;
    ArrayList<Askeditdata> dataSet;
    ArrayList<Askeditdata> searchDataSet;
    boolean searchState = false;

    public Questionlistfrag() {

    }

    public static Questionlistfrag newInstance() {
        Questionlistfrag fragment = new Questionlistfrag();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qusetion_listfrag, container, false);
        findingedit = view.findViewById(R.id.questionfinding);
        dataSet = new ArrayList<>();
        searchDataSet = new ArrayList<>();


        final ListView cardlist = view.findViewById(R.id.questionlist);
        cardviewAdapter = new CardviewAdapter(getContext());
        cardlist.setAdapter(cardviewAdapter);
        cardlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(searchState) {
                    searchDataSet.get(i).getContextID();
                } else {
                    dataSet.get(i).getContextID();
                }
                Bundle bundle = getArguments();
                String username = bundle.getString("username");
                String userid = bundle.getString("userid");

                Intent intent = new Intent(getContext(), Questionviewpage.class);
                intent.putExtra("picktitle", dataSet.get(i).getTitle());
                intent.putExtra("pickbody",dataSet.get(i).getBody());
                intent.putExtra("pickcontextid",dataSet.get(i).getContextID());
                intent.putExtra("viewusername", username);
                intent.putExtra("viewuserid",userid);

                startActivity(intent);
            }
        });


        //  TextWatcher
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchDataSet.clear();
                cardviewAdapter.removeAllData();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                    if(editable.toString().length() == 0) {
                    searchState = false;
                    for(int i=0; i<dataSet.size(); i++) {
                        cardviewAdapter.addDataSet(dataSet.get(i));
                    }
                } else {
                    searchState = true;
                    String input = editable.toString().toLowerCase().trim();
                    input = input.replace(" ", "");
                    for(int i=0; i<dataSet.size(); i++) {
                        String compareStr = dataSet.get(i).getTitle().toString().toLowerCase().trim();
                        compareStr = compareStr.replace(" ", "");
                        if(compareStr.contains(input)) {
                            searchDataSet.add(dataSet.get(i));
                            cardviewAdapter.addDataSet(dataSet.get(i));
                        }
                    }

                }
            }
        };
        findingedit.addTextChangedListener(watcher);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference("Question");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot item : dataSnapshot.getChildren()) {
                    Askeditdata data = item.getValue(Askeditdata.class);
                    cardviewAdapter.addDataSet(data);
                    dataSet.add(data);

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
