package com.mac.hiddenmessages.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mac.hiddenmessages.R;
import com.mac.hiddenmessages.adapters.MessageAdapter;
import com.mac.hiddenmessages.models.Message;
import com.mac.hiddenmessages.utils.MsgParser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MessageAdapter mAdapter;
    private RecyclerView recyclerView;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MessageAdapter(this, new ArrayList<Message>());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        et = (EditText) findViewById(R.id.input);
        ImageView send = (ImageView) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewMessages(et.getText().toString());
            }
        });
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    addNewMessages(textView.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    private void addNewMessages(String text) {
        if(text.isEmpty()){
            return;
        }
        Message input = new Message(1, text);
        Message output1 = new Message(2, "Algo1: "+MsgParser.algorithm1(text));
        Message output2 = new Message(2, "Algo2: "+MsgParser.algorithm2(text));

        mAdapter.addMessage(input);
        mAdapter.addMessage(output1);
        mAdapter.addMessage(output2);
        recyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
        et.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    

}
