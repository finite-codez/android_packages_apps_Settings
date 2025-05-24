package com.android.settings.gestures;

import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

import com.android.settings.R;

public class EchoTapSettingsFragment extends PreferenceFragmentCompat
        implements Preference.OnPreferenceChangeListener {

    private static final String KEY_ECHO_TAP = "echotap_enabled";
    private SwitchPreferenceCompat mEchoTapPref;
    private final ContentObserver mObserver = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange, Uri uri) {
            updateSwitch();
        }
    };

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.gesture, rootKey);

        mEchoTapPref = findPreference(KEY_ECHO_TAP);
        if (mEchoTapPref != null) {
            mEchoTapPref.setOnPreferenceChangeListener(this);
            updateSwitch();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getContext().getContentResolver().registerContentObserver(
                Settings.Secure.getUriFor(KEY_ECHO_TAP),
                false,
                mObserver
        );
    }

    @Override
    public void onPause() {
        super.onPause();
        getContext().getContentResolver().unregisterContentObserver(mObserver);
    }

    private void updateSwitch() {
        if (mEchoTapPref != null) {
            boolean enabled = Settings.Secure.getInt(
                    getContext().getContentResolver(),
                    KEY_ECHO_TAP,
                    0
            ) == 1;
            mEchoTapPref.setChecked(enabled);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (KEY_ECHO_TAP.equals(preference.getKey())) {
            boolean enabled = (Boolean) newValue;
            Settings.Secure.putInt(
                    getContext().getContentResolver(),
                    KEY_ECHO_TAP,
                    enabled ? 1 : 0
            );
            return true;
        }
        return false;
    }
}
