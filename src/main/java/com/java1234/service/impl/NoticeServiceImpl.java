package com.java1234.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java1234.entity.Notice;
import com.java1234.dao.NoticeDao;
import com.java1234.service.NoticeService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 23:19:19
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param n_id 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer n_id) {
        return this.noticeDao.queryById(n_id);
    }

    @Override
    public PageInfo queryAllByLimit(Page p, Notice n) {
        PageHelper.startPage(p.getPageNum(),p.getPageSize());
        List<Notice> list=noticeDao.queryAll(n);
        PageInfo pageInfo=new PageInfo(list);
        pageInfo.setList(list);
        return  pageInfo;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeDao.insert(notice);
        return notice;
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeDao.update(notice);
        return this.queryById(notice.getN_id());
    }

    /**
     * 通过主键删除数据
     *
     * @param n_id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer n_id) {
        return this.noticeDao.deleteById(n_id) > 0;
    }
}