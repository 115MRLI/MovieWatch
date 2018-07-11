package movie.watch.moviewatch.utils;

import android.widget.Toast;

import movie.watch.moviewatch.app.App;

public class Utils {
    private static Toast toast;

    /**
     * 吐丝提示方法
     *
     * @param message
     */
    public static void showToast(String message) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(App.mContext, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
