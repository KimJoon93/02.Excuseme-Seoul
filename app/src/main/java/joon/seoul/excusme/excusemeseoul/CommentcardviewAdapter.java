package joon.seoul.excusme.excusemeseoul;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CommentcardviewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    String title;
    String body;
    String contextid;

    public CommentcardviewAdapter(Context context, String title, String body,String contextid) {
        this.context = context;
        this.title = title;
        this.body = body;
        this.contextid = contextid;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = layoutInflater.inflate(R.layout.cardviewlayout, viewGroup, false);
        }
        TextView questitle = view.findViewById(R.id.questitle);
        TextView quesbody = view.findViewById(R.id.quesbody);

        questitle.setText(title);
        quesbody.setText(body);

        return view;
    }
}
