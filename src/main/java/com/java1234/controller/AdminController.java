package com.java1234.controller;

import com.github.pagehelper.PageInfo;
import com.java1234.entity.Admin;
import com.java1234.entity.Power;
import com.java1234.entity.Role;
import com.java1234.service.AdminService;
import com.java1234.service.HasPowerService;
import com.java1234.service.PowerService;
import com.java1234.service.RoleService;
import com.java1234.util.MyHas;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-05-14 23:13:52
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;
    @Resource
    private RoleService r;
    @Resource
    private PowerService p;
    @Resource
    private HasPowerService has;

    @PostMapping("/sign")
    @ResponseBody
    public  String sign(Admin admin, HttpSession session){
//            System.out.println(admin);

        /*List<Admin> list=adminService.queryAllByAll(admin);

        if (list==null||list.size()==0)return "0";

        else{
            Admin a=list.get(0);
            session.setAttribute("admin",a);
            return "1";
        }*/
        UsernamePasswordToken token=new UsernamePasswordToken(admin.getA_user(),admin.getPwd());
//        System.out.println(token.getPassword());
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(token);
            session.setAttribute("admin",adminService.queryAllByAll(admin).get(0));
            return "1";
        }catch (Exception e){

            e.printStackTrace();
            subject.logout();
            return "0";
        }

    }
    @RequestMapping ("/index")
    public String index(Model m){
       List li= adminService.queryAllByAll(new Admin());
//       System.out.println(li);
       m.addAttribute("list",li);
       return "admin";
    }
    @RequestMapping("/add")
    public String add(Admin a){
//        System.out.println(a);
//        System.out.println("admin/add");
        if(a!=null)adminService.insert(a);
        return "forward:/admin/index";
    }
    @RequestMapping (value = "/update")
    public String update(Admin a){
        System.out.println(a);
        if(a!=null)adminService.update(a);

        return "forward:/admin/index";
    }
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(Integer a_id){
        if(adminService.deleteById(a_id)){
            return "1";
        }
        else return "0";
    }
    @RequestMapping ("/selectone/{a_id}")
    @ResponseBody
    public Admin selectone(@PathVariable("a_id") Integer a_id){
        return adminService.queryById(a_id);
    }




    @RequestMapping("/power/{a_id}/{a_user}")
    public ModelAndView power(@PathVariable("a_id") Integer a_id, @PathVariable("a_user")String a_user){
//       System.out.println(a_user);
        ModelAndView mv=new ModelAndView("power");
        List<Role> role=r.queryAll();
        List<Power>power=p.queryAll();
        Set hasRole=has.queryRname(a_user);
//        System.out.println(hasRole);
        Set hasPower=has.queryPower(a_user);
        role.forEach((i)->{
            if(hasRole.contains(i.getRname())){
                i.setChecked(true);
            };
        });
//        System.out.println();
        power.forEach((i)->{

            if(hasPower.contains(i.getHas())){

                i.setChecked(true);
            };
        });
//        mv.addObject("hasr",hasRole);
//        mv.addObject("hasp",hasPower);
        mv.addObject("a_id",a_id);
        mv.addObject("role",role);
        mv.addObject("power",power);
        return  mv;
    }

    @RequestMapping("/addpower")
    public  String addpower(MyHas h){
        System.out.println(h.getP());
        System.out.println(h.getR());
        System.out.println(h.getAid());
      if(h.getP()!=null&&h.getP().size()>0){
          has.insertpower(h.getP(),h.getAid());
      }
        if(h.getR()!=null&&h.getR().size()>0){
            has.insertrole(h.getR(),h.getAid());
        }

        return "redirect:/admin/index";
    }





}