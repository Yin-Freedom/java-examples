# RabbitMQ

使用场景

1. 异步任务
    - 文件上传、图片处理、邮件发送等
2. 日志聚合与处理
    - RabbitMQ 可以作为日志收集系统的一部分，接收来自不同服务的日志信息，并将其转发给日志处理服务或存储系统。
3. 流量削峰：
    - 在高流量的互联网应用中，如电商促销活动期间，RabbitMQ 可以用来缓冲瞬时高峰流量，避免后端系统因压力过大而崩溃。

使用步骤

1. 添加依赖项
2. 添加配置，rabbitmq、mail
3. 创建RabbitMQ配置类
4. 创建邮件发送服务
5. 创建消费者

```shell
# 拉取镜像
docker pull dhub.kubesre.xyz/rabbitmq:3.9.11-management

# 启动镜像
docker run -d \
  --name rabbitmq \
  -p 5672:5672 \
  -p 15672:15672 \
  -v /mydata/rabbitmq/data:/var/lib/rabbitmq
  dhub.kubesre.xyz/rabbitmq:3.9.11-management
```
