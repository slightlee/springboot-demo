package com.demain.poi.doc.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @describe: 汇总统计信息
 * @author: demain_lee
 * @since:  2022/5/15 10:33
 */
@Data
@Builder
public class SummaryStatisticsVO {

    @ApiModelProperty(value = "type")
    private String type;

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

    @ApiModelProperty(value = "WASO（m）")
    private String waso;

    @ApiModelProperty(value = "awak")
    private String awak;

}
