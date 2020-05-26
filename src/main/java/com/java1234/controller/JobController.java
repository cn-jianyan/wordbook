package com.java1234.controller;

import com.java1234.entity.Department;
import com.java1234.entity.Job;
import com.java1234.service.DepartmentService;
import com.java1234.service.JobService;
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
@RequestMapping("/job")
public class JobController {
    /**
     * 服务对象
     */
    @Resource
    private JobService jobService;

    @RequestMapping("/index")
    public String index(ModelMap m){
        m.addAttribute("list",jobService.queryAll(new Job()));
        return "job";
    }
    @RequestMapping("/selectone/{j_id}")
    @ResponseBody
    public Job selectone(@PathVariable("j_id") Integer j_id){
        return  jobService.queryById(j_id);
    }

    @RequestMapping("/add")
    public  String add(Job d){
        jobService.insert(d);
        return "forward:/job/index";
    }
    @RequestMapping("/update")
    public  String update(Job d){
        jobService.update(d);
        return "forward:/job/index";
    }
    @RequestMapping("/delete/{j_id}")
    @ResponseBody
    public String de(@PathVariable("j_id")Integer d_id){
        if(jobService.deleteById(d_id)){
            return "1";
        }
        return "0";
    }
}