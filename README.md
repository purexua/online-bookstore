# 网上书店购物系统 - Online Bookstore

<img src="./images/hello.jpg"  />

## 简介

欢迎来到我们独具创意的网上书店购物系统！这是一个不仅仅是购物，更是探索知识的奇妙之地。我们为您呈现的不仅是一系列精选图书，更是一场身临其境的文学冒险。

在这里，我们致力于将购书变成一次独特而愉悦的体验。我们的网上书店不仅提供丰富多彩的图书选择，而且注重每一位顾客的个性化需求。您可以在这里发现从经典巨著到独立小众作品的全方位图书馆，满足您多元化的阅读胃口。

我们的系统不仅仅是一个购物平台，更是一个与书籍亲密互动的社区。通过我们精心设计的用户界面，您将轻松畅游于文学海洋，发现那些或让人深思，或令人捧腹，又或是让人热泪盈眶的故事。我们相信，每一本书都是一个奇妙的世界，而您正是这个世界的主人。

此外，我们的购物系统不仅提供便捷的购书服务，更关注知识的传播和分享。您将获得关于图书、作者、文学流派等方方面面的丰富信息。我们不仅仅是卖书，更是为您提供一个全方位的文学文化体验。

无论您是狂热的书迷，还是初次踏足文学殿堂，我们都为您准备了丰富多彩的选择。让我们一同探索知识的海洋，让每一本书都成为您人生旅途中不可或缺的伴侣。

感谢您选择我们的网上书店购物系统，让阅读变得更有趣、更有深度！

## 环境准备

- Spring boot (Spring + Spring MVC )
- Maven
- Mybatis (MySQL)
- Vue (HTML + JavaScript +CSS + Vuex + Router)
- axios
- Element UI
- ...

## 数据库

### 用户表（User）

|    Field     | Explain  |      Type      | Null | Key  | Default |     Extra      |
| :----------: | :------: | :------------: | :--: | :--: | :-----: | :------------: |
|   user_id    |  用户ID  |      INT       |  NO  | PRI  |  NULL   | AUTO_INCREMENT |
|  user_name   |  用户名  |  VARCHAR(255)  |  NO  |      |  NULL   |                |
|   password   |   密码   |  VARCHAR(255)  |  NO  |      |  NULL   |                |
|  real_name   | 真实姓名 |  VARCHAR(255)  |  NO  |      |  NULL   |                |
|    email     | 电子邮件 |  VARCHAR(100)  | YES  |      |  NULL   |                |
|   address    |   地址   |  VARCHAR(255)  | YES  |      |  NULL   |                |
| phone_number | 电话号码 |  VARCHAR(20)   | YES  |      |  NULL   |                |
|   balance    |   余额   | DECIMAL(10, 2) |  NO  |      |  NULL   |                |

### 书籍表（Book）

|   Field   | Explain |      Type      | Null | Key  | Default |     Extra      |
| :-------: | :-----: | :------------: | :--: | :--: | :-----: | :------------: |
|  book_id  | 书籍ID  |      INT       |  NO  | PRI  |  NULL   | AUTO_INCREMENT |
|   title   |  标题   |  VARCHAR(255)  |  NO  |      |  NULL   |                |
|  author   |  作者   |  VARCHAR(255)  |  NO  |      |  NULL   |                |
| publisher | 出版社  |  VARCHAR(255)  |  NO  |      |  NULL   |                |
|   isbn    | ISBN号  |  VARCHAR(13)   |  NO  |      |  NULL   |                |
|   price   |  价格   | DECIMAL(10, 2) |  NO  |      |  NULL   |                |
|   stock   | 库存量  |      INT       |  NO  |      |  NULL   |                |
|   type    |  类型   |  VARCHAR(50)   |  NO  |      |  NULL   |                |

### 订单表（Order）

|    Field    | Explain  |     Type      | Null | Key  | Default |     Extra      |
| :---------: | :------: | :-----------: | :--: | :--: | :-----: | :------------: |
|  order_id   |  订单ID  |      INT      |  NO  | PRI  |  NULL   | AUTO_INCREMENT |
|   user_id   |  用户ID  |      INT      |  NO  | MUL  |  NULL   |                |
| order_date  | 订单日期 |   DATETIME    |  NO  |      |  NULL   |                |
| FOREIGN KEY | 用户外键 | user(user_id) |      |      |         |                |

#### 订单详情表（Order_Item）

|     Field     |  Explain   |      Type       | Null | Key  | Default |     Extra      |
| :-----------: | :--------: | :-------------: | :--: | :--: | :-----: | :------------: |
| order_item_id | 订单详情ID |       INT       |  NO  | PRI  |  NULL   | AUTO_INCREMENT |
|   order_id    |   订单ID   |       INT       |  NO  | MUL  |  NULL   |                |
|    book_id    |   书籍ID   |       INT       |  NO  | MUL  |  NULL   |                |
|   quantity    |    数量    |       INT       | YES  |      |  NULL   |                |
|  FOREIGN KEY  |  订单外键  | order(order_id) |      |      |         |                |
|  FOREIGN KEY  |  书籍外键  |  book(book_id)  |      |      |         |                |

#### 购物车表（Shopping_Cart）

|    Field    | Explain  |     Type      | Null | Key  | Default |     Extra      |
| :---------: | :------: | :-----------: | :--: | :--: | :-----: | :------------: |
|   cart_id   | 购物车ID |      INT      |  NO  | PRI  |  NULL   | AUTO_INCREMENT |
|   user_id   |  用户ID  |      INT      |  NO  | MUL  |  NULL   |                |
| FOREIGN KEY | 用户外键 | user(user_id) |      |      |         |                |

#### 购物车详情表（Shopping_Cart_Item）

|    Field    |   Explain    |          Type          | Null | Key  | Default |     Extra      |
| :---------: | :----------: | :--------------------: | :--: | :--: | :-----: | :------------: |
|   item_id   | 购物车详情ID |          INT           |  NO  | PRI  |  NULL   | AUTO_INCREMENT |
|   cart_id   |   购物车ID   |          INT           |  NO  | MUL  |  NULL   |                |
|   book_id   |    书籍ID    |          INT           |  NO  | MUL  |  NULL   |                |
|  quantity   |     数量     |          INT           |  NO  |      |  NULL   |                |
| FOREIGN KEY |  购物车外键  | shopping_cart(cart_id) |      |      |         |                |
| FOREIGN KEY |   书籍外键   |     book(book_id)      |      |      |         |                |

## 模块

1.

|     名称     |   描述    |
| :----------: | :-------: |
|   模块名称   |   登录    |
|  模块负责人  |  钟俊博   |
| 文档提交日期 | 2023/11/6 |

修改记录

|  No  | 版本号 | 修改内容意见 | 修改日期  | 修改人 |
| :--: | :----: | :----------: | :-------: | :----: |
|  1   | v1.0.0 |   初始版本   | 2023/11/6 | 钟俊博 |

## 接口说明

### 用户登录

url: `http://localhost:3919/login`

method: `GET`

type: `params`

|  参数名  | 参数含义 | 类型/必须 |       备注       |
| :------: | :------: | :-------: | :--------------: |
| userName |  用户名  | String/Y  | 按用户名查询用户 |

接口流程：

输出结果：
