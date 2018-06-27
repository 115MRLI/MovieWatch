package movie.watch.moviewatch.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.SupportActivity;
import android.util.Log;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import cn.bmob.newim.BmobIM;
import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobInstallationManager;
import cn.bmob.v3.InstallationListener;
import cn.bmob.v3.exception.BmobException;
import movie.watch.moviewatch.utils.BmobMessageHandler;

import static cn.bmob.newim.util.Utils.getMyProcessName;


public class App extends Application {
    private static App instance;
    private Set<FragmentActivity> allActivities;
    public static Context mContext;
    private static DbManager.DaoConfig daoConfig;

    public DbManager.DaoConfig getDaoConfig() {
        return daoConfig;
    }

    /**
     * 获取自定义Application
     *
     * @return
     */
    public static App getInstance() {
        return instance;
    }

    /**
     * 注册当前Activity到集合
     *
     * @param act 当前的activity
     */
    public void registerActivity(FragmentActivity act) {
        if (allActivities == null) {
            allActivities = new HashSet<FragmentActivity>();
        }
        allActivities.add(act);
    }

    /**
     * 从集合中清除当前 activity
     *
     * @param act
     */
    public void unregisterActivity(SupportActivity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出程序
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (FragmentActivity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mContext = getApplicationContext();
        initializedDatabase();
        initBmob();
    }

    /**
     * 初始化Bmob信息
     */
    private void initBmob() {
        //TODO 集成：1.4、初始化数据服务SDK、初始化设备信息并启动推送服务
        // 初始化BmobSDK
        Bmob.initialize(this, "af8174f3afdde0f3ff885d12fb91a6e4");
        // 使用推送服务时的初始化操作
        BmobInstallationManager.getInstance().initialize(new InstallationListener<BmobInstallation>() {
            @Override
            public void done(BmobInstallation bmobInstallation, BmobException e) {
                if (e == null) {
                    Log.i("bmob", bmobInstallation.getObjectId() + "-" + bmobInstallation.getInstallationId());
                } else {
                    Log.e("bmob", e.getMessage());
                }
            }
        });
        // 启动推送服务
        BmobPush.startWork(this);

        //TODO 集成：1.8、初始化IM SDK，并注册消息接收器
        if (getApplicationInfo().packageName.equals(getMyProcessName())) {
            BmobIM.init(this);
            BmobIM.registerDefaultMessageHandler(new BmobMessageHandler());
        }
    }

    /**
     * 获取当前运行的进程名
     *
     * @return
     */
    public static String getMyProcessName() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 初始化数据库
     */
    private void initializedDatabase() {
        x.Ext.init(this);//Xutils初始化
        daoConfig = new DbManager.DaoConfig()
                .setDbName("movice") //数据库名字
                .setDbVersion(1)//数据库版本号
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {

                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                    }
                });
    }


}
