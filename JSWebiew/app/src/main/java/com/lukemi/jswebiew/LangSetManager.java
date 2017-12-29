package com.lukemi.jswebiew;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Locale;

/**
 * Created by chenmz
 * on 2017/12/13 0013.
 */

public class LangSetManager {

    private final String TAG = "LangSetManager";
    private final String Lang_Manager = "LangManager";
    private final String Lang_SET = "Lang_set";

    public final static String ZH = "zh";//中文
    public final static String EN = "en";//英文

    private Context context;

    public LangSetManager(Context context) {
        this.context = context;
    }

    /**
     * 获取管理语言的SPF
     *
     * @return
     */
    public SharedPreferences getLSMSharedPreferences() {
        return context.getSharedPreferences(Lang_Manager, Context.MODE_PRIVATE);
    }

    /**
     * 获取管理语言的Editor
     *
     * @return
     */
    public SharedPreferences.Editor getLSMManagerEditor() {
        return context.getSharedPreferences(Lang_Manager, Context.MODE_PRIVATE).edit();
    }

    /**
     * 设置语言
     *
     * @param lang 当前选择的语言{@link LangSetManager#ZH },{@link LangSetManager#EN }
     */
    public void setLang(String lang) {
        SharedPreferences.Editor lsmManagerEditor = getLSMManagerEditor();
        lsmManagerEditor.putString(Lang_SET, lang).commit();
    }

    /**
     * 获取当前保存的语言设置，默认为空
     *
     * @return
     */
    public String getSetLang() {
        return getLSMSharedPreferences().getString(Lang_SET, "");
    }

    /**
     * 获取当前的Locale设置
     *
     * @return
     */
    public Locale getSetLocale() {
        String setLang = getSetLang();
        Log.i(TAG, setLang);
        Locale locale;
        switch (setLang) {
            case LangSetManager.ZH:
                locale = Locale.CHINESE;
                break;
            case LangSetManager.EN:
                locale = Locale.ENGLISH;
                break;
            default:
                locale = Locale.getDefault();
                break;
        }
        return locale;
    }
}
