package com.sstutsman.learnretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
    private static final int ITEM_RES_ID = R.layout.item_person;

    private List<Person> persons;

    private ViewHolder.ItemClickListener listener;
    private Context context;

    public PeopleAdapter(final List<Person> persons) {
        this.persons = persons;
        listener = new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Person person = persons.get(position);
                // Whatever you gotta do!
            }
        };
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(ITEM_RES_ID, parent, false);
        if (context == null) {
            context = parent.getContext();
        }
        ViewHolder viewHolder = new ViewHolder(view, listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.tvName.setText(person.getName());
        holder.tvAge.setText(person.getAge());
        holder.tvPhone.setText(person.getPhoneNumber());
        holder.tvCompany.setText(person.getCompany());
        holder.tvTitle.setText(person.getTitle());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemClickListener listener;
        TextView tvName;
        TextView tvAge;
        TextView tvPhone;
        TextView tvCompany;
        TextView tvTitle;


        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAge = (TextView) itemView.findViewById(R.id.tv_age);
            tvPhone = (TextView) itemView.findViewById(R.id.tv_phone);
            tvCompany = (TextView) itemView.findViewById(R.id.tv_company);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }

        public static interface ItemClickListener {
            public void onItemClick(View view, int position);
        }
    }
}
