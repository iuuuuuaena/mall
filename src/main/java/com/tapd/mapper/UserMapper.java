package com.tapd.mapper;

import com.tapd.POJO.User;
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
     *
     * @return
     */
    @Select("select * from user_info_table")
    List<User> showAllUser();

    /**
     * 通过ID查找用户
     *
     * @param id
     * @return
     */
    @Select("select * from user_info_table where user_id = #{id}")
    User findById(Integer id);


    /**
     * 通过ID查找用户
     *
     * @param account
     * @return
     */
    @Select("select * from user_info_table where user_account = #{account}")
    User findByAccount(String account);


    /**
     * 通过账号删除用户
     *
     * @param user_account
     * @return
     */
    @Delete("DELETE FROM user_info_table WHERE user_account = #{user_account}")
    int deleteByAccount(String user_account);


    /**
     * 通过id删除用户
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM user_info_table WHERE user_account = #{id}")
    int deleteByID(Integer id);

    /**
     * 插入用户
     *
     * @param user
     * @return 返回的是插入的条数，也就是插入的用户数量，一般就是一个，批量插入就是多个了
     */
    @Insert("insert into user_info_table (user_nickname,user_account,user_password,user_age,user_gender,user_hobby,user_icon,user_qq,user_card,all_deal_amount,user_email)" +
            "values " +
            "(#{user_nickname},#{user_account},#{user_password},#{user_age},#{user_gender},#{user_hobby},#{user_icon},#{user_qq},#{user_card},#{all_deal_amount},#{user_email})")
    int insert(User user);

    /**
     * 传入要修改的user
     *
     * @param user
     * @return
     */
    @Update(" UPDATE user_info_table " +
            "        SET  user_nickname = #{user_nickname}," +
            "            user_password = #{user_password}," +
            "            user_age = #{user_age}," +
            "            user_gender = #{user_gender}," +
            "            user_hobby = #{user_hobby}," +
            "            user_icon = #{user_icon}," +
            "            user_qq = #{user_qq}," +
            "            user_card = #{user_card}," +
            "            all_deal_amount = #{all_deal_amount}," +
            "            user_email = #{user_email}" +
            "        WHERE user_account = #{user_account}")
    int update(User user);


    /**
     * 用email找user
     *
     * @param userEmail
     * @return List<User>
     */
    @Select("select * from user_info_table where user_email = #{userEmail} ")
    List<User> findUserByEmail(String userEmail);


    /**
     * 更新照片
     * @param user_account
     * @param new_image
     * @return
     */
    @Update(" UPDATE user_info_table" +
            "        SET user_icon = #{new_image} " +
            "        WHERE user_account = #{user_account}")
    int updateImage(String user_account,String new_image);




    /**
     * 更新用户信息2 ：不更新头像
     *
     * @param user
     * @return
     */
    @Update(" UPDATE user_info_table " +
            "        SET  user_nickname = #{user_nickname}," +
            "            user_password = #{user_password}," +
            "            user_age = #{user_age}," +
            "            user_gender = #{user_gender}," +
            "            user_hobby = #{user_hobby},"+
            "            user_qq = #{user_qq}," +
            "            user_card = #{user_card}," +
            "            all_deal_amount = #{all_deal_amount}," +
            "            user_email = #{user_email}" +
            "        WHERE user_account = #{user_account}")
    int update2(User user);


}
