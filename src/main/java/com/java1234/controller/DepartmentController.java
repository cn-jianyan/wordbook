package com.java1234.controller;

import com.java1234.entity.Department;
import com.java1234.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2020-05-14 23:16:13
 */
@Controller
@RequestMapping("/dept")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/index")
    public String index(ModelMap m){
        m.addAttribute("list",departmentService.queryAll(new Department()));
        return "dept";
    }
    @RequestMapping("/selectone/{d_id}")
    @ResponseBody
    public Department selectone(@PathVariable("d_id") Integer d_id){
        return  departmentService.queryById(d_id);
    }

    @RequestMapping("/add")
    public  String add(Department d){
        departmentService.insert(d);
        return "forward:/dept/index";
    }
    @RequestMapping("/update")
    public  String update(Department d){
        departmentService.update(d);
        return "forward:/dept/index";
    }
    @RequestMapping("/delete/{d_id}")
    @ResponseBody
    public String de(@PathVariable("d_id")Integer d_id){
        if(departmentService.deleteById(d_id)){
            return "1";
        }
        return "0";
    }
}