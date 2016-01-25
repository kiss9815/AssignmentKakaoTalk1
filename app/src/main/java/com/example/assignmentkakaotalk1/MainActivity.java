package com.example.assignmentkakaotalk1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Date;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RadioGroup radioGroup;
    EditText edit_input;
    MultiAdapter mAdapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
          mAdapter = new MultiAdapter();
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        edit_input = (EditText)findViewById(R.id.edit_input);
         radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        Button btn = (Button)findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                switch (id){
                    case R.id.radio_send:
                        SendData sd = new SendData();
                        sd.iconId = R.mipmap.ic_launcher;
                        sd.message = edit_input.getText().toString();
                        mAdapter.add(sd);
                        break;
                    case R.id.radio_receive:
                        ReceiveData rd = new ReceiveData();
                        rd.iconId = R.mipmap.ic_launcher;
                        rd.message = edit_input.getText().toString();
                        mAdapter.add(rd);
                        break;
                    case R.id.radio_date:
                        DateData dd = new DateData();
                        dd.message = new Date().toString();
                        mAdapter.add(dd);
                        break;
                }
                edit_input.setText("");
            }
        });

    }
}
