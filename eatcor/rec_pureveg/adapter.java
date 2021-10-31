package com.example.eatcor.rec_pureveg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatcor.R;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.holder> {
    private Context context;
    List<model> modelList;

    public adapter(Context context, List<model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pureveg_list,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.holder holder, int position) {
    holder.tv.setText(modelList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView tv;
        public holder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
