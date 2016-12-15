package com.pei.foodpie.dbtool;

import com.pei.foodpie.volleysingleton.MyApp;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import static android.R.id.list;

/**
 * Created by dllo on 16/12/13.
 */

public class DBTool {
    private static DBTool ourInstance = new DBTool();
    private static CollectionBeanDao collectionBeanDao;
    private static SearchDataDao searchDataDao;


    // 对外提供getInstance方法获取本类的单例对象
    public static DBTool getInstance() {


        if (ourInstance == null) {
            synchronized (DBTool.class) {
                if (ourInstance == null) {
                    ourInstance = new DBTool();
                }
            }
        }
        collectionBeanDao = MyApp.getDaoSession().getCollectionBeanDao();
        searchDataDao = MyApp.getDaoSession().getSearchDataDao();
        return ourInstance;
    }

    private DBTool() {

    }

//    public void insertSearchData(SearchData searchData){
//        searchDataDao.insert(searchData);
//    }
    public List<SearchData> querySearchData(){
        List<SearchData> list = searchDataDao.loadAll();
        return list ;
    }

    // 增加单一对象的方法
    public void insertCollectionBean(CollectionBean CollectionBean) {
        collectionBeanDao.insert(CollectionBean);
    }

    // 增加集合的方法
    public void insertList(List<CollectionBean> list) {
        collectionBeanDao.insertInTx(list);
    }

    // 删除单一对象
    public void deleteCollectionBean(CollectionBean CollectionBean) {
        collectionBeanDao.delete(CollectionBean);
    }

    // 删除所有
    public void deleteAll() {
        collectionBeanDao.deleteAll();
    }

    // 根据id进行删除
    public void deleteById(Long id) {
        collectionBeanDao.deleteByKey(id);
    }

    // 根据某一字段进行删除
    public void deleteByTitle(String title) {
        DeleteQuery<CollectionBean> deleteQuery =
                collectionBeanDao.queryBuilder().where
                        (CollectionBeanDao.Properties.Title.eq(title)).buildDelete();
        deleteQuery.executeDeleteWithoutDetachingEntities();
    }

    public void deleteBy(String title) {
        DeleteQuery<CollectionBean> deleteQuery = collectionBeanDao.queryBuilder().where
                (CollectionBeanDao.Properties.Title.eq(title)).buildDelete();

        if (deleteQuery != null) {
            deleteQuery.executeDeleteWithoutDetachingEntities();
        }
    }

    public void deleteByUrl(String url) {
        DeleteQuery<CollectionBean> deleteQuery = collectionBeanDao.queryBuilder().where
                (CollectionBeanDao.Properties.Url.eq(url)).buildDelete();

        if (deleteQuery != null) {
            deleteQuery.executeDeleteWithoutDetachingEntities();
        }
    }


    // 查询所有的方法
    public List<CollectionBean> queryAll(){
        // 查询方法1
        List<CollectionBean> list = collectionBeanDao.loadAll();
        // 查寻方法2
        List<CollectionBean> CollectionBeans = collectionBeanDao.queryBuilder().list();
        return list;
    }
    // 查重方法
    public boolean isSava(String url){
        QueryBuilder<CollectionBean> queryBuilder =
                collectionBeanDao.queryBuilder().where(CollectionBeanDao.Properties.Url.eq(url));

        // 获取到我们要查询内容的size
        Long size = queryBuilder.buildCount().count();
        return size > 0 ? true : false;
    }

    public boolean isSava(String url,String title){
        QueryBuilder<CollectionBean> queryBuilder =
                collectionBeanDao.queryBuilder().where(CollectionBeanDao.Properties.Url.eq(url),CollectionBeanDao
                .Properties.Title.eq(title));

        // 获取到我们要查询内容的size
        Long size = queryBuilder.buildCount().count();
        return size > 0 ? true : false;
    }

    public boolean isSavaUrl(String url){
        QueryBuilder<CollectionBean> queryBuilder =
                collectionBeanDao.queryBuilder().where(CollectionBeanDao.Properties.Url.eq(url));
        // 获取到我们要查询内容的size
        Long size = queryBuilder.buildCount().count();
        return size > 0 ? true : false;
    }


    public boolean isSavaTitle(String title){
        QueryBuilder<CollectionBean> queryBuilder =
                collectionBeanDao.queryBuilder().where(CollectionBeanDao.Properties.Title.eq(title));
        // 获取到我们要查询内容的size
        Long size = queryBuilder.buildCount().count();
        return size > 0 ? true : false;
    }



    public boolean isSave(CollectionBean CollectionBean){
        QueryBuilder<CollectionBean> queryBuilder =
                collectionBeanDao.queryBuilder().where(CollectionBeanDao.Properties.Title.eq(CollectionBean.getTitle()));


        Long size = queryBuilder.buildCount().count();
        return size > 0 ? true : false ;
    }
}
