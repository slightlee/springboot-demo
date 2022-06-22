package com.demain.poi.doc.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @describe: 每日统计信息
 * @author: demain_lee
 * @since:  2022/5/15 10:33
 */
@Data
@Builder
public class DailyStatisticsVO {

    @ApiModelProperty(value = "日期 【格式:  星期几 日期 (yyyy-MM-dd)】")
    private String date;

    @ApiModelProperty(value = "上床时间")
    private String bedTime;

    @ApiModelProperty(value = "起床时间")
    private String getUpTime;

    @ApiModelProperty(value = "在床时间（h）")
    private String timeInBed;

    @ApiModelProperty(value = "总睡眠时间（h）")
    private String totalSleepTime;

    @ApiModelProperty(value = "起床延迟")
    private String onsetLatency;

    @ApiModelProperty(value = "睡眠效率(%)")
    private String sleepEfficiency;

    @ApiModelProperty(value = "入睡后清醒时间")
    private String waso;

    @ApiModelProperty(value = "连续睡眠中断次数")
    private String awak;
}
