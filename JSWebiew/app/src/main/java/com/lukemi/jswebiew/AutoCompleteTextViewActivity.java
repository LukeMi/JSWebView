package com.lukemi.jswebiew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;

public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private AutoCompleteTextView view;
    private String[] str = {"大大大", "大大小", "大小大", "大小小", "小大大", "小大小", "小大小", "小小小"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        initView();
    }

    private void initView() {
        view = ((AutoCompleteTextView) findViewById(R.id.actw));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AutoCompleteTextViewActivity.this,
                android.R.layout.simple_list_item_1, str );
        view.setAdapter(adapter);
    }
}
