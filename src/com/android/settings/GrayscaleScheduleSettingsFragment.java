package com.android.settings;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.TimePickerPreference;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import android.text.format.DateFormat;

public class GrayscaleScheduleSettingsFragment extends PreferenceFragmentCompat {

    private static final String KEY_SCHEDULED_GRAYSCALE = "scheduled_grayscale_enabled";
    private static final String KEY_START_TIME = "scheduled_grayscale_start_time";
    private static final String KEY_END_TIME = "scheduled_grayscale_end_time";
    private static final String KEY_24H_MODE = "grayscale_24hour_mode";

    private SwitchPreferenceCompat mScheduledGrayscalePref;
    private TimePickerPreference mStartTimePref;
    private TimePickerPreference mEndTimePref;
    private SwitchPreferenceCompat m24hModePref;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.grayscale_schedule_settings, rootKey);

        mScheduledGrayscalePref = findPreference(KEY_SCHEDULED_GRAYSCALE);
        mStartTimePref = findPreference(KEY_START_TIME);
        mEndTimePref = findPreference(KEY_END_TIME);
        m24hModePref = findPreference(KEY_24H_MODE);

        updatePreferenceStates();

        Preference.OnPreferenceChangeListener listener = (preference, newValue) -> {
            updatePreferenceStates();
            return true;
        };

        mScheduledGrayscalePref.setOnPreferenceChangeListener(listener);
        m24hModePref.setOnPreferenceChangeListener(listener);
    }

    private void updatePreferenceStates() {
        boolean scheduledEnabled = mScheduledGrayscalePref.isChecked();
        boolean is24hMode = m24hModePref.isChecked();

        mStartTimePref.setEnabled(scheduledEnabled && !is24hMode);
        mEndTimePref.setEnabled(scheduledEnabled && !is24hMode);
        m24hModePref.setEnabled(scheduledEnabled);
    }
}
