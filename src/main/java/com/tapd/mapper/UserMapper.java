package com.tapd.mapper;

import com.tapd.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-05-31  19:09
 * @Version 1.0
 */


// 这是user表的mapper

@Mapper
public interface UserMapper {


    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from user_info_table")
    public List<User> showAllUser();

    /**
     * 通过ID查找用户
     * @param id
     * @return
     */
    @Select("select * from user_info_table where user_id = #{id}")
    public User findById(Integer id);


    /**
     * 通过ID查找用户
     * @param account
     * @return
     */
    @Select("select * from user_info_table where user_account = #{account}")
    public User findByAccount(String account);



    /**
     *  通过账号删除用户
     * @param user_account
     * @return
     */
    @Delete("DELETE FROM user_info_table WHERE user_account = #{user_account}")
    public int  deleteByAccount(String user_account);

    /**
     * 插入用户
     * @param user
     * @return  返回的是插入的条数，也就是插入的用户数量，一般就是一个，批量插入就是多个了
     */
    @Insert("insert into user_info_table (user_nickname,user_account,user_password,user_age,user_gender,user_hobby,user_icon,user_qq,user_card,all_deal_amount,user_email)" +
            "values " +
            "(#{user_nickname},#{user_account},#{user_password},#{user_age},#{user_gender},#{user_hobby},#{user_icon},#{user_qq},#{user_card},#{all_deal_amount},#{user_email})")
    public int insert(User user);

    /**
     * 传入要修改的user
     * @param user
     * @return
     */
    @Update(" UPDATE user_info_table\n" +
            "        SET user_id = #{user_id},\n" +
            "            user_nickname = #{user_nickname},\n" +
            "            user_account = #{user_account},\n" +
            "            user_password = #{user_password},\n" +
            "            user_age = #{user_age},\n" +
            "            user_gender = #{user_gender},\n" +
            "            user_hobby = #{user_hobby},\n" +
            "            user_icon = #{user_icon},\n" +
            "            user_qq = #{user_qq},\n" +
            "            user_card = #{user_card},\n" +
            "            all_deal_amount = #{all_deal_amount}\n" +
            "            user_email = #{user_email}\n"+
            "        WHERE user_account = #{user_account}")
    public int update(User user);



}
