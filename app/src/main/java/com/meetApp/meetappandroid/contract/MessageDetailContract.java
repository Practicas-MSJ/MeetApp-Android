package com.meetApp.meetappandroid.contract;

import com.meetApp.meetappandroid.domain.Message;

public interface MessageDetailContract {
    interface Model {
        Message getMessage(int messageId);
    }

    interface View {
        void showMessageDetails(Message message);
    }

    interface Presenter {
        void loadMessageDetails(int messageId);
    }

}

