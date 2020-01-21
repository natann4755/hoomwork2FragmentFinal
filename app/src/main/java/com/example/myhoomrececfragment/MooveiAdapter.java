package com.example.myhoomrececfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MooveiAdapter extends RecyclerView.Adapter <MooveiAdapter.ViewHolder>  {

    OnMooveiClickLisiner myOnMooveiClickLisiner;
    LayoutInflater myinflater;
    List<Moovei> myMooveis;

    public MooveiAdapter(Context context, List<Moovei> mooveis, OnMooveiClickLisiner onMooveiClickLisiner) {
        myinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myMooveis = mooveis;
        myOnMooveiClickLisiner = onMooveiClickLisiner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vview = myinflater.inflate(R.layout.mooveilist,parent,false);
        return new ViewHolder(vview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setOldHolder(myMooveis.get(position));
    }

    @Override
    public int getItemCount() {
        return myMooveis.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imeg;
        private TextView titel;
        private TextView mytext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (myOnMooveiClickLisiner != null) {
                        myOnMooveiClickLisiner.OnMooveiClickLisiner(getAdapterPosition());
                    }
                }
            });

            imeg = itemView.findViewById(R.id.ML_TV_imeg);
            titel = itemView.findViewById(R.id.ML_TV_titel);
            mytext = itemView.findViewById(R.id.ML_tv_mytext);
        }

        public void setOldHolder(Moovei myMoovei){
            imeg.setImageResource(myMoovei.getImeg());
            titel.setText(myMoovei.getTitel());
            mytext.setText(myMoovei.getText());
        }
    }
}
