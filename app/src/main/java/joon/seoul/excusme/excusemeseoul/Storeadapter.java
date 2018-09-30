package joon.seoul.excusme.excusemeseoul;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Storeadapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    String userid;
    ArrayList<Askeditdata> storedataset;

    public Storeadapter(Context context, String userid) {
        this.context = context;
        this.userid = userid;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        storedataset = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return storedataset.size();
    }

    @Override
    public Object getItem(int i) {
        return storedataset.size();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void addstoreDataSet(Askeditdata obj) {
        storedataset.add(obj);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = layoutInflater.inflate(R.layout.cardviewlayout, viewGroup, false);
        }

        TextView questitle = view.findViewById(R.id.questitle);
        TextView quesbody = view.findViewById(R.id.quesbody);

        questitle.setText(storedataset.get(i).title);
        quesbody.setText(storedataset.get(i).body);

        return view;
    }
}
