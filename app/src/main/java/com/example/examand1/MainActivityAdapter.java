package com.example.examand1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examand1.Gallery.GlideApp;

import java.util.ArrayList;


class MainActivityAdapter extends RecyclerView.Adapter<ViewHolder> {

        private static final String TAG = "MainActivityAdapter";
        private ArrayList<FrontPhoto> images;
        private Context mContext;

        public MainActivityAdapter(Context mContext, ArrayList<FrontPhoto> images) {
            this.mContext = mContext;
            this.images = images;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.activity_main_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            FrontPhoto Foto = images.get(position);
            GlideApp.with(mContext).load(Foto.getImageurl())
                    .error(R.drawable.ic_cloud_off_red)
                    .placeholder(R.drawable.ic_cloud_off_red)
                    .into(holder.image_view);



        }

        @Override
        public int getItemCount() {
            if ((images != null)) {
                return images.size();
            } else {
                return 0;
            }
        }

        }

         class ViewHolder extends RecyclerView.ViewHolder {
            ImageView image_view;


            public ViewHolder(View itemView) {
                super(itemView);
                this.image_view = itemView.findViewById(R.id.front_photo);

            }
        }




