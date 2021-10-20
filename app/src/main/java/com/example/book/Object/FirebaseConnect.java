package com.example.book.Object;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.book.MainActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseConnect {

    public  static  void setOrderReceivedBill(Bill bill){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("bills");
        mDatabase.child(bill.getId()).child("status").setValue(2);
    }

}
