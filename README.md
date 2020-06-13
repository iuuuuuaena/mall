# P2P商城 (管理后台+前端商城)

### 技术栈 
* 后台管理页面：Springboot + thymeleaf + Mybatis + SpringSecurity + Druid + mysql

* 前端商城页面 vue.js + vue/cli + elementUI

### 项目预览

[后台管理界面](http://admin.jxdgogogo.xyz:8080)

[前端商城页面](http://mall.jxdgogogo.xyz)

### 版本迭代
0.0.0 Maven创建项目

0.0.1 后台登录

0.0.2 注册注销

0.0.3 集成Mybatis,完成mysql数据库连接配置

0.0.4 用户CRUD、员工CRUD和图片上传功能

0.0.5 评论商品CRUD 

0.0.6 集成SpringSecurity,划分用户/员工/管理员权限

0.0.7 集成Druid,监控SQL情况

0.0.8 完成使用JavaMailSender发送登录验证码

0.0.9 使用JWT完成登录token验证

1.0.0 第一版后台管理系统上线

1.0.1 提供部分前端API包括 登录注册，商品评论查询等等

1.5.0 完成购物车，前端登录，注册，搜搜，显示商品，订单，支付，回调等功能


### API接口


### 后台登录注册和用户CRUD

|登录注册和用户CRUD

| 作用                            | 请求URL         | 请求方式 | 最终去向                 |
| ------------------------------- | --------------- | -------- | ------------------------ |
| 登录                            | /mail/login     | POST     | username,password        |
| 退出登录                        | /mail/logout    | GET      |                          |
| 注册                            | /mail/register  | GET      | username,passoword,email |
| 跳转到用户界面，显示所有的用户  | /users          | GET      |                          |
| 进入用户添加界面                | /user           | GET      |                          |
| 添加用户                        | /user           | POST     | user                     |
| 携带用户Account进入用户修改界面 | /user/{account} | GET      |                          |
| 修改用户信息                    | /user           | PUT      | user                     |
| 根据Account删除员工             | /user/{account} | POST     |                          |

员工CRUD


| 作用                            | 请求URL            | 请求方式 | 请求参数 |
| ------------------------------- | ------------------ | -------- | -------- |
| 跳转到员工界面，显示所有员工    | /managers          | GET      |          |
| 到员工添加页面                  | /manager           | GET      |          |
| 添加员工                        | /manager           | POST     | manager  |
| 携带Account去修改员工信息的页面 | /manager/{account} | GET      |          |
| 修改员工信息                    | /manager           | PUT      | manager  |
| 删除员工信息                    | /manager/{account} | POST     |          |

商品


| 作用                           | 请求URL          | 请求方式 | 最终去向        |
| ------------------------------ | ---------------- | -------- | --------------- |
| 跳转到商品页面，并显示所有商品 | /goods           | GET      | goods/list.html |
| 删除商品                       | /goods/{good_id} | POST     | goods/list.html |

评论

| 作用                           | 请求URL               | 请求方式 | 最终去向          |
| ------------------------------ | --------------------- | -------- | ----------------- |
| 跳转到评论界面，并显示所有评论 | /discuss              | GET      | discuss/list.html |
| 删除评论                       | /discuss/{discuss_id} | POST     | discuss/list.html |

订单

| 作用           | 请求URL           | 请求方式 | 最终去向        |
| -------------- | ----------------- | -------- | --------------- |
| 通过id删除订单 | /order/{order_id} | DELETE   | order/list.html |
| 显示所有订单   | /orders           | POST     | order/list.html |

### 前端商城API接口

登录

| 作用 | 请求URL  | 请求方式 | 请求参数                          |
| ---- | -------- | -------- | --------------------------------- |
| 登录 | /u/login | GET      | username, password,isloginkeeping |

注册

| 作用       | 请求URL          | 请求方式 | 请求参数                 |
| ---------- | ---------------- | -------- | ------------------------ |
| 注册       | /u/register      | POST     | username, password,email |
| 获取验证码 | /email/getCode   | POST     | cookie中                 |
| 验证验证码 | /email/checkCode | POST     | email，code              |

登出

| 作用 | 请求URL      | 请求方式 | 方式                                    |
| ---- | ------------ | -------- | --------------------------------------- |
| 登出 | /user/logout | POST     | 设置cookie里面的Authorization为null即可 |

商品

| 作用                       | 请求URL            | 请求方式 | 请求参数     |
| -------------------------- | ------------------ | -------- | ------------ |
| 添加商品                   | /publishGood       | POST     | goods        |
| 修改商品信息               | /good              | PUT      | Goods        |
| 通过ID删除商品             | /goodDeleteById    | POST     | id           |
| 通过ID查询商品             | /goodsId           | GET      | id           |
| 根据Name，模糊查询         | /goodsName         | GET      | goods_name   |
| 返回所有商品的信息         | /goodsList         | GET      |              |
| 用户账号搜索用户发布的商品 | /goodByUserAccount | GET      | user_account |
| 显示所有标签               | /showAllTag        | GET      |              |
| 通过标签找商品             | /GoodsByTag        | GET      | goods_tag    |

##### 评论

| 作用                | 请求URL            | 请求方式 | 请求参数     |
| ------------------- | ------------------ | -------- | ------------ |
| 添加评论            | /discussCreate     | POST     | discuss      |
| 修改评论            | /discussUpdate     | POST     | discuss      |
| 通过ID删除评论      | /discussDeleteById | POST     | discuss_id   |
| 通过ID查找评论      | /discusssId        | GET      | discuss_id   |
| 通过GoodsId找评论   | /discussByGoodsId  | GET      | goods_id     |
| 通过用户的Account查 | /discussByAccount  | GET      | user_account |

订单

| 创建订单            | /createOrder         | POST     | Order        |
| ------------------- | -------------------- | -------- | ------------ |
| 通过用户账号找订单  | /getOrderByAccount   | GET      | discuss      |
| 作用                | 请求URL              | 请求方式 | 请求参数     |
| 通过ID删除评论      | /saveOne             | POST     | discuss_id   |
| 通过ID找订单        | /orderById           | GET      | order_id     |
| 通过GoodsId找评论   | /findAllGoodsOfOrder | GET      | goods_id     |
| 通过用户的Account查 | /discussByAccount    | GET      | user_account |



文件上传

| 作用               | 请求URL  | 请求方式 | 返回信息 |
| ------------------ | -------- | -------- | -------- |
| 创建订单           | /mUpload | POST     | path     |
| 通过用户账号找订单 | /dUpload | GET      | path     |

用户



| 作用                   | 请求URL                | 请求方式 | 返回信息   |
| ---------------------- | ---------------------- | -------- | ---------- |
| 创建订单               | 请求URL                | POST     | Order      |
| 通过用户账号找用户信息 | /getUserInfo/{account} | GET      | discuss    |
| 上传图片               | /changeImage           | GET      | path       |
| 通过ID删除评论         | /updateInfo            | POST     | discuss_id |



标签



| 作用                 | 请求URL     | 请求方式 | 返回信息 |
| -------------------- | ----------- | -------- | -------- |
| 查询所有标签         | /showAllTag | GET      | Order    |
| 通过标签查询商品信息 | /goodsByTag | GET      | Goods    |



阿里支付


| 作用                   | 请求URL      | 请求方式 | 返回信息 |
| ---------------------- | ------------ | -------- | -------- |
| 创建订单               | /getPagePay  | POST     |          |
| 通过用户账号找用户信息 | /aliPayQuery | POST     | discuss  |
| 退款查询               | /refundQuery | GET      | path     |
| 关闭交易               | /alipayclose | POST     |          |
| 异步通知               | /notify      | GET      | String   |




### 作者

* QQ:2291146413
* Email:waniiu@126.com
