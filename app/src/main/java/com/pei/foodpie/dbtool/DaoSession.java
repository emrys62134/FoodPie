package com.pei.foodpie.dbtool;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.pei.foodpie.dbtool.CollectionBean;
import com.pei.foodpie.dbtool.SearchData;

import com.pei.foodpie.dbtool.CollectionBeanDao;
import com.pei.foodpie.dbtool.SearchDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig collectionBeanDaoConfig;
    private final DaoConfig searchDataDaoConfig;

    private final CollectionBeanDao collectionBeanDao;
    private final SearchDataDao searchDataDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        collectionBeanDaoConfig = daoConfigMap.get(CollectionBeanDao.class).clone();
        collectionBeanDaoConfig.initIdentityScope(type);

        searchDataDaoConfig = daoConfigMap.get(SearchDataDao.class).clone();
        searchDataDaoConfig.initIdentityScope(type);

        collectionBeanDao = new CollectionBeanDao(collectionBeanDaoConfig, this);
        searchDataDao = new SearchDataDao(searchDataDaoConfig, this);

        registerDao(CollectionBean.class, collectionBeanDao);
        registerDao(SearchData.class, searchDataDao);
    }
    
    public void clear() {
        collectionBeanDaoConfig.clearIdentityScope();
        searchDataDaoConfig.clearIdentityScope();
    }

    public CollectionBeanDao getCollectionBeanDao() {
        return collectionBeanDao;
    }

    public SearchDataDao getSearchDataDao() {
        return searchDataDao;
    }

}