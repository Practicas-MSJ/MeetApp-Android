package com.meetApp.meetappandroid.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.meetApp.meetappandroid.R;
import com.meetApp.meetappandroid.contract.MessageListContract;
import com.meetApp.meetappandroid.domain.Message;
import com.meetApp.meetappandroid.presenter.MessageListPresenter;

import java.util.ArrayList;
import java.util.List;

public class MessageListView extends AppCompatActivity implements MessageListContract.View {

    private MessageListPresenter presenter;
    private ArrayAdapter<Message> messagesAdapter;
    private List<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMessageList();

        presenter = new MessageListPresenter(this);
        presenter.loadAllMessages();
    }

    private void initializeMessageList() {
        messageList = new ArrayList<>();
        messagesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messageList);
        ListView lvMessages = findViewById(R.id.messages_list);
        lvMessages.setAdapter(messagesAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllMessages();
    }

    @Override
    public void listAllMessages(List<Message> messages) {
        messageList.clear();
        messageList.addAll(messages);
        messagesAdapter.notifyDataSetChanged();

    }

    @Override
    public void showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
