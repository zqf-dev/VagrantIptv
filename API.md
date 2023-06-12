## API接口

### Base Url: https://tv.cctv.com/live

### 频道：首页、直播、听音、节目单、栏目大全、片库、热榜、视频百科、微故事、AI美食

### 1、直播

```java
url: https://api.cntv.cn/epg/nowepg
{
	Method: GET
	params: 
	{
		c:cctv1,cctv2....[可变参数逗号分割]
		serviceId:tvcctv [default=tvcctv]
		cb:t [default=t]
	}
	response: 处理json：头——>"t("	尾——>");"
}
icon：https://t.live.cntv.cn/imagehd
{
    Method：Get
    params：
    {
        cctvx_01.png [可变参数cctv1_01.png、cctv2_01.png...]
    }
}
每个时段的详情：https://tv.cctv.com/lm/
{
    Method：GET
    params：每个时段的首字母拼音：{例如：第一时间=dysj、正点财经=zdcj}
}
```



#### CCTV1

```java
videoUrl：https://cctvwbndbd.a.bdydns.com/cctvwbnd/cctv1_2/index.m3u8
```

#### CCTV2

```java
1、正点财经时段：
列表详情：https://api.cntv.cn/NewVideo/getVideoListByColumn?id=TOPC1453100395512779&n=100&sort=desc&p=1&bd=20230612&mode=2&serviceId=tvcctv&cb=cb
{
    Method：Get
    params: bd：[例如：20230612]
}
videoUrl：	https://newcntv.qcloudcdn.com/asp/hls/main/0303000a/3/default/312ab1d0a3184ce0b4e668869a9b6fa4/main.m3u8?maxbr=2048
2、
```

#### CCTV13

```java
1、cctv13播放时段列表接口：
https://api.cntv.cn/epg/epginfo3?serviceId=shiyi&d=20230612&c=cctv13&cb=LiveTileShow.prototype.getEpg
2、对应时段的详情:
https://vdn.apps.cntv.cn/api/getHttpVideoInfo.do?pid=6e7e815400324e4ca938b8e74b40e824
{
    Method：Get
    params：pid：[播放时段列表中item项的vid值]
}
3、对应时段的视频播放Url：
https://newcntv.qcloudcdn.com/asp/hls/main/0303000a/3/default/6e7e815400324e4ca938b8e74b40e824/main.m3u8?maxbr=2048
{
    来源：取 [对应时段详情接口] 中hls_url字段值
}
```



