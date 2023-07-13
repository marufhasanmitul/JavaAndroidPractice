package com.maruftech.javaandroidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listViewId;

    ArrayList<HashMap<String,String>>arrayList;
    HashMap<String,String>hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewId=findViewById(R.id.listViewId);

        createTable();

        MyAdapter myAdapter=new MyAdapter();
        listViewId.setAdapter(myAdapter);
    }
 //===========================================
 //===========================================
 //===================Adapter========================
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View MyView=inflater.inflate(R.layout.item,viewGroup,false);
            ImageView itemImage=MyView.findViewById(R.id.coverImage);
            TextView itemCatagory=MyView.findViewById(R.id.cat);
            TextView itemTitle=MyView.findViewById(R.id.title);
            TextView itemDesc=MyView.findViewById(R.id.desc);
            LinearLayout layItem=MyView.findViewById(R.id.layItem);

            HashMap<String,String>hashMap=arrayList.get(i);
            String cat=hashMap.get("cat");
            String image_url=hashMap.get("image_url");
            String title=hashMap.get("titile");
            String des=hashMap.get("des");

            Picasso.get()
                    .load(image_url)
                    .into(itemImage);
            itemCatagory.setText(cat);
            itemTitle.setText(title);
            itemDesc.setText(des);



            //Random Color set
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            itemCatagory.setBackgroundColor(color);

            layItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Details.TITLE=title;
                    Details.DESCRIPTION=des;
                    Bitmap bitmap=((BitmapDrawable) itemImage.getDrawable()).getBitmap();
                    Details.MY_BITMAP=bitmap;
                    startActivity(new Intent(MainActivity.this,Details.class));
                }
            });


            return MyView;
        }
    }
    //==========================
    //==========================
    //==========================

    void  createTable(){
        arrayList=new ArrayList<>();


        hashMap=new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://dnc.techtunes.io/tDrive/tuner/rubelttc/113105/Refrigerator.jpg");
        hashMap.put("titile","আসুন ফ্রিজ ও এসি মেরামত করি");
        hashMap.put("des","সবাই ভাল আছেন তো ! আজ থেকে আমি টেকটিউনস এ নতুন একটি কোর্স চালু করতে যাইতেছি ! এই কোর্সটির নাম হল রেফ্রিজারেশন সিস্টেম ! এটি থেকে আপনি শিখতে পারবেন যে কি ভাবে একটা ফ্রিজ ও এসি মেরামত করা যায় ! যদি এটা ভাল ভাবে শিখতে না পারেন তাহলেও কোন ক্ষতি নাই ! আর কোন টেকনিশিয়ান আপনাকে ঠকাতে পারবে না এই বিষয়ে নিশ্চন্ত থাকেন ! এর জন্য আপনাকে আমার টিউগুলো নিয়মিত দেখতে হবে ! টিউনটি করার আগে আমি কিছু কথা বলতে চাই, আমি খুব গরীর ছিলাম ! অর্থের অভাবে বেশি পড়ালেখা করতে পারিনি ! গরীর হলেও আমার সখ ছিল অনেক ! ছোট বেলায় যখন থ্রিতে পড়তাম তখন স্কুলের ক্লাশ ফাকি দিয়ে ইলেক্ট্রনিক্সের দোকানে গিয়ে বসে থাকতাম আর তাদের কাজ দেখতাম ! কাজ দেখতে দেখতে কখন যে কাজ শিখে গেলাম মনে নেই ! আমার সবগুলো কাজ প্রায় এই ভাবেই শিখা ! আমার ইলেক্ট্রনিক্সের কাজের অভিজ্ঞতা 11 বছর, ইলেক্ট্রিক কাজের অভিজ্ঞতা 10 বছর ! আর ফ্রিজ ও এসির কাজের অভিজ্ঞতা মাত্র 4.5 বছর ! কিন্তু আমার বয়স মাত্র 23 বছর ! এখন আমি একটি টিটিসি শিক্ষক হিসাবে নিয়োজিত আছি ! এই অল্প বয়সে বেশি কাজ শিখতে পারি নাই ! জানি না আপনাদের শিখাতে পারবো কি না ? তবে দোয়া করবেন আমি যেন আমার অর্জিত এই অল্প জ্ঞান সবার মাঝে বিলিয়ে দিতে পারি ! যাইহোক এবার কাজের কথায় আসি ! আমরা অনেকেই জানি না যে, ফ্রিজ ও এসিতে কি কি ডিভাইস বা যন্ত্রাংশ বা মেটারিয়ালস বা মালামাল থাকে ! আজ আমি এগুলোর নাম আপনাদের কাছে জানাবো !");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://dnc.techtunes.io/tDrive/tuner/rubelttc.jpg");
        hashMap.put("titile","Compressor (কম্প্রেসর)");
        hashMap.put("des","আপনাদের মাঝে হয়তো এমন কেউ নেই যে কম্প্রেসরের নাম শোনেন নি ! এটাকে ফ্রিজ ও এসির হৃদপিন্ড বলা চলে ! ফ্রিজ ও এসিতে যতগুলো মালামাল ব্যবহার করা হয় তার মধ্যে এটির দাম একটু বেশি ! এখন আমি আপনাদের জানাবো যে এটি কি কাজ করে ! এর ভিতরে কি কি আছে , এটি কেমন, কত রকমের এইসব বিষয়ে ! তবে বলে রাখা ভাল যে রেফ্রিজারেশন সিস্টেমে গ্যাসের ভূমিকাই বেশি ! এই গ্যাসকে আমরা রেফ্রিজারেন্ট বা ফ্রিয়ন্স বলে থাকি ! মূলত, এই গ্যাসের সার্কুলেশনের কারনেই ফ্রিজ ও এসি ঠান্ডা হয় ! কম্প্রেসর এর গ্যাসকে সার্কুলেশন করে ! এটি এই রেফ্রিজারেন্ট বা হিমায়ক গ্যাসকে সংকুচিত করে হিমায়কের চাপ বারিয়ে কন্ডেনসারে পাঠিয়ে দেয় কন্ডেনসারে গিয়ে গ্যাসটি তরল হয় ! আমরা জানি চাপ বারলে তাপমাত্রা বারে ! এই কারনে দেখবেন, ফ্রিজ বা এসি এর এক পাশ খুব গরম হয় ! এই পাশে কন্ডেনসার থাকে ! কম্প্রেসর যদি সঠিক ভাবে চাপ বারিয়ে দিতে না পারে তাহলে কান্ডেনসার গরমও হবে না ফলে ফিজ বা এসি ঠান্ডাও হবে না ! একটি ভাল কম্প্রেসরের প্রেশার 350 থেকে 500 PSI এর মধ্যে থাকতে হবে ! PSI হল চাপের একটি একক ! এর অর্থ হল হল Pound per Square Inch ! কম্প্রেসরের তিনটা লাইন থাকে");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://dnc.techtunes.io/tDrive/tuner/Rubelttc1.jpg");
        hashMap.put("titile","কম্প্রেসরের ইলেক্ট্রিক লাইন !");
        hashMap.put("des","সবাই ভাল আছেন তো ! আজ থেকে আমি টেকটিউনস এ নতুন একটি কোর্স চালু করতে যাইতেছি ! এই কোর্সটির নাম হল রেফ্রিজারেশন সিস্টেম ! এটি থেকে আপনি শিখতে পারবেন যে কি ভাবে একটা ফ্রিজ ও এসি মেরামত করা যায় ! যদি এটা ভাল ভাবে শিখতে না পারেন তাহলেও কোন ক্ষতি নাই ! আর কোন টেকনিশিয়ান আপনাকে ঠকাতে পারবে না এই বিষয়ে নিশ্চন্ত থাকেন ! এর জন্য আপনাকে আমার টিউগুলো নিয়মিত দেখতে হবে ! টিউনটি করার আগে আমি কিছু কথা বলতে চাই, আমি খুব গরীর ছিলাম ! অর্থের অভাবে বেশি পড়ালেখা করতে পারিনি ! গরীর হলেও আমার সখ ছিল অনেক ! ছোট বেলায় যখন থ্রিতে পড়তাম তখন স্কুলের ক্লাশ ফাকি দিয়ে ইলেক্ট্রনিক্সের দোকানে গিয়ে বসে থাকতাম আর তাদের কাজ দেখতাম ! কাজ দেখতে দেখতে কখন যে কাজ শিখে গেলাম মনে নেই ! আমার সবগুলো কাজ প্রায় এই ভাবেই শিখা ! আমার ইলেক্ট্রনিক্সের কাজের অভিজ্ঞতা 11 বছর, ইলেক্ট্রিক কাজের অভিজ্ঞতা 10 বছর ! আর ফ্রিজ ও এসির কাজের অভিজ্ঞতা মাত্র 4.5 বছর ! কিন্তু আমার বয়স মাত্র 23 বছর ! এখন আমি একটি টিটিসি শিক্ষক হিসাবে নিয়োজিত আছি ! এই অল্প বয়সে বেশি কাজ শিখতে পারি নাই ! জানি না আপনাদের শিখাতে পারবো কি না ? তবে দোয়া করবেন আমি যেন আমার অর্জিত এই অল্প জ্ঞান সবার মাঝে বিলিয়ে দিতে পারি ! যাইহোক এবার কাজের কথায় আসি ! আমরা অনেকেই জানি না যে, ফ্রিজ ও এসিতে কি কি ডিভাইস বা যন্ত্রাংশ বা মেটারিয়ালস বা মালামাল থাকে ! আজ আমি এগুলোর নাম আপনাদের কাছে জানাবো !");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://dnc.techtunes.io/tDrive/tuner/rubelttc/113105/Refrigerator.jpg");
        hashMap.put("titile","আসুন ফ্রিজ ও এসি মেরামত করি");
        hashMap.put("des","সবাই ভাল আছেন তো ! আজ থেকে আমি টেকটিউনস এ নতুন একটি কোর্স চালু করতে যাইতেছি ! এই কোর্সটির নাম হল রেফ্রিজারেশন সিস্টেম ! এটি থেকে আপনি শিখতে পারবেন যে কি ভাবে একটা ফ্রিজ ও এসি মেরামত করা যায় ! যদি এটা ভাল ভাবে শিখতে না পারেন তাহলেও কোন ক্ষতি নাই ! আর কোন টেকনিশিয়ান আপনাকে ঠকাতে পারবে না এই বিষয়ে নিশ্চন্ত থাকেন ! এর জন্য আপনাকে আমার টিউগুলো নিয়মিত দেখতে হবে ! টিউনটি করার আগে আমি কিছু কথা বলতে চাই, আমি খুব গরীর ছিলাম ! অর্থের অভাবে বেশি পড়ালেখা করতে পারিনি ! গরীর হলেও আমার সখ ছিল অনেক ! ছোট বেলায় যখন থ্রিতে পড়তাম তখন স্কুলের ক্লাশ ফাকি দিয়ে ইলেক্ট্রনিক্সের দোকানে গিয়ে বসে থাকতাম আর তাদের কাজ দেখতাম ! কাজ দেখতে দেখতে কখন যে কাজ শিখে গেলাম মনে নেই ! আমার সবগুলো কাজ প্রায় এই ভাবেই শিখা ! আমার ইলেক্ট্রনিক্সের কাজের অভিজ্ঞতা 11 বছর, ইলেক্ট্রিক কাজের অভিজ্ঞতা 10 বছর ! আর ফ্রিজ ও এসির কাজের অভিজ্ঞতা মাত্র 4.5 বছর ! কিন্তু আমার বয়স মাত্র 23 বছর ! এখন আমি একটি টিটিসি শিক্ষক হিসাবে নিয়োজিত আছি ! এই অল্প বয়সে বেশি কাজ শিখতে পারি নাই ! জানি না আপনাদের শিখাতে পারবো কি না ? তবে দোয়া করবেন আমি যেন আমার অর্জিত এই অল্প জ্ঞান সবার মাঝে বিলিয়ে দিতে পারি ! যাইহোক এবার কাজের কথায় আসি ! আমরা অনেকেই জানি না যে, ফ্রিজ ও এসিতে কি কি ডিভাইস বা যন্ত্রাংশ বা মেটারিয়ালস বা মালামাল থাকে ! আজ আমি এগুলোর নাম আপনাদের কাছে জানাবো !");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://dnc.techtunes.io/tDrive/tuner/rubelttc/113105/Refrigerator.jpg");
        hashMap.put("titile","আসুন ফ্রিজ ও এসি মেরামত করি");
        hashMap.put("des","সবাই ভাল আছেন তো ! আজ থেকে আমি টেকটিউনস এ নতুন একটি কোর্স চালু করতে যাইতেছি ! এই কোর্সটির নাম হল রেফ্রিজারেশন সিস্টেম ! এটি থেকে আপনি শিখতে পারবেন যে কি ভাবে একটা ফ্রিজ ও এসি মেরামত করা যায় ! যদি এটা ভাল ভাবে শিখতে না পারেন তাহলেও কোন ক্ষতি নাই ! আর কোন টেকনিশিয়ান আপনাকে ঠকাতে পারবে না এই বিষয়ে নিশ্চন্ত থাকেন ! এর জন্য আপনাকে আমার টিউগুলো নিয়মিত দেখতে হবে ! টিউনটি করার আগে আমি কিছু কথা বলতে চাই, আমি খুব গরীর ছিলাম ! অর্থের অভাবে বেশি পড়ালেখা করতে পারিনি ! গরীর হলেও আমার সখ ছিল অনেক ! ছোট বেলায় যখন থ্রিতে পড়তাম তখন স্কুলের ক্লাশ ফাকি দিয়ে ইলেক্ট্রনিক্সের দোকানে গিয়ে বসে থাকতাম আর তাদের কাজ দেখতাম ! কাজ দেখতে দেখতে কখন যে কাজ শিখে গেলাম মনে নেই ! আমার সবগুলো কাজ প্রায় এই ভাবেই শিখা ! আমার ইলেক্ট্রনিক্সের কাজের অভিজ্ঞতা 11 বছর, ইলেক্ট্রিক কাজের অভিজ্ঞতা 10 বছর ! আর ফ্রিজ ও এসির কাজের অভিজ্ঞতা মাত্র 4.5 বছর ! কিন্তু আমার বয়স মাত্র 23 বছর ! এখন আমি একটি টিটিসি শিক্ষক হিসাবে নিয়োজিত আছি ! এই অল্প বয়সে বেশি কাজ শিখতে পারি নাই ! জানি না আপনাদের শিখাতে পারবো কি না ? তবে দোয়া করবেন আমি যেন আমার অর্জিত এই অল্প জ্ঞান সবার মাঝে বিলিয়ে দিতে পারি ! যাইহোক এবার কাজের কথায় আসি ! আমরা অনেকেই জানি না যে, ফ্রিজ ও এসিতে কি কি ডিভাইস বা যন্ত্রাংশ বা মেটারিয়ালস বা মালামাল থাকে ! আজ আমি এগুলোর নাম আপনাদের কাছে জানাবো !");
        arrayList.add(hashMap);

    }


}