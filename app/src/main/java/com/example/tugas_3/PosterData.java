package com.example.tugas_3;

import java.util.ArrayList;

public class PosterData {
    private static String[] title = new String[]{"Spiderman:Homecoming","Dunkirk","Iron Man","Mulan","Ant-Man","Avenger:Endgame","Justice League","Black Widow","Harry Potter","Godzilla:King of The Monster","Jaws","Joker","Midway","Mortal Kombat",
            "Jamse Bond:No Time To Die","Power","Batman:The Dark Knight","A Star Is Born","The Raid","The New Mutant (X-Men)","21 Bridges"};
    private static int[] thumbnail = new int[] {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,
            R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,R.drawable.img_10,R.drawable.img_11,R.drawable.img_12,R.drawable.img_13,R.drawable.img_14,R.drawable.img_15,R.drawable.img_16,R.drawable.img_17,R.drawable.img_18,R.drawable.img_19,R.drawable.img_20,R.drawable.img_21};

    public static ArrayList<PosterModel> getListData(){
        PosterModel posterModel = null;
        ArrayList<PosterModel> list = new ArrayList<>();
        for (int i=0; i<title.length;i++){
            posterModel = new PosterModel();
            posterModel.setPosterFilm(thumbnail[i]);
            posterModel.setNamaFilm(title[i]);
            list.add(posterModel);
        }
        return list;
    }
    public static String getTitle(int posisi) {

        return title[posisi];
    }

    public static int getThumbnail(int posisi) {

        return thumbnail[posisi];
    }


}
