package com.pei.foodpie.dbtool;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dllo on 16/12/14.
 */
@Entity
public class SearchData {
    @Id
    private Long id;
    private String name;
    @Generated(hash = 40412961)
    public SearchData(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 693570109)
    public SearchData() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
