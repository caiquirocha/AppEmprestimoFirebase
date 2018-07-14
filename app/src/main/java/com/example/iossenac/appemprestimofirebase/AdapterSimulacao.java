package com.example.iossenac.appemprestimofirebase;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import com.example.iossenac.appemprestimofirebase.database.Simulacao;

public class AdapterSimulacao extends RecyclerView.Adapter<AdapterSimulacao.ViewHolder> {
        private List<Simulacao> feeds;

        public interface OnLongClick {
            void action(Simulacao simulacao);
        }
        private OnLongClick listener;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;
            public View view;
            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
                this.view = view;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public AdapterSimulacao(List<Simulacao> feeds, OnLongClick listener) {
            this.feeds = feeds;
            this.listener = listener;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public AdapterSimulacao.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
            // create a new view
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.simulacao_item, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTextView.setText(feeds.get(position).idPessoa);
            holder.mTextView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.action(feeds.get(position));
                    return true;
                }
            });

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return feeds.size();
        }
    }
