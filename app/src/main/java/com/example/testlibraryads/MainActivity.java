package com.example.testlibraryads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.libraryprebid.BilliAds;

public class MainActivity extends AppCompatActivity {
    Button button;
    FrameLayout adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnad);
        adView = (FrameLayout) findViewById(R.id.adView);
//        BilliAds.Banner320x50Setup(MainActivity.this,"625c6125-f19e-4d5b-95c5-55501526b2a4",adView);
        BilliAds.Banner300x250Setup(MainActivity.this,"2a02a36d-8136-4a95-a3fd-ae79e20572e5",adView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BilliAds.Banner300x250Setup(MainActivity.this,"2a02a36d-8136-4a95-a3fd-ae79e20572e5",adView);

            }
        });
    }
}
