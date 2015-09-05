package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Window;

/**
 * Created by zzz40500 on 15/8/26.
 */
public abstract class MAppCompatDelegateFactory extends android.support.v7.app.AppCompatDelegate {



    /**
     * Create a {@link android.support.v7.app.AppCompatDelegate} to use with {@code activity}.
     *
     * @param callback An optional callback for AppCompat specific events
     */
    public static AppCompatDelegate create(Activity activity, AppCompatCallback callback) {
        return create(activity, activity.getWindow(), callback);
    }

    /**
     * Create a {@link android.support.v7.app.AppCompatDelegate} to use with {@code dialog}.
     *
     * @param callback An optional callback for AppCompat specific events
     */
    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback callback) {
        return create(dialog.getContext(), dialog.getWindow(), callback);
    }

    private static AppCompatDelegate create(Context context, Window window,
                                            AppCompatCallback callback) {
        final int sdk = Build.VERSION.SDK_INT;
        if (sdk >= 14) {
            return new MAppCompatDelegateImplV14(context, window, callback);
        } else if (sdk >= 11) {
            return new MAppCompatDelegateImplV11(context, window, callback);
        } else {
            return new MAppCompatDelegateImplV7(context, window, callback);
        }
    }
}
