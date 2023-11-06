## 数据库

user 表

```mysql
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL
);

#数据模拟
INSERT INTO user (username, password, balance) VALUES ('user1', 'password1', 100.00);
INSERT INTO user (username, password, balance) VALUES ('user2', 'password2', 200.00);
INSERT INTO user (username, password, balance) VALUES ('user3', 'password3', 300.00);
INSERT INTO user (username, password, balance) VALUES ('user4', 'password4', 400.00);
INSERT INTO user (username, password, balance) VALUES ('user5', 'password5', 500.00);
INSERT INTO user (username, password, balance) VALUES ('user6', 'password6', 600.00);
INSERT INTO user (username, password, balance) VALUES ('user7', 'password7', 700.00);
INSERT INTO user (username, password, balance) VALUES ('user8', 'password8', 800.00);
INSERT INTO user (username, password, balance) VALUES ('user9', 'password9', 900.00);
INSERT INTO user (username, password, balance) VALUES ('user10', 'password10', 1000.00);

```

book 表

```
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
   ```

9. 
   
