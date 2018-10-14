package com.springboot.controller;

import com.springboot.entity.UserInfo;
import com.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xfgeng on 2018/10/11.
 */
@Controller
public class UserInfoControl {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/home")
    public String home(HttpServletRequest request){
        List<UserInfo> list = userInfoService.selectAll();
        System.out.println("count:"+list.size());
        request.setAttribute("userInfos",list);
        return "index";
    }

    @RequestMapping("/insert")
    public void insert(UserInfo userInfo){
        userInfoService.insert(userInfo);
    }
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id")  int id){
        userInfoService.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    public String update(HttpServletRequest request,UserInfo userInfo){
        userInfoService.updateByPrimaryKey(userInfo);
        return home(request);
    }
    @RequestMapping("/select/{id}")
    public String select(@PathVariable("id") int id,HttpServletRequest request){
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        request.setAttribute("userInfo",userInfo);
        return "edit";
    }
    @RequestMapping("/selectAll")
    public List<UserInfo> selectAll(){
        return userInfoService.selectAll();
    }

}
