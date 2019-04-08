package com.art.bbc_news.bbcnews_page;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.art.bbc_news.R;
import com.art.bbc_news.objects.Article;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BBCNewsAdapter extends RecyclerView.Adapter<BBCNewsAdapter.BBCNewsViewHolder> {

    private List<Article> mBBCNewsItemList;
    private OnItemClickListener itemClickListener;

    interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public BBCNewsAdapter(){
        if (this.mBBCNewsItemList == null){
            this.mBBCNewsItemList = new ArrayList<>();
        }
    }

    public BBCNewsAdapter(List<Article> mBBCNewsItemList) {
        if (mBBCNewsItemList != null) {
            this.mBBCNewsItemList = mBBCNewsItemList;
        }else {
            this.mBBCNewsItemList = new ArrayList<>();
        }
    }

    @Override
    public BBCNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bbc_news, parent, false);
        return new BBCNewsViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull BBCNewsViewHolder holder, int i) {
        holder.bind(mBBCNewsItemList.get(i), i);
    }

    @Override
    public int getItemCount() {
        if (mBBCNewsItemList != null) {
            return mBBCNewsItemList.size();
        }
        return 0;
    }

    public void clearItems() {
        mBBCNewsItemList.clear();
        notifyDataSetChanged();
    }

    public void setItems(List<Article> itemList) {
        mBBCNewsItemList.clear();
        mBBCNewsItemList.addAll(itemList);
        notifyDataSetChanged();
    }


    class BBCNewsViewHolder extends RecyclerView.ViewHolder{

        Context context;
        TextView mTitleTxt;
        TextView mDescriptionTxt;
        ImageView mNewsImage;

        public BBCNewsViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            this.context = context;

            mTitleTxt = itemView.findViewById(R.id.news_title);
            mDescriptionTxt = itemView.findViewById(R.id.news_description);
            mNewsImage = itemView.findViewById(R.id.news_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(v, getAdapterPosition());
                }
            });

        }

        void bind(final Article articleItem, int position) {
            mTitleTxt.setText(articleItem.getTitle());
            mDescriptionTxt.setText(articleItem.getDescription());
            Glide.with(context).load(articleItem.getUrlToImage()).into(mNewsImage);        }
    }
}



