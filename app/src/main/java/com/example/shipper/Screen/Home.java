package com.example.shipper.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shipper.R;

public class Home extends Fragment{
    Button btnCanGiao,btnDangGiao,btnDaGiao,btnDaHuy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_trang_chu,container,false);
        btnCanGiao = view.findViewById(R.id.btnCanGiao);
        btnDangGiao = view.findViewById(R.id.btnDangGiao);
        btnDaGiao = view.findViewById(R.id.btnDaGiao);
        btnDaHuy = view.findViewById(R.id.btnDaHuy);
        btnCanGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ScreenNeedDelivery.class));
            }
        });
        btnDangGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ScreenDelivering.class));
            }
        });
        btnDaGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ScreenDelivered.class));
            }
        });
        btnDaHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ScreenCanceled.class));
            }
        });
        return view;
    }
}
