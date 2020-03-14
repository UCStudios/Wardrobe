package com.ucstudios.wardrobe;

import android.app.ActionBar;
import android.app.Person;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import android.widget.CompoundButton.OnCheckedChangeListener;

public class CustomListView extends ArrayAdapter<String>  {

    private static final String TAG = "CustomListView";

    private Context mContext;
    int mResource;
    DatabaseHelper mDatabaseHelper;
    public int a=2;




    MainActivity mainActivity;
    public CustomListView(Context context, int adapter_view_layout, ArrayList<String> listData) {
        super(context, adapter_view_layout, listData);
        mResource = adapter_view_layout;
        this.mContext= context;
    }


    public void replaceItemOutfit(String item, String negro){
        boolean replaceItemOutfit = mDatabaseHelper.ReplaceItemOutfit(item, negro);

    }

    public void addItem(String item, String negro){
        boolean addItemOutfit = mDatabaseHelper.addData3(item, negro);

    }



    public void DeleteData(String Column, String sex){
        boolean insertData = mDatabaseHelper.delete1(Column, sex);

    }


    public View getView(int position, View convertView, ViewGroup parent){
        mDatabaseHelper = new DatabaseHelper(getContext());
        String category = getItem(position);


        Cursor Drugs =  mDatabaseHelper.getData1(category);
        final ArrayList<String> drugs = new ArrayList<>();
        while (Drugs.moveToNext()) {
            drugs.add(Drugs.getString(1));
        }

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        final TextView checkbox = (TextView) convertView.findViewById(R.id.textView2);
        final Switch aSwitch = (Switch) convertView.findViewById(R.id.switch1);
        final Spinner spinner = convertView.findViewById(R.id.spinner);




        aSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                spinnerVisibility();

            }

            private void spinnerVisibility() {
                if (aSwitch.isChecked()){
                    spinner.setVisibility(View.VISIBLE);


                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            final String item = (String) spinner.getSelectedItem();
                               final String column = (String) checkbox.getText();
                               if(a==2) {
                                   addItem(item, column);
                                   a=1;
                               }else{
                                   replaceItemOutfit(item, column);}}





                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }});
                }
                else{
                    final String porno = (String) spinner.getSelectedItem();
                    final String perno = (String) checkbox.getText();
                    spinner.setVisibility(View.GONE);
                    DeleteData(perno, porno);
                }
            }

        });
        checkbox.setText(category);

        ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter(getContext(),
                android.R.layout.simple_spinner_item, drugs );

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter1);




        return convertView;


    }





        }


