package com.example.uas_0593.ui.berlangsung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uas_0593.R;
import com.example.uas_0593.adapter.BerlangsungAdapter;
import com.example.uas_0593.adapter.RiwayatAdapter;
import com.example.uas_0593.models.Berlangsung;
import com.example.uas_0593.models.Riwayat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BerlangsungFragment extends Fragment {

    private BerlangsungViewModel riwayatViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
//        riwayatViewModel =
//                ViewModelProviders.of(this).get(BerlangsungViewModel.class);
        View view = inflater.inflate(R.layout.fragment_pertandinganberlangsung, container, false);


        final RecyclerView rcBerlangsung = view.findViewById(R.id.rcBerlangsung);


        RequestQueue queue = Volley.newRequestQueue(container.getContext());
        String url ="https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4335";

        final ArrayList<Berlangsung> berlangsung = new ArrayList<Berlangsung>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray events = obj.getJSONArray("events");
                            for(int x=0;x<events.length();x++){
                                JSONObject item = events.getJSONObject(x);
                                String matchTitle = item.getString("strEvent");
                                String date = item.getString("dateEvent");
                                String time = item.getString("strTime");
                                String matchDescription = item.getString("strFilename");
                                String image = item.getString("strThumb");
                                String matchId = item.getString("idEvent");
                                berlangsung.add(new Berlangsung(matchTitle,"....","....",date+" "+time,image,matchId));

                                BerlangsungAdapter berlangsungAdapter = new BerlangsungAdapter(container.getContext(), berlangsung );

                                rcBerlangsung.setAdapter(berlangsungAdapter);
                                rcBerlangsung.setLayoutManager(new LinearLayoutManager(container.getContext()));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });


        queue.add(stringRequest);

        return view;
    }
}