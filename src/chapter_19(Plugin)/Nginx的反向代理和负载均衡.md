### 1. Nginx 反向代理和负载均衡配置

#### 1.1 安装 Nginx
在大多数 Linux 发行版上，可以使用包管理器来安装 Nginx。
```bash
sudo apt-get update
sudo apt-get install nginx
```

#### 1.2 配置文件结构
- `/etc/nginx/nginx.conf`：主配置文件
- `/etc/nginx/conf.d/`：包含各个虚拟主机的配置文件

#### 1.3 反向代理和负载均衡配置
假设有两个后端服务器 `http://192.168.1.101:8080` 和 `http://192.168.1.102:8080`，它们都提供了登录和注册功能。

##### 1.3.1 定义上游服务器组
创建或修改 `/etc/nginx/conf.d/load_balancer.conf` 文件，定义上游服务器组和反向代理配置。

```nginx
http {
    upstream backend_servers {
        server 192.168.1.101:8080;
        server 192.168.1.102:8080;
    }

    server {
        listen 80;
        server_name example.com;

        location / {
            proxy_pass http://backend_servers;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto $scheme;
        }

        # 处理登录请求
        location /login {
            proxy_pass http://backend_servers/login;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto $scheme;
        }

        # 处理注册请求
        location /register {
            proxy_pass http://backend_servers/register;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto $scheme;
        }
    }
}
```

### 2. 配置文件说明

- **upstream backend_servers**：定义了上游服务器组，包括两个后端服务器 `192.168.1.101:8080` 和 `192.168.1.102:8080`。
- **server**：定义了一个虚拟服务器，监听 `80` 端口，域名为 `example.com`。
- **location /**：将根路径的请求代理到上游服务器组。
- **location /login**：将 `/login` 路径的请求代理到上游服务器组的 `/login` 路径。
- **location /register**：将 `/register` 路径的请求代理到上游服务器组的 `/register` 路径。

### 3. 检查配置和重启 Nginx
在修改配置文件后，使用以下命令检查配置文件的语法是否正确：
```bash
sudo nginx -t
```
如果配置文件正确，则重启 Nginx 服务使配置生效：
```bash
sudo systemctl restart nginx
```

### 4. 示例测试
假设有两个后端服务器运行在 `192.168.1.101:8080` 和 `192.168.1.102:8080` 上，它们提供了相同的 Web 服务，包括 `/login` 和 `/register` 功能。

- **访问根路径**：打开浏览器，访问 `http://example.com`，请求将被反向代理到两个后端服务器中的一个。
- **访问登录页面**：访问 `http://example.com/login`，请求将被反向代理到两个后端服务器中的 `/login` 页面。
- **访问注册页面**：访问 `http://example.com/register`，请求将被反向代理到两个后端服务器中的 `/register` 页面。

### 5. 常见问题和解决办法

- **Nginx 服务未启动或重启失败**：检查配置文件的语法是否正确。
  ```bash
  sudo nginx -t
  ```
- **无法访问后端服务器**：确保后端服务器地址和端口正确，并且防火墙没有阻止访问。
- **负载均衡不均匀**：检查服务器的权重配置，并确保所有后端服务器都正常运行。

### 6. 总结
通过 Nginx 配置反向代理和负载均衡，可以显著提升应用的性能和可靠性。反向代理有助于隐藏后端服务器，提高安全性；负载均衡则能均衡分配流量，避免单点故障。

---

### 复习笔记
1. **反向代理的基本配置**：
    - 安装 Nginx
    - 修改配置文件，使用 `proxy_pass` 指定后端服务器地址。

2. **负载均衡的基本配置**：
    - 定义 `upstream` 块，列出后端服务器。
    - 在 `server` 块中使用 `proxy_pass` 指向 `upstream` 名称。

3. **负载均衡策略**：
    - 轮询（默认）
    - 加权轮询
    - IP 哈希

4. **常见问题排查**：
    - 配置文件语法检查 `sudo nginx -t`
    - 确认后端服务器可访问
    - 确保负载均衡配置正确
