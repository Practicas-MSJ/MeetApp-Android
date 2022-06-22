package com.meetApp.meetappandroid.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.meetApp.meetappandroid.R;
import com.meetApp.meetappandroid.contract.MessageDetailContract;
import com.meetApp.meetappandroid.domain.Message;
import com.meetApp.meetappandroid.presenter.MessageDetailPresenter;

public class MessageDetailView extends AppCompatActivity implements MessageDetailContract.View {
    private  int modify;
    private MessageDetailPresenter presenter;
    Message message =new Message(0,"","",true,null);
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);

       // presenter = new MessageDetailPresenter(this);

        Intent intent = getIntent();
        modify = intent.getIntExtra("modify", 0);
        //TextView tvInfo = findViewById(R.id.modify_visit_info);
        String messageDate = intent.getStringExtra("dateMessage");

        message = (Message) intent.getSerializableExtra("Message");

        EditText etText = findViewById(R.id.message_text);
//        EditText etDate = findViewById(R.id.message_date);
//        EditText etFavourite = findViewById(R.id.message_favourite);
//        EditText etImage = findViewById(R.id.message_image);
//
            etText.setText(message.getText());
 //       etDate.setText(message.getDate());
//        etFavourite.setText(message.isFavourite());
//        etImage.setText(message.getImage());


//        int messageId = 0;
//        presenter.loadMessageDetails(messageId);
    }

    @Override
    public void showMessageDetails(Message message) {

    }
}
