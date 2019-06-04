package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Administrator on 2019/4/22.
 */
public class UiActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTest;
    private Button mBtnTest1;
    private Button mBtnTest2;
    private Button mBtnTest3;
    private Button mBtnTest4;
    private Button mBtnTest5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui);

        initView();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mTvTest.setText("子线程可以更新UI");//只有初始创建视图的线程才能触碰这些视图，也就是说只有主线程才能更新UI。
            }
        }).start();
    }

    private void initView() {
        mTvTest = findViewById(R.id.tv_test);
        mBtnTest1 = findViewById(R.id.btn_test1);
        mBtnTest2 = findViewById(R.id.btn_test2);
        mBtnTest3 = findViewById(R.id.btn_test3);
        mBtnTest4 = findViewById(R.id.btn_test4);
        mBtnTest5 = findViewById(R.id.btn_test5);
        mBtnTest1.setOnClickListener(this);
        mBtnTest2.setOnClickListener(this);
        mBtnTest2.setOnClickListener(this);
        mBtnTest3.setOnClickListener(this);
        mBtnTest4.setOnClickListener(this);
        mBtnTest5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mTvTest.setText("子线程真的可以更新UI吗？");
                    }
                }).start();
                /*
                其实子线程是不能直接更新UI的。
                Android实现View更新有两组方法，分别是invalidate和postInvalidate。前者在UI线程中使用，后者在非UI线程即子线程中使用。
                换句话说，在子线程调用 invalidate 方法会导致线程不安全。
                invalidate 方法会通知 view 立即重绘，刷新界面。
                假设，现在我用 invalidate 在子线程中刷新界面，同时UI线程也在用 invalidate 刷新界面，
                这样会不会导致界面的刷新不能同步？这就是invalidate不能在子线程中使用的原因。
                我们可以在子线程执行某段代码，需要更新UI的时候去通知主线程，让主线程来更新。见下面
                 */
                break;
            case R.id.btn_test2:  //通过发送消息
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.sendEmptyMessage(100);
                    }
                }).start();
                break;
            case R.id.btn_test3:  //通过Handler.post方法
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mTvTest.setText("handler.post");
                            }
                        });
                    }
                }).start();
                break;
            case R.id.btn_test4:   //通过 view.post方法
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mTvTest.post(new Runnable() {
                            @Override
                            public void run() {
                                mTvTest.setText("view.post");
                            }
                        });
                        mBtnTest1.post(new Runnable() {
                            @Override
                            public void run() {
                                mBtnTest1.setText("111112222");
                            }
                        });
                    }
                }).start();
                break;
            case R.id.btn_test5:   //通过 activity 的 runOnUiThread方法
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTvTest.setText("runOnUIThread");
                            }
                        });
                    }
                }).start();
                break;

        }
    }

    private Handler mHandler =  new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 100)
                mTvTest.setText("由Handler发送消息");

            return false;
        }
    });
}
