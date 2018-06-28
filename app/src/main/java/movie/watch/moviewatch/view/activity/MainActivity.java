package movie.watch.moviewatch.view.activity;

import android.view.View;

import butterknife.BindView;
import movie.watch.loading.ColoringLoadingView;
import movie.watch.moviewatch.R;
import movie.watch.moviewatch.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @BindView(R.id.main_loading)
    ColoringLoadingView loadingView;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        loadingView.setCharacter(ColoringLoadingView.Character.AK);
        loadingView.setColoringColor(0xFFFF1744);
        loadingView.setVisibility(View.VISIBLE);
        loadingView.startDrawAnimation();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }

    @Override
    protected void getIntentData() {
        super.getIntentData();
    }
}
