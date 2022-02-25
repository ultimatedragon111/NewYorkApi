package com.example.newyorkapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    @NonNull
    private List<Result> mResult;
    private Context mContext;

    public MyAdapter(List<Result> mResult, Context mContext) {
        this.mResult = mResult;
        this.mContext = mContext;
    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.my_row, parent, false );
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(mResult.get(position).getMultimedia().getSrc())
                .fit()
                .centerCrop()
                .into(holder.image);
        holder.nombre.setText(mResult.get(position).getDisplay_title());
        holder.director.setText(mResult.get(position).getByline());
        holder.headLine.setText(mResult.get(position).getHeadline());
        holder.fecha.setText(mResult.get(position).getPublication_date());

    }
    @Override
    public int getItemCount() {
        return mResult.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView nombre;
        private TextView director;
        private TextView headLine;
        private TextView fecha;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView2);
            nombre = itemView.findViewById(R.id.nombre);
            director = itemView.findViewById(R.id.director);
            headLine = itemView.findViewById(R.id.headLine);
            fecha = itemView.findViewById(R.id.fecha);

        }
    }
}
