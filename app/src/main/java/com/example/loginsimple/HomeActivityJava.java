package com.example.loginsimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by 张垚杰 on 2018/1/16.
 */

public class HomeActivityJava extends BaseActivityJava{

    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        button=findViewById(R.id.home_bt);
        button.setOnClickListener(v->{
            Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
            sendBroadcast(intent);
        });
    }
}
