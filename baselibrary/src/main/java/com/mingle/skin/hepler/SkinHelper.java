package com.mingle.skin.hepler;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.mingle.skin.SkinStyle;
import com.mingle.widget.LinearLayout;

/**
 * /**
 * @attr ref android.R.styleable#View_background
 * @attr ref android.R.styleable#TextView_text
 * @attr ref android.R.styleable#TextView_textColor
 * @attr ref android.R.styleable#TextView_textColorHighlight
 * @attr ref android.R.styleable#TextView_textColorHint
 * @attr ref android.R.styleable#TextView_textAppearance
 * @attr ref android.R.styleable#TextView_textColorLink
 * Created by zzz40500 on 15/8/27.
 */
public abstract class SkinHelper {


    public  abstract void init(View view,AttributeSet attrs);
    public abstract void setSkinStyle(SkinStyle skinStyle);

    public static SkinHelper create(View v) {

        if(v instanceof TextView){

            return new TextViewSkinHelper();
        }else if (v instanceof ListView){

            return  new ListViewSkinHelper();

        }else  if(v instanceof LinearLayout){

            return  new LinearLayoutSkinHelper();
        }
        return new  ViewSkinHelper();
    }

    public static DefaultViewSkinHelper createDeFault( ) {

        return new DefaultViewSkinHelper();
    }

    public abstract void setCurrentTheme();
}
