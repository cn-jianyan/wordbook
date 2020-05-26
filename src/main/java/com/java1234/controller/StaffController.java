package com.java1234.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.Department;
import com.java1234.entity.Job;
import com.java1234.entity.Notice;
import com.java1234.entity.Staff;
import com.java1234.service.DepartmentService;
import com.java1234.service.JobService;
import com.java1234.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Staff)表控制层
 *
 * @author makejava
 * @since 2020-05-14 23:20:03
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
    /**
     * 服务对象
     */
    @Resource
    private StaffService staffService;
    @Resource
    private JobService jobService;
    @Resource
    private DepartmentService departmentService;


    @RequestMapping("/index/{pageNum}")
    public ModelAndView index(@PathVariable("pageNum") Integer pageNum, Staff staff){
        System.out.println("分页："+staff);
        Page px=new Page(); px.setPageNum(pageNum);px.setPageSize(1);
        PageInfo p=staffService.queryAllByLimit(px,staff);
        ModelAndView modelAndView=new ModelAndView("staff");
        List<Notice> list=p.getList();
        System.out.println(list);
        System.out.println("why"+p);
        modelAndView.addObject("job",jobService.queryAll(new Job()));
        modelAndView.addObject("dept",departmentService.queryAll(new Department() ));
        modelAndView.addObject("staff",staff);
        modelAndView.addObject("list",list);
        modelAndView.addObject("p",p);
        return modelAndView;
    }
    @RequestMapping("/selectone/{n_id}")
    @ResponseBody
    public Staff selectone(@PathVariable("n_id") Integer n_id){
        return  staffService.queryById(n_id);
    }

    @RequestMapping("/add")
    public  String add(Staff d){
        staffService.insert(d);
        return "redirect:/staff/index/1";
    }
    @RequestMapping("/update")
    public  String update(Staff d){
        staffService.update(d);
        System.out.println("修改"+d);
        return "redirect:/staff/index/1";
    }
    @RequestMapping("/delete/{n_id}")
    @ResponseBody
    public String de(@PathVariable("n_id")Integer d_id){
        if(staffService.deleteById(d_id)){
            return "1";
        }
        return "0";
    }
}