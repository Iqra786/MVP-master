package com.prac.mvp.android.activity.adaptor;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.prac.mvp.R;
import com.squareup.picasso.Picasso;


abstract class ResultAdaptor extends RecyclerView.Adapter<ItemViewHolderAdaptor>  {


    @Override
    public ItemViewHolderAdaptor onCreateViewHolder(ViewGroup viewGroup, int i) {
        int layoutRes = setAdaptorView();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutRes, viewGroup, false);
        return new ItemViewHolderAdaptor(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolderAdaptor itemViewHolderAdaptor, int i) {
        viewBinder(itemViewHolderAdaptor, i);
    }

    protected void imageLoader(String url, ImageView artWork) throws IllegalArgumentException {
        if (!url.isEmpty()) {
            Picasso.with(artWork.getContext()).load(url).into(artWork);
        } else {
            artWork.setImageResource(R.drawable.image_missing);
        }
    }

    @Override
    public int getItemCount() {
        return resultCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    protected abstract int setAdaptorView();

    protected abstract void viewBinder(ItemViewHolderAdaptor itemViewHolderAdaptor, int i);

    protected abstract int resultCount();
}
