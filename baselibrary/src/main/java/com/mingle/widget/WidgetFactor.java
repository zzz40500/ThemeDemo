package com.mingle.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by zzz40500 on 15/9/5.
 */
public class WidgetFactor {


    private  static WidgetFactor instant;

    public static WidgetFactor getInstant() {

        if(instant == null){
            instant=new WidgetFactor();
        }

        return instant;
    }

    private WidgetParser mWidgetParser;

    public android.view.View parseWidget(String name, Context context, AttributeSet attrs){

        if(mWidgetParser != null){
            return mWidgetParser.parseWidget(name,context,attrs);
        }
        return  null;
    }


    public void setWidgetParser(WidgetParser widgetParser) {
        mWidgetParser = widgetParser;
    }

    public interface WidgetParser {
        android.view.View  parseWidget(String name, Context context, AttributeSet attrs);
    }
}
