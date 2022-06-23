package com.meetApp.meetappandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.meetApp.meetappandroid.R;
import com.meetApp.meetappandroid.contract.MessageListContract;
import com.meetApp.meetappandroid.domain.Message;
import com.meetApp.meetappandroid.presenter.MessageDetailPresenter;
import com.meetApp.meetappandroid.presenter.MessageListPresenter;

import java.util.ArrayList;
import java.util.List;

public class MessageListView extends AppCompatActivity implements MessageListContract.View, AdapterView.OnItemClickListener {

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
        lvMessages.setOnItemClickListener(this);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_main, menu);
        return true;
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        switch (item.getItemId()) {
            case R.id.settings:

                break;
            case R.id.events:

                break;
            case R.id.reminders:
                break;
            case R.id.messages:
                break;
            case R.id.categories:
                break;
            case R.id.favs:
                break;
            case R.id.exit:
                break;
        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Message message = messageList.get(position);
        Intent intent = new Intent(this, MessageDetailView.class);//carga la clase

        Bundle bundle = new Bundle();
        bundle.putSerializable("message",message);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
