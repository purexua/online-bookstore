# 数据库课程设计

### 开发环境

- Maven 3.9.1
- Java 20
- Spring-Boot 3.1.4

## 数据库设计

### 1.用户表

```mysql
CREATE TABLE user
(
    user_id      INT AUTO_INCREMENT PRIMARY KEY,
    user_name    VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,  -- Consider using a hashed password
    email        VARCHAR(100),
    address      VARCHAR(255),
    phone_number VARCHAR(20),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### 2.图书表

```mysql
CREATE TABLE book (
                      book_id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255),
                      publisher VARCHAR(255),
                      isbn VARCHAR(20) UNIQUE NOT NULL,
                      price DECIMAL(5, 2) NOT NULL,
                      stock INT NOT NULL
);
```

### 3.订单状态表

```mysql
CREATE TABLE order_status (
                              status_id INT AUTO_INCREMENT PRIMARY KEY,
                              status_name VARCHAR(255) NOT NULL
);
```

### 4.订单表

```mysql
CREATE TABLE `order` (
                          order_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          order_date DATE,
                          status_id INT NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES user(user_id),
                          FOREIGN KEY (status_id) REFERENCES order_status(status_id)
);
```

### 5.订单详情表

```mysql
CREATE TABLE order_detail (
                              detail_id INT AUTO_INCREMENT PRIMARY KEY,
                              order_id INT NOT NULL,
                              book_id INT NOT NULL,
                              quantity INT NOT NULL,
                              FOREIGN KEY (order_id) REFERENCES `order`(order_id),
                              FOREIGN KEY (book_id) REFERENCES book(book_id)
);
```

### 6.购物车表

```mysql
CREATE TABLE shopping_cart (
                              cart_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES user(user_id)
);
```

### 7.购物车明细表

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

## 数据模拟

```mysql
-- Insert into User
INSERT INTO user (user_name, password, email, address, phone_number)
VALUES ('Alice', 'password1', 'alice@example.com', '123 Main St', '123-456-7890'),
       ('Bob', 'password2', 'bob@example.com', '456 Maple Ave', '234-567-8901');

-- Insert into Book
INSERT INTO book (title, author, publisher, isbn, price, stock)
VALUES ('Book1', 'Author1', 'Publisher1', '1234567890123', 19.99, 10),
       ('Book2', 'Author2', 'Publisher2', '2345678901234', 29.99, 15);

-- Insert into OrderStatus
INSERT INTO order_status (status_name)
VALUES ('Processing'), ('Shipped'), ('Delivered');

-- Insert into Order
INSERT INTO `order` (user_id, order_date, status_id)
VALUES (1, CURDATE(), 1), (2, CURDATE(), 2);

-- Insert into OrderDetail
INSERT INTO order_detail (order_id, book_id, quantity)
VALUES (1, 1, 1), (1, 2, 2), (2, 2, 1);

-- Insert into ShoppingCart
INSERT INTO shopping_cart (user_id)
VALUES (1), (2);

-- Insert into ShoppingCartItem
INSERT INTO shopping_cart_item (cart_id, book_id, quantity)
VALUES (1, 1, 1), (1, 2, 1), (2, 1, 1);
```

## 实体类映射

### 1.用户表

```java
package com.purexua.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@Data
public class User {
  private Integer userId;
  @NotBlank(message = "用户名不能为空")
  private String userName;
  @Length(min = 6, max = 16, message = "密码长度必须在6-16位之间")
  private String password;
  @Email(message = "邮箱格式不正确")
  private String email;
  private String address;
  @Digits(integer = 11, fraction = 0, message = "手机号码格式不正确")
  private String phoneNumber;
  private Date createdAt;
  private Date updatedAt;

  private List<Order> orders;
  private ShoppingCart shoppingCart;
}
```

### 2.图书表

```java
package com.purexua.entity;

import lombok.Data;

@Data
public class Book {
  private int bookId;
  private String title;
  private String author;
  private String publisher;
  private String isbn;
  private double price;
  private int stock;
}
```

### 3.订单状态表

```java
package com.purexua.entity;

import lombok.Data;

@Data
public class OrderStatus {
  private Integer statusId;
  private String statusName;
}
```

### 4.订单表

```java
package com.purexua.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
  private Integer orderId;
  private Integer userId;
  private Date orderDate;
  private Integer statusId;

  private User user;
  private OrderStatus orderStatus;
  private List<OrderItem> orderItems;
}
```

### 5.订单详情表

```java
package com.purexua.entity;


import lombok.Data;

@Data
public class OrderItem {
  private Integer orderDetailId;
  private Integer orderId;
  private Integer bookId;
  private Integer quantity;

  private Order order;
  private Book book;
}
```

### 6.购物车表

```java
package com.purexua.entity;

import lombok.Data;

@Data
public class ShoppingCart {
  private Integer cartId;
  private Integer userId;

  private User user;
}
```

### 7.购物车明细表

```java
package com.purexua.entity;

import lombok.Data;

@Data
public class ShoppingCartItem {
  private Integer itemId;
  private Integer cartId;
  private Integer bookId;
  private Integer quantity;

  private ShoppingCart shoppingCart;
  private Book book;
}
```

------

**to be continued...**
