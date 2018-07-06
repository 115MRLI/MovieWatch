package movie.watch.moviewatch.presenter.impl;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

import movie.watch.moviewatch.presenter.WelcomePresenter;
import movie.watch.moviewatch.view.contract.WelcomeContract;

public class WelcomePresenterImpl<T extends WelcomeContract> implements WelcomePresenter<T> {
    private T baseView;
    private Timer timer;
    private int num = 1;

    @Override
    public void starAnimation() {
        if (baseView != null) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(num);
                }
            };

            timer = new Timer();
            timer.schedule(task, 2000);//3秒后执行TimeTask的run方法

        }
    }

    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void detachView() {
        baseView = null;
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (baseView != null) {
                switch (msg.what) {
                    case 1:
                        baseView.loadAnimation();
                        num = 2;
                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                handler.sendEmptyMessage(num);
                            }
                        };
                        timer.schedule(task, 6000);//3秒后执行TimeTask的run方法
                        break;
                    case 2:
                        baseView.jumpThere();
                        break;
                }
            }
        }
    };
}
