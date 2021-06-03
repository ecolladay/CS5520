package edu.neu.madcourse.numad21su_emilycolladay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.linksViewHolder> {
    private final ArrayList<ItemCard> itemList;
    private LinkClickListener listener;

    public LinksAdapter(ArrayList<ItemCard> itemList) {
        this.itemList = itemList;
    }

    public void setOnItemClickListener(LinkClickListener listener) {
        this.listener = listener;
    }


    public class linksViewHolder extends RecyclerView.ViewHolder {
        private TextView linkName;
        private TextView link;

        public linksViewHolder(final View itemView, final LinkClickListener listener) {
            super(itemView);
            linkName  = itemView.findViewById(R.id.linkName);
            link = itemView.findViewById(R.id.hyperLink);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }

                    }
                }
            });

        }
    }

    @NonNull
    @Override
    public LinksAdapter.linksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View linkView = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_card, parent, false);
        return new linksViewHolder(linkView, listener);
    }

    @Override
    public void onBindViewHolder(LinksAdapter.linksViewHolder holder, int position) {
        ItemCard current = itemList.get(position);
        holder.linkName.setText(current.getLinkName());
        holder.link.setText(current.getLinkHyper());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
