package com.example.admin.exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.exam.R;
import com.example.admin.exam.bean.DbBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RlvHotAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final List<DbBean> mList;
    private setOnCLickListener mListener;

    public RlvHotAdapter(Context context, List<DbBean> list) {

        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_rlv1, null, false);
            return new ViewHolder1(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_rlv2, null, false);
            return new ViewHolder2(inflate);
        } else if (viewType == 3) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_rlv3, null, false);
            return new ViewHolder3(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_rlv4, null, false);
            return new ViewHolder4(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        if (viewType==1){
            final ViewHolder1 holder1= (ViewHolder1) holder;
            holder1.mBanner.setImages(mList);
            holder1.mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    DbBean dbBean= (DbBean) path;
                    Glide.with(context).load(dbBean.getImg()).into(imageView);
                }
            }).start();
        }else if (viewType==2){
            ViewHolder2 holder2= (ViewHolder2) holder;
            Glide.with(mContext).load(mList.get(position).getImg()).into(holder2.mImg1);
            Glide.with(mContext).load(mList.get(position).getImg()).into(holder2.mImg2);
            holder2.mTv1.setText(mList.get(position).getTitle());
            holder2.mTv2.setText(mList.get(position).getTitle());
            holder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null){
                        mListener.onListener(v,position);
                    }
                }
            });
        }else if (viewType==3){
            ViewHolder3 holder3= (ViewHolder3) holder;
            Glide.with(mContext).load(mList.get(position).getImg()).into(holder3.mImg);
            holder3.mTv.setText(mList.get(position).getTitle());
            holder3.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null){
                        mListener.onListener(v,position);
                    }
                }
            });
        }else {
            ViewHolder4 holder4= (ViewHolder4) holder;
            Glide.with(mContext).load(mList.get(position).getImg()).into(holder4.mImg);
            holder4.mTv.setText(mList.get(position).getTitle());
            holder4.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null){
                        mListener.onListener(v,position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else if (position > 1 && position % 2 == 1) {
            return 3;
        } else {
            return 4;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        private final Banner mBanner;

        public ViewHolder1(View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.banner);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        private final TextView mTv2;
        private final TextView mTv1;
        private final ImageView mImg2;
        private final ImageView mImg1;

        public ViewHolder2(View itemView) {
            super(itemView);
            mImg1 = itemView.findViewById(R.id.img1);
            mImg2 = itemView.findViewById(R.id.img2);
            mTv1 = itemView.findViewById(R.id.tv1);
            mTv2 = itemView.findViewById(R.id.tv2);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {

        private final ImageView mImg;
        private final TextView mTv;

        public ViewHolder3(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mTv = itemView.findViewById(R.id.tv);
        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder {

        private final ImageView mImg;
        private final TextView mTv;

        public ViewHolder4(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mTv = itemView.findViewById(R.id.tv);
        }
    }

    public interface setOnCLickListener{
        void onListener(View v,int position);
    }

    public void setOnClickListener(setOnCLickListener listener){
        mListener=listener;
    }

}
