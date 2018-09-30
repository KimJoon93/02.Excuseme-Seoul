package joon.seoul.excusme.excusemeseoul.MainFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import joon.seoul.excusme.excusemeseoul.R;


public class Infofrag extends Fragment {
    public Infofrag() {
        // Required empty public constructor
    }
    public static Infofrag newInstance() {
        Infofrag fragment = new Infofrag();
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
        View view = inflater.inflate(R.layout.fragment_infofrag, container, false);
        ImageView iseouluimg = view.findViewById(R.id.iseouluimg);
        Glide.with(getContext()).load("http://www.seoul.go.kr/v2012/seoul/symbol/images/iseoulu.gif").into(iseouluimg);
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
