package android.support.v7.app;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

import java.lang.reflect.Field;

/**
 * Created by zzz40500 on 15/8/26.
 */
public class MAppCompatDelegateImplV14 extends AppCompatDelegateImplV14 {
    private Field field;

    MAppCompatDelegateImplV14(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }

    private MAppCompatViewInflater mAppCompatViewInflater;


    @Override
    public View createView(View parent, final String name, @NonNull Context context,
                           @NonNull AttributeSet attrs) {
        final boolean isPre21 = Build.VERSION.SDK_INT < 21;

        if (mAppCompatViewInflater == null) {
            mAppCompatViewInflater = new MAppCompatViewInflater();
        }

        final boolean inheritContext = isPre21 && isSubDecorInstalled() && parent != null
                && parent.getId() != android.R.id.content
                && !ViewCompat.isAttachedToWindow(parent);

        return mAppCompatViewInflater.createView(parent, name, context, attrs, inheritContext,
                isPre21,
                true
        );
    }

    public boolean isSubDecorInstalled() {


        if (field == null) {

            try {

                field = AppCompatDelegateImplV7.class.getDeclaredField("mSubDecorInstalled");
                field.setAccessible(true);
                Object o = field.get(this);
                return (boolean) o;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            Object o = null;
            try {
                o = field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return (boolean) o;

        }
        return true;
    }


}
