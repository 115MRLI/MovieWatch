# MovieWatch

#### 自定义缓冲条
        之前在泡在网上的日子看到一个特别合口味的缓冲条，可是无论怎么样添加依赖都是报错没办法只好重新把它，做一个依赖。
        然后新的调用地址
        
        //项目根目录下build.gradle添加
        
        allprojects {
        		repositories {
        			...
        			maven { url 'https://jitpack.io' }
        		}
        	}
        	
        	//app目录下build.gradle添加
        	
        	dependencies {
            	        implementation 'com.github.115MRLI:MovieWatch:1.0.0'
            	}
            	
         使用方法：
         布局文件中添加：
         
         <movie.watch.loading.ColoringLoadingView
                 android:id="@+id/main_loading"
                 android:layout_width="300dp"
                 android:layout_height="300dp"/>
                 
         java文件中添加：
        
        //这个是设置要展示什么样式的动画， 
         loadingView.setCharacter(ColoringLoadingView.Character.AK);
         loadingView.setColoringColor(0xFFFF1744);
         loadingView.startDrawAnimation();
         
         动画样式：
         
         ColoringLoadingView.Character.AK            AK枪；         ColoringLoadingView.Character.NINJA            日本武士；
         
         ColoringLoadingView.Character.BUTTERFLY     蝴蝶；         ColoringLoadingView.Character.HAIR_STYLE       发型；
         
         ColoringLoadingView.Character.TOOTH         牙齿；         ColoringLoadingView.Character.STORM            风暴；
         
         ColoringLoadingView.Character.DOGEZA        跪在地上的人； ColoringLoadingView.Character.CAT              猫；
         
         ColoringLoadingView.Character.VIOLIN        小提琴；       ColoringLoadingView.Character.CUCUMBER         黄瓜；
          ……………………
        	
### 展示图
![](screenshot/animation.gif)
![](screenshot/ill1.png)
![](screenshot/sc1.png)
![](screenshot/sc2.png)
![](screenshot/sc3.png)
![](screenshot/sc4.png)
![](screenshot/sc5.png)
![](screenshot/sc8.png)
![](screenshot/sc9.png)
![](screenshot/sc10.png)
![](screenshot/sc11.png)
![](screenshot/sc12.png)