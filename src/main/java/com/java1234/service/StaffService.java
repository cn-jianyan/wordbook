package com.java1234.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.Staff;
import java.util.List;

/**
 * (Staff)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 23:20:03
 */
public interface StaffService {

    /**
     * 通过ID查询单条数据
     *
     * @param s_id 主键
     * @return 实例对象
     */
    Staff queryById(Integer s_id);

    /**
     * 查询多条数据

     * @return 对象列表
     */
    PageInfo queryAllByLimit(Page p, Staff s);

    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    Staff insert(Staff staff);

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    Staff update(Staff staff);

    /**
     * 通过主键删除数据
     *
     * @param s_id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer s_id);

}