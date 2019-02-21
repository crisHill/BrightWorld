package com.zls.brightworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity{

    public static void start(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
    }

    protected String TAG = this.getClass().getSimpleName();
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
    }
}
