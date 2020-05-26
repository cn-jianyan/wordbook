package com.java1234.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.Staff;
import com.java1234.dao.StaffDao;
import com.java1234.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Staff)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 23:20:03
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param s_id 主键
     * @return 实例对象
     */
    @Override
    public Staff queryById(Integer s_id) {
        return this.staffDao.queryById(s_id);
    }

    @Override
    public PageInfo queryAllByLimit(Page p, Staff s) {
        PageHelper.startPage(p.getPageNum(),p.getPageSize());
        List list= staffDao.queryAll(s);
        PageInfo pageInfo=new PageInfo(list);
        return  pageInfo;
    }


    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    @Override
    public Staff insert(Staff staff) {
        this.staffDao.insert(staff);
        return staff;
    }

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    @Override
    public Staff update(Staff staff) {
        this.staffDao.update(staff);
        return this.queryById(staff.getS_id());
    }

    /**
     * 通过主键删除数据
     *
     * @param s_id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer s_id) {
        return this.staffDao.deleteById(s_id) > 0;
    }
}