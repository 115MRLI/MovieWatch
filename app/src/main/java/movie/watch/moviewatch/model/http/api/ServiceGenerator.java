package movie.watch.moviewatch.model.http.api;

import java.io.File;

import movie.watch.moviewatch.app.App;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {
    private static String BASE_URL = "https://api-m.mtime.cn/";
    //缓存文件夹
    private static File cacheFile = new File(App.mContext.getCacheDir(), "responses");
    //缓存大小为10M
    private static int cacheSize = 10 * 1024 * 1024;
    //创建缓存对象
    private static Cache cache = new Cache(cacheFile, cacheSize);

    private static OkHttpClient client = new OkHttpClient.Builder()
            .cache(cache)
            .build();
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL);

    /**
     * 创建
     *
     * @param serviceClass
     * @param <T>
     * @return
     */
    public static <T> T createServiceFrom(Class<T> serviceClass) {
        return builder.build().create(serviceClass);
    }

    /**
     * 改变BASE_URL
     *
     * @param newApiBaseUrl
     */
    public static void changeApiBaseUrl(String newApiBaseUrl) {
        BASE_URL = newApiBaseUrl;

        builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL);
    }
}
