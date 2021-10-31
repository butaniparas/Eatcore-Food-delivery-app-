package com.example.eatcor.top_brands;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatcor.R;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.holder> {
    private Context context;
    List<model_topbrand> listname;

    public adapter(Context context, List<model_topbrand> listname) {
        this.context = context;
        this.listname = listname;
    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.top_brands_list,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  adapter.holder holder, int position) {
    holder.tv.setText(listname.get(position).getName());
        holder.img.setImageResource(listname.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listname.size();
    }

    class holder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;
        public holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
