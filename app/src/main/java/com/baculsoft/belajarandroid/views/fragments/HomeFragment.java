package com.baculsoft.belajarandroid.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baculsoft.belajarandroid.R;
import com.baculsoft.belajarandroid.views.adapters.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class HomeFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActionBar().setSubtitle(getActivity().getResources().getString(R.string.menu_home));

        // Prepare mock object into list of items
        final List<String> items = new ArrayList<>();
        items.add("Opsi Satu");
        items.add("Opsi Dua");
        items.add("Opsi Tiga");
        items.add("Opsi Empat");
        items.add("Opsi Lima");
        items.add("Opsi Enam");
        items.add("Opsi Tujuh");
        items.add("Opsi Delapan");
        items.add("Opsi Sembilan");
        items.add("Opsi Sepuluh");

        final RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.rv_home);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        final HomeAdapter homeAdapter = new HomeAdapter(getContext(), items);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.smoothScrollToPosition(recyclerView.getBottom());
        recyclerView.setAdapter(homeAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }
}