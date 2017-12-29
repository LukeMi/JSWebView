package com.lukemi.jswebiew;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.Locale;

import static java.security.AccessController.getContext;

public class LangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);
        initView();
        String language = getResources().getConfiguration().locale.getLanguage();
        Log.i("LangActivity: ", language);
    }

    private void initView() {
        findViewById(R.id.tv_zh).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_en).setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_zh:
                    switchLang(0);
                    break;
                case R.id.tv_en:
                    switchLang(1);
                    break;
                default:
                    break;
            }

        }
    };

    private void switchLang(int index) {
        LangSetManager langSetManager = new LangSetManager(this);
        Resources resources = getResources();

        DisplayMetrics dm = resources.getDisplayMetrics();

        Configuration config = resources.getConfiguration();

        // 应用用户选择语言
        switch (index) {
            case 0:
                config.locale = Locale.CHINESE;
                langSetManager.setLang(LangSetManager.ZH);
                break;
            case 1:
                langSetManager.setLang(LangSetManager.EN);
                config.locale = Locale.ENGLISH;
                break;
            default:
                break;
        }
        resources.updateConfiguration(config, dm);
        refreshSelf();
    }

    //refresh self
    public void refreshSelf() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
