package com.java1234.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.Notice;


import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 23:19:19
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param n_id 主键
     * @return 实例对象
     */
    Notice queryById(Integer n_id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageInfo queryAllByLimit(Page p, Notice n);


    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param n_id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer n_id);

}