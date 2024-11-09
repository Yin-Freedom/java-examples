## 使用说明

SpringBoot和Swagger存在版本依赖问题，需要使用对应版本。

### SpringBoot2

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

并需要加上如下配置

```properties
# spring boot 2.6版本将SpringMVC处理程序映射匹配请求路径的默认策略
# 已从AntPathMatcher更改为PathPatternParser。
spring.mvc.pathmatch.matching-strategy=ant_path_matcher
```

SpringBoot2 Swagger UI: `http://localhost:8080/swagger-ui/index.html`

### SpringBoot3

```xml
<dependency>
   <groupId>org.springdoc</groupId>
   <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
   <version>2.0.0</version>
</dependency>
```

SpringBoot3 Swagger UI: `http://localhost:port/context-path/swagger-ui.html`