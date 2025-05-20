package com.android.settings.slateos;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

public class SlateOSActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
            .beginTransaction()
            .replace(android.R.id.content, new SlateOSFragment())
            .commit();
    }
}
