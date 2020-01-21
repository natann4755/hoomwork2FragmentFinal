package com.example.myhoomrececfragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frgment2 extends Fragment {
    private Moovei myMoovei;
    private static final String key1 = "key1";
    private ImageView image1;
    private ImageView image2;
    private TextView titel;
    private TextView text1;
    private Button mybutton;

    public static frgment2 staticFrgment2 (Moovei mymoovei){
       frgment2 newFrgment2 = new frgment2();
       Bundle mybundle = new Bundle();
       mybundle.putParcelable(key1,mymoovei);
       newFrgment2.setArguments(mybundle);
       return newFrgment2;
   }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myMoovei = getArguments().getParcelable(key1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        findplase(view);

        if (myMoovei!= null){
            set();
        }
        return view;
    }



    private void findplase(View view) {
        image1 = view.findViewById(R.id.F2_iv1);
        image2 = view.findViewById(R.id.F2_iv2);
        titel = view.findViewById(R.id.F2_tv_titel);
        text1 = view.findViewById(R.id.F2_tv_text);
        mybutton = view.findViewById(R.id.F2_boton);
    }

    private void set() {
        image1.setImageResource(myMoovei.getImeg());
        image2.setImageResource(myMoovei.getImeg());
        titel.setText(myMoovei.getTitel());
        text1.setText(myMoovei.getText());

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myMoovei.getUrl()));
                startActivity(intent);
            }
        });
    }
}
