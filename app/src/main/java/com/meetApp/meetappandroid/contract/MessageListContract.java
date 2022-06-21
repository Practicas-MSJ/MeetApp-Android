package com.meetApp.meetappandroid.contract;

import com.meetApp.meetappandroid.domain.Message;

import java.util.List;

public interface MessageListContract {
    interface Model {
        interface OnLoadMessagesListener {
            void onLoadMessagesSuccess(List<Message> messages);
            void onLoadMessagesError(String error);
        }
        void loadAllMessages(OnLoadMessagesListener listener);
    }

    interface View {
        void listAllMessages(List<Message> messages);
        void showErrorMessage(String error);
    }

    interface Presenter {
        void loadAllMessages();
    }
}
