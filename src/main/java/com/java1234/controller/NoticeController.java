package com.java1234.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.Department;
import com.java1234.entity.Job;
import com.java1234.entity.Notice;
import com.java1234.entity.Staff;
import com.java1234.service.DepartmentService;
import com.java1234.service.JobService;
import com.java1234.service.NoticeService;
import com.java1234.service.StaffService;
import org.aspectj.weaver.ast.Not;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2020-05-14 23:16:13
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private StaffService staffService;
    @Resource
    private JobService jobService;
    @Resource
    private  DepartmentService departmentService;


    @RequestMapping("/index/{pageNum}")
    public ModelAndView index(@PathVariable("pageNum") Integer pageNum,Notice notice){
        Page px=new Page(); px.setPageNum(pageNum);px.setPageSize(1);
        PageInfo p=noticeService.queryAllByLimit(px,notice);
        ModelAndView modelAndView=new ModelAndView("notice");
        List<Notice> list=p.getList();
        System.out.println("why"+p);
        modelAndView.addObject("list",list);
        modelAndView.addObject("p",p);
        return modelAndView;
    }
    @RequestMapping("/selectone/{n_id}")
    @ResponseBody
    public Notice selectone(@PathVariable("n_id") Integer n_id){
        return  noticeService.queryById(n_id);
    }

    @RequestMapping("/add")
    public  String add(Notice d){
        noticeService.insert(d);
        return "forward:/notice/index/1";
    }
    @RequestMapping("/update")
    public  String update(Notice d){
        noticeService.update(d);
        return "forward:/notice/index/1";
    }
    @RequestMapping("/delete/{n_id}")
    @ResponseBody
    public String de(@PathVariable("n_id")Integer d_id){
        if(noticeService.deleteById(d_id)){
            return "1";
        }
        return "0";
    }

    /*
    * 邮件发送
    * */
    @RequestMapping("/sendmail/{n_id}")
    public String mail(@RequestParam("email") List<String> email,@PathVariable("n_id") Integer n_id) throws MessagingException {


      Notice n=noticeService.queryById(n_id);

        MimeMessage message=javaMailSender.createMimeMessage();

        MimeMessageHelper helper=new MimeMessageHelper(message);
        //发送方  这个要和properties中的一致
        helper.setFrom("1935751864@qq.com");
        //接受方
        helper.setTo("645879124@qq.com");

        //主题
        helper.setSubject(n.getN_name());
        //邮件内容
        helper.setText(n.getContent());

      email.forEach((i)->{
          try {
              System.out.println(i+":"+n);
              helper.setTo(i);
              javaMailSender.send(message);
              System.out.println("邮件发送成功");
          } catch (MessagingException e) {
              e.printStackTrace();
          }
      });

        return "forward:/notice/index/1";
    }

    @RequestMapping("/mail/{pageNum}")
    public ModelAndView mailindex(@PathVariable("pageNum") Integer pageNum, Staff staff,Integer n_id){
//        System.out.println("分页："+staff);
        Page px=new Page(); px.setPageNum(pageNum);px.setPageSize(1);
        PageInfo p=staffService.queryAllByLimit(px,staff);
        ModelAndView modelAndView=new ModelAndView("sendmail");
        List<Notice> list=p.getList();
//        System.out.println(list);
//        System.out.println("why"+p);
        modelAndView.addObject("n_id",n_id);
        modelAndView.addObject("job",jobService.queryAll(new Job()));
        modelAndView.addObject("dept",departmentService.queryAll(new Department() ));
        modelAndView.addObject("staff",staff);
        modelAndView.addObject("list",list);
        modelAndView.addObject("p",p);
        return modelAndView;
    }
}