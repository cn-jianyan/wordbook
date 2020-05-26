package com.java1234.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.Admin;
import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 23:13:49
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param a_id 主键
     * @return 实例对象
     */
    Admin queryById(Integer a_id);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    PageInfo queryAllByLimit(PageInfo p,Admin a);
    List<Admin> queryAllByAll(Admin a);
    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param a_id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer a_id);

}