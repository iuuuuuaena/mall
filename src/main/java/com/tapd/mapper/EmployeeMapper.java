package com.tapd.mapper;

import com.tapd.entities.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-01  12:27
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from manager_info_table")
    public List<Employee> showAllManager();

    /**
     * 通过ID查找用户
     * @param id
     * @return
     */
    @Select("select * from manager_info_table where manager_id = #{id}")
    public Employee findById(Integer id);

    /**
     * 通过Account查找用户
     * @param account
     * @return
     */
    @Select("select * from manager_info_table where manager_account = #{account}")
    public Employee findByAccount(String account);



    /**
     *  通过账号删除用户
     * @param manager_account
     * @return
     */
    @Delete("DELETE FROM manager_info_table WHERE manager_account = #{manager_account}")
    public int  deleteByAccount(String manager_account);

    /**
     *  通过id删除用户
     * @param id
     * @return
     */
    @Delete("DELETE FROM manager_info_table WHERE manager_id = #{id}")
    public int  deleteById(int id);


    /**
     * 插入用户
     * @param employee
     * @return  返回的是插入的条数，也就是插入的用户数量，一般就是一个，批量插入就是多个了
     */
    @Insert("insert into manager_info_table (manager_nickname,manager_account,manager_password,manager_icon,manager_email,all_deal_amount)" +
            "values " +
            "(#{manager_nickname},#{manager_account},#{manager_password},#{manager_icon},#{manager_email},#{all_deal_amount})")
    public int insert(Employee employee);

    /**
     * 传入要修改的user
     * @param employee
     * @return
     */
    @Update(" UPDATE manager_info_table" +
            "        SET manager_nickname = #{manager_nickname}," +
            "            manager_account = #{manager_account}," +
            "            manager_password = #{manager_password}," +
            "            manager_icon = #{manager_icon}," +
            "            manager_email = #{manager_email}," +
            "            all_deal_amount = #{all_deal_amount}" +
            "        WHERE manager_account = #{manager_account}")
    public int update(Employee employee);

}
