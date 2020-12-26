package com.example.pcs.helperclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcs.R;

import java.util.ArrayList;

public class mostviewAdpter extends RecyclerView.Adapter<mostviewAdpter.mostviewViewHolder> {
ArrayList<mostview>  mostviewsLoaction;

    public mostviewAdpter(ArrayList<mostview> mostviewsLoaction) {
        this.mostviewsLoaction = mostviewsLoaction;
    }

    @NonNull
    @Override
    public mostviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_card,parent,false);
        mostviewViewHolder mostviewViewHolder = new mostviewViewHolder(view);
        return mostviewViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull mostviewViewHolder holder, int position) {

         mostview mostview = mostviewsLoaction.get(position);
         holder.image.setImageResource(mostview.getImage());
    }

    @Override
    public int getItemCount() {
        return mostviewsLoaction.size();
    }

    public static  class mostviewViewHolder extends  RecyclerView.ViewHolder{
        ImageView image;

        public mostviewViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.ms_image);
        }
    }
}
