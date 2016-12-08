package com.pei.foodpie.foodbaike.detail.leftpop;

import java.util.List;

/**
 * Created by dllo on 16/12/6.
 */

public class OrderBean {

    private List<TypesBeanDetail> types;

    public List<TypesBeanDetail> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBeanDetail> types) {
        this.types = types;
    }

    public static class TypesBeanDetail {
        /**
         * code : calory
         * name : 热量
         * index : 2
         */

        private String code;
        private String name;
        private String index;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }
    }
}
