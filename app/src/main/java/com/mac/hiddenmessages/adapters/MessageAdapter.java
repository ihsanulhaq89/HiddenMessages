package com.mac.hiddenmessages.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mac.hiddenmessages.R;
import com.mac.hiddenmessages.models.Message;
import com.mac.hiddenmessages.viewholders.BaseViewHolder;
import com.mac.hiddenmessages.viewholders.InputHolder;
import com.mac.hiddenmessages.viewholders.OutputHolder;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter {
    private final int INPUT_TYPE = 1;
    private final int OUTPUT_TYPE = 2;
    private final Context mContext;
    private final List<Message> mItems;

    public MessageAdapter(Context context, List<Message> cards) {
        mContext = context;
        mItems = cards;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case INPUT_TYPE: {
                View v = LayoutInflater.from(mContext)
                        .inflate(R.layout.input, parent, false);
                return new InputHolder(v);
            }
            case OUTPUT_TYPE: {
                View v = LayoutInflater.from(mContext)
                        .inflate(R.layout.output, parent, false);
                return new OutputHolder(v);
            }

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((BaseViewHolder) viewHolder).invalidate(mItems.get(position).getMsg());
    }

    public void addMessage(Message msg){
        mItems.add(msg);
        notifyDataSetChanged();
    }
}
