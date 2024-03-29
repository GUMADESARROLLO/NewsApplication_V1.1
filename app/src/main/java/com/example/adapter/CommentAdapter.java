package com.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.item.CommentList;
import com.example.util.Tools;
import com.viaviapp.newsapps.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.ArrayList;
import java.util.Date;


public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ItemRowHolder> {

    private ArrayList<CommentList> dataList;
    private Context mContext;

    public CommentAdapter(Context context, ArrayList<CommentList> dataList) {
        this.dataList = dataList;
        this.mContext = context;

    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_adapter, parent, false);
        return new ItemRowHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemRowHolder holder, final int position) {
        final CommentList singleItem = dataList.get(position);

        holder.text_title.setText(singleItem.getCmt_name());
        holder.text_comment.setText(singleItem.getCmt_text());

        PrettyTime prettyTime = new PrettyTime();
        long timeAgo = Tools.timeStringtoMilis(singleItem.getCmt_date());
        holder.text_date.setText(prettyTime.format(new Date(timeAgo)));

        //holder.text_date.setText(singleItem.getCmt_date());


    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        private TextView text_title, text_comment,text_date;

        private ItemRowHolder(View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.txt_title);
            text_title = itemView.findViewById(R.id.txt_title);
            text_comment = itemView.findViewById(R.id.textView_comment_adapter);
            text_date = itemView.findViewById(R.id.comment_date);

        }
    }


}
