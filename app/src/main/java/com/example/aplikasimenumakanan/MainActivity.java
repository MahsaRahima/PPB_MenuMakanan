package com.example.aplikasimenumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recMakanan;
    private ArrayList<Menu> listMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recMakanan = findViewById(R.id.rec_makanan);
        initData();

        recMakanan.setAdapter(new MenuAdapter(listMakanan));
        recMakanan.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initData(){
        this.listMakanan = new ArrayList<>();
        listMakanan.add(new Menu("Boba Milk Tea",
                "Rp. 25.000",
                "Milk tea pearl boba with brown sugar",
                R.drawable.boba));
        listMakanan.add(new Menu("Spaghetti Carbonara",
                "Rp. 30.000",
                "Spaghetti with carbonara sauce",
                R.drawable.spaghetticarbonara));
        listMakanan.add(new Menu("Shihlin",
                "Rp. 25.000",
                "Ayam goreng taiwan dengan aneka bumbu",
                R.drawable.shihlin));
        listMakanan.add(new Menu("Risol Mayo",
                "Rp. 5.000",
                "Risol dengan isian smoked beef, telur dan mayonnaise",
                R.drawable.risolmayo));
        listMakanan.add(new Menu("Tteokpokki",
                "Rp. 25.000",
                "Risol dengan isian smoked beef, telur dan mayonnaise",
                R.drawable.tteokpokki));
    }
}