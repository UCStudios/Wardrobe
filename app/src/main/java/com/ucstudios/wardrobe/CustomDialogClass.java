package com.ucstudios.wardrobe;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.text.GetChars;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class CustomDialogClass extends Dialog implements View.OnClickListener {


    public Dialog d;
    public Button button;
    public Button buttoncancel;
    DatabaseHelper mDatabaseHelper;
    MainActivity mainActivity;
    EditText editText;
    private ListView mRecyclerView;




    public CustomDialogClass(Activity a) {
        super(a);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        buttoncancel = findViewById(R.id.button2);
        buttoncancel.setOnClickListener(this);
        mDatabaseHelper = new DatabaseHelper(getContext());
        editText = findViewById(R.id.editText);


        mRecyclerView = findViewById(R.id.spezzaossa);
        populateButtons();

    }
    private void populateButtons() {
        Cursor data = mDatabaseHelper.getData();
        final ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(data.getString(1));
        }

        CustomListView adapter = new CustomListView(mRecyclerView.getContext(), R.layout.adapter_view_layout, listData);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:

                Log.i("msg",editText.getText().toString());
                dismiss();
                break;
            case R.id.button2:
                dismiss();



        }
    }
}