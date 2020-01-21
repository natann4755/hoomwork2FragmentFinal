package com.example.myhoomrececfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class frgment1 extends Fragment implements OnMooveiClickLisiner {

   private RecyclerView myRecyclerView;
   private RecyclerView.LayoutManager myLayoutManager;
   private RecyclerView.Adapter myAdapter;
   private OOnMooveiClickLisiner myoonMooveiClickLisiner;
   public static int myposhishen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vieww = inflater.inflate(R.layout.frgment1,container,false);
        myRecyclerView= vieww.findViewById(R.id.AM_recyclerview);

        initRecyclerView();
        return vieww;
    }

    private void initRecyclerView() {
        if (getContext()!=null);
        myLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(myLayoutManager);
        myAdapter = new MooveiAdapter(getContext(),MainActivity.dataMoovei(),this);
        myRecyclerView.setAdapter(myAdapter);
        }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OOnMooveiClickLisiner){
            myoonMooveiClickLisiner = (OOnMooveiClickLisiner) context;
        }
        else {
            throw new RuntimeException(context.toString()+ "must by implements OnMovieFragmentClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myoonMooveiClickLisiner=null;
    }

    @Override
    public void OnMooveiClickLisiner(int posishen) {
        if (myoonMooveiClickLisiner != null){
            myposhishen = posishen;
         myoonMooveiClickLisiner.oonMooveiClickLisiner(MainActivity.dataMoovei().get(posishen));
        }
    }
}

