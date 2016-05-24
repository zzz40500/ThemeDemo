package com.dim.skin.hepler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.dim.skin.SkinConfig;
import com.dim.skin.SkinStyle;
import com.dim.widget.LinearLayout;

/**
 * /**
 *
 * @attr ref android.R.styleable#View_background
 * @attr ref android.R.styleable#TextView_text
 * @attr ref android.R.styleable#TextView_textColor
 * @attr ref android.R.styleable#TextView_textColorHighlight
 * @attr ref android.R.styleable#TextView_textColorHint
 * @attr ref android.R.styleable#TextView_textAppearance
 * @attr ref android.R.styleable#TextView_textColorLink
 * Created by dim on 15/8/27.
 */
public abstract class SkinHelper {


    private SkinStyle mSkinStyle;
    private Context mContext;

    public SkinHelper(Context context) {
        mSkinStyle = SkinConfig.getSkinStyle(context);
        mContext = context;

    }

    public abstract void init(View view, AttributeSet attrs);

    public void setSkinStyle(SkinStyle skinStyle) {
        mSkinStyle = skinStyle;
    }

    public static SkinHelper create(View v) {

        if (v instanceof TextView) {
            return new TextViewSkinHelper(v.getContext());
        } else if (v instanceof ListView) {
            return new ListViewSkinHelper(v.getContext());
        } else if (v instanceof LinearLayout) {
            return new LinearLayoutSkinHelper(v.getContext());
        }
        return new ViewSkinHelper(v.getContext());
    }

    public SkinStyle getSkinStyle() {
        return mSkinStyle;
    }

    public static DefaultViewSkinHelper createDeFault(Context context) {

        return new DefaultViewSkinHelper(context);
    }

    public abstract void setCurrentTheme();

    public void preDraw(View view) {
        if (!getSkinStyle().equals(SkinConfig.getSkinStyle(view.getContext()))) {
            SkinCompat.changeSkinView(view,SkinConfig.getSkinStyle(view.getContext()));
        }
    }
}
