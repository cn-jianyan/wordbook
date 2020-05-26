package com.java1234.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.File;
import com.java1234.dao.FileDao;
import com.java1234.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (File)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 23:17:44
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    @Resource
    private FileDao fileDao;

    /**
     * 通过ID查询单条数据
     *
     * @param f_id 主键
     * @return 实例对象
     */
    @Override
    public File queryById(Integer f_id) {
        return this.fileDao.queryById(f_id);
    }

    /**
     * 查询多条数据
     *
     *
     * @return 对象列表
     */
    @Override
    public PageInfo queryAllByLimit(Page p, File f) {
        PageHelper.startPage(p.getPageNum(),p.getPageSize());
        List<File> list=fileDao.queryAll(f);
        PageInfo pageInfo=new PageInfo(list);
        return  pageInfo;

    }

    @Override
    public List<File> quaeyAll(File f) {
        return fileDao.queryAll(f);
    }

    /**
     * 新增数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    @Override
    public File insert(File file) {
        this.fileDao.insert(file);
        return file;
    }

    /**
     * 修改数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    @Override
    public File update(File file) {
        this.fileDao.update(file);
        return this.queryById(file.getF_id());
    }

    /**
     * 通过主键删除数据
     *
     * @param f_id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer f_id) {
        return this.fileDao.deleteById(f_id) > 0;
    }
}