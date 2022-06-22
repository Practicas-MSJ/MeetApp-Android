package com.meetApp.meetappandroid.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.meetApp.meetappandroid.R;
import com.meetApp.meetappandroid.contract.MessageDetailContract;
import com.meetApp.meetappandroid.domain.Message;
import com.meetApp.meetappandroid.presenter.MessageDetailPresenter;

public class MessageDetailView extends AppCompatActivity implements MessageDetailContract.View {
    private  int modify;
    private MessageDetailPresenter presenter;
    Message message =new Message(0,"","",true,null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);

        EditText etText = findViewById(R.id.message_text);
        EditText etDate = findViewById(R.id.message_date);
        EditText etFavourite = findViewById(R.id.message_favourite);
        ImageView etImage = findViewById(R.id.message_image);



            Bundle objetoEnviado = getIntent().getExtras();
            Message message = null;

            if (objetoEnviado!=null){
                message = (Message) objetoEnviado.getSerializable("message");
            }

            etText.setText(message.getText());
            etDate.setText(message.getDate());


//TODO AQUI ES DONDE ME FALTA DE PASAR ESOS DOS ATRIBUTOS

//            etFavourite.setText(message.);
//        etImage.setImageBitmap(message.getImage().toString());


    }

    @Override
    public void showMessageDetails(Message message) {

    }
}
