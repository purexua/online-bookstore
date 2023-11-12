## 数据库

### ER图

![](./er.jpg)

### 数据库表

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
```

order_item表

```mysql
CREATE TABLE `order_item` (
  `order_item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `book_id` int NOT NULL,
  `quantity` int ,
  PRIMARY KEY (`order_item_id`),
  FOREIGN KEY (`order_id`) REFERENCES `order`(`order_id`),
  FOREIGN KEY (`book_id`) REFERENCES `book`(`book_id`)
);
```

shopping_cart表

```mysql
CREATE TABLE shopping_cart (
  cart_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(user_id)
);
```

shopping_cart_item表

```mysql
CREATE TABLE shopping_cart_item (
  item_id INT AUTO_INCREMENT PRIMARY KEY,
  cart_id INT NOT NULL,
  book_id INT NOT NULL,
  quantity INT NOT NULL,
  FOREIGN KEY (cart_id) REFERENCES shopping_cart(cart_id),
  FOREIGN KEY (book_id) REFERENCES book(book_id)
);
```

### 数据库关系模式

1. 用户（**用户ID**，姓名，密码，真实姓名，邮箱，地址，电话，钱包金额）
2. 图书（ **图书ID**，书名，作者，出版商，ISBN，价格，库存，类型）
3. 订单（ **订单ID**，*用户ID*，订单时间）
4. 订单项（ **订单项ID**，*订单ID*，图书ID，图书数量）
5. 购物车（**购物车ID**，*用户ID*）
6. 购物车项（**购物车项ID**，*购物车ID*，*图书ID*，图书数量）

> 注：加粗为主键，斜体为外键

1. 用户表（user）

- 用户ID（user_id	Int	主键  ）
- 姓名（user_name    String）
- 密码（password    String）
- 真实姓名（real_name    String）
- 邮箱（email    String）
- 地址（address    String）
- 电话（phone_number    String）
- 钱包金额（balance    DECIMAL）

2. 图书表（book）
- 图书ID（book_id    Int    主键）
- 书名（title    String）
- 作者（author    String）
- 出版商（publisher    String）
- ISBN（isbn    String）
- 价格（price    DECIMAL）
- 库存（stock    int）
- 类型（type    String）

3. 订单（order）

- 订单ID（order_id    Int    主键）
- 用户ID（user_id    Int    外键关联user表（user_id））
- 订单时间（order_date   datetime）

4. 订单项（order_item）

- 订单项ID（order_item_id    Int    主键）
- 订单ID（order_id    Int    外键关联order表（order_id））
- 图书ID（book_id    Int    外键关联book表（book_id））
- 图书数量（quantity    Int）

5. 购物车（shopping_cart）

- 购物车ID（cart_id    Int    主键）
- 用户ID（user_id    Int   外键关联user表（user_id））

6. 购物车项（shopping_cart_item）

- 购物车项ID（item_id    Int    主键）
- 购物车ID（cart_id    Int    外键关联shopping_cart（cart_id））
- 图书ID（book_id    Int    外键关联book表（book_id））
- 图书数量（quantity    Int）

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

    
