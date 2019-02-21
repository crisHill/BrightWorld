package com.zls.brightworld;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseActivity extends Activity{

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
