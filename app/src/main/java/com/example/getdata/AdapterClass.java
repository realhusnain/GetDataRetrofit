package com.example.getdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {


    List<StoreData> storeDataList;
    Context context;

    public AdapterClass(Context context, List<StoreData> list) {
        this.context = context;
        storeDataList = list;
    }

    @NonNull
    @Override


    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
       StoreData storeData=storeDataList.get(position);
       holder.title.setText(storeData.getTitle());
       holder.body.setText(storeData.getBody());

    }

    @Override
    public int getItemCount() {
        return storeDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,  body;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tv_title);
            body=view.findViewById(R.id.tv_body);


        }
    }
}
