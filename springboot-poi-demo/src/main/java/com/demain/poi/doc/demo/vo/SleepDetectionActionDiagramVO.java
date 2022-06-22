package com.demain.poi.doc.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @describe: 动作图
 * @author: demain_lee
 * @since: 2022/5/13 10:02
 */
@Data
@Builder
public class SleepDetectionActionDiagramVO {

    @ApiModelProperty(value = "报告相关动作图")
    private List<String> reportUpImage;

    @ApiModelProperty(value = "报告底部图")
    private String reportBottomImage;

    @ApiModelProperty(value = "活动规模")
    private String activityScale;

    @ApiModelProperty(value = "白光规模")
    private String whiteLightScale;

    @ApiModelProperty(value = "彩光规模")
    private String colorLightScale;
}


