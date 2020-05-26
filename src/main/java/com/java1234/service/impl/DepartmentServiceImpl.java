package com.java1234.service.impl;

import com.java1234.entity.Department;
import com.java1234.dao.DepartmentDao;
import com.java1234.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 23:16:13
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param d_id 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer d_id) {
        return this.departmentDao.queryById(d_id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Department> queryAllByLimit(int offset, int limit) {
        return this.departmentDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Department> queryAll(Department d) {
        return departmentDao.queryAll(d);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentDao.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentDao.update(department);
        return this.queryById(department.getD_id());
    }

    /**
     * 通过主键删除数据
     *
     * @param d_id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer d_id) {
        return this.departmentDao.deleteById(d_id) > 0;
    }
}