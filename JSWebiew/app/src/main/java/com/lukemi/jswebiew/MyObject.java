package com.lukemi.jswebiew;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenmz
 * on 2017/12/6 0006.
 */

public class MyObject {

    public static final String TAG = MyObject.class.getSimpleName();
    private Context mContext;
    private String data;

    public MyObject(Context c, String data) {
        this.data = data;
        mContext = c;
    }

    /**
     * 获取person字符串传Html
     *
     * @return
     */
    @JavascriptInterface
    public String getData() {

        List<Person> mlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mlist.add(new Person("Li" + i, i + "", "com" + i));
        }
        Gson gson = new Gson();
        String d = gson.toJson(mlist);
        Log.d(TAG, "getData: dddd" + d);
        return d;
    }
}