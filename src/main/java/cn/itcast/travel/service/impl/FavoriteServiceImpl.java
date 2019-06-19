package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(rid, uid);
    }

    @Override
    public boolean isFavorite(String rid, int uid) {
        return favoriteDao.isFavorite(Integer.parseInt(rid), uid) != null;
    }
}
