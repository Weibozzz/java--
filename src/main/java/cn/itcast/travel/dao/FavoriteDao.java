package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {
    void add(String rid, int uid);

    Favorite isFavorite(int rid, int uid);
}
