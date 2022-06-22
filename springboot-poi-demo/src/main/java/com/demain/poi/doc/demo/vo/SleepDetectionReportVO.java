package com.demain.poi.doc.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @describe: 睡眠监测报告
 * @author: demain_lee
 * @since: 2022/5/13 10:02
 */
@Data
@ApiModel(value = "SleepDetectionReportVO对象", description = "睡眠监测报告")
@Builder
public class SleepDetectionReportVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报告基础信息
     */
    @ApiModelProperty(value = "报告名字")
    private String reportName;

    @ApiModelProperty(value = "报告生成时间")
    private String reportTime;

    /**
     * 汇总统计信息
     */
    @ApiModelProperty(value = "汇总统计信息")
    private List<SummaryStatisticsVO> summaryStatistics;

    /**
     * 每日统计信息
     */
    @ApiModelProperty(value = "每日统计信息")
    private List<DailyStatisticsVO> dailyStatistics;

    /**
     * 动作图  Action diagram
     */
    @ApiModelProperty(value = "动作图")
    private SleepDetectionActionDiagramVO actionDiagramVO;


}


