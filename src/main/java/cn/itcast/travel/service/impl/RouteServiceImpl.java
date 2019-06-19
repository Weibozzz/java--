package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname) {
        // 1.封装PageBean
        PageBean<Route> pb = new PageBean<Route>();
        // 设置当前页
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        // 设置总记录数
        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * pageSize;
        pb.setList(routeDao.findByPage(cid,start,pageSize,rname));
        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public Route findOne(String rid) {
        //1.根据id去route表中查询route对象
        Route route = routeDao.findOne(Integer.parseInt(rid));
        //2.根据route的id 查询图片集合信息
        List<RouteImg> routeImgList = routeDao.findByRid(route.getRid());
        route.setRouteImgList(routeImgList);
        //3.根据route的sid（商家id）查询商家对象
        Seller seller = routeDao.findById(route.getSid());
        route.setSeller(seller);
        //4. 查询收藏次数
        int count = routeDao.findCountByRid(route.getRid());
        route.setCount(count);
        return route;
    }
}
