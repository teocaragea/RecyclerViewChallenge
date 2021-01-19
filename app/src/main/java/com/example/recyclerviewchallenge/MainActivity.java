package com.example.recyclerviewchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    Button btnCar,btnOwner;
    TextView tvName,tvNumber,tvModel;
    ImageView ivMake;
    ListFrag listFrag;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCar=findViewById(R.id.btnCar);
        btnOwner=findViewById(R.id.btnOwner);
        tvName=findViewById(R.id.tvName);
        tvNumber=findViewById(R.id.tvNumber);
        tvModel=findViewById(R.id.tvModel);
        ivMake=findViewById(R.id.ivMake);


        fragmentManager=this.getSupportFragmentManager();
        listFrag=(ListFrag) fragmentManager.findFragmentById(R.id.list); //connection to list frag
        fragmentManager.beginTransaction()
                .show(fragmentManager.findFragmentById(R.id.fragment7))
                .hide(fragmentManager.findFragmentById(R.id.fragment8))
                .commit();


        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        fragmentManager.beginTransaction()
                .show(fragmentManager.findFragmentById(R.id.fragment7))
                .hide(fragmentManager.findFragmentById(R.id.fragment8))
                .commit();


            }
        });

        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .show(fragmentManager.findFragmentById(R.id.fragment8))
                        .hide(fragmentManager.findFragmentById(R.id.fragment7))
                        .commit();

            }
        });

        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {
        tvModel.setText(ApplicationClass.cars.get(index).getModel());
        tvNumber.setText(ApplicationClass.cars.get(index).getNumber());
        tvName.setText(ApplicationClass.cars.get(index).getName());
        if(ApplicationClass.cars.get(index).getMake().equals("mercedes"))
            ivMake.setImageResource(R.drawable.mercedes);
        else if(ApplicationClass.cars.get(index).getMake().equals("nissan"))
            ivMake.setImageResource(R.drawable.nissan);
        else
            ivMake.setImageResource(R.drawable.volkswagen);
    }
}