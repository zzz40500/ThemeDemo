package android.support.v7.app;

import com.mingle.skin.SkinConfig;
import com.mingle.skin.SkinStyle;
import com.mingle.skin.hepler.SkinCompat;

/**
 * Created by zzz40500 on 15/8/26.
 */
public class MAppCompatActivity extends android.support.v7.app.AppCompatActivity {


    private AppCompatDelegate mDelegate;



    private  SkinStyle mSkinStyle;

    /**
     * @return The {@link android.support.v7.app.AppCompatDelegate} being used by this Activity.
     */
    public android.support.v7.app.AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            mDelegate = MAppCompatDelegateFactory.create(this, this);
        }
        return mDelegate;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mSkinStyle != null && !mSkinStyle.equals(SkinConfig.getSkinStyle(this))) {
            SkinCompat.setCurrentTheme(this, null);
        }
    }

    @Override
    protected void onPause() {
        mSkinStyle= SkinConfig.getSkinStyle(this);
        super.onPause();
    }
}


