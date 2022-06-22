package com.demain.poi.doc.demo.controller;

import com.demain.poi.doc.demo.poi.PoiFileAnalysis;
import com.demain.poi.doc.demo.vo.SleepDetectionActionDiagramVO;
import com.demain.poi.doc.demo.vo.SleepDetectionReportVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping
@Slf4j
public class FileController {


    @RequestMapping("upload")
    public SleepDetectionReportVO upload(MultipartFile multipartFile) throws IOException {

        SleepDetectionReportVO sleepDetectionReportVO = null;

        String osName = System.getProperties().getProperty("os.name");
        String path = "";
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if (osName != null) {
            if (osName.toLowerCase().contains("Linux")) {
                path = "/usr/home/temp/images/" + time + "/";
            } else {
                path = "D:\\Desktop\\image\\" + time + "\\";
            }
        }

        File fl = new File(path);
        if (!fl.exists() && !fl.isDirectory()) {
            // 目录不存在创建
            fl.mkdirs();
        }

        if (!multipartFile.isEmpty()) {

            String originalFilename = multipartFile.getOriginalFilename();
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            if (fileSuffix.endsWith(".doc")) {
                // 处理doc格式 即office2003版本
                sleepDetectionReportVO = handlerDoc(multipartFile,path);
            }
            if (fileSuffix.endsWith(".docx")) {
                 sleepDetectionReportVO = handlerDocx(multipartFile,path);
            }
        }

        return sleepDetectionReportVO;

    }


    /**
     * 处理 doc 后缀文件
     *
     * @param multipartFile 文件
     */
    public SleepDetectionReportVO handlerDoc(MultipartFile multipartFile,String path) {
        log.info("==== doc格式文件 ====");
        HWPFDocument hwpfDocument = transDoc(multipartFile);

        // TODO 如果解析表格、图片、文字 较慢 可以使用多线程
        // 解析表格
        SleepDetectionReportVO tableReportVO =  PoiFileAnalysis.readDocTable(hwpfDocument);
        // 解析图片
        SleepDetectionActionDiagramVO imgVO = PoiFileAnalysis.reaDocImage(hwpfDocument,path);
        // 解析文字
        SleepDetectionActionDiagramVO textVO = PoiFileAnalysis.readDocText(hwpfDocument);

        SleepDetectionActionDiagramVO sleepDetectionActionDiagramVO = SleepDetectionActionDiagramVO.builder()
                .reportUpImage(imgVO.getReportUpImage())
                .reportBottomImage(imgVO.getReportBottomImage())
                .activityScale(textVO.getActivityScale())
                .whiteLightScale(textVO.getWhiteLightScale())
                .colorLightScale(textVO.getColorLightScale())
                .build();

        return SleepDetectionReportVO.builder()
                .summaryStatistics(tableReportVO.getSummaryStatistics())
                .dailyStatistics(tableReportVO.getDailyStatistics())
                .actionDiagramVO(sleepDetectionActionDiagramVO)
                .build();
    }

    /**
     * 处理 docx 后缀文件
     *
     * @param multipartFile 文件
     */
    public SleepDetectionReportVO handlerDocx(MultipartFile multipartFile,String path) {
        log.info("==== docx格式文件 ====");
        XWPFDocument xwpfDocument = transDocx(multipartFile);

        // TODO 如果解析表格、图片、文字 较慢 可以使用多线程
        // 解析表格
        SleepDetectionReportVO tableReportVO = PoiFileAnalysis.readDocxTable(xwpfDocument);
        // 解析图片
        SleepDetectionActionDiagramVO imgVO = PoiFileAnalysis.reaDocxImage(xwpfDocument,path);
        // 解析文字
        SleepDetectionActionDiagramVO textVO = PoiFileAnalysis.readDocxText(xwpfDocument);

        SleepDetectionActionDiagramVO sleepDetectionActionDiagramVO = SleepDetectionActionDiagramVO.builder()
                .reportUpImage(imgVO.getReportUpImage())
                .reportBottomImage(imgVO.getReportBottomImage())
                .activityScale(textVO.getActivityScale())
                .whiteLightScale(textVO.getWhiteLightScale())
                .colorLightScale(textVO.getColorLightScale())
                .build();

        return SleepDetectionReportVO.builder()
                .summaryStatistics(tableReportVO.getSummaryStatistics())
                .dailyStatistics(tableReportVO.getDailyStatistics())
                .actionDiagramVO(sleepDetectionActionDiagramVO)
                .build();
    }


    /**
     * docx 文件转换
     * @param multipartFile 文件
     * @return XWPFDocument
     */
    public static XWPFDocument transDocx(MultipartFile multipartFile) {
        XWPFDocument xwpfDocument = null;
        try {
            InputStream is = multipartFile.getInputStream();
            xwpfDocument = new XWPFDocument(is);
            log.info("==== 获取 xwpfDocument 文件 ====");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xwpfDocument;
    }

    /**
     * doc 文件转换
     * @param multipartFile 文件
     * @return HWPFDocument
     */
    public static HWPFDocument transDoc(MultipartFile multipartFile) {
        HWPFDocument hwpfDocument = null;
        try {
            InputStream is = multipartFile.getInputStream();
            hwpfDocument = new HWPFDocument(is);
            log.info("==== 获取 hwpfDocument 文件 ====");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hwpfDocument;
    }

}
