package com.android.settings.slateos;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import com.android.settings.R;

public class SlateOSFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.slateos_preferences, rootKey);
    }
}
