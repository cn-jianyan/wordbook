package com.java1234.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.Admin;
import com.java1234.dao.AdminDao;
import com.java1234.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 23:13:51
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param a_id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer a_id) {
        return this.adminDao.queryById(a_id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public PageInfo queryAllByLimit(PageInfo p,Admin a) {
        PageHelper.startPage(p.getPageNum(),p.getPageSize());
        List<Admin> list= this.adminDao.queryAll(a);
        PageInfo page=new PageInfo(list);
        return  page;
    }

    @Override
    public List<Admin> queryAllByAll(Admin a) {
        return adminDao.queryAll(a);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
       adminDao.update(admin);
        return adminDao.queryById(admin.getA_id());
    }

    /**
     * 通过主键删除数据
     *
     * @param a_id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer a_id) {
        return this.adminDao.deleteById(a_id) > 0;
    }
}