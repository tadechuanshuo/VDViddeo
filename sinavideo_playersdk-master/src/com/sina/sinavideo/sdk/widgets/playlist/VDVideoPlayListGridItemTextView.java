package com.sina.sinavideo.sdk.widgets.playlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.sina.sinavideo.sdk.data.VDVideoInfo;
import com.sina.sinavideo.sdk.widgets.VDBaseWidget;
import com.sina.video_playersdkv2.R;

/**
 * TV模式中全屏播放时相关视频列表中数据列中的文字内容
 * @author liuqun
 */
public class VDVideoPlayListGridItemTextView extends TextView implements VDBaseWidget, VDVideoPlaylistBase {

    protected VDVideoInfo mInfo = null;
    protected int mVideoInfoIndex = -1;
    private int mCurPlayColor;
    private int mNoPlayColor;

    public VDVideoPlayListGridItemTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ResolutionBackGround);
        int otherTextColor = Color.parseColor("#ffffff");
        int curBgColor = Color.parseColor("#f42c2c");
        mNoPlayColor = a.getColor(R.styleable.PlayListTextViewColor_NoPlayColor, otherTextColor);
        mCurPlayColor = a.getColor(R.styleable.PlayListTextViewColor_CurPlayColor, curBgColor);
        a.recycle();
    }

    @Override
    public void reset() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void setData(VDVideoInfo info) {
        mInfo = info;
//        setText(info.mTitle);
    }

    @Override
    public void setVideoInfo(int infoIndex, int curPlayIndex) {
        mVideoInfoIndex = infoIndex;
        if (mVideoInfoIndex == curPlayIndex) {
            setTextColor(mCurPlayColor);
            setBackgroundColor(0xff333333);
        } else {
            setTextColor(mNoPlayColor);
            setBackgroundResource(R.drawable.gridtext_background);
        }
        setText(String.valueOf(infoIndex + 1));
//        setBackground(R.drawable.)
    }

}
