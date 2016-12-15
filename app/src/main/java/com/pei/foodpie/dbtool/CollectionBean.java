package com.pei.foodpie.dbtool;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dllo on 16/12/14.
 */
@Entity
public class CollectionBean {
    @Id
    private Long id;
    private String url,title;
    @Generated(hash = 145525740)
    public CollectionBean(Long id, String url, String title) {
        this.id = id;
        this.url = url;
        this.title = title;
    }
    @Generated(hash = 1423617684)
    public CollectionBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
