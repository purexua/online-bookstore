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
    password     VARCHAR(255) NOT NULL,
    email        VARCHAR(255),
    address      VARCHAR(255),
    phone_number VARCHAR(15)
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

### 3.订单信息表

```mysql
CREATE TABLE `Order` (
                         order_id INT AUTO_INCREMENT PRIMARY KEY,
                         user_id INT,
                         order_date DATE,
                         order_status ENUM('Pending', 'Processing') NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES User(user_id)
);
```

### 4.订单详情表

```mysql
CREATE TABLE OrderDetail (
                             detail_id INT AUTO_INCREMENT PRIMARY KEY,
                             order_id INT,
                             book_id INT,
                             quantity INT,
                             total_price DECIMAL(10, 2),
                             FOREIGN KEY (order_id) REFERENCES `Order`(order_id),
                             FOREIGN KEY (book_id) REFERENCES Book(book_id)
);
```

### 5.购物车表

```mysql
CREATE TABLE ShoppingCart (
                              cart_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT,
                              FOREIGN KEY (user_id) REFERENCES User(user_id)
);
```

### 6.购物车明细表

```mysql
CREATE TABLE ShoppingCartItem (
                                  item_id INT AUTO_INCREMENT PRIMARY KEY,
                                  cart_id INT,
                                  book_id INT,
                                  quantity INT,
                                  FOREIGN KEY (cart_id) REFERENCES ShoppingCart(cart_id),
                                  FOREIGN KEY (book_id) REFERENCES Book(book_id)
);
```

## 数据模拟

```mysql
INSERT INTO user (user_name, password, email, address, phone_number)
VALUES
    ('JohnDoe', 'password123', 'john.doe@example.com', '123 Main St, City', '555-1234'),
    ('AliceSmith', 'securepass', 'alice.smith@example.com', '456 Elm St, Town', '555-5678');

INSERT INTO book (title, author, publisher, isbn, price, stock)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', '9780743273565', 12.99, 50),
    ('To Kill a Mockingbird', 'Harper Lee', 'Harper Perennial', '9780061120084', 10.50, 35),
    ('1984', 'George Orwell', 'Penguin Books', '9780451524935', 9.99, 60),
    ('Pride and Prejudice', 'Jane Austen', 'Penguin Classics', '9780141439518', 8.95, 40);

INSERT INTO `Order` (user_id, order_date, order_status)
VALUES
    (1, '2023-09-01', 'Pending'),
    (2, '2023-09-02', 'Processing'),
    (1, '2023-09-03', 'Pending'),
    (2, '2023-09-04', 'Processing');

INSERT INTO OrderDetail (order_id, book_id, quantity, total_price)
VALUES
    (1, 1, 2, 25.98),
    (1, 3, 1, 9.99),
    (2, 2, 3, 31.50),
    (3, 4, 2, 17.90),
    (4, 1, 1, 12.99),
    (4, 2, 2, 21.00);

-- 假设用户1的购物车包含两本图书
INSERT INTO ShoppingCart (user_id)
VALUES (1);

INSERT INTO ShoppingCartItem (cart_id, book_id, quantity)
VALUES
    (1, 1, 2),
    (1, 3, 1);

-- 假设用户2的购物车包含一本图书
INSERT INTO ShoppingCart (user_id)
VALUES (2);

INSERT INTO ShoppingCartItem (cart_id, book_id, quantity)
VALUES (2, 2, 3);
```

## 实体类映射



------

**to be continued...**
