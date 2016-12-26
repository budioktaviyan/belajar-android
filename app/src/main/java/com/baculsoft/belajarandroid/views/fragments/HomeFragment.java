package com.baculsoft.belajarandroid.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baculsoft.belajarandroid.R;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}