package com.rq;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.proxy.UserDAO;
import com.proxy.UserDAOFactory;
import com.proxy.UserDAOFactory2;
import com.proxy.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by raoqi on 16/9/25.
 */
@WebServlet(name = "HelloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());


        Person person = (Person)applicationContext.getBean("person") ;
        response.getWriter().write(person.toString());

        UserDAO userDAO1 = (UserDAO) UserDAOFactory.getProxyInstance(new UserDAOImpl());
        userDAO1.hello();


        UserDAOFactory2 factory = new UserDAOFactory2(new UserDAOImpl());
        UserDAOImpl userDAO2 = (UserDAOImpl) factory.getProxyInstance();
        userDAO2.goodbye();

    }
}
