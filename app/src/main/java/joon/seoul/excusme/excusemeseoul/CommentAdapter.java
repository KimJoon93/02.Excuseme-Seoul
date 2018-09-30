package joon.seoul.excusme.excusemeseoul;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Commenteditdata> commentdataset;

    public CommentAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        commentdataset = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return commentdataset.size();
    }

    @Override
    public Object getItem(int i) {
        return commentdataset.size();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void addDataSet(Commenteditdata commenteditdata) {
        commentdataset.add(commenteditdata);
        notifyDataSetChanged();
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = layoutInflater.inflate(R.layout.commentlayout, viewGroup, false);
        }
        TextView commentwriter = view.findViewById(R.id.commentusername);
        TextView commentbody = view.findViewById(R.id.commentbody);

        commentwriter.setText(commentdataset.get(i).commentwritername);
        commentbody.setText(commentdataset.get(i).comment);
        return view;
    }
}
