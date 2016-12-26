package com.baculsoft.belajarandroid.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baculsoft.belajarandroid.R;

import java.util.List;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private final List<String> mItems;

    public HomeAdapter(final List<String> items) {
        mItems = items;
    }

    @Override
    public HomeHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(final HomeHolder holder, final int position) {
        final String item = mItems.get(position);
        holder.getTextView().setText(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;

        public HomeHolder(final View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_home);
        }

        public TextView getTextView() {
            return mTextView;
        }
    }
}