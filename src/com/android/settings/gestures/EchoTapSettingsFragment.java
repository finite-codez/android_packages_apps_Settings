package com.android.settings.gestures;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.android.settings.R;

public class EchoTapSettingsFragment extends PreferenceFragmentCompat {
    private static final String KEY_ECHOTAP = "echotap_enabled";
    private SwitchPreferenceCompat mEchoTapPref;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.gesture, rootKey);

        mEchoTapPref = findPreference(KEY_ECHOTAP);
        if (mEchoTapPref != null) {
            boolean enabled = Settings.Secure.getInt(
                getContext().getContentResolver(), KEY_ECHOTAP, 0) == 1;

            mEchoTapPref.setChecked(enabled);
            mEchoTapPref.setOnPreferenceChangeListener((preference, newValue) -> {
                boolean isEnabled = (Boolean) newValue;
                Settings.Secure.putInt(
                    getContext().getContentResolver(), KEY_ECHOTAP, isEnabled ? 1 : 0);
                return true;
            });
        }
    }
}
