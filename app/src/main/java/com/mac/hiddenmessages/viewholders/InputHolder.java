package com.mac.hiddenmessages.viewholders;

import android.view.View;
import android.widget.TextView;

import com.mac.hiddenmessages.R;

public class InputHolder extends BaseViewHolder {
    public InputHolder(View v) {
        super(v);
        messageView = (TextView) v.findViewById(R.id.inputTxt);
    }
}
