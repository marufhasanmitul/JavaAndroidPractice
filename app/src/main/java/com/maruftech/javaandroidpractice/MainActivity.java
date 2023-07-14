package com.maruftech.javaandroidpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    ArrayList<HashMap<String,String>>arrayList;
    HashMap<String,String>hashMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);


        //Create and Unvisible Table
        arrayList=new ArrayList<>();

        hashMap=new HashMap<>();
        hashMap.put("itemType","BOOK");
        hashMap.put("bookName","বাইশের বন্যা");
        hashMap.put("writerName","তাসরিফ খান");
        hashMap.put("bookUrl","https://ds.rokomari.store/rokomari110/ProductNew20190903/130X186/Baisher_Bonna-Tasrif_Khan-2c6fc-274727.jpg");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("title","Gandi Baat | Full Video Song");
        hashMap.put("video_id","vvLBXO94EfA");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("title","Fevicol Se | Dabangg 2 (Official) ");
        hashMap.put("video_id","fQqfKizTH_M");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("itemType","BOOK");
        hashMap.put("bookName","বাইশের বন্যা");
        hashMap.put("writerName","তাসরিফ খান");
        hashMap.put("bookUrl","https://ds.rokomari.store/rokomari110/ProductNew20190903/130X186/Baisher_Bonna-Tasrif_Khan-2c6fc-274727.jpg");
        arrayList.add(hashMap);




        hashMap=new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("title","Papa Tho Pailam Lyrical");
        hashMap.put("video_id","D6L3cx3u-xc");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("title","Gandi Baat | Full Video Song");
        hashMap.put("video_id","vvLBXO94EfA");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("title","Fevicol Se | Dabangg 2 (Official) ");
        hashMap.put("video_id","fQqfKizTH_M");
        arrayList.add(hashMap);







        MyAdapter myAdapter=new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));




    }
 //===========================================
 //===========================================
 //===================Adapter========================

   class MyAdapter extends RecyclerView.Adapter{
       int BOOK = 0;
       int VIDEO = 1;

        class videoViewHolder extends RecyclerView.ViewHolder{
            TextView videoItemTitle;
            ImageView videoItemCover;
            public videoViewHolder(@NonNull View itemView) {
                super(itemView);
                videoItemTitle=itemView.findViewById(R.id.videoItemTitle);
                videoItemCover=itemView.findViewById(R.id.videoItemCover);
            }
        }

        class bookViewHolder extends RecyclerView.ViewHolder{
            ImageView bookCoverImage;
            TextView bookName,writerName,buy;
            public bookViewHolder(@NonNull View itemView) {
                super(itemView);
                bookCoverImage=itemView.findViewById(R.id.bookCoverImage);
                bookName=itemView.findViewById(R.id.bookName);
                writerName=itemView.findViewById(R.id.writerName);

            }
        }

       @NonNull
       @Override
       public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=getLayoutInflater();
            if(viewType==BOOK){
                View MyView=inflater.inflate(R.layout.item,parent,false);
                return new bookViewHolder(MyView);
            }else {
                View MyView=inflater.inflate(R.layout.video_item,parent,false);
                return new videoViewHolder(MyView);
            }

       }

       @Override
       public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (getItemViewType(position)==BOOK){
                bookViewHolder bookViewHolder= (MyAdapter.bookViewHolder) holder;
                hashMap=arrayList.get(position);
                String writerName=hashMap.get("writerName");
                String bookName=hashMap.get("bookName");
                String bookUrl=hashMap.get("bookUrl");

                bookViewHolder.bookName.setText(bookName);
                bookViewHolder.writerName.setText(writerName);
                Picasso.get().load(bookUrl)
                        .into(bookViewHolder.bookCoverImage);


            }else if(getItemViewType(position)==VIDEO) {
                videoViewHolder videoViewHolder= (MyAdapter.videoViewHolder) holder;
                hashMap=arrayList.get(position);
                String title=hashMap.get("title");
                String video_id=hashMap.get("video_id");
                String urlThumb="https://img.youtube.com/vi/"+video_id+"/hqdefault.jpg";;

                videoViewHolder.videoItemTitle.setText(title);
                Picasso.get().load(urlThumb)
                        .into(videoViewHolder.videoItemCover);


            }
       }

       @Override
       public int getItemCount() {
           return arrayList.size();
       }

       @Override
       public int getItemViewType(int position) {
            hashMap=arrayList.get(position);
            String itemType=hashMap.get("itemType");

            if(itemType.contains("BOOK")) return BOOK;
            else return VIDEO;
            }


       }


    //==========================
    //==========================
    //==========================



}