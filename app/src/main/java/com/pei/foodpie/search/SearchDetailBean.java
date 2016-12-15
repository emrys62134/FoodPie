package com.pei.foodpie.search;

import java.util.List;

/**
 * Created by dllo on 16/12/12.
 */

public class SearchDetailBean {


    /**
     * page : 1
     * total_pages : 9386
     * tags : [{"type":"tags","name":"粮食制品"}]
     * items : [{"id":56,"code":"mifan_zheng","name":"米饭","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_201512613144756.jpg","is_liquid":false,"health_light":2,"weight":"100","calory":"116","type":"food"},{"id":469,"code":"pingguo_junzhi","name":"苹果","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2015126214658469.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"54","type":"food"},{"id":1312,"code":"fengmi","name":"蜂蜜","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2015241543181312.jpg","is_liquid":false,"health_light":2,"weight":"100","calory":"321","type":"food"},{"id":611,"code":"xiangjiao","name":"香蕉","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2015131152726611.jpg","is_liquid":false,"health_light":2,"weight":"100","calory":"93","type":"food"},{"id":910,"code":"jidan_junzhi","name":"鸡蛋","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2015131131916910.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"144","type":"food"},{"id":883,"code":"suannai_junzhi","name":"酸奶","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2015131142935883.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"72","type":"food"},{"id":119,"code":"doujiang","name":"豆浆","thumb_image_url":"http://s.boohee.cn/house/upload_food/2016/7/11/mid_photo_url_8bbc2f53b1ff471d9fd280ebe201b8a5.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"16","type":"food"},{"id":872,"code":"niuru_junzhi","name":"牛奶","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2015131143228872.jpg","is_liquid":true,"health_light":1,"weight":"100","calory":"54","type":"food"},{"id":219,"code":"fanqie","name":"番茄","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2014122395220219.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"20","type":"food"},{"id":236,"code":"huanggua","name":"黄瓜","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2015131153129236.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"16","type":"food"},{"id":63,"code":"yumi_xian","name":"玉米(鲜)","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_201512613192563.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"112","type":"food"},{"id":626,"code":"xigua_junzhi","name":"西瓜","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_201513115340626.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"26","type":"food"},{"id":23,"code":"mantou_junzhi","name":"馒头","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_201512613214923.jpg","is_liquid":false,"health_light":2,"weight":"100","calory":"223","type":"food"},{"id":525,"code":"tao_junzhi","name":"桃","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_2015131153636525.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"51","type":"food"},{"id":101590,"code":"fd749b2c","name":"薄荷超模25代餐粉（香草味）","thumb_image_url":"http://s.boohee.cn/house/upload_food/2015/4/21/1510332_1429575547mid.png","is_liquid":false,"health_light":1,"weight":"100","calory":"375","type":"food"},{"id":101849,"code":"fd347dc2","name":"薄荷超模25代餐粉（奶香味）","thumb_image_url":"http://s.boohee.cn/house/upload_food/2015/5/8/261612_1431085108mid.png","is_liquid":false,"health_light":1,"weight":"100","calory":"370","type":"food"},{"id":99833,"code":"chaomo25daicanfen","name":"超模25 营养饮（香草味·草莓味·奶香味）","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_201532614293799831.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"353","type":"food"},{"id":473,"code":"hongfushipingguo","name":"红富士苹果","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_201513115391473.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"49","type":"food"},{"id":584,"code":"cheng","name":"橙","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_201513115415584.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"48","type":"food"},{"id":17341,"code":"chaoqingcai","name":"炒青菜","thumb_image_url":"http://s.boohee.cn/house/food_mid/mid_photo_20152415465417341.jpg","is_liquid":false,"health_light":1,"weight":"100","calory":"39","type":"food"}]
     */

    private int page;
    private int total_pages;
    private List<TagsBean> tags;
    private List<ItemsBean> items;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class TagsBean {
        /**
         * type : tags
         * name : 粮食制品
         */

        private String type;
        private String name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ItemsBean {
        /**
         * id : 56
         * code : mifan_zheng
         * name : 米饭
         * thumb_image_url : http://s.boohee.cn/house/food_mid/mid_photo_201512613144756.jpg
         * is_liquid : false
         * health_light : 2
         * weight : 100
         * calory : 116
         * type : food
         */

        private int id;
        private String code;
        private String name;
        private String thumb_image_url;
        private boolean is_liquid;
        private int health_light;
        private String weight;
        private String calory;
        private String type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public String getThumb_image_url() {
            return thumb_image_url;
        }

        public void setThumb_image_url(String thumb_image_url) {
            this.thumb_image_url = thumb_image_url;
        }

        public boolean isIs_liquid() {
            return is_liquid;
        }

        public void setIs_liquid(boolean is_liquid) {
            this.is_liquid = is_liquid;
        }

        public int getHealth_light() {
            return health_light;
        }

        public void setHealth_light(int health_light) {
            this.health_light = health_light;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getCalory() {
            return calory;
        }

        public void setCalory(String calory) {
            this.calory = calory;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
