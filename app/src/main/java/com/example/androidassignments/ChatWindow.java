package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatWindow extends AppCompatActivity {

    public class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        @Override
        public int getCount(){
            if (chatMessages == null) return -1;
            else return chatMessages.size();
        }
        public String getItem(int position){
            if (chatMessages == null) return null;
            else if (position < 0 || position >= chatMessages.size()) return null;
            else return chatMessages.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            TextView message = null;

            if(position%2 == 0) {
                result = inflater.inflate(R.layout.chat_row_incoming, null);
                message = result.findViewById(R.id.incoming_message_text);
            }
            else {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
                message = result.findViewById(R.id.outgoing_message_text);
            }

            message.setText(getItem(position)); // get the string at position
            return result;
        }
    }
    private ListView chatView;
    private ArrayList<String> chatMessages;
    private Button sendButton;
    private EditText chatInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        chatMessages = new ArrayList<>();
        chatView = super.findViewById(R.id.chatView);
        ChatAdapter messageAdapter =new ChatAdapter( this );
        chatView.setAdapter(messageAdapter);
        chatInput = super.findViewById(R.id.chatInput);
        sendButton = super.findViewById(R.id.sendButton);
        sendButton.setOnClickListener((view) -> {
            String chat = chatInput.getText().toString();
            chatMessages.add(chat);
            messageAdapter.notifyDataSetChanged();
            chatInput.setText("");
        });
    }
}