## 项目背景

&emsp;&nbsp;经过长达三个月的技术攻坚，我们正式宣布完成对九年历史开源项目的全面重构升级！原项目基于JFina框架开发，现采用SpringBoot+MyBatis技术栈重构，正式更名为Jarpress。<br/>
<img src="https://www.seifly.cn/jarpress/img/7.png">
-  **体验网址** ：http://jarpress.seifly.cn
-  **前端源码地址** ：https://gitee.com/sablog/jarpress_front1
## 架构升级

采用最小组件依赖实现，减少系统复杂度，缩短学习曲线和上手难度，不懂技术的人也能轻易部署，有需要也可联系本人协助部署。

### 后端技术栈：

核心框架：Spring Boot 2.7.18 + JDK 1.8 LTS

wordpress: 6.7.2

API文档：Spring Doc OpenAPI 3.0

### 前端技术矩阵：

小程序端：Uni-app 3.x + Vant Weapp

## 源码说明
jarpress/<br>
├── seifly-common/          # 公共项目<br>
│   ├── common/        # 公用类<br>
│   └── framework/     # 框架相关公用类<br>
├── seifly-javapress/            # DDD 核心域<br>
├── javapress-app/      # 应用层<br>
└── javapress-business/ # DDD风格，业务核心层不依赖其它层<br>
└── javapress-dao/      # 持久层<br>

## 核心功能

实现WordPress网站数据与小程序共享数据，pc与移动端同步更新内容

可一键将wordPress的帖子发布到微信公众号

系统深度融合 WordPress 内容生态,实现wordpress零侵入，无须安装插件和修改数据库表结构和参数。

一套代码实现H5及各应用平台小程序的编译和打包。

多款开源资讯前端选择，总一套你喜欢的配色和主题，满足不同用户的喜好，并可付费定制。

## 插件增值服务

2025.Q2：接入deepseek，查询各大平台热点，根据标题自动编写文章并发表。<br/>
2025.Q3：开发类似小红书样式前端展示。

## 下载源码

开源协议：AMT License
项目地址：https://gitee.com/sablog/jarpress
文档中心：https://gitee.com/sablog/jarpress/doc/README.md

## 安装和启动命令
$ git clone --depth 1 https://github.com/jarpress/jarpress.git      

$ cd jarpress && mvn -T 4C clean install    

$ java -jar --enable-preview jarpress-admin/target/*.jar<br/>

 ## **联系作者微信**   
  <p align="center">
 <img src="https://www.seifly.cn/jarpress/img/8.jpg" hight="150px" width="150px"> </p>

## **交流微信群**

请先加我的微信：<strong>softsxf </strong>，我拉你入群。加微信时备注信息: 来自开源社区。  

### 鸣谢
1.若依   
2.芋道   
3.wordpress   
感谢所有为Jarpress贡献代码的开发者和用户，他们的支持和关注是我们前进的动力。

## 十年风雨初心不改，全新架构再启征程！诚邀开发者共建生态，让内容管理更简单！