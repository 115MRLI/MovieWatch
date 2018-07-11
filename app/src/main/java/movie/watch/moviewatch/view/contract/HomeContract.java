package movie.watch.moviewatch.view.contract;

import movie.watch.moviewatch.base.BaseView;

/**
 * 首页接口
 */
public interface HomeContract extends BaseView {
    /**
     * 进度条样式弹窗
     *
     * @param title
     */
    void progressDialog(final String title);

    /**
     * 关闭进度条样式弹窗
     */
    void cancelDialog();
}
