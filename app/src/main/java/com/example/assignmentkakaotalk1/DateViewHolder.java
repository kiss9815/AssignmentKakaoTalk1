package com.example.assignmentkakaotalk1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by EOM on 2016-01-24.
 */
public class DateViewHolder extends RecyclerView.ViewHolder{
    TextView text_title;
    public DateViewHolder(View itemView) {
        super(itemView);
        text_title = (TextView)itemView.findViewById(R.id.text_message);

    }

    public void setDateData(DateData data){
        text_title.setText(data.message);
    }
}
