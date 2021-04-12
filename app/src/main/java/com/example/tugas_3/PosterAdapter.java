package com.example.tugas_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PosterModel> posterModels;
    private int orientasi;
    private OnItemClickListener fListener;

    public int getOrientasi() {

        return orientasi;
    }

    public void setOrientasi(int tanda) {
        this.orientasi = tanda;
    }

    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        this.fListener = listener;
    }


    public PosterAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<PosterModel> getPosterModels() {
        return posterModels;
    }

    public void setPosterModels(ArrayList<PosterModel> posterModels) {
        this.posterModels = posterModels;
    }

    @NonNull
    @Override
    public PosterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow;
        if (getOrientasi()==0) itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film,parent,false);
            // jika horizontal
        else if (getOrientasi()==1) itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film,parent,false);
            // jika grid
        else if (getOrientasi()==2) itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent,false);
            // default
        else  itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film,parent,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(getPosterModels().get(position).getPosterFilm()).into(holder.ivPosterFilm);
        holder.tvNamaFilm.setText(getPosterModels().get(position).getNamaFilm());
    }

    @Override
    public int getItemCount() {
        return getPosterModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPosterFilm;
        private TextView tvNamaFilm;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPosterFilm = itemView.findViewById(R.id.foto_poster);
            tvNamaFilm = itemView.findViewById(R.id.nama_poster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        fListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
