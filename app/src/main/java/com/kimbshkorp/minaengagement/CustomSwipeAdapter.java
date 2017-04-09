package com.kimbshkorp.minaengagement;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Mario on 4/2/2017.
 */

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources = {R.drawable.mm1,R.drawable.mm2,R.drawable.mm3,R.drawable.mm4,R.drawable.mm5,R.drawable.mm7,R.drawable.mm8,R.drawable.mm10,R.drawable.mm11};
    private String[] text_string = {"It seemed to be a normal day","till Mina disappeared and left Marina alone","he returned back with a surprise !!!","Mina was crossing the river to tell her, ...","\"Will you marry me?\"","When Mina came, he proposed"," She loudly said YES","and their friends were so happy for them","Together   &   Forever"};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx){ this.ctx= ctx; }
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view== object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView=(ImageView) item_view.findViewById(R.id.image_view);
        TextView textView= (TextView) item_view.findViewById(R.id.text_view);
        Picasso.with(ctx).load(image_resources[position]).into(imageView);
        textView.setText(text_string[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
     }
}
