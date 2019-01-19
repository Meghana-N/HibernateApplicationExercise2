package com.stackroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Controller
public class HomeController {
    User user = new User();

    @RequestMapping(value = "/")
    public String userInfo(){
        return "index";
    }

    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
    {
        Connection con;
        int status;

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here User is database name, user is username and root123 is password
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User","user","root123");
            //create statement object
            System.out.println("got connected");

            Statement st=con.createStatement();

            status=st.executeUpdate("insert into UserInfo(username,password)values('"+username+"','"+password+"')");

            System.out.println("data updated");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        String message = "Welcome to Stackroute " + username;

        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("display");
        modelView.addObject("result",message);
        return modelView;

    }
}
