package com.java1234.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.*;
import com.java1234.service.DepartmentService;
import com.java1234.service.FileService;
import com.java1234.service.JobService;
import com.java1234.service.NoticeService;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2020-05-14 23:16:13
 */
@Controller
@RequestMapping("/file")
public class FileController {
    /**
     * 服务对象
     */
    @Resource
    private FileService fileService;


    @RequestMapping("/index/{pageNum}")
    public ModelAndView index(@PathVariable("pageNum") Integer pageNum, File f){
        Page px=new Page(); px.setPageNum(pageNum);px.setPageSize(2);
        f.setState(1);
        PageInfo p=fileService.queryAllByLimit(px,f);
        ModelAndView modelAndView=new ModelAndView("file");
        List<Notice> list=p.getList();
        System.out.println("why"+p);
        modelAndView.addObject("f",f);
        modelAndView.addObject("list",list);
        modelAndView.addObject("p",p);
        return modelAndView;
    }
    @RequestMapping("/selectone/{n_id}")
    @ResponseBody
    public File selectone(@PathVariable("n_id") Integer n_id){
        return  fileService.queryById(n_id);
    }

    @RequestMapping("/add")
    public  String add( @RequestParam("file") MultipartFile file, File d,HttpServletRequest req,HttpSession session){
        System.out.println("进入添加文件");
        System.out.println(file);
        d.setState(1);
        Admin a=(Admin) session.getAttribute("admin");
        d.setA_id(a.getA_id());
        if(file!=null&&!file.isEmpty()){
            String oldname=file.getOriginalFilename();//文件后缀
            String newname= UUID.randomUUID().toString()+oldname.substring(oldname.lastIndexOf("."));//新的文件名
            java.io.File folder=new java.io.File(req.getServletContext().getRealPath("/file"));
            if (!folder.exists()) {
                folder.mkdirs();
            }
            try{
                //transferTo方法写入
                file.transferTo(new java.io.File(folder,newname));//File（文件夹，文件名）
                d.setLu("/file/"+newname);

            }catch (Exception e){
                return "forward:/file/index/1";
            }
        }

        fileService.insert(d);
        return "forward:/file/index/1";
    }
    @RequestMapping("/update")
    public  String update(File d, MultipartFile file, HttpServletRequest req){
        if(file!=null&&!file.isEmpty()){
            String oldname=file.getOriginalFilename();//文件后缀
            String newname= UUID.randomUUID().toString()+oldname.substring(oldname.lastIndexOf("."));//新的文件名
            java.io.File folder=new java.io.File(req.getServletContext().getRealPath("/file"));
            if (!folder.exists()) {
                folder.mkdirs();
            }
            try{
                //transferTo方法写入
                file.transferTo(new java.io.File(folder,newname));//File（文件夹，文件名）
                d.setLu("/file/"+newname);

            }catch (Exception e){
                return "forward:/file/index/1";
            }
        }

        fileService.update(d);
        return "forward:/file/index/1";
    }
    @RequestMapping("/delete/{f_id}")
    @ResponseBody
    public String de(@PathVariable("f_id")Integer f_id){
        File f=new File();
        f.setF_id(f_id);
        f.setState(0);
        if(fileService.update(f)!=null){
            return "1";
        }
        return "0";
    }

    /*下载*/
    @RequestMapping("/down/{f_id}")
    public void down(HttpServletRequest request, HttpServletResponse response,@PathVariable("f_id") Integer f_id) throws IOException {
        System.out.println("开始下载");
        //通过文件id查询文件
        File fx=fileService.queryById(f_id);
        if (fx==null)return;
        //获取文件名
        String filename=fx.getLu();
        response.reset();
        //获取下载文件类型
        response.setContentType(request.getServletContext().getMimeType(filename));
        //3.告诉客户端文件不是以文件形式打开 而是以附件形式下载
        response.setHeader("content-disposition", "attachment;filename="+ filename);
        //4获取文件的绝对路径
        String path=request.getServletContext().getRealPath("/"+filename);
        System.out.println(path);
        FileInputStream in=new FileInputStream(path);
        ServletOutputStream out=response.getOutputStream();
        byte[] b=new byte[1024];
        while(in.read(b)!=-1) {
            out.write(b);
        }
        in.close();

    }

}