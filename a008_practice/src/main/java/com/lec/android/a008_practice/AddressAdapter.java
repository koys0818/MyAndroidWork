package com.lec.android.a008_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {



    List<AddressBook> items = new ArrayList<AddressBook>();

    static AddressAdapter adapter;

    public AddressAdapter(){this.adapter = this;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inf = LayoutInflater.from(parent.getContext());
        View itemView = inf.inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder holder, int position) {
        AddressBook item = items.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{


        TextView tvname, tvage, tvaddress;
        ImageButton btndel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tvName);
            tvaddress = itemView.findViewById(R.id.tvAddress);
            tvage = itemView.findViewById(R.id.tvAge);
            btndel = itemView.findViewById(R.id.btnDel);

            btndel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.removeItem(getAdapterPosition());

                    adapter.notifyDataSetChanged();

                }
            });

        }


        public void setItem(AddressBook item){
            tvname.setText(item.getName());
            tvage.setText(item.getAge());
            tvaddress.setText(item.getAddress());
        }




    }



    public void addItem(AddressBook item) {  items.add(item); }
    public void addItem(int position, AddressBook item) {   items.add(position, item);}
    public void setItems(ArrayList<AddressBook> items) {   this.items = items;}
    public AddressBook getItem(int position) {   return items.get(position);}
    public void setItem(int position, AddressBook item) {   items.set(position, item); }
    public void removeItem(int position){ items.remove(position); }


}
