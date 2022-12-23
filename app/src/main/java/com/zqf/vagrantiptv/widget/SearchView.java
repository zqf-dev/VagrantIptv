package com.zqf.vagrantiptv.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zqf.vagrantiptv.R;

/**
 * Author: zqf
 * Date: 2022/12/23
 */
public class SearchView extends LinearLayout implements TextWatcher {
    private ImageView leftIv;
    private EditText searchEt;
    private ImageView sureIv;
    private TextView clearIv;
    private onTextListener onTextListener;

    public SearchView(Context context) {
        super(context);
        init(context);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.search_view_layout, this, true);
        leftIv = findViewById(R.id.lef_igv);
        searchEt = findViewById(R.id.search_et);
        sureIv = findViewById(R.id.search_sure_igv);
        clearIv = findViewById(R.id.search_clear_igv);
        clearIv.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View view) {
                searchEt.setText("");
            }
        });
        searchEt.addTextChangedListener(this);
    }

    //返回点击事件
    public void setLeftIvClick(NoDoubleClickListener onClickListener) {
        leftIv.setOnClickListener(onClickListener);
    }

    //确认搜索
    public void sureSearch(onTextListener onTextListener, NoDoubleClickListener onClickListener) {
        Log.e("TAG", "onTextListener");
        this.onTextListener = onTextListener;
        sureIv.setOnClickListener(onClickListener);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        onTextListener.onTextChanged(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().length() > 0) {
            clearIv.setVisibility(View.VISIBLE);
        } else {
            clearIv.setVisibility(View.GONE);
        }
    }

    public interface onTextListener {
        void onTextChanged(String str);
    }
}
