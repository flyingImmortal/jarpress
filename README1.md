# SAPress
SAPress=spring-angularjs-wordpress的press，一个使用最新最流行的框架搭建的能与wordpress比肩的java博客系统。
虽然现在还很弱小，但相信开源的力量，只要还有需要存在我们就会一直维护下去，请大家伸出支持与鼓励的双手一起成长，同时欢迎大家提出您的宝贵建议和意见。

---
QQ交流群：**522480715** 

## 简介
sablog是一个wordpress的java翻版，支持类似wordpress的几乎所有功能，数据库表结构与wordpress4.5完全相同，你的博客可轻松由PHP转换成java版，前端采用angularjs前后端分离的框架编写，可轻松定制前端模板。该软件主要使用了springmvc和Mybatis框架及jfinal的ORM插件，这种框架组合既可满足对稳定性和可靠性要求高的项目，也可满足快速开发的项目，整个框架使用了企业级分包设计理念，分类打包后可分布式部署。友情建议复杂的查询使用mybatis，简单的增删改使用jfinal的ORM。
## 修改说明
2016-08-25 增加评论功能，修复界面上的一些bug。
2016-07-18 经过多次尝试终于成功部署到百度BAE上，非常激动。并且成功按环境自动配置日志和数据库连接，同时使用Druid连接池，轻松监控sql的性能和博客的访问量。
2016-07-10 一个台风忘记密码而迟迟不能登陆的日子里开始了人生中的第二开源项目，第一个是jfinal的一个插件。

## 运行项目配置说明
1、修改数据库配置 修改文件SAPress\src\main\resources\env\dev\jdbc.properties 配置数据库

2、修改数据库表前缀配置 修改文件SAPress\src\main\resources\env\dev\config.properties 

3、导入数据库 
sql脚本位于SAPress\doc\db  
4、打war包，在cmd里进入项目所在目录输入mvn complie package,会在项目所在目录的target目录生成root.war包，直接上传到百度云上重启服务就可以访问了。
## 其他说明
前端angularjs开源项目  
http://git.oschina.net/sablog/sablog_front  
依赖项目smf-framework-core。是对和spring及jfinal插件和一些公用方法的简单封装  
不下载也可以运行，只要删除pom里的依懒，然后把doc文件夹下的jar包放到lib里就可以运行了。

源码地址：


## 演示界面
[http://sapress.duapp.com/](http://sapress.duapp.com/)

## 表结构说明
截至WordPress4.5，WordPress一共有以下12个表。这里加上了默认的表前缀 wp_ 。

wp_commentmeta：存储评论的元数据
wp_comments：存储评论
wp_links：存储友情链接（Blogroll）
wp_options：存储WordPress系统选项和插件、主题配置
wp_postmeta：存储文章（包括页面、上传文件、修订）的元数据
wp_posts：存储文章（包括页面、上传文件、修订）
wp_termmeta：目录、标签的元数据
wp_terms：存储每个目录、标签
wp_term_relationships：存储每个文章、链接和对应分类的关系
wp_term_taxonomy：存储每个目录、标签所对应的分类
wp_usermeta：存储用户的元数据
wp_users：存储用户
##### 更多信息可参考：
http://blog.csdn.net/ppiao1970hank/article/details/6301812

## 鸣谢
###### JPress
###### JFinal
###### oschina
###### wordpress
## 打赏
 ![image](http://gmph.u.qiniudn.com/pay26k.jpg)