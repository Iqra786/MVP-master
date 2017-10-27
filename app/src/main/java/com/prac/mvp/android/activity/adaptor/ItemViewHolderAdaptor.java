package com.prac.mvp.android.activity.adaptor;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.prac.mvp.R;

public class ItemViewHolderAdaptor  extends RecyclerView.ViewHolder {

    public TextView name;
    public   TextView artistName;
    public ImageView artWork;

    public ItemViewHolderAdaptor(View itemView) {
        super(itemView);
        name =  itemView.findViewById(R.id.name);
        artistName = itemView.findViewById(R.id.artist_Name);
        artWork = itemView.findViewById(R.id.art_Work);
    }

}
