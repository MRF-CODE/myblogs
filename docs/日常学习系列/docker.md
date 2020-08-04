### 安装虚拟机

下载virtualBox

```
https://www.virtualbox.org/wiki/Downloads
```

下载vagrant

```
https://www.vagrantup.com/
```

下载centos7 镜像

链接: https://pan.baidu.com/s/1kUsgtG5d7Nwj9YH90ECfaA 提取码: sf3t

初始化box

在命令行下执行以下命令，cmd , 其中地址为本地存储centos 镜像的地址

```
vagrant box add centos7 E:/vagrant/Vagrant-CentOS-7.box
```

查看本地 box

```
vagrant box list
```

执行初始化命令

```
vagrant init centos7
```

启动

```
 vagrant up
```

连接虚拟机

```
vagrant ssh
```

### 卸载docker

```
sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
```

### 安装 Docker Engine-Community

在新主机上首次安装 Docker Engine-Community 之前，需要设置 Docker 仓库

设置仓库（阿里云）

使用官方源下载比较慢，笔者采用阿里云的源安装

```
sudo yum-config-manager \
    --add-repo \
    http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```

安装 Docker Engine-Community

```
sudo yum install docker-ce docker-ce-cli containerd.io
```

启动docker

```
$ sudo systemctl start docker
```

### CentOS7 配置镜像加速

对于使用 systemd 的系统，请在 /etc/docker/daemon.json 中写入如下内容（如果文件不存在请新建该文件）：

创建文件命令

```
touch  /etc/docker/daemon.json
```

然后加入以下配置

```
{"registry-mirrors":["https://reg-mirror.qiniu.com/"]}
```

之后重新启动服务：

```
$ sudo systemctl daemon-reload
$ sudo systemctl restart docker
```

查看镜像是否安装成功命令

```
docker info
```

设置docker随容器自动启动

```
systemctl enable docekr
```

### 使用docker 安装mysql

此处我们安装的版本是mysql5.7,为了解决超时的问题，这里笔者采用了国内镜像

通过国内镜像daocloud.io/library库下载

```
docker pull daocloud.io/library/centos:latest
```

```
docker pull daocloud.io/library/mysql:5.7
```

这里安装后我们启动的时候由于是要和vagrant 虚拟机关联，所以启动的时候做了映射

启动容器

```
docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7
```

修改配置文件

```
vi /mydata/mysql/conf/my.cnf
```

```
[client]
default-character-set=utf8

[mysql]
default-character-set=utf8

[mysqld]
init_connect='SET collation_connection = utf8_unicode_ci'
init_connect='SET NAMES utf8'
character-set-server=utf8
collation-server=utf8_unicode_ci
skip-character-set-client-handshake
skip-name-resolve
```

重启

```
docker restart mysql
```

进入mysql容器

```
docker exec -it mysql /bin/bash
```

查看是否成功修改

```
cat /etc/mysql/my.cnf
```

### 使用docker 安装redis

下载镜像

```
docker pull daocloud.io/library/redis
```

创建配置文件

```
mkdir -p /mydata/redis/conf
touch /mydata/redis/conf/redis.conf
```

启动容器

```
docker run -p 6379:6379 --name redis \
-v /mydata/redis/data:/data \
-v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf \
-d redis redis-server /etc/redis/redis.conf
```

运行 redis

```
docker exec -it redis redis-cli
```

开启 aof 持久化

```
vi /mydata/redis/conf/redis.conf
# 添加如下内容
appendonly yes
```

重启 redis

```
docker restart redis
```

### 设置自启动

```
docker update mysql --restart=always

docker update redis --restart=always

```

