package com.tapd.mapper;

import com.tapd.entities.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author jxd
 * @Date 2020-05-31  20:27
 * @Version 1.0
 */

@Mapper
public interface DepartmentMapper {

    /**
     * 通过id查找
     * @param id
     * @return
     */
    @Select("select * from department where id = #{id}")
    public Department findById(Integer id);



    // /**
    //  * 插入
    //  * @param department
    //  * @return
    //  */
    //
    // public int insert(Department department);
}
