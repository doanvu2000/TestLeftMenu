package com.example.testleftmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.testleftmenu.databinding.Fragment1Binding;
import com.example.testleftmenu.databinding.Fragment2Binding;

public class Fragment_2 extends Fragment {
    Fragment2Binding binding;
    public static Fragment_2 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment_2 fragment = new Fragment_2();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate( inflater,R.layout.fragment_2,container,false );
        return binding.getRoot();
    }
}
