package com.example.pcs.helperclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcs.R;

import java.util.ArrayList;

public class featuredAdpater extends RecyclerView.Adapter<featuredAdpater.featuredViewHolder> {

    ArrayList<featuredhelperclass> featuredLocation;

    public featuredAdpater(ArrayList<featuredhelperclass> featuredLocation) {
        this.featuredLocation = featuredLocation;
    }

    @NonNull
    @Override
    public featuredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()
        ).inflate(R.layout.featured_card_deign,parent, false);
        featuredViewHolder featuredViewHolder= new featuredViewHolder(view);

        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull featuredViewHolder holder, int position) {
        featuredhelperclass featuredhelperclass = featuredLocation.get(position);

        holder.image.setImageResource(featuredhelperclass.getImage());
        holder.title.setText(featuredhelperclass.getTitle());
        holder.desc.setText(featuredhelperclass.getDescrption());

    }

    @Override
    public int getItemCount() {
        return featuredLocation.size();
    }

    public static class featuredViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public featuredViewHolder(@NonNull View itemView) {
            super(itemView);
            //hooks
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_ders);


        }
    }
}
