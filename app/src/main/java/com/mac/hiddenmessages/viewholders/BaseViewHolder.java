package com.mac.hiddenmessages.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    protected TextView messageView;

    public BaseViewHolder(View v) {
        super(v);
    }

    public void invalidate(String msg) {
        messageView.setText(msg);
    }
}
