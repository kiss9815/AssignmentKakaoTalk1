package com.example.assignmentkakaotalk1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-01-25.
 */
public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<ChattingData> items = new ArrayList<ChattingData>();

    public void add(ChattingData data){
        items.add(data);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_RECEIVE = 0;
    private static final int VIEW_TYPE_DATE = 1;
    private static final int VIEW_TYPE_SEND = 2;


    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
        if(data instanceof DateData){
            return VIEW_TYPE_DATE;
        }else if(data instanceof ReceiveData){
            return VIEW_TYPE_RECEIVE;
        }else if(data instanceof SendData){
            return VIEW_TYPE_SEND;
        }

        return super.getItemViewType(position);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType){
            case VIEW_TYPE_SEND:
                view =inflater.inflate(R.layout.view_send,parent,false);
                return new SendViewHolder(view);
            case VIEW_TYPE_RECEIVE:
                view = inflater.inflate(R.layout.view_receive, parent, false);
                return new ReceiveViewHolder(view);
            case VIEW_TYPE_DATE:
                view = inflater.inflate(R.layout.view_date, parent, false);
                return new DateViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            switch (getItemViewType(position)){
                case VIEW_TYPE_SEND:
                    ((SendViewHolder)holder).setSendData((SendData) items.get(position));
                    break;
                case VIEW_TYPE_RECEIVE:
                    ((ReceiveViewHolder)holder).setReceiveData((ReceiveData) items.get(position));
                    break;
                case VIEW_TYPE_DATE:
                    ((DateViewHolder)holder).setDateData((DateData) items.get(position));
                    break;

            }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
