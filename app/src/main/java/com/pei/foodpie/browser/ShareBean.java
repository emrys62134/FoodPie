package com.pei.foodpie.browser;

import com.pei.foodpie.R;

/**
 * Created by dllo on 16/12/8.
 */

public class ShareBean {
    private Integer[] icons = {R.mipmap.ssdk_oks_classic_qq, R.mipmap.ssdk_oks_classic_wechatfavorite,
            R.mipmap.ssdk_oks_classic_sinaweibo, R.mipmap.ssdk_oks_classic_wechat,
            R.mipmap.ssdk_oks_classic_wechatmoments, R.mipmap.ssdk_oks_classic_qzone};

    private String[] titleNames = {"QQ", "微信收藏", "新浪微博", "微信好友", "微信朋友圈", "QQ空间"};

    public Integer[] getIcons() {
        return icons;
    }

    public void setIcons(Integer[] icons) {
        this.icons = icons;
    }

    public String[] getTitleNames() {
        return titleNames;
    }

    public void setTitleNames(String[] titleNames) {
        this.titleNames = titleNames;
    }
}
