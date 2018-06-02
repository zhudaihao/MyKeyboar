package com.example.administrator.mykeyboar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.ziyeyouhu.library.KeyboardTouchListener;
import com.ziyeyouhu.library.KeyboardUtil;

public class MainActivity extends AppCompatActivity {
    KeyboardUtil keyboardUtil;
    LinearLayout ll_layout;
    ScrollView scroll_view;
    EditText editText, et_2;

    /**
     * 注意ScrollView布局
     * android:layout_width="match_parent"
     * android:layout_height="0dp"
     * android:layout_weight="1"
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_layout = findViewById(R.id.ll_layout);
        scroll_view = findViewById(R.id.scrollView);
        editText = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);


        keyboardUtil = new KeyboardUtil(this, ll_layout, scroll_view);
        keyboardUtil.setOtherEditText(editText);
        keyboardUtil.setOtherEditText(et_2);
        editText.setOnTouchListener(new KeyboardTouchListener(keyboardUtil, KeyboardUtil.INPUTTYPE_ABC, -1));
       // et_2.setOnTouchListener(new KeyboardTouchListener(keyboardUtil, KeyboardUtil.INPUTTYPE_ABC, -1));

        keyboardUtil.setInputOverListener(new KeyboardUtil.InputFinishListener() {
            @Override
            public void inputHasOver(int onclickType, EditText editText) {

            }
        });


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (keyboardUtil.isShow) {
                keyboardUtil.hideSystemKeyBoard();
                keyboardUtil.hideAllKeyBoard();
                keyboardUtil.hideKeyboardLayout();
            } else {
                return super.onKeyDown(keyCode, event);
            }

            return false;
        } else
            return super.onKeyDown(keyCode, event);
    }


}
