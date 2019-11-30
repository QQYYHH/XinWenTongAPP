package com.android.xinwentong.entity;

import android.widget.ImageView;
import android.widget.TextView;

public class ItemCenterPicNews {
    //是图片还是视频
    private boolean isPic = true;
    private boolean isFirst = true;//是否置顶
    private TextView tvtitle;
    private ImageView ivimag;
    private ImageView ivplay;
    private TextView playtime;
    private TextView tvauthor;
    private TextView tvcommentnum;
    private TextView tvtime;

    //图片
    public ItemCenterPicNews(boolean isPic, boolean isFirst, TextView tvtitle, ImageView ivimag,
                             TextView tvauthor, TextView tvcommentnum, TextView tvtime){
        this.isPic = isPic;
        this.isFirst = isFirst;
        this.tvtitle = tvtitle;
        this.ivimag = ivimag;
        this.tvauthor = tvauthor;
        this.tvcommentnum = tvcommentnum;
        this.tvtime = tvtime;
    }

    //视频
    public ItemCenterPicNews(boolean isPic, boolean isFirst, TextView tvtitle, ImageView ivimag,TextView playtime,
                             TextView tvauthor, TextView tvcommentnum, TextView tvtime){
        this.isPic = isPic;
        this.isFirst = isFirst;
        this.tvtitle = tvtitle;
        this.ivimag = ivimag;
        this.playtime = playtime;
        this.tvauthor = tvauthor;
        this.tvcommentnum = tvcommentnum;
        this.tvtime = tvtime;
    }
    public ItemCenterPicNews() {}


}
