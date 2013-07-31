package com.ryzhang.resistor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 2013-07-30
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResistorFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resistor, container, false);
        return view;
    }
}
