package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
//    public WordAdapter(@NonNull Context context, int resource, @NonNull List<Word> objects) {
//        super(context, resource, objects);
//    }
//    public WordAdapter(@NonNull Context context, ArrayList<Word> resources) {
//        super(context, resources);
//    }
    public WordAdapter(Context context,ArrayList<Word> words,int colorResourceId){
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility((View.VISIBLE));
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
        //return super.getView(position, convertView, parent);
    }
}