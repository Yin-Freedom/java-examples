# Document

## 项目启动

docker镜像

```shell
docker pull nginx:1.22-alpine
docker pull rabbitmq:3.9.11-management
```

WSL执行路径

```shell
cd /mnt/d/program/src/java-examples/docker
docker-compose up -d

```

docker-ce安装

```shell
sudo apt update
sudo apt upgrade -y

sudo apt install apt-transport-https ca-certificates curl -y

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
  
sudo apt update
sudo apt install docker-ce docker-ce-cli containerd.io docker-compose -y

# 验证
sudo systemctl status docker
```

## 问题记录

- docker重装错误

```
Job for docker.service failed because the control process exited with error code.
See "systemctl status docker.service" and "journalctl -xe" for details.
```

解决办法：
1.查看启动错误原因 `sudo dockerd --debug`
2.根据原因排查。我的问题是重写`/etc/docker/daemon.json`时导致文件内容错误

- 