package com.meetApp.meetappandroid.presenter;

import com.meetApp.meetappandroid.contract.MessageDetailContract;
import com.meetApp.meetappandroid.domain.Message;
import com.meetApp.meetappandroid.model.MessageDetailModel;
import com.meetApp.meetappandroid.view.MessageDetailView;

public class MessageDetailPresenter implements MessageDetailContract.Presenter {

    private MessageDetailModel model;
    private MessageDetailView view;

    public MessageDetailPresenter(MessageDetailView view) {
        this.view = view;
        model = new MessageDetailModel();
    }


    @Override
    public void loadMessageDetails(int messageId) {

    }
}
