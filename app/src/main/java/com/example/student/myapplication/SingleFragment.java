package com.example.student.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.myapplication.adapters.BedsitterRecylerAdapter;
import com.example.student.myapplication.dataModels.HouseModels;
import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleFragment extends Fragment {
    private FirebaseAuth firebaseAuth;

    int[] hostelImage = {R.drawable.single1,R.drawable.single3,R.drawable.single4,R.drawable.single5,R.drawable.single6};
    String[] hostelNumber = {"S1", "S2", "S3", "S4", "S5", "S6"};
    String[] hostelContactName = {"Manuell Milimo", "Peter Wambulwa", "Shylla Atieno", "Mourine Jane", "Angela Mramba", "Polo Jerry"};
    String[] hostelContactNumber = {"0798745214", "0712345678", "0798654732", "0712856734", "07287943567", "0712324567"};
    String[] hostelPrice = {"3,000", "3,500", "4,000", "4500", "5000", "3300"};

    RecyclerView mRecyclerView;
    BedsitterRecylerAdapter mRecyclerAdapter;
    List<HouseModels> latestList;
    Context mContext;

    public SingleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single, container, false);
        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.hostelRecycler);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        latestList = new ArrayList<>();

        getLatestHouses();
        return view;
    }


    private void getLatestHouses() {

        for (int i = 0; i<hostelImage.length ; i++){

            HouseModels houseModels = new HouseModels(
                    hostelImage[i],
                    hostelNumber[i],
                    hostelContactName[i],
                    hostelContactNumber[i],
                    hostelPrice[i]
            );
            latestList.add(houseModels);
        }
        mRecyclerAdapter = new BedsitterRecylerAdapter(mContext,latestList);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }


}
