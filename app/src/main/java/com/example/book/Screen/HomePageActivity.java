package com.example.book.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.book.R;

public class HomePageActivity extends Fragment {
    Button btnCanGiao, btnDangGiao, btnDaGiao, btnDaHuy;
    ViewFlipper viewFlipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_trang_chu, container, false);
        btnCanGiao = view.findViewById(R.id.btnCanGiao);
        btnDangGiao = view.findViewById(R.id.btnDangGiao);
        btnDaGiao = view.findViewById(R.id.btnDaGiao);
        btnDaHuy = view.findViewById(R.id.btnDaHuy);
        btnCanGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ScreenNeedDelivery.class));
            }
        });
        btnDangGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ScreenDelivering.class));
            }
        });
        btnDaGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ScreenDelivered.class));
            }
        });
        btnDaHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ScreenCanceled.class));
            }
        });


        int background[] = {R.drawable.shipper1, R.drawable.shipper2, R.drawable.shipper3, R.drawable.shipper4};
        viewFlipper = view.findViewById(R.id.viewFlipper);

        for (int i = 0; i < background.length; i++) {
            setViewFlipper(background[i]);
        }


        return view;
    }

    public void setViewFlipper(int background) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(background);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
    }
}
