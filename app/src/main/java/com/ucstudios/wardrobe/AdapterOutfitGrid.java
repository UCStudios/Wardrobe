package com.ucstudios.wardrobe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterOutfitGrid extends BaseAdapter {
    public static final String TAG = "AdapterOutfitGrid";
    private LayoutInflater thisInflater;
    private Context mContext;
    ArrayList<String> itemname;
    TextView text;
    ArrayList<ArrayList<byte[]>> imagedata;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    public AdapterOutfitGrid(Context context, ArrayList<String> itemname,ArrayList<ArrayList<byte[]>> alloutfitimagess) {
        this.thisInflater = LayoutInflater.from(context);
        this.itemname = itemname;
        this.imagedata = alloutfitimagess;
    }

    @Override
    public int getCount(){
        return itemname.size();
    }

    @Override
    public Object getItem(int position){return null;}

    @Override
    public long getItemId(int position){
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        convertView = thisInflater.inflate(R.layout.adapter_outfit_grid,parent,false);
        text = convertView.findViewById(R.id.textViewGridOutfit);
        text.setText(itemname.get(position));
        imageView = convertView.findViewById(R.id.imageViewGridnumber1);
        imageView2 = convertView.findViewById(R.id.imageViewGridNumber2);
        imageView3 = convertView.findViewById(R.id.imageViewGridNumber3);
        imageView4 = convertView.findViewById(R.id.imageViewGridNumber4);

        switch(imagedata.size()){
            case 0:
                break;
            case 1:
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageBitmap(Utils.getImage(imagedata.get(position).get(0)));

            case 2:
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageBitmap(Utils.getImage(imagedata.get(position).get(0)));
                imageView2.setVisibility(View.VISIBLE);
                imageView2.setImageBitmap(Utils.getImage(imagedata.get(position).get(1)));

            case 3:
                imageView.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                imageView.setImageBitmap(Utils.getImage(imagedata.get(position).get(0)));
                imageView2.setImageBitmap(Utils.getImage(imagedata.get(position).get(1)));
                imageView3.setImageBitmap(Utils.getImage(imagedata.get(position).get(2)));

        }

        if(imagedata.size()>=4){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageView3.setVisibility(View.VISIBLE);
            imageView4.setVisibility(View.VISIBLE);
            imageView.setImageBitmap(Utils.getImage(imagedata.get(position).get(0)));
            imageView2.setImageBitmap(Utils.getImage(imagedata.get(position).get(1)));
            imageView3.setImageBitmap(Utils.getImage(imagedata.get(position).get(2)));
            imageView4.setImageBitmap(Utils.getImage(imagedata.get(position).get(3)));
        }
       
       //Build if to check imagedata actual presence

        return convertView;
    }

}

