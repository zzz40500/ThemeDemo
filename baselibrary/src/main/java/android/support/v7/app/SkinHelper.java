package android.support.v7.app;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.VectorEnabledTintResources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * Created by dim on 16/5/24.
 */
public class SkinHelper {


    private static final String TAG = "SkinHelper";

    public static void init(Object ob) {

        try {
            Class cls = Class.forName("android.app.SystemServiceRegistry");
            Class serviceFetcher = Class.forName("android.app.SystemServiceRegistry$ServiceFetcher");
            Field system_service_fetchers = cls.getDeclaredField("SYSTEM_SERVICE_FETCHERS");
            system_service_fetchers.setAccessible(true);
            HashMap o = (HashMap) system_service_fetchers.get(null);
            final Object layoutInflaterFetcher = o.get(Context.LAYOUT_INFLATER_SERVICE);
            Object HockLayoutInflaterFetcher = Proxy.newProxyInstance(ob.getClass().getClassLoader(), new Class[]{serviceFetcher}, new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    LayoutInflater inflater = (LayoutInflater) method.invoke(layoutInflaterFetcher, args);
                    inflater.setFactory2(new LayoutInflaterFactory2());
                    return inflater;
                }
            });
            o.put(Context.LAYOUT_INFLATER_SERVICE, HockLayoutInflaterFetcher);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
