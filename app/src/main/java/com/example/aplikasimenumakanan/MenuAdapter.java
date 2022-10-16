package com.example.aplikasimenumakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    public MenuAdapter(ArrayList<Menu> listMakanan) {
        this.listMakanan = listMakanan;
    }

    private ArrayList<Menu> listMakanan;


    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_makanan, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Menu Makanan = listMakanan.get(position);
        holder.txtNama.setText(Makanan.getNama());
        holder.txtHarga.setText(Makanan.getHarga());
        holder.imgFoto.setImageResource(Makanan.getId_gambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(holder.itemView.getContext(), makanan.getNama(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(holder.itemView.getContext(), DetailMakananActivity.class);
                intent.putExtra("nama", Makanan.getNama());
                intent.putExtra("harga", Makanan.getHarga());
                intent.putExtra("deskripsi", Makanan.getDeskripsi());
                intent.putExtra("gambar",Makanan.getId_gambar());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNama, txtHarga;
        public ImageView imgFoto;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtHarga = (TextView) itemView.findViewById(R.id.txtHarga);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            this.itemView = (ConstraintLayout) itemView.findViewById(R.id.mainLayout);

        }
    }
}

