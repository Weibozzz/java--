package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void add(String rid, int uid) {
        String sql = "insert into tab_favorite values(?,?,?)";
        System.out.println("add:rid:uid:"+rid+uid);
        template.update(sql,rid,new Date(),uid); // 更新用戶收藏的线路
        String updateSql = "update tab_route set count = count + 1 where rid = ?";
        template.update(updateSql,rid);// 更新收藏的线路
    }

    @Override
    public Favorite isFavorite(int rid, int uid) {
        Favorite favorite = null;
        try {
            String sql = "select * from tab_favorite where rid = ? and uid = ?";
            favorite = template.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),rid,uid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return favorite;
    }
}
