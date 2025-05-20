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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
