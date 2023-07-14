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
        hashMap.put("title","Papa Tho Pailam Lyrical");
        hashMap.put("video_id","D6L3cx3u-xc");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("title","Gandi Baat | Full Video Song");
        hashMap.put("video_id","vvLBXO94EfA");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("title","Fevicol Se | Dabangg 2 (Official) ");
        hashMap.put("video_id","fQqfKizTH_M");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("title","Papa Tho Pailam Lyrical");
        hashMap.put("video_id","D6L3cx3u-xc");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("title","Gandi Baat | Full Video Song");
        hashMap.put("video_id","vvLBXO94EfA");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
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

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder>{
        private class myViewHolder extends RecyclerView.ViewHolder{
            ImageView coverImage;
            TextView title,catagory,desc;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);
                coverImage=itemView.findViewById(R.id.coverImage);
                title=itemView.findViewById(R.id.title);
                desc=itemView.findViewById(R.id.desc);
                catagory=itemView.findViewById(R.id.cat);

            }
        }


        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView=inflater.inflate(R.layout.item,parent,false);

            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            HashMap<String,String>hashMap=arrayList.get(position);
            String title= hashMap.get("title");
            String video_id= hashMap.get("video_id");
            String url="https://img.youtube.com/vi/"+video_id+"/hqdefault.jpg";

            Picasso.get().load(url)
                    .into(holder.coverImage);


            holder.catagory.setText("Song");
            holder.title.setText(title);
            holder.desc.setText(video_id);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }

    //==========================
    //==========================
    //==========================



}