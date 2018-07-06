package movie.watch.moviewatch.view.contract;

import movie.watch.moviewatch.base.BaseView;

/**
 * 欢迎界面接口的视图层的调起
 */
public interface WelcomeContract extends BaseView {
    /**
     * 调起缓冲条动画
     */
    void loadAnimation();

    /**
     * 跳转页面
     */
    void jumpThere();
}
