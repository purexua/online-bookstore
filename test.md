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

## 接口

1. `http://localhost:8080/login`

   请求方式：`GET`
   param参数：`username`
   返回结果示例：

   ```
   {
   
     "username": "user1",
   
     "password": "password1",
   
     "balance": 100.0
   
   }
   ```

2. 
