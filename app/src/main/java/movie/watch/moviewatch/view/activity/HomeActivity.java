package movie.watch.moviewatch.view.activity;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import movie.watch.moviewatch.R;
import movie.watch.moviewatch.base.BaseActivity;
import rx.Observer;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.home_page)
    LinearLayout homePage;
    @BindView(R.id.inform)
    LinearLayout inform;
    @BindView(R.id.myself)
    LinearLayout myself;
    @BindView(R.id.home_page_iv)
    ImageView homePageIv;
    @BindView(R.id.inform_iv)
    ImageView informIv;
    @BindView(R.id.myself_iv)
    ImageView myselfIv;
    @BindView(R.id.home_page_tv)
    TextView homePageTv;
    @BindView(R.id.inform_tv)
    TextView informTv;
    @BindView(R.id.myself_tv)
    TextView myselfTv;
    private List<LinearLayout> linearLayouts = new ArrayList<>();
    private List<TextView> textViews = new ArrayList<>();
    private List<ImageView> imageViews = new ArrayList<>();
    private int[] image = {R.mipmap.moive, R.mipmap.square, R.mipmap.me};
    private int[] imageselect = {R.mipmap.movie_no, R.mipmap.square_no, R.mipmap.me_no};

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        getLIines();
        getImages();
        getTexts();
        for (LinearLayout linearLayout : linearLayouts) {
            onClick(linearLayout);
        }
    }
    /**
     * 获取菜单
     */
    private void getLIines() {
        linearLayouts.add(homePage);
        linearLayouts.add(inform);
        linearLayouts.add(myself);
    }

    /**
     * 获取菜单文字
     */
    private void getTexts() {
        textViews.add(homePageTv);
        textViews.add(informTv);
        textViews.add(myselfTv);
    }

    /**
     * 获取菜单字体
     */
    private void getImages() {
        imageViews.add(homePageIv);
        imageViews.add(informIv);
        imageViews.add(myselfIv);
    }

    /**
     * 改变选中菜单样式
     *
     * @param position 要改变得菜单
     */
    private void changeStyle(int position) {
        for (int i = 0; i < imageViews.size(); i++) {
            if (i == position) {
                imageViews.get(i).setBackgroundResource(image[i]);
                textViews.get(i).setTextColor(Color.parseColor("#2c2c2c"));
            } else {
                imageViews.get(i).setBackgroundResource(imageselect[i]);
                textViews.get(i).setTextColor(Color.parseColor("#bfbfbf"));
            }
        }
    }
    /**
     * 防抖
     *
     * @param view
     */
    private void onClick(final View view) {
        RxView.clicks(view)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {
                        switch (view.getId()) {
                            case R.id.home_page:
                                changeStyle(0);
                                break;
                            case R.id.inform:
                                changeStyle(1);
                                break;
                            case R.id.myself:
                                changeStyle(2);
                                break;
                            default:

                                break;
                        }
                    }
                });
    }
    /**
     * 跳转到该页面
     *
     * @param activity
     */
    public static void jumpHere(Activity activity) {
        activity.startActivity(new Intent(activity, HomeActivity.class));
        activity.finish();
    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    /**
     * 第一种解决办法 通过监听keyUp
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(HomeActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyUp(keyCode, event);
    }
}
