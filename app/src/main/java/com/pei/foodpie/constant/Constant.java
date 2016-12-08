package com.pei.foodpie.constant;

/**
 * Created by dllo on 16/11/28.
 */

public class Constant {
    // 食物百科
    public static final String FoodBaiKeUrl = "http://food.boohee.com/fb/v1/categories/list";

    public static final String FOOD_KIND_URL = "http://food.boohee.com/fb/v1/foods?kind=";

//    http://food.boohee.com/fb/v1/foods?kind=group&value=1(&sub_value=13)&order_by=1&page=1&order_asc=0
    public static final String FOOD_GRID_POSITION_URL = "&value=";

    public static final String FOOD_DETAIL_ORDER_BY_URL = "&order_by=";

    public static final String FOOD_DETAIL_LIST_VIEW_URL = "http://food.boohee.com/fb/v1/foods/sort_types";

    public static final String FOOD_DETAIL_RIGHT_POP_VALUE_URL = "&sub_value=";

    public static final String FOOD_DETAIL_ORDER_BY_PAGE_URL = "&order_by=1&page=";

    public static final String FOOD_DETAIL_TAIL = "&order_asc=0";




    // 逛吃:
    // 1,首页
    public static final String HOME_URL = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=1&per=10";
    public static final String HOME_HEAD_URL = "http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    public static final String HOME_FOOT_URL = "&category=1&per=10";

    // 2,评测
    public static final String EVALUATION_URL = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=2&per=10";
    public static final String EVALUATION_HEAD_URL = "http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    public static final String EVALUATION_FOOT_URL = "&category=2&per=10";


    // 3,知识
    public static final String KNOWLEDGE_URL = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=3&per=10";
    public static final String KNOWLEDGE_HEAD_URL = "http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    public static final String KNOWLEDGE_FOOT_URL = "&category=3&per=10";

    // 4,美食
    public static final String DELICIOUS_URL = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=4&per=10";
    public static final String DELICIOUS_HEAD_URL = "http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    public static final String DELICIOUS_FOOT_URL = "&category=4&per=10";
}