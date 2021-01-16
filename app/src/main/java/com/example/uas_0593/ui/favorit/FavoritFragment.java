package com.example.uas_0593.ui.favorit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_0593.R;
import com.example.uas_0593.adapter.FavoritAdapter;
import com.example.uas_0593.models.Favorit;

import java.util.ArrayList;

public class FavoritFragment extends Fragment {

    private FavoritViewModel favoritViewModel;
    ArrayList<Favorit> arrayFavorit = new ArrayList<Favorit>();
    RecyclerView rcFavorit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        favoritViewModel =
//                ViewModelProviders.of(this).get(FavoritViewModel.class);
        View view = inflater.inflate(R.layout.fragment_pertandinganfavorit, container, false);


        final SQLiteDatabase mydatabase = getActivity().openOrCreateDatabase("database_0593",android.content.Context.MODE_PRIVATE,null);

        Cursor res =  mydatabase.rawQuery( "SELECT * FROM favorit", null );

        res.moveToFirst();

        rcFavorit = view.findViewById(R.id.rcFavorit);

        while(res.isAfterLast() == false){
            String matchid = res.getString(0);
            String namaevent = res.getString(1);
            String liga = res.getString(2);
            String venue = res.getString(3);
            String waktu = res.getString(4);
            String hasil = res.getString(5);
            String image = res.getString(6);
            System.out.println(namaevent);
            arrayFavorit.add(new Favorit(matchid,image,namaevent, "-","-","-"));
            res.moveToNext();
        }

        FavoritAdapter fAdapter = new FavoritAdapter(container.getContext(),arrayFavorit);

        rcFavorit.setAdapter(fAdapter);
        rcFavorit.setLayoutManager(new LinearLayoutManager(container.getContext()));


        return view;
    }
}