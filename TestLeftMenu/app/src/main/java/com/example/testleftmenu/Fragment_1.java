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

public class Fragment_1 extends Fragment {
    Fragment1Binding binding;
    public static Fragment_1 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment_1 fragment = new Fragment_1();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate( inflater,R.layout.fragment_1,container,false );
        return binding.getRoot();
    }
}
