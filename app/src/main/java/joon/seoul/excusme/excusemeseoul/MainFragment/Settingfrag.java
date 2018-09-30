package joon.seoul.excusme.excusemeseoul.MainFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import joon.seoul.excusme.excusemeseoul.R;


public class Settingfrag extends Fragment {

    public Settingfrag() {
        // Required empty public constructor
    }

    public static Settingfrag newInstance() {
        Settingfrag fragment = new Settingfrag();
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
        View view = inflater.inflate(R.layout.fragment_settingfrag, container, false);
        TextView settingusername = view.findViewById(R.id.usersettingname);
        TextView settinguserid = view.findViewById(R.id.settinguserid);
        TextView setusername = view.findViewById(R.id.settingusername);
        Bundle bundle = getArguments();
        String username = bundle.getString("username");
        String useremail = bundle.getString("useremail");
        settingusername.setText(username);
        settinguserid.setText(useremail);
        setusername.setText(username);

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
