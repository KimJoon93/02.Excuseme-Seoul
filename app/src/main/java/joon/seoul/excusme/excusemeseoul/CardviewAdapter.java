package joon.seoul.excusme.excusemeseoul;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CardviewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Askeditdata> dataset;

    public CardviewAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dataset = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int i) {
        return dataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void addDataSet(Askeditdata obj) {
        dataset.add(obj);
        notifyDataSetChanged();
    }

    public void addDataSetArrayList(ArrayList<Askeditdata> obj) {
        dataset = obj;
        notifyDataSetChanged();
    }

    public void removeAllData() {
        dataset.clear();
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = layoutInflater.inflate(R.layout.cardviewlayout, viewGroup, false);
        }
        TextView questitle = view.findViewById(R.id.questitle);
        TextView quesbody = view.findViewById(R.id.quesbody);

        questitle.setText(dataset.get(i).title);
        quesbody.setText(dataset.get(i).body);

        return view;
    }
}
