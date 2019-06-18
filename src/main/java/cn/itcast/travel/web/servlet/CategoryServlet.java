package cn.itcast.travel.web.servlet;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.ResultInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao service = new CategoryDaoImpl();
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        info.setData(service.findAll());
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(), info);
        writeValue(info,response);
    }
}
