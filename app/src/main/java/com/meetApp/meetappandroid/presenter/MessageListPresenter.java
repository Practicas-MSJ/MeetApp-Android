package com.meetApp.meetappandroid.presenter;

import com.meetApp.meetappandroid.contract.MessageListContract;
import com.meetApp.meetappandroid.domain.Message;
import com.meetApp.meetappandroid.model.MessageListModel;
import com.meetApp.meetappandroid.view.MessageListView;

import java.util.List;

public class MessageListPresenter implements MessageListContract.Presenter, MessageListContract.Model.OnLoadMessagesListener {
    private MessageListModel model;
    private MessageListView view;

    public MessageListPresenter(MessageListView view){
        model = new MessageListModel(view.getApplicationContext());
        this.view =view;
    }
    @Override
    public void onLoadMessagesSuccess(List<Message> messages) {

    view.listAllMessages(messages);
    }

    @Override
    public void onLoadMessagesError(String error) {
    view.showErrorMessage(error);
    }

    @Override
    public void loadAllMessages() {
    model.loadAllMessages(this);
    }
}
