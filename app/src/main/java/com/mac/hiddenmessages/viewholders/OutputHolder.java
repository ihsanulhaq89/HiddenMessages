package com.mac.hiddenmessages.viewholders;

import android.view.View;
import android.widget.TextView;

import com.mac.hiddenmessages.R;

public class OutputHolder extends BaseViewHolder {
    public OutputHolder(View v) {
        super(v);
        messageView = (TextView) v.findViewById(R.id.outputTxt);
    }
}
