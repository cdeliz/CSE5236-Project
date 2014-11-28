package com.example.chris.comicalstudios;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CreatePageDialog extends DialogFragment {
    public static final String EXTRA_TITLE_PAGE = "com.chris.android.comicalstudios.title";

    private String title;

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null)
            return;

        Intent i = new Intent();
        i.putExtra(EXTRA_TITLE_PAGE, title);


        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_create_page, null);

        //  final EditText editText = (EditText)v.findViewById(R.id.book_title);

        //inflater.inflate(R.layout.dialog_create_book, null)
        builder.setView(v)
                .setPositiveButton(
                        android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Dialog f = (Dialog) dialog;
                                EditText editText = (EditText)f.findViewById(R.id.page_title);
                                title = editText.getText().toString();

                                sendResult(Activity.RESULT_OK);
                            }
                        })
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        return builder.create();
    }

}