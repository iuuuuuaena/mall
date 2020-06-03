package com.tapd.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author jxd
 * @Date 2020-05-31  18:12
 * @Version 1.0
 */

@Repository
// @Repository原意指的是仓库,Repository居于业务层和数据层之间，
// 将两者隔离开来，在它的内部封装了数据查询和存储的逻辑。这样设计的好处有两个：
//         1.降低层级之间的耦合：更换、升级ORM引擎（Hibernate）并不会影响业务逻辑
//         2.提高测试效率：如果在测试时能用Mock数据对象代替实际的数据库操作，运行速度会快很多


// @Repository和DAO的区别
//          DAO是传统MVC中Model的关键角色，全称是Data Access Object。
//      DAO直接负责数据库的存取工作，乍一看两者非常类似，但从架构设计上讲两者有着本质的区别：
//
//          Repository蕴含着真正的OO概念，即一个数据仓库角色，负责所有对象的持久化管理。
//      DAO则没有摆脱数据的影子，仍然停留在数据操作的层面上。Repository是相对对象而言，
//      DAO则是相对数据库而言，虽然可能是同一个东西 ，但侧重点完全不同。
public class UserDao {


}
