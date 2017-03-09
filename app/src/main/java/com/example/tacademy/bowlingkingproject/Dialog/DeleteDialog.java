package com.example.tacademy.bowlingkingproject.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;

/**
 * Created by Tacademy on 2017-02-27.
 */


public class DeleteDialog extends Dialog {

    TextView revise,delete;
    View.OnClickListener reviseListener,deleteListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.dialog_location);
       setContentView(R.layout.deletedialog);
        revise= (TextView) findViewById(R.id.revise);
        delete= (TextView) findViewById(R.id.delete);
        revise.setOnClickListener(reviseListener);
        delete.setOnClickListener(deleteListener);

    }


    public DeleteDialog(Context context, View.OnClickListener reviseListener, View.OnClickListener deleteListener) {

        super(context);
        this.reviseListener=reviseListener;
        this.deleteListener=deleteListener;

    }

    public DeleteDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
