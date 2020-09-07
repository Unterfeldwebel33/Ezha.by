package com.example.ezhaby.Helper.Classes.Home.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhaby.R;

import java.util.ArrayList;

public class SortAdapter extends RecyclerView.Adapter<SortAdapter.SortVievHolder> {

    ArrayList<SortHelperClass> sortLocations;
    private RecyclerVievClickListener listener;

    public SortAdapter (ArrayList<SortHelperClass> sortLocations, RecyclerVievClickListener listener) {
        this.sortLocations = sortLocations;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SortVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_button_design,parent,false);
        SortVievHolder sortVievHolder = new SortVievHolder(view);
        return sortVievHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SortVievHolder holder, int position) {

        SortHelperClass sortHelperClass = sortLocations.get(position);

        holder.image.setImageResource(sortHelperClass.getImage());
        holder.title.setText(sortHelperClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return sortLocations.size() ;
    }

    public interface RecyclerVievClickListener{
        void onClick(View v, int position);
    }

    public class SortVievHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView title;

        public SortVievHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.sortImage);
            title = itemView.findViewById(R.id.sortTitle);
            itemView.setOnClickListener(this);
        }

        //обработка нажатия
        @Override
        public void onClick(View v) {
            listener.onClick(itemView, getAdapterPosition());

        }
    }
}
