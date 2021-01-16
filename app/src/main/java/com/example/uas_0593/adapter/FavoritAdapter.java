package com.example.uas_0593.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.uas_0593.R;
import com.example.uas_0593.detail_riwayat;
import com.example.uas_0593.models.Favorit;

import java.util.ArrayList;

public class FavoritAdapter extends RecyclerView.Adapter<FavoritAdapter.MyViewHolder> {

    Context context;
    ArrayList<Favorit> favorit;

    public FavoritAdapter(Context context, ArrayList<Favorit> favorit){
        this.context=context;
        this.favorit=favorit;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_favorit, parent, false);
        return new FavoritAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.matchTitle.setText(favorit.get(position).getMatchTitle());
        holder.matchDescription.setText(favorit.get(position).getMatchId());



        Glide.with(context).load(favorit.get(position).getImage()).into(holder.gambarMatch);

        holder.btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SQLiteDatabase mydatabase = context.openOrCreateDatabase("database_0593",android.content.Context.MODE_PRIVATE,null);
                mydatabase.execSQL(String.format("DELETE FROM favorit WHERE idevent='%s'",favorit.get(position).getMatchId()));
            }
        });

        holder.btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detail_riwayat.class);
                intent.putExtra("matchId",favorit.get(position).getMatchId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favorit.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView matchTitle, matchDescription;
        ImageView gambarMatch;
        Button btndetail, btnhapus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            matchTitle = itemView.findViewById(R.id.titleMatch);
            matchDescription = itemView.findViewById(R.id.descriptionMatch);
            gambarMatch = itemView.findViewById(R.id.gambarMatch);
            btndetail = itemView.findViewById(R.id.btnDetail);
            btnhapus = itemView.findViewById(R.id.btnHapus);
        }
    }
}
