package com.ucstudios.wardrobe;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class RecyclerAdapterItems extends RecyclerView.Adapter<RecyclerAdapterItems.ViewHolder> implements  ItemTouchHelperAdapter{

    private static final String TAG = "RecyclerAdapter";
    DatabaseHelper mDatabaseHelper;
    Context mContext;
    int count = 0;
    String[] items;
    View.OnClickListener mClickListener;
    Integer[] ppos;
    Integer[] icons;
    List<byte[]>tech;
    public int sex;
    MainActivity mainActivity;
    private Integer[] Icons = {
            R.drawable.nobrand,
            R.drawable.ic_nike,
            R.drawable.ic_adidas,
            R.drawable.ic_aber,
            R.drawable.ic_armani,
            R.drawable.ic_asics,
            R.drawable.ic_diadora,
            R.drawable.ic_eddiebauer,
            R.drawable.ic_bershka,
            R.drawable.ic_fila,
            R.drawable.ic_gaudi,
            R.drawable.ic_hollister,
            R.drawable.ic_kappa,
            R.drawable.ic_lacoste,
            R.drawable.ic_oakley,
            R.drawable.ic_pullbear,
            R.drawable.ic_seiko,
            R.drawable.ic_americaneagle,
            R.drawable.ic_billabong,
            R.drawable.ic_burton,
            R.drawable.ic_ck,
            R.drawable.ic_celio,
            R.drawable.ic_champions,
            R.drawable.ic_chanel,
            R.drawable.ic_coach,
            R.drawable.ic_columbia,
            R.drawable.ic_dior,
            R.drawable.ic_gap,
            R.drawable.ic_gucci,
            R.drawable.ic_hm,
            R.drawable.ic_hermes,
            R.drawable.ic_boss,
            R.drawable.ic_lee,
            R.drawable.ic_levis,
            R.drawable.ic_lv,
            R.drawable.ic_mk,
            R.drawable.ic_napa,
            R.drawable.ic_nb,
            R.drawable.ic_puma,
            R.drawable.ic_quicksilver,
            R.drawable.ic_rayban,
            R.drawable.ic_stradivarius,
            R.drawable.ic_supreme,
            R.drawable.ic_northface,
            R.drawable.ic_trasher,
            R.drawable.ic_timberland,
            R.drawable.ic_under,
            R.drawable.ic_vans,
            R.drawable.ic_volcom,
            R.drawable.ic_wrangler,
            R.drawable.ic_zara,


    };

    private Integer[] IconsNobrand = {
            R.drawable.ic_sweater,
            R.drawable.ic_jeans,
            R.drawable.ic_hoodie,
            R.drawable.ic_shoes,
            R.drawable.ic_backpack,
            R.drawable.ic_denim,
            R.drawable.ic_shirt,
            R.drawable.ic_watch,
            R.drawable.ic_basketballjersey,
            R.drawable.ic_bathrobe,
            R.drawable.ic_belt,
            R.drawable.ic_blouse,
            R.drawable.ic_boot,
            R.drawable.ic_boot2,
            R.drawable.ic_bowtie,
            R.drawable.ic_bra,
            R.drawable.ic_cap,
            R.drawable.ic_coat,
            R.drawable.ic_dress,
            R.drawable.ic_glasses,
            R.drawable.ic_gloves,
            R.drawable.ic_bag,
            R.drawable.ic_hat,
            R.drawable.ic_heels,
            R.drawable.ic_jacket,
            R.drawable.ic_pimuno,
            R.drawable.ic_jacket2,
            R.drawable.ic_necklace,
            R.drawable.ic_salopette,
            R.drawable.ic_mutandefemmina,
            R.drawable.ic_cargo,
            R.drawable.ic_polo,
            R.drawable.ic_24h,
            R.drawable.ic_purse,
            R.drawable.ic_scarf,
            R.drawable.ic_tee,
            R.drawable.ic_top,
            R.drawable.ic_mocasso,
            R.drawable.ic_shorts,
            R.drawable.ic_papere,
            R.drawable.ic_skirt,
            R.drawable.ic_slippers,
            R.drawable.ic_socks,
            R.drawable.ic_tie,
            R.drawable.ic_trench,
            R.drawable.ic_underwear,
            R.drawable.ic_vest,
            R.drawable.ic_wallet,
            R.drawable.ic_winterhat,




    };

    private Integer[] iconwm ={
            R.drawable.ic_wm,
            R.drawable.ic_basket,
            R.drawable.ic_chevron_right_black_24dp
    };
    AdapterListResult mAdapterResult;

    String table;




    public RecyclerAdapterItems(Context context,List<Integer> position2, List<String> items,List<Integer> icons,List<byte[]> tech,String table,int sex) {
        this.mContext=context;
        this.items = items.toArray(new String[0]);
        this.ppos = position2.toArray(new Integer[0]);
        this.icons = icons.toArray(new Integer[0]);
        this.tech= tech;
        this.table=table;
        this.sex=sex;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mDatabaseHelper = new DatabaseHelper(mContext);
        Log.i(TAG,"onCreateViewHolder: " + count++ );
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.adapter_list, parent, false);
        RecyclerAdapterItems.ViewHolder viewHolder = new RecyclerAdapterItems.ViewHolder(view);
        mainActivity = new MainActivity();
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mClickListener.onClick(view);

            }
        });







        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(items[position]);

        if(icons[position]==0){
            holder.imageView.setImageResource(IconsNobrand[sex]);
        }
        else{
            holder.imageView.setImageResource(Icons[icons[position]]);
        }
        //holder.imageView.setImageBitmap(Utils.getImage(tech.get(position))); Mostra immagine vera
        if(ppos[position]==1){
            holder.imageView2.setImageResource(iconwm[1]);
            holder.imageView2.setVisibility(View.VISIBLE);

        }
        if(ppos[position]==2){
            holder.imageView2.setImageResource(iconwm[0]);
            holder.imageView2.setVisibility(View.VISIBLE);
        }
        /*Crea varibile GifImageView che contiene appunto la gif,
        dopodichè passala all'holder gif, se è uguale a 3, allora starta la gif*/
        if(ppos[position]==3){
            holder.imageView2.setImageResource(R.drawable.ic_wmtimer);
            holder.imageView2.setVisibility(View.VISIBLE);
        }
    }



    @Override
    public int getItemCount() {

        return items.length;
    }

    @Override
    public void onItemDismiss(int position) {
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        try{
        Log.i("position1","ecco"+fromPosition);
        Log.i("position2","ecco"+toPosition);
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(Arrays.asList(items), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(Arrays.asList(items), i, i - 1);

            }
        }
        notifyItemMoved(fromPosition, toPosition);
        mDatabaseHelper.SwapRows(fromPosition+1,toPosition+1,table);

        return true;
    }catch (Exception e){
            return false;
        }

    }






    public void setClickListener(View.OnClickListener callback){
        mClickListener = callback;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageView imageView2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView2 = itemView.findViewById(R.id.imageView5);
            imageView = itemView.findViewById(R.id.imageView231);
            textView = itemView.findViewById(R.id.textView4);




        }
    }

    public void setAdapterResult(AdapterListResult adapterResult){

        mAdapterResult = adapterResult;
    }



    public interface AdapterListResult{
        void finish(String result);
    }
}
