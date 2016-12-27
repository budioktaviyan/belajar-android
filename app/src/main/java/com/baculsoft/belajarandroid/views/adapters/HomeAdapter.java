package com.baculsoft.belajarandroid.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baculsoft.belajarandroid.R;

import java.util.List;
import java.util.Locale;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private Context mContext;
    private final List<String> mItems;

    public HomeAdapter(final Context context, final List<String> items) {
        mContext = context;
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

    public Context getContext() {
        return mContext;
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;

        public HomeHolder(final View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_home);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    final int position = getAdapterPosition();
                    final String message = String.format(Locale.getDefault(), "Item click at position %d", position);
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }
            });
        }

        public TextView getTextView() {
            return mTextView;
        }
    }
}