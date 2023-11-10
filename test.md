## 数据库

user 表

```mysql
CREATE TABLE user
(
    user_id      INT AUTO_INCREMENT PRIMARY KEY,
    user_name    VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    real_name    VARCHAR(255) NOT NULL,
    email        VARCHAR(100),
    address      VARCHAR(255),
    phone_number VARCHAR(20),
    balance DECIMAL(10, 2) NOT NULL
);

#数据模拟
INSERT INTO user (user_name, password, real_name, email, address, phone_number, balance) VALUES
('张三', 'zhangsan123', '张三', 'zhangsan@example.com', '北京市朝阳区', '13811112222', 1000.00),
('李四', 'lisi456', '李四', 'lisi@example.com', '上海市浦东新区', '13911113333', 1500.50),
('王五', 'wangwu789', '王五', 'wangwu@example.com', '广州市天河区', '13611114444', 800.25),
('赵六', 'zhaoliu012', '赵六', 'zhaoliu@example.com', '深圳市福田区', '13711115555', 2000.00),
('孙七', 'sunqi234', '孙七', 'sunqi@example.com', '重庆市渝北区', '13611116666', 3000.00),
('周八', 'zhouba567', '周八', 'zhouba@example.com', '成都市武侯区', '13911117777', 1200.75),
('吴九', 'wuji890', '吴九', 'wuji@example.com', '杭州市西湖区', '13811118888', 2500.50),
('郑十', 'zhengshi345', '郑十', 'zhengshi@example.com', '南京市鼓楼区', '13911119999', 1800.25),
('刘一', 'liuyi678', '刘一', 'liuyi@example.com', '武汉市江汉区', '13711112211', 2100.00),
('陈二', 'chener345', '陈二', 'chener@example.com', '苏州市姑苏区', '13611113322', 1600.50),
('许三', 'xusan678', '许三', 'xusan@example.com', '西安市雁塔区', '13811114433', 2800.25),
('丁四', 'dingsi901', '丁四', 'dingsi@example.com', '青岛市市南区', '13911115544', 1500.00),
('胡五', 'huwu234', '胡五', 'huwu@example.com', '长沙市岳麓区', '13711116655', 3200.00),
('朱六', 'zhuliu567', '朱六', 'zhuliu@example.com', '福州市鼓楼区', '13611117766', 2000.75),
('杨七', 'yangqi890', '杨七', 'yangqi@example.com', '沈阳市沈河区', '13811118877', 3500.50),
('何八', 'heba123', '何八', 'heba@example.com', '济南市历下区', '13911119988', 1900.25),
('林九', 'linji345', '林九', 'linji@example.com', '南宁市青秀区', '13711112200', 2400.00),
('罗十', 'luoshi678', '罗十', 'luoshi@example.com', '合肥市蜀山区', '13811113300', 1700.50),
('宋一', 'songyi901', '宋一', 'songyi@example.com', '石家庄市长安区', '13611114400', 3000.25),
('姜二', 'jianger234', '姜二', 'jianger@example.com', '太原市小店区', '13711115500', 2200.00);
```

book 表

```mysql
CREATE TABLE book (
                       book_id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       publisher VARCHAR(255) NOT NULL,
                       isbn VARCHAR(13) NOT NULL,
                       price DECIMAL(10, 2) NOT NULL,
                       stock INT NOT NULL,
                       type VARCHAR(50) NOT NULL
);

#数据模拟
INSERT INTO books (title, author, publisher, isbn, price, stock, type) VALUES
('活着', '余华', '作家出版社', '9787506365437', 29.80, 100, '小说'),
('围城', '钱钟书', '人民文学出版社', '9787020001864', 36.00, 80, '小说'),
('解忧杂货店', '东野圭吾', '南海出版公司', '9787544258609', 39.50, 120, '小说'),
('白夜行', '东野圭吾', '南海出版公司', '9787544242516', 29.80, 150, '小说'),
('三体', '刘慈欣', '重庆出版社', '9787229030930', 36.00, 60, '科幻'),
('1984', '乔治·奥威尔', '上海译文出版社', '9787532728333', 22.00, 100, '小说'),
('百年孤独', '加西亚·马尔克斯', '南海出版公司', '9787544245449', 39.50, 90, '小说'),
('红楼梦', '曹雪芹', '人民文学出版社', '9787020000799', 50.00, 70, '小说'),
('活着(插图本)', '余华', '作家出版社', '9787506362115', 39.80, 110, '小说'),
('霍乱时期的爱情', '加西亚·马尔克斯', '南海出版公司', '9787544253994', 45.00, 80, '小说'),
('数据库系统概念', 'Abraham Silberschatz', '机械工业出版社', '9787111198773', 99.00, 50, '计算机'),
('数据结构与算法分析', 'Mark Allen Weiss', '清华大学出版社', '9787302330646', 89.00, 40, '计算机'),
('经济学原理', '曼昆', '机械工业出版社', '9787111472634', 69.00, 60, '经济学'),
('人类简史', '尤瓦尔·赫拉利', '中信出版社', '9787508644315', 45.00, 70, '历史'),
('西方哲学史', '罗素', '商务印书馆', '9787100089740', 58.00, 30, '哲学');
```

order表

```mysql
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `order_date` datetime NOT NULL, 
  PRIMARY KEY (`order_id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`)  
);

#数据模拟
INSERT INTO `order` (order_id, user_id, order_date) VALUES
(1,2,'2019-01-01'),
(2,2,'2019-01-02'),
(3,2,'2019-01-03'),
(4,4,'2019-01-04'),
(5,5,'2019-01-05'),
(6,6,'2019-01-06'),
(7,7,'2019-01-07'),
(8,8,'2019-01-08'),
(9,9,'2019-01-09'),
(10,9,'2019-01-10' );
```

order_item表

```
CREATE TABLE `order_item` (
  `order_item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `book_id` int NOT NULL,
  PRIMARY KEY (`order_item_id`),
  FOREIGN KEY (`order_id`) REFERENCES `order`(`order_id`),
  FOREIGN KEY (`book_id`) REFERENCES `book`(`book_id`)
);

#数据模拟

```



## 接口

1. `http://localhost:8080/login`

   请求方式：`GET`
   param参数：`username`
   返回结果示例：

   ```json
   {
   
     "username": "user1",
   
     "password": "password1",
   
     "balance": 100.0
   
   }
   ```

2. `http://localhost:8080/books`
   请求方式：`GET`
   返回结果示例：

   ```json
   [
       {
           "bookId": 1,
           "title": "活着",
           "author": "余华",
           "publisher": "作家出版社",
           "isbn": "9787506365437",
           "price": 29.8,
           "stock": 100,
           "type": "小说"
       },
       {
           "bookId": 13,
           "title": "经济学原理",
           "author": "曼昆",
           "publisher": "机械工业出版社",
           "isbn": "9787111472634",
           "price": 69.0,
           "stock": 60,
           "type": "经济学"
       },
       ...
       {
           "bookId": 14,
           "title": "人类简史",
           "author": "尤瓦尔·赫拉利",
           "publisher": "中信出版社",
           "isbn": "9787508644315",
           "price": 45.0,
           "stock": 70,
           "type": "历史"
       },
       {
           "bookId": 15,
           "title": "西方哲学史",
           "author": "罗素",
           "publisher": "商务印书馆",
           "isbn": "9787100089740",
           "price": 58.0,
           "stock": 30,
           "type": "哲学"
       }
       ...
   ]
   ```

3. `http://localhost:8080/book/search`

   请求方式：`GET`
   param参数：`type`
   返回结果示例：

   ```
   [
       {
           "bookId": 1,
           "title": "活着",
           "author": "余华",
           "publisher": "作家出版社",
           "isbn": "9787506365437",
           "price": 29.8,
           "stock": 100,
           "type": "小说"
       },
       {
           "bookId": 2,
           "title": "围城",
           "author": "钱钟书",
           "publisher": "人民文学出版社",
           "isbn": "9787020001864",
           "price": 36.0,
           "stock": 80,
           "type": "小说"
       },
   ...
   ]
   ```

4. `http://localhost:8080/book/page`
   请求方式：`GET`
   param参数：`pageNum` `pageSize`
   返回结果示例：

   ```json
   [
       {
           "bookId": 7,
           "title": "百年孤独",
           "author": "加西亚·马尔克斯",
           "publisher": "南海出版公司",
           "isbn": "9787544245449",
           "price": 39.5,
           "stock": 90,
           "type": "小说"
       },
       {
           "bookId": 8,
           "title": "红楼梦",
           "author": "曹雪芹",
           "publisher": "人民文学出版社",
           "isbn": "9787020000799",
           "price": 50.0,
           "stock": 70,
           "type": "小说"
       }
   ]
   ```


5. `http://localhost:8080/book/page/type`

   请求方式：`GET`
   param参数：`type` `pageNum` `pageSize`
   返回结果示例：

   ```
   [
       {
           "bookId": 7,
           "title": "百年孤独",
           "author": "加西亚·马尔克斯",
           "publisher": "南海出版公司",
           "isbn": "9787544245449",
           "price": 39.5,
           "stock": 90,
           "type": "小说"
       }
   ]
   ```

6. `http://localhost:8080/book/page/info`

   请求方式：`GET`
   param参数：`pageNum` `pageSize`
   返回结果示例：

   ```
   {
       "totalPages": 4,
       "totalItems": 16,
       "pageNum": 2,
       "pageSize": 5
   }
   ```

7. `http://localhost:8080/book/page/type/info`

   请求方式：`GET`
   param参数：`type` `pageNum` `pageSize`
   返回结果示例：

   ```
   {
       "totalPages": 2,
       "totalItems": 9,
       "pageNum": 2,
       "pageSize": 5
   }
   ```


8. `http://localhost:8080/book/add`

   请求方式：`POST`
   param参数：`title` `author` `publisher` `isbn` `price` `stock` `type`
   返回结果示例：

   ```
   success
   ---
   添加失败 - 已经存在该书籍
   ```

9. `http://localhost:8080/book/update`
   请求方式：`PUT`
   param参数：`bookId` `title` `author` `publisher` `isbn` `price` `stock` `type`
   返回结果示例：

   ```
   success
   ---
   更新失败 - 不存在该书籍
   ```

10. `http://localhost:8080/book/delete`
    请求方式：`DELETE`
    param参数：`bookId` 
    返回结果示例：

    ```
    success
    ---
    删除失败 - 不存在该书籍
    ```

11. `http://localhost:8080/book/exist`
    请求方式：`GET`
    param参数：`pageNum` `pageSize` `title (required = false)` `author (required = false)` `isbn (required = false)` `type`
    返回结果示例：

    ```
    ---
    http://localhost:8080/book/exist?title=深入
    ---
    
    [
        {
            "bookId": 190,
            "title": "深入理解计算机系统",
            "author": "Randal E. Bryant",
            "publisher": "机械工业出版社",
            "isbn": "9787111574297",
            "price": 29.99,
            "stock": 30,
            "type": "计算机"
        },
        {
            "bookId": 196,
            "title": "深入理解计算机系统",
            "author": "Randal E. Bryant",
            "publisher": "机械工业出版社",
            "isbn": "9787111574297",
            "price": 23.99,
            "stock": 60,
            "type": "计算机"
        },
        {
            "bookId": 202,
            "title": "深入理解计算机系统",
            "author": "Randal E. Bryant",
            "publisher": "机械工业出版社",
            "isbn": "9787111574297",
            "price": 17.99,
            "stock": 90,
            "type": "计算机"
        },
        {
            "bookId": 208,
            "title": "深入理解计算机系统",
            "author": "Randal E. Bryant",
            "publisher": "机械工业出版社",
            "isbn": "9787111574297",
            "price": 11.99,
            "stock": 120,
            "type": "计算机"
        },
        {
            "bookId": 214,
            "title": "深入理解计算机系统",
            "author": "Randal E. Bryant",
            "publisher": "机械工业出版社",
            "isbn": "9787111574297",
            "price": 5.99,
            "stock": 150,
            "type": "计算机"
        }
    ]
    ```

12. `http://localhost:8080/book/exist/info`
    请求方式：`GET`
    param参数：`pageNum` `pageSize` `title (required = false)` `author (required = false)` `isbn (required = false)` 
    返回结果示例：

    ```
    ---
    http://localhost:8080/book/exist/info?pageNum=1&pageSize=5&title=深入&type=计算机
    ---
    
    {
        "totalPages": 3,
        "totalItems": 14,
        "pageNum": 1,
        "pageSize": 5
    }
    ```

13. `http://localhost:8080/user/password`
    请求方式：`PUT`
    param参数：`id` `password`
    返回结果示例：

    ```
    success
    ```

14. `http://localhost:8080/user`
    请求方式：`PUT`
    param参数：`userId` `realName`  `password` `realName` `email` `address` `phoneNumber` `balance`
    返回结果示例：

    ```
    success
    ```

15. `http://localhost:8080/user/recharge`
    请求方式：`PUT`
    param参数：`userId` `balance`
    返回结果示例：

    ```
    success
    ```

16. `http://localhost:8080/order`
    请求方式：`GET`
    param参数：`userId`
    返回结果示例：

    ```
    ---
    http://localhost:8080/order?userId=2
    ---
    
    [
        {
            "orderId": 1,
            "userId": 2,
            "orderDate": "2018-12-31T16:00:00.000+00:00"
        },
        {
            "orderId": 2,
            "userId": 2,
            "orderDate": "2019-01-01T16:00:00.000+00:00"
        },
        {
            "orderId": 3,
            "userId": 2,
            "orderDate": "2019-01-02T16:00:00.000+00:00"
        }
    ]
    ```

    
