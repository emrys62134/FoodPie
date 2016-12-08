package com.pei.foodpie.foodbaike;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by dllo on 16/12/7.
 */

public class FoodBaiKeBean implements Parcelable {

    /**
     * group_count : 3
     * group : [{"kind":"group","categories":[{"id":1,"name":"主食类","image_url":"http://up.boohee.cn/house/u/food_library/category/1_v1.png","sub_category_count":3,"sub_categories":[{"id":13,"name":"包装谷薯","image_url":null},{"id":11,"name":"天然谷薯","image_url":null},{"id":12,"name":"谷薯制品","image_url":null}],"description":null},{"id":2,"name":"肉蛋类","image_url":"http://up.boohee.cn/house/u/food_library/category/2_v1.png","sub_category_count":3,"sub_categories":[{"id":22,"name":"白肉","image_url":null},{"id":21,"name":"红肉","image_url":null},{"id":23,"name":"蛋类","image_url":null}],"description":null},{"id":3,"name":"大豆及制品","image_url":"http://up.boohee.cn/house/u/food_library/category/3_v1.png","sub_category_count":1,"sub_categories":[{"id":31,"name":"大豆及制品","image_url":null}],"description":null},{"id":4,"name":"蔬菜菌藻类","image_url":"http://up.boohee.cn/house/u/food_library/category/4_v1.png","sub_category_count":2,"sub_categories":[{"id":42,"name":"菌藻","image_url":null},{"id":41,"name":"蔬菜","image_url":null}],"description":null},{"id":5,"name":"水果类","image_url":"http://up.boohee.cn/house/u/food_library/category/5_v1.png","sub_category_count":1,"sub_categories":[{"id":51,"name":"水果","image_url":null}],"description":null},{"id":6,"name":"奶类","image_url":"http://up.boohee.cn/house/u/food_library/category/6_v1.png","sub_category_count":5,"sub_categories":[{"id":65,"name":"其它","image_url":null},{"id":64,"name":"奶粉","image_url":null},{"id":63,"name":"奶酪","image_url":null},{"id":62,"name":"酸奶","image_url":null},{"id":61,"name":"鲜奶","image_url":null}],"description":null},{"id":7,"name":"油脂类","image_url":"http://up.boohee.cn/house/u/food_library/category/7_v1.png","sub_category_count":2,"sub_categories":[{"id":72,"name":"动物油","image_url":null},{"id":71,"name":"植物油","image_url":null}],"description":null},{"id":8,"name":"坚果类","image_url":"http://up.boohee.cn/house/u/food_library/category/8_v1.png","sub_category_count":1,"sub_categories":[{"id":81,"name":"坚果种子","image_url":null}],"description":null},{"id":9,"name":"调味品","image_url":"http://up.boohee.cn/house/u/food_library/category/9_v1.png","sub_category_count":4,"sub_categories":[{"id":94,"name":"糖和蜂蜜","image_url":null},{"id":91,"name":"调味料","image_url":null},{"id":92,"name":"调味酱","image_url":null},{"id":93,"name":"酱菜","image_url":null}],"description":null},{"id":10,"name":"饮料类","image_url":"http://up.boohee.cn/house/u/food_library/category/10_v1.png","sub_category_count":8,"sub_categories":[{"id":108,"name":"乳饮料","image_url":null},{"id":104,"name":"含糖饮料","image_url":null},{"id":107,"name":"固体饮料","image_url":null},{"id":106,"name":"无糖咖啡","image_url":null},{"id":105,"name":"无糖茶饮","image_url":null},{"id":102,"name":"碳酸饮料","image_url":null},{"id":103,"name":"纯果蔬汁饮料","image_url":null},{"id":101,"name":"酒精饮料","image_url":null}],"description":null},{"id":11,"name":"零食，点心及冷饮","image_url":"http://up.boohee.cn/house/u/food_library/category/11_v1.png","sub_category_count":3,"sub_categories":[{"id":113,"name":"冷饮","image_url":null},{"id":112,"name":"点心","image_url":null},{"id":111,"name":"零食","image_url":null}],"description":null},{"id":12,"name":"其它","image_url":"http://up.boohee.cn/house/u/food_library/category/12_v1.png","sub_category_count":2,"sub_categories":[{"id":121,"name":"药食","image_url":null},{"id":122,"name":"营养保健","image_url":null}],"description":null}]},{"kind":"brand","categories":[{"id":20,"name":"薄荷","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand1.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":1,"name":"鲜得味","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand2.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":2,"name":"雀巢","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand3.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":3,"name":"光明","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand4.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":4,"name":"伊利","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand5.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":5,"name":"蒙牛","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand6.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":6,"name":"三全","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand7.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":7,"name":"永和","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand8.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":8,"name":"南方","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand9.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":9,"name":"康师傅","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand10.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":10,"name":"思念","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand11.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":21,"name":"新农哥","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand12.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":23,"name":"旺旺","image_url":"http://up.boohee.cn/house/u/food_library/brand/brand13.png","sub_category_count":0,"sub_categories":[],"description":null}]},{"kind":"restaurant","categories":[{"id":1,"name":"肯德基","image_url":"http://up.boohee.cn/house/u/food_library/chain_restaurant/linkage1.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":2,"name":"麦当劳","image_url":"http://up.boohee.cn/house/u/food_library/chain_restaurant/linkage2.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":3,"name":"星巴克","image_url":"http://up.boohee.cn/house/u/food_library/chain_restaurant/linkage3.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":4,"name":"吉野家","image_url":"http://up.boohee.cn/house/u/food_library/chain_restaurant/linkage4.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":5,"name":"德克士","image_url":"http://up.boohee.cn/house/u/food_library/chain_restaurant/linkage5.png","sub_category_count":0,"sub_categories":[],"description":null},{"id":6,"name":"大娘水饺","image_url":"http://up.boohee.cn/house/u/food_library/chain_restaurant/linkage6.png","sub_category_count":0,"sub_categories":[],"description":null}]}]
     */

    private int group_count;
    private List<GroupBeanDetail> group;

    protected FoodBaiKeBean(Parcel in) {
        group_count = in.readInt();
        group = in.createTypedArrayList(GroupBeanDetail.CREATOR);
    }

    public static final Creator<FoodBaiKeBean> CREATOR = new Creator<FoodBaiKeBean>() {
        @Override
        public FoodBaiKeBean createFromParcel(Parcel in) {
            return new FoodBaiKeBean(in);
        }

        @Override
        public FoodBaiKeBean[] newArray(int size) {
            return new FoodBaiKeBean[size];
        }
    };

    public int getGroup_count() {
        return group_count;
    }

    public void setGroup_count(int group_count) {
        this.group_count = group_count;
    }

    public List<GroupBeanDetail> getGroup() {
        return group;
    }

    public void setGroup(List<GroupBeanDetail> group) {
        this.group = group;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(group_count);
        parcel.writeTypedList(group);
    }

    public static class GroupBeanDetail implements Parcelable {
        /**
         * kind : group
         * categories : [{"id":1,"name":"主食类","image_url":"http://up.boohee.cn/house/u/food_library/category/1_v1.png","sub_category_count":3,"sub_categories":[{"id":13,"name":"包装谷薯","image_url":null},{"id":11,"name":"天然谷薯","image_url":null},{"id":12,"name":"谷薯制品","image_url":null}],"description":null},{"id":2,"name":"肉蛋类","image_url":"http://up.boohee.cn/house/u/food_library/category/2_v1.png","sub_category_count":3,"sub_categories":[{"id":22,"name":"白肉","image_url":null},{"id":21,"name":"红肉","image_url":null},{"id":23,"name":"蛋类","image_url":null}],"description":null},{"id":3,"name":"大豆及制品","image_url":"http://up.boohee.cn/house/u/food_library/category/3_v1.png","sub_category_count":1,"sub_categories":[{"id":31,"name":"大豆及制品","image_url":null}],"description":null},{"id":4,"name":"蔬菜菌藻类","image_url":"http://up.boohee.cn/house/u/food_library/category/4_v1.png","sub_category_count":2,"sub_categories":[{"id":42,"name":"菌藻","image_url":null},{"id":41,"name":"蔬菜","image_url":null}],"description":null},{"id":5,"name":"水果类","image_url":"http://up.boohee.cn/house/u/food_library/category/5_v1.png","sub_category_count":1,"sub_categories":[{"id":51,"name":"水果","image_url":null}],"description":null},{"id":6,"name":"奶类","image_url":"http://up.boohee.cn/house/u/food_library/category/6_v1.png","sub_category_count":5,"sub_categories":[{"id":65,"name":"其它","image_url":null},{"id":64,"name":"奶粉","image_url":null},{"id":63,"name":"奶酪","image_url":null},{"id":62,"name":"酸奶","image_url":null},{"id":61,"name":"鲜奶","image_url":null}],"description":null},{"id":7,"name":"油脂类","image_url":"http://up.boohee.cn/house/u/food_library/category/7_v1.png","sub_category_count":2,"sub_categories":[{"id":72,"name":"动物油","image_url":null},{"id":71,"name":"植物油","image_url":null}],"description":null},{"id":8,"name":"坚果类","image_url":"http://up.boohee.cn/house/u/food_library/category/8_v1.png","sub_category_count":1,"sub_categories":[{"id":81,"name":"坚果种子","image_url":null}],"description":null},{"id":9,"name":"调味品","image_url":"http://up.boohee.cn/house/u/food_library/category/9_v1.png","sub_category_count":4,"sub_categories":[{"id":94,"name":"糖和蜂蜜","image_url":null},{"id":91,"name":"调味料","image_url":null},{"id":92,"name":"调味酱","image_url":null},{"id":93,"name":"酱菜","image_url":null}],"description":null},{"id":10,"name":"饮料类","image_url":"http://up.boohee.cn/house/u/food_library/category/10_v1.png","sub_category_count":8,"sub_categories":[{"id":108,"name":"乳饮料","image_url":null},{"id":104,"name":"含糖饮料","image_url":null},{"id":107,"name":"固体饮料","image_url":null},{"id":106,"name":"无糖咖啡","image_url":null},{"id":105,"name":"无糖茶饮","image_url":null},{"id":102,"name":"碳酸饮料","image_url":null},{"id":103,"name":"纯果蔬汁饮料","image_url":null},{"id":101,"name":"酒精饮料","image_url":null}],"description":null},{"id":11,"name":"零食，点心及冷饮","image_url":"http://up.boohee.cn/house/u/food_library/category/11_v1.png","sub_category_count":3,"sub_categories":[{"id":113,"name":"冷饮","image_url":null},{"id":112,"name":"点心","image_url":null},{"id":111,"name":"零食","image_url":null}],"description":null},{"id":12,"name":"其它","image_url":"http://up.boohee.cn/house/u/food_library/category/12_v1.png","sub_category_count":2,"sub_categories":[{"id":121,"name":"药食","image_url":null},{"id":122,"name":"营养保健","image_url":null}],"description":null}]
         */

        private String kind;
        private List<CategoriesBeanDetail> categories;

        protected GroupBeanDetail(Parcel in) {
            kind = in.readString();
            categories = in.createTypedArrayList(CategoriesBeanDetail.CREATOR);
        }

        public static final Creator<GroupBeanDetail> CREATOR = new Creator<GroupBeanDetail>() {
            @Override
            public GroupBeanDetail createFromParcel(Parcel in) {
                return new GroupBeanDetail(in);
            }

            @Override
            public GroupBeanDetail[] newArray(int size) {
                return new GroupBeanDetail[size];
            }
        };

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public List<CategoriesBeanDetail> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesBeanDetail> categories) {
            this.categories = categories;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(kind);
            parcel.writeTypedList(categories);
        }

        public static class CategoriesBeanDetail implements Parcelable{
            /**
             * id : 1
             * name : 主食类
             * image_url : http://up.boohee.cn/house/u/food_library/category/1_v1.png
             * sub_category_count : 3
             * sub_categories : [{"id":13,"name":"包装谷薯","image_url":null},{"id":11,"name":"天然谷薯","image_url":null},{"id":12,"name":"谷薯制品","image_url":null}]
             * description : null
             */

            private int id;
            private String name;
            private String image_url;
            private int sub_category_count;
            private Object description;
            private List<SubCategoriesBean> sub_categories;

            protected CategoriesBeanDetail(Parcel in) {
                id = in.readInt();
                name = in.readString();
                image_url = in.readString();
                sub_category_count = in.readInt();
                sub_categories = in.createTypedArrayList(SubCategoriesBean.CREATOR);
            }

            public static final Creator<CategoriesBeanDetail> CREATOR = new Creator<CategoriesBeanDetail>() {
                @Override
                public CategoriesBeanDetail createFromParcel(Parcel in) {
                    return new CategoriesBeanDetail(in);
                }

                @Override
                public CategoriesBeanDetail[] newArray(int size) {
                    return new CategoriesBeanDetail[size];
                }
            };

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getSub_category_count() {
                return sub_category_count;
            }

            public void setSub_category_count(int sub_category_count) {
                this.sub_category_count = sub_category_count;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public List<SubCategoriesBean> getSub_categories() {
                return sub_categories;
            }

            public void setSub_categories(List<SubCategoriesBean> sub_categories) {
                this.sub_categories = sub_categories;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(id);
                parcel.writeString(name);
                parcel.writeString(image_url);
                parcel.writeInt(sub_category_count);
                parcel.writeTypedList(sub_categories);
            }

            public static class SubCategoriesBean implements Parcelable{
                /**
                 * id : 13
                 * name : 包装谷薯
                 * image_url : null
                 */

                private int id;
                private String name;
                private Object image_url;

                protected SubCategoriesBean(Parcel in) {
                    id = in.readInt();
                    name = in.readString();
                }

                public static final Creator<SubCategoriesBean> CREATOR = new Creator<SubCategoriesBean>() {
                    @Override
                    public SubCategoriesBean createFromParcel(Parcel in) {
                        return new SubCategoriesBean(in);
                    }

                    @Override
                    public SubCategoriesBean[] newArray(int size) {
                        return new SubCategoriesBean[size];
                    }
                };

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getImage_url() {
                    return image_url;
                }

                public void setImage_url(Object image_url) {
                    this.image_url = image_url;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeInt(id);
                    parcel.writeString(name);
                }
            }
        }
    }
}
