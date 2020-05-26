import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.java1234.dao.*;
import com.java1234.entity.*;
import com.java1234.service.AdminService;
import com.java1234.service.HasPowerService;
import com.java1234.service.NoticeService;

import com.java1234.util.emil.MailSenderInfo;
import com.java1234.util.emil.SimpleMailSender;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.*;

public class Myjunit {
   @Test
    public void h1(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
       StaffDao st=ioc.getBean(StaffDao.class);
       System.out.println(st.queryAll(new Staff()));
       System.out.println(ioc.getBean(AdminDao.class).queryAll(new Admin()));
       System.out.println(ioc.getBean(DepartmentDao.class).queryAll(new Department()));
       System.out.println(ioc.getBean(JobDao.class).queryAll(new Job()));
       System.out.println(ioc.getBean(NoticeDao.class).queryAll(new Notice()));
   }
    @Test
    public void h2(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        NoticeDao dao=ioc.getBean(NoticeDao.class);
        System.out.println(dao.queryAll(new Notice()));
    }
    @Test
    public void h3(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        JobDao dao=ioc.getBean(JobDao.class);
        System.out.println(dao.queryAll(new Job()));
    }
    @Test
    public void h4(){
//        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
//        FileDao dao=ioc.getBean(FileDao.class);
//        System.out.println(dao.queryAll(new File()));
    }
    @Test
    public void h5(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        DepartmentDao dao=ioc.getBean(DepartmentDao.class);
        System.out.println(dao.queryAll(new Department()));
    }
    @Test
    public void h6(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
       AdminService dao=ioc.getBean(AdminService.class);
       Admin a=new Admin();
       a.setPwd("123456");a.setA_id(1);a.setA_name("葬送");
       a.setState(1);
       try{
           dao.update(a);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    @Test
    public void h7(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminDao dao=ioc.getBean(AdminDao.class);
        Admin a=new Admin();
        a.setPwd("123456");a.setA_id(1);a.setA_name("葬送");
        a.setState(1);
        try{
            dao.update(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void x1(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        NoticeService nc=ioc.getBean(NoticeService.class);
        Page p=new Page(); p.setPageNum(1);p.setPageSize(5);
        PageInfo pageInfo=nc.queryAllByLimit(p,new Notice());
        System.out.println(pageInfo.getList());


    }
    @Test
    public  void x2(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        HasPowerService dao=ioc.getBean(HasPowerService.class);
        Set set=dao.queryRole("root");
        System.out.println(set.toString());
        set.forEach((i)->{
            System.out.println(i);
        });


    }

    @Test
    public void x3(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminService ad=ioc.getBean(AdminService.class);
        Admin a=new Admin(); a.setA_user("tom"); a.setPwd("55555");
        System.out.println(ad.queryAllByAll(a).get(0));
    }
    @Test
    public void x5(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        HasPowerDao dao=ioc.getBean(HasPowerDao.class);
        System.out.println(dao.queryRoleRname("root"));
    }

    @Test
    public void mail(){
        MailSenderInfo mailSenderInfo=new MailSenderInfo();//邮件信息类
        mailSenderInfo.setMailServerHost("smtp.qq.com");//主机地址
        mailSenderInfo.setMailServerPort("25");//主机端口

        mailSenderInfo.setUsername("1935751864");//邮箱账号
        mailSenderInfo.setPassword("zttctnndsqjcdiha");//邮箱的授权码
        mailSenderInfo.setFromAddresss("1935751864@qq.com");

        //接受者信息
        mailSenderInfo.setToAddrss("645879124@qq.com");//收件地址
        mailSenderInfo.setTitle("java实现邮件发送");//邮件主题
        mailSenderInfo.setContent("在吗，在干嘛，吃了吗，吃了什么，好吃吗.....");

        //创建核心类
        SimpleMailSender sms=new SimpleMailSender();//核心类
        sms.sendHtmlMail(mailSenderInfo);


    }
    @Test
    public void springmail() throws MessagingException {
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-config.xml");
        JavaMailSender javaMailSender=ioc.getBean(JavaMailSender.class);

        MimeMessage message=javaMailSender.createMimeMessage();

        MimeMessageHelper helper=new MimeMessageHelper(message);
        //发送方  这个要和properties中的一致
        helper.setFrom("1935751864@qq.com");
        //接受方
        helper.setTo("645879124@qq.com");

        //主题
        helper.setSubject("java发送邮件");
        //邮件内容
        helper.setText("spring自带的邮箱发送工具");

        javaMailSender.send(message);
    }




}
