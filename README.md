## 项目结构

```lua
java-examples
├── docker        -- CICD
├── common        -- 公共模块，返回结果封装，异常，Swagger基础配置，jasypt加密工具，日志配置
├── swagger       -- swagger示例，http://localhost:8080/swagger-ui/index.html
├── mybatis       -- mybatis示例
├── h2database    -- h2数据库示例，方便本地运行
├── rabbitmq      -- rabbitmq示例
├── search        -- elasticsearch+mq示例
└── 
```

## 技术栈

| 名称                   | 版本                        | 说明              |
|----------------------|---------------------------|-----------------|
| spring-boot          | 2.7.18                    |                 |
| swagger              | 3.0.0                     | 和SpringBoot版本匹配 |
| swagger              | 2.9.2                     | 接口文档            |
| mybatis-plus         | 3.3.0                     | ORM框架           |

采用Spring多模块组织项目结构，每个模块引入common模块，获得基本功能。

## 项目启动

1. 由于使用jasypt对配置进行加密，因此需要在环境变量或启动参数中添加如下配置
2. 由于在common包中有Swagger配置，其他引入该模块的都需要实现BaseSwaggerConfig
3. 由于SpringBoot2.6之后mvc映射路径规则变更，需要在application.yml中加上`spring.mvc.pathmatch.matching-strategy=ant_path_matcher`

加密配置

```properties
# 环境变量
jasypt.encryptor.password=XXX

# java启动参数
-Djasypt.encryptor.password=XXX
```

```properties
#使用jasypt加密参数
调用JasyptUtilTest.encrypt方法

#使用jasypt解密参数
调用JasyptUtilTest.decrypt方法
#填写jasypt加密参数格式
jasypt:
    encryptor:
    algorithm: PBEWithMD5AndDES
    iv-generator-classname: org.jasypt.iv.NoIvGenerator
    property:
        prefix: ENC(
        suffix: )
```

