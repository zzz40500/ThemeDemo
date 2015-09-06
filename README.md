[![Android Gems](http://www.android-gems.com/badge/zzz40500/ThemeDemo.svg?branch=master)](http://www.android-gems.com/lib/zzz40500/ThemeDemo)

#效果图:

![ThemeDemo.gif](http://upload-images.jianshu.io/upload_images/166866-f4a26bbeebb3fff9.gif?imageMogr2/auto-orient/strip)


[Github](https://github.com/zzz40500/ThemeDemo)  
#前面:  
实现的原理像我微博之前的说的那样.  
>关于多主题实现的,我这里的做法是继承AppCompatActivity,置换了AppCompatDelegate中AppCompatViewInflater中的createView 方法.实现了对 xml 控件的控制.


#实现:
1. 实现了日夜模式的切换.(不重启 Acitivity )
* 解决了因为快速点击 View 导致的多次响应点击事件.
* 内部实现了 Android 5.0 的CircularReveal效果.

###优点:
布局中直接使用 Android 默认的控件就可以.在解析以后会根据控件转换成支持主题切换的控件.解放冗余的名称.
###缺点:
暂时不支持 Menu 级的切换.

###支持属性:
View 级:  
`nightBackground`  
TextView 级:  
`nightTextColor`  
`nightTextColorHighlight`  
`nightTextAppearance`  
`nightTextColorLink`  
`nightTextColorHint`  
ListView 级:  
`nightLVDivider`  
LinearLayout 级别:  
`nightDivider`  
第三方控件支持:
`nightBackground`  
`nightTextColor`  




###gradle:
/build.gradle
~~~

repositories {
    maven {
        url "https://jitpack.io"
    }
}
~~~
/app/build.gradle
~~~
compile 'com.github.zzz40500:ThemeDemo:0.1'
~~~

##使用方法:
####代码上
 Activity 继承MAppCompatActivity  
####布局上
~~~
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:tools="http://schemas.android.com/tools"
              android:id="@+id/rl"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:background="@color/light_bg"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              android:orientation="vertical"
              tools:ignore="MissingPrefix"
              app:nightBackground="@color/night_bg"
              tools:context=".MainActivity">
    <android.support.v7.widget.Toolbar
        android:id="@+id/toolBar"
        android:layout_height="?attr/actionBarSize"
        android:layout_width="fill_parent"
        />
    <TextView
        android:layout_width="fill_parent"
        android:id="@+id/tv"
        android:layout_below="@+id/toolBar"
        android:gravity="center"
        android:background="@color/red"
        android:text="TextView"
        android:textColor="@color/normal_black"
        android:textAppearance="@style/TextAppearance.AppCompat.Display1"
        android:layout_height="100dp"
        app:nightTextColor="@color/night_tv_color"
        app:nightBackground="@color/night_bg"
        />

    <Button
        android:layout_below="@+id/tv"
        android:layout_width="fill_parent"
        android:text="Click"
        android:id="@+id/button"
        android:background="@color/button_bg"
        android:textColor="@color/normal_black"
        android:layout_height="50dp"
        app:nightBackground="@color/night_bg"
        />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fb"
        android:layout_width="48dp"
        android:layout_alignParentRight="true"
        android:layout_alignParentBottom="true"
        android:layout_margin="16dp"
        android:layout_height="48dp"
        app:backgroundTint="#ff87ffeb"
        app:rippleColor="#33728dff"
        android:src="@mipmap/ic_launcher"
        android:orientation="vertical" />

</RelativeLayout>
~~~
处女座在根控件加入`tools:ignore="MissingPrefix"`


####切换主题方法:
~~~


/**
 * 
 * @param activity 当前 Activity
 * @param skinStyle Dark(夜间),Light(日间)
 * @param skinStyleChangeListener (转换监听器)
 */
SkinCompat.setSkinStyle(Activity activity, SkinStyle skinStyle,SkinStyleChangeListener skinStyleChangeListener) 
~~~

####使用CircularReveal 效果:
5.0 上面用的是原生的 api,5.0下面才是自己的实现的方法.
~~~
 

CRAnimation crA =
        new CircularRevealCompat(mRl).circularReveal(
                mFloatingActionButton.getLeft() + mFloatingActionButton.getWidth() / 2, mFloatingActionButton.getTop() + mFloatingActionButton.getHeight() / 2, 0, mRl.getHeight());

if (crA != null)
    crA.start();
~~~


###扩展:
支持对原生控件的解析时期替换:
~~~
这边很奇葩的把 TextView 变成了 EditText 控件,只是为了替换而替换.
WidgetFactor.getInstant().setWidgetParser(new WidgetFactor.WidgetParser() {
    @Override
    public View parseWidget(String name, Context context, AttributeSet attrs) {
        //布局中的名称
        if (name.equals("TextView")) {
            return new EditText(context, attrs);
        }
        //返回 null 则不替换.
        return null;
    }
});
~~~


第三方控件支持CircularReveal效果:  
实现CircleRevealEnable这个接口:[模板](https://github.com/zzz40500/ThemeDemo/blob/master/%E6%A8%A1%E6%9D%BF)  

###未来可能实现的:
1. 实现Toolbar和 menu 的日夜间切换.
* 替换CircularReveal算法 . 
* 出个轻量的,不带日夜间切换的库.

#尾巴:  
1. 实现原理主要是受到代码家在[Google I/O 2015 为 Android 开发者带来了哪些福利](http://www.jianshu.com/p/4f7f55471da2)里面的启发.  
* 我在项目中也仅仅只是用在解决快速点击 View 导致的多响应,和使用CircularReveal效果.日夜间模式并没有这个需求.  







