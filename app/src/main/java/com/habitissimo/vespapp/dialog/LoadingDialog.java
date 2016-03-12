package com.habitissimo.vespapp.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.habitissimo.vespapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoadingDialog extends AlertDialog {
    @Bind(R.id.container) View container;
    private Listener listener;

    protected LoadingDialog(Context context) {
        super(context);
        init();
    }

    protected LoadingDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    protected LoadingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    public static void show(Context context, Listener listener) {
        new LoadingDialog(context).setListener(listener).show();
    }

    private LoadingDialog setListener(Listener listener) {
        this.listener = listener;
        return this;
    }

    private void init() {
        setContentView(R.layout.dialog_loading);
        ButterKnife.bind(this);

        container.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                dismiss();
            }
        });

        setOnDismissListener(new OnDismissListener() {
            @Override public void onDismiss(DialogInterface dialog) {
                listener.onDialogDismissed();
            }
        });
    }

    public interface Listener {
        void onDialogDismissed();
    }
}
