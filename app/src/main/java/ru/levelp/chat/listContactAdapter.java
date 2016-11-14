package ru.levelp.chat;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListContactAdapter extends RecyclerView.Adapter<ListContactAdapter.ViewHolder>{

    private ArrayList<Contact> contacts;
    private OnListItemClickListener clickListener;

    public ListContactAdapter(ArrayList<Contact> contacts, OnListItemClickListener clickListener) {
        this.contacts = contacts;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(contacts.get(position));

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView avatar;
        TextView name;
        TextView description;

        public ViewHolder(View itemView){
            super(itemView);
            avatar = (TextView) itemView.findViewById(R.id.avatar1);
            name = (TextView) itemView.findViewById(R.id.name1);
            description = (TextView) itemView.findViewById(R.id.description1);
            itemView.setOnClickListener(this);
        }

        public void bind(Contact contact){
            avatar.setText(contact.getName().substring(0, 1));
            name.setText(contact.getName());
            description.setText(contact.getDescription());
        }

        @Override
        public void onClick(View v) {

            clickListener.onClick(v, getAdapterPosition());
        }
    }
}
