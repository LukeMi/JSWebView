package com.lukemi.jswebiew;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by chenmz
 * on 2017/12/13 0013.
 */

public class JSApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = getSetLocale();
        resources.updateConfiguration(config, dm);
    }

    private Locale getSetLocale() {
        LangSetManager l = new LangSetManager(this);
        return l.getSetLocale();
    }

}
