package cn.itcast.travel.service;

public interface FavoriteService {
    void add(String rid, int uid);

    boolean isFavorite(String rid, int uid);
}
