package com.java1234.dao;

import com.java1234.entity.Department;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-14 23:16:13
 */
public interface DepartmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param d_id 主键
     * @return 实例对象
     */
    Department queryById(Integer d_id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param department 实例对象
     * @return 对象列表
     */
    List<Department> queryAll(Department department);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param d_id 主键
     * @return 影响行数
     */
    int deleteById(Integer d_id);

}