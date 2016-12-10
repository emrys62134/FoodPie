package com.pei.foodpie.foodbaike.search;

/**
 * Created by dllo on 16/12/10.
 */

public class HistoryBean {
    private String name;

    public HistoryBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HistoryBean){
            HistoryBean historyBean = (HistoryBean) obj;
            return this.getName().equals(historyBean.getName());
        }
        return false;
    }
}
