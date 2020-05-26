package com.java1234.service.impl;

import com.java1234.entity.Job;
import com.java1234.dao.JobDao;
import com.java1234.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Job)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 23:19:05
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
    @Resource
    private JobDao jobDao;

    /**
     * 通过ID查询单条数据
     *
     * @param j_id 主键
     * @return 实例对象
     */
    @Override
    public Job queryById(Integer j_id) {
        return this.jobDao.queryById(j_id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Job> queryAllByLimit(int offset, int limit) {
        return this.jobDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Job> queryAll(Job j) {
        return jobDao.queryAll(j);
    }

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public Job insert(Job job) {
        this.jobDao.insert(job);
        return job;
    }

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public Job update(Job job) {
        this.jobDao.update(job);
        return this.queryById(job.getJ_id());
    }

    /**
     * 通过主键删除数据
     *
     * @param j_id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer j_id) {
        return this.jobDao.deleteById(j_id) > 0;
    }
}