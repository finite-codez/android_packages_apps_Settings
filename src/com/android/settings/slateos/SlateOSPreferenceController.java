package com.android.settings.slateos;

import android.content.Context;
import android.content.Intent;
import androidx.preference.Preference;
import com.android.settings.core.BasePreferenceController;

public class SlateOSPreferenceController extends BasePreferenceController {

    public SlateOSPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getTitle() {
        return "SlateOS"; // Preferably from strings.xml
    }

    @Override
    public CharSequence getSummary() {
        return "Customize your experience"; // Preferably from strings.xml
    }

    @Override
    public Intent getIntent() {
        return new Intent().setClassName("com.android.settings", "com.android.settings.slateos.SlateOSActivity");
    }

    @Override
    public boolean handlePreferenceTreeClick(Preference preference) {
        if ("slateos_tile".equals(preference.getKey())) {
            Context context = preference.getContext();
            Intent intent = getIntent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Optional but helpful in some contexts
            context.startActivity(intent);
            return true;
        }
        return false;
    }
}
