package com.example.myhoomrececfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OOnMooveiClickLisiner {

    private ViewPager tabletFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frgment1 myfrgment1 = new frgment1();
        getSupportFragmentManager().beginTransaction().add(R.id.AM_framLayot,myfrgment1).commit();

        tabletFrameLayout = findViewById(R.id.AM_Tablet_framLayot2);
        if (tabletFrameLayout!=null){
            viewPageAdapter myviewPageAdapter = new viewPageAdapter(getSupportFragmentManager(), dataFragment());
            tabletFrameLayout.setAdapter(myviewPageAdapter);
        }

    }

    public static List<Moovei> dataMoovei(){
        List<Moovei> dataMoovei = new ArrayList<Moovei>();
        dataMoovei.add(new Moovei("cars", "1",R.drawable.cars,"https://www.youtube.com/watch?v=UND7XDWgLF0"));
        dataMoovei.add(new Moovei("code", "2",R.drawable.code_8,"https://www.youtube.com/watch?v=DqO90q0WZ0M"));
        dataMoovei.add(new Moovei("forzon", "3",R.drawable.frozen_2,"https://www.youtube.com/watch?v=bwzLiQZDw2I"));
        dataMoovei.add(new Moovei("interstellar", "4",R.drawable.interstellar,"https://www.youtube.com/watch?v=UDVtMYqUAyw"));
        dataMoovei.add(new Moovei("jurassic_world", "5",R.drawable.jurassic_world,"https://www.youtube.com/watch?v=vJ0BB9nRS_I&t=1827s"));

        dataMoovei.add(new Moovei("rabbi_jacob", "6",R.drawable.rabbi_jacob,"https://www.youtube.com/watch?v=dFZHMHjdB8w"));
        dataMoovei.add(new Moovei("rick_and_morty", "7",R.drawable.rick_and_morty,"https://www.youtube.com/watch?v=dFZHMHjdB8w"));
        dataMoovei.add(new Moovei("spider_man", "8",R.drawable.spider_man,"https://www.youtube.com/watch?v=dFZHMHjdB8w"));
        dataMoovei.add(new Moovei("the_lion_king", "9",R.drawable.the_lion_king,"https://www.youtube.com/watch?v=dFZHMHjdB8w"));
        dataMoovei.add(new Moovei("the_simpsons", "10",R.drawable.the_simpsons,"https://www.youtube.com/watch?v=dFZHMHjdB8w"));
        dataMoovei.add(new Moovei("toy_story_4", "11",R.drawable.toy_story_4,"https://www.youtube.com/watch?v=dFZHMHjdB8w"));
        dataMoovei.add(new Moovei("young_sheldon", "12",R.drawable.young_sheldon,"https://www.youtube.com/watch?v=dFZHMHjdB8w"));

        return dataMoovei;
    }

    public List<Fragment> dataFragment(){
        List<Fragment> ddataFragment = new  ArrayList<Fragment>();
        for (int i = 0; i <MainActivity.dataMoovei().size() ; i++) {
            ddataFragment.add(frgment2.staticFrgment2(MainActivity.dataMoovei().get(i)));
        }
        return ddataFragment;
    }

    @Override
    public void oonMooveiClickLisiner(Moovei myMoovei) {
        frgment2 myfrgment2 = frgment2.staticFrgment2(myMoovei);
        if (tabletFrameLayout == null) {
            getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.AM_framLayot, myfrgment2).commit();
        }else {
//            getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.AM_Tablet_framLayot2,myfrgment2).commit();
            tabletFrameLayout.setCurrentItem(frgment1.myposhishen);
        }

    }
}

