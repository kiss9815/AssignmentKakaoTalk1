package com.example.assignmentkakaotalk1;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by EOM on 2016-01-24.
 */
public class ReceiveViewHolder extends RecyclerView.ViewHolder{
    TextView text_message;
    ImageView image_icon;
    public ReceiveViewHolder(View itemView) {
        super(itemView);
        text_message = (TextView)itemView.findViewById(R.id.text_message);
        image_icon = (ImageView)itemView.findViewById(R.id.image_icon);
    }

    public void setReceiveData(ReceiveData data){
        text_message.setText(data.message);
        image_icon.setImageResource(data.iconId);
    }

}
