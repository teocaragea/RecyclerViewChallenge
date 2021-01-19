package com.example.recyclerviewchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>
{

    private ArrayList<Car> cars;

    ItemClicked activity;

    public interface  ItemClicked
    {
        void onItemClicked(int index);
    }

    public CarAdapter(Context context,ArrayList<Car>list)
    {
        cars=list;
        activity=(ItemClicked) context;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivMake;
    TextView tvModel,tvOwner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvModel=itemView.findViewById(R.id.tvModel);
            tvOwner=itemView.findViewById(R.id.tvOwner);
            ivMake=itemView.findViewById(R.id.ivMake);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.onItemClicked(cars.indexOf((Car)view.getTag()));

                }
            });
        }

    }


    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false);//link to external layout
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(cars.get(position));//runs for every element
        String make=cars.get(position).getMake();
        if(make.equals("mercedes"))
        {
           viewHolder.ivMake.setImageResource(R.drawable.mercedes);
        }
        else if (make.equals("volkswagen"))
        {
            viewHolder.ivMake.setImageResource(R.drawable.volkswagen);
        }
        else
        {
            viewHolder.ivMake.setImageResource(R.drawable.nissan);
        }
        viewHolder.tvOwner.setText(cars.get(position).getName());//afisam numele
        viewHolder.tvModel.setText(cars.get(position).getModel());

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
