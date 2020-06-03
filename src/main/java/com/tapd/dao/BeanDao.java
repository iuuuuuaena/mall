package com.tapd.dao;

import com.tapd.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author jxd
 * @Date 2020-05-31  18:24
 * @Version 1.0
 */
public class BeanDao <T>{

//
//     @Autowired
//     JdbcTemplate jdbcTemplate;
//
//
//      protected void doQuery(String strSql) {
//
//         JdbcTemplate jt = new JdbcTemplate(getDataSource());    //使用JdbcTemplate
//         
//         try {
//             List result = jt.queryForList(strSql);
//             this.resultList = result;
//             
//             this.resultCount = result.size();
//             
//             log.debug(logHeader + strSql);
//             
//         } catch (DataAccessException de) {
//             
//             log.error(logHeader + de);
//         }
//
//     public Integer addUser(User user) {
//         return jdbcTemplate.update("insert into user_info_table (user_id) values (?,?);",
//                 user.getUser_id(), user.getUser_password());
//     }

}
