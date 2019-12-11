# iot_project_backend
物联网project服务端开发

## 项目要求

- 收集并上传环境光传感器的测量数据到服务器

- 收集并上传开发板(开/关)上的LED状态到服务器

- 实现一个web页面/移动应用程序/微信迷你程序，要求如下:

1. 可视化环境光传感器的测量

2. 控制LED有两种模式: 在远程应用程序上切换这两种模式

- 手动模式:在远程应用上手动控制LED的开关

- 自动模式:根据环境测量值控制LED的开关光传感器。当测量值低于50勒克斯时打开LED，当测量值低于50勒克斯时关闭LED



## 接口暴露

### 客户端接口

地址与端口：129.226.168.220:8081

**/led/get_state**

get请求，获取led灯状态

后端

```json
{
    state:0或1
}
```



**/led/modify_state**

post请求，修改led灯状态

前端

```json
{
    state:0或1
}
```

后端

```json
{
    state:0或1
    message:修改成功或失败
}
```



**/record/get_record**

post请求，分页获取记录

前端

```json
{
    page:1 //第几页
    volume:10 //每页容量
}
```

后端

```json
[
    {
    	记录对象1
	},
    {
    	记录对象2
	},
]
```

**/mode/get_mode**

get请求，获取状态信息

后端

```json
{
    state:1或2（1为手动模式，2为自动模式）
}
```



**/mode/modify_mode**

post请求，修改状态信息

前端

```json
{
    state:1或2（1为手动模式，2为自动模式）
}
```

后端

```json
{
    state:0或1
    message:修改成功或失败
}
```





## 硬件接口

地址与端口：129.226.168.220:1883

服务器这里开了4个topic：

- light：硬件往这个topic发布环境中的灯光信息，直接传int值
- ledh：硬件往这个topic发布led灯的暗灭信息，0为关灯，1为开灯
- mode：服务器往这个topic发布指令，1为手动模式，2为自动模式。
- leds：服务器往这个topic发布指令，如果硬件为手动模式，0为关灯，1为开灯。