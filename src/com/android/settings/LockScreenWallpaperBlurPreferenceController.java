package com.android.settings;

import android.content.Context;
import android.provider.Settings;

import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;

import com.android.settings.core.TogglePreferenceController;

public class LockScreenWallpaperBlurPreferenceController extends TogglePreferenceController {

    public static final String KEY = "lock_screen_wallpaper_blur";

    public LockScreenWallpaperBlurPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE; // Optionally add logic here to hide if unsupported
    }

    @Override
    public boolean isChecked() {
        return Settings.Secure.getInt(mContext.getContentResolver(),
                Settings.Secure.LOCK_SCREEN_WALLPAPER_BLUR, 0) == 1;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        return Settings.Secure.putInt(mContext.getContentResolver(),
                Settings.Secure.LOCK_SCREEN_WALLPAPER_BLUR, isChecked ? 1 : 0);
    }

    @Override
    public CharSequence getSummary() {
        return "Applies a soft blur effect to your lock screen background";
    }
}
