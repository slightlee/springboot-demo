### poi world文档

> poi解析doc、docx 格式world文档示例
>
> 包含表格、文字、图片等

### poi相关

```xml
<!--POI包 -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-scratchpad</artifactId>
    <version>5.2.2</version>
</dependency>
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.2</version>
</dependency>
```

### 图片转换相关

```xml
<!-- wmf转svg转png -->
<dependency>
    <groupId>net.arnx</groupId>
    <artifactId>wmf2svg</artifactId>
    <version>0.9.11</version>
</dependency>

<!--    svg转png-->
<dependency>
    <groupId>org.apache.xmlgraphics</groupId>
    <artifactId>batik-codec</artifactId>
    <version>1.14</version>
</dependency>
```


文档示例：

![img1](../springboot-poi-demo/src/main/java/com/demain/poi/doc/demo/images/img1.png)

![img2](../springboot-poi-demo/src/main/java/com/demain/poi/doc/demo/images/img2.png)

![img3](../springboot-poi-demo/src/main/java/com/demain/poi/doc/demo/images/img3.png)

解析数据示例：

```json
{
    "reportName": null,
    "reportTime": null,
    "summaryStatistics": [
        {
            "type": "Min",
            "bedTime": "21:37:45",
            "getUpTime": "5:14:00",
            "timeInBed": "7:24:30",
            "totalSleepTime": "6:16:30",
            "onsetLatency": "0.00",
            "sleepEfficiency": "79.60",
            "waso": "10.50",
            "awak": "15"
        },
        {
            "type": "Max",
            "bedTime": "22:35:00",
            "getUpTime": "7:50:00",
            "timeInBed": "9:32:30",
            "totalSleepTime": "8:29:15",
            "onsetLatency": "64.25",
            "sleepEfficiency": "92.83",
            "waso": "25.25",
            "awak": "59"
        },
        {
            "type": "Avg",
            "bedTime": "22:08:12",
            "getUpTime": "6:06:27",
            "timeInBed": "7:58:15",
            "totalSleepTime": "7:03:08",
            "onsetLatency": "21.71",
            "sleepEfficiency": "88.79",
            "waso": "16.43",
            "awak": "32.00"
        }
    ],
    "dailyStatistics": [
        {
            "date": "星期二 2013/11/5",
            "bedTime": "21:37:45",
            "getUpTime": "5:18:45",
            "timeInBed": "7:41:00",
            "totalSleepTime": "7:04:00",
            "onsetLatency": "14.00",
            "sleepEfficiency": "91.97",
            "waso": "17.00",
            "awak": "46"
        },
        {
            "date": "星期三 2013/11/6",
            "bedTime": "22:15:00",
            "getUpTime": "5:39:30",
            "timeInBed": "7:24:30",
            "totalSleepTime": "6:40:30",
            "onsetLatency": "9.00",
            "sleepEfficiency": "90.10",
            "waso": "11.25",
            "awak": "20"
        },
        {
            "date": "星期四 2013/11/7",
            "bedTime": "22:35:00",
            "getUpTime": "6:19:15",
            "timeInBed": "7:44:15",
            "totalSleepTime": "6:59:00",
            "onsetLatency": "18.75",
            "sleepEfficiency": "90.25",
            "waso": "15.25",
            "awak": "15"
        },
        {
            "date": "星期五 2013/11/8",
            "bedTime": "22:34:30",
            "getUpTime": "6:27:30",
            "timeInBed": "7:53:00",
            "totalSleepTime": "6:16:30",
            "onsetLatency": "64.25",
            "sleepEfficiency": "79.60",
            "waso": "10.50",
            "awak": "16"
        },
        {
            "date": "星期六 2013/11/9",
            "bedTime": "21:44:30",
            "getUpTime": "5:14:00",
            "timeInBed": "7:29:30",
            "totalSleepTime": "6:57:15",
            "onsetLatency": "0.00",
            "sleepEfficiency": "92.83",
            "waso": "25.25",
            "awak": "32"
        },
        {
            "date": "星期日 2013/11/10",
            "bedTime": "22:17:30",
            "getUpTime": "7:50:00",
            "timeInBed": "9:32:30",
            "totalSleepTime": "8:29:15",
            "onsetLatency": "32.75",
            "sleepEfficiency": "90.73",
            "waso": "19.00",
            "awak": "36"
        },
        {
            "date": "星期一 2013/11/11",
            "bedTime": "21:53:15",
            "getUpTime": "5:56:15",
            "timeInBed": "8:03:00",
            "totalSleepTime": "6:55:30",
            "onsetLatency": "13.25",
            "sleepEfficiency": "86.02",
            "waso": "16.75",
            "awak": "59"
        }
    ],
    "actionDiagramVO": {
        "reportUpImage": [
            "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",
        ],
        "reportBottomImage": "iVBORw0KGgoAAAANSUhEUgAAAlUAAAAxCAIAAAB8nsuAAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA+tpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDYuMC1jMDA2IDc5LmRhYmFjYmIsIDIwMjEvMDQvMTQtMDA6Mzk6NDQgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIDIyLjQgKE1hY2ludG9zaCkiIHhtcDpDcmVhdGVEYXRlPSIyMDIyLTA2LTA5VDEwOjAxOjA3KzA4OjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAyMi0wNi0wOVQwMjoxNDozMyswODowMCIgeG1wOk1ldGFkYXRhRGF0ZT0iMjAyMi0wNi0wOVQwMjoxNDozMyswODowMCIgZGM6Zm9ybWF0PSJpbWFnZS9wbmciIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MzA1RkFFODdERkJFMTFFQzlDNjREMkUzQjhFRDQyNTAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MzA1RkFFODhERkJFMTFFQzlDNjREMkUzQjhFRDQyNTAiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RS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",
        "activityScale": "394/0",
        "whiteLightScale": "26850.0/0.1",
        "colorLightScale": "2.700E+04/1.000E-02"
    }
}
```