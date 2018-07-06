package movie.watch.moviewatch.view.activity;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import movie.watch.loading.ColoringLoadingView;
import movie.watch.moviewatch.R;
import movie.watch.moviewatch.app.App;
import movie.watch.moviewatch.base.BaseActivity;
import movie.watch.moviewatch.presenter.WelcomePresenter;
import movie.watch.moviewatch.presenter.impl.WelcomePresenterImpl;
import movie.watch.moviewatch.view.contract.WelcomeContract;

public class WelcomeActivity extends BaseActivity implements WelcomeContract {
    @BindView(R.id.main_loading)
    ColoringLoadingView loadingView;
    @BindView(R.id.wel_bac)
    ImageView welBac;
    private WelcomePresenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        setTranslucentStatus(true);
        presenter = new WelcomePresenterImpl();
        presenter.attachView(this);
        presenter.starAnimation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }

    @Override
    protected void getIntentData() {
        super.getIntentData();
    }

    @Override
    public void loadAnimation() {
        loadingView.setCharacter(ColoringLoadingView.Character.CAT);
        loadingView.setColoringColor(0xFFFF1744);
        loadingView.setVisibility(View.VISIBLE);
        loadingView.startDrawAnimation();
    }

    @Override
    public void jumpThere() {
        HomeActivity.jumpHere(this);
    }
}
