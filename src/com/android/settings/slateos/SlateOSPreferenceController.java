package com.android.settings.slateos;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
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
        return "SlateOS";
    }

    @Override
    public CharSequence getSummary() {
        return "Customize your experience";
    }

    @Override
    public Intent getIntent() {
        return new Intent().setClassName("com.android.settings", "com.android.settings.slateos.SlateOSActivity");
    }
}
