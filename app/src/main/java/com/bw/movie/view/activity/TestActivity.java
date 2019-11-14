package com.bw.movie.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.bw.movie.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.ListPopupWindow.MATCH_PARENT;


public class TestActivity extends AppCompatActivity {

    @BindView(R.id.room_btn)
    Button roomBtn;
    @BindView(R.id.btn_purchaseOrder)
    Button btnPurchaseOrder;
    private PopupWindow myPopuWindow;
    private boolean isReclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        roomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isReclick) {
                    View view = getLayoutInflater().inflate(R.layout.pop_view, null);
                    myPopuWindow = new PopupWindow(view, 500, 500);
                    myPopuWindow.setWidth(MATCH_PARENT);
                    myPopuWindow.setHeight(276);
                    myPopuWindow.showAtLocation(roomBtn, Gravity.BOTTOM, 0, 80);

                    isReclick = true;
                } else {
                    myPopuWindow.dismiss();
                    isReclick = false;
                }
            }
        });
    }
}
