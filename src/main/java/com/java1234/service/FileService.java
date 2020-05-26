package com.java1234.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.File;


import java.util.List;

/**
 * (File)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 23:17:44
 */
public interface FileService {

    /**
     * 通过ID查询单条数据
     *
     * @param f_id 主键
     * @return 实例对象
     */
    File queryById(Integer f_id);

    /**
     * 查询多条数据

     * @return 对象列表
     */
    PageInfo queryAllByLimit(Page p, File f);
    List<File> quaeyAll(File f);
    /**
     * 新增数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    File insert(File file);

    /**
     * 修改数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    File update(File file);

    /**
     * 通过主键删除数据
     *
     * @param f_id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer f_id);

}