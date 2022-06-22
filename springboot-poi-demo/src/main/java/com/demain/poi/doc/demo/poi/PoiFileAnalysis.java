package com.demain.poi.doc.demo.poi;

import com.demain.poi.doc.demo.util.UUIDUtil;
import com.demain.poi.doc.demo.util.WmfUtil;
import com.demain.poi.doc.demo.vo.DailyStatisticsVO;
import com.demain.poi.doc.demo.vo.SleepDetectionActionDiagramVO;
import com.demain.poi.doc.demo.vo.SleepDetectionReportVO;
import com.demain.poi.doc.demo.vo.SummaryStatisticsVO;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @describe: 文档解析
 * @author: demain_lee
 * @since: 2022-06-09
 */
public class PoiFileAnalysis {

    private static final String BOTTOM_IMAGE_BASE64 = "iVBORw0KGgoAAAANSUhEUgAAAlUAAAAxCAIAAAB8nsuAAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA+tpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDYuMC1jMDA2IDc5LmRhYmFjYmIsIDIwMjEvMDQvMTQtMDA6Mzk6NDQgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIDIyLjQgKE1hY2ludG9zaCkiIHhtcDpDcmVhdGVEYXRlPSIyMDIyLTA2LTA5VDEwOjAxOjA3KzA4OjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAyMi0wNi0wOVQwMjoxNDozMyswODowMCIgeG1wOk1ldGFkYXRhRGF0ZT0iMjAyMi0wNi0wOVQwMjoxNDozMyswODowMCIgZGM6Zm9ybWF0PSJpbWFnZS9wbmciIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MzA1RkFFODdERkJFMTFFQzlDNjREMkUzQjhFRDQyNTAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MzA1RkFFODhERkJFMTFFQzlDNjREMkUzQjhFRDQyNTAiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RS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";

    /**
     * 解析docx表格
     *
     * @param doc XWPFDocument
     * @return SleepDetectionReportVO
     */
    public static SleepDetectionReportVO readDocxTable(XWPFDocument doc) {

        // 汇总统计信息
        List<Map<Integer, String>> summaryStatisticsMapList = new ArrayList<>();
        // 每日统计信息
        List<Map<Integer, String>> dailyStatisticsMapList = new ArrayList<>();

        List<XWPFTable> tables = doc.getTables();
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;

        try {

            for (int i = 0; i < tables.size(); i++) {
                // 根据实际文档定义
                if (i == 1) {
                    //表格属性
                    CTTblPr pr = tables.get(i).getCTTbl().getTblPr();
                    //获取表格对应的行
                    rows = tables.get(i).getRows();
                    for (int j = 1; j < rows.size(); j++) {
                        cells = rows.get(j).getTableCells();
                        Map<Integer, String> map = new LinkedHashMap<>();
                        for (int k = 0; k < cells.size(); k++) {
                            System.out.print(cells.get(k).getText().trim() + " ");
                            map.put(k, cells.get(k).getText().trim());
                        }
                        summaryStatisticsMapList.add(map);
                    }

                }

                if (i == 5) {
                    //表格属性
                    CTTblPr pr = tables.get(i).getCTTbl().getTblPr();
                    //获取表格对应的行
                    rows = tables.get(i).getRows();
                    for (int j = 1; j < rows.size(); j++) {
                        cells = rows.get(j).getTableCells();
                        Map<Integer, String> map = new LinkedHashMap<>();
                        for (int k = 0; k < cells.size(); k++) {
                            System.out.print(cells.get(k).getText().trim() + " ");
                            map.put(k, cells.get(k).getText().trim());
                        }
                        dailyStatisticsMapList.add(map);
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据解析失败");
        }

        // 转换数据
        List<SummaryStatisticsVO> summaryStatisticsList = getSummaryStatisticsList(summaryStatisticsMapList);
        // 转换数据
        List<DailyStatisticsVO> dailyStatisticsList = getDailyStatisticsList(dailyStatisticsMapList);

        return SleepDetectionReportVO.builder()
                .summaryStatistics(summaryStatisticsList)
                .dailyStatistics(dailyStatisticsList)
                .build();
    }


    /**
     * 解析doc表格
     *
     * @param doc XWPFDocument
     * @return SleepDetectionReportVO
     */
    public static SleepDetectionReportVO readDocTable(HWPFDocument doc) {

        Range range = doc.getRange();

        // 汇总统计信息
        List<Map<Integer, String>> summaryStatisticsMapList = getSummaryStatisticsMapList(range);
        // 每日统计信息
        List<Map<Integer, String>> dailyStatisticsMapList = getDailyStatisticsMapList(range);

        // 转换数据
        List<SummaryStatisticsVO> summaryStatisticsList = getSummaryStatisticsList(summaryStatisticsMapList);
        // 转换数据
        List<DailyStatisticsVO> dailyStatisticsList = getDailyStatisticsList(dailyStatisticsMapList);

        return SleepDetectionReportVO.builder()
                .summaryStatistics(summaryStatisticsList)
                .dailyStatistics(dailyStatisticsList)
                .build();
    }


    /**
     * 汇总统计信息
     *
     * @param range range
     * @return list
     */
    public static List<Map<Integer, String>> getSummaryStatisticsMapList(Range range) {

        List<Map<Integer, String>> summaryStatisticsMapList = new ArrayList<>();

        Table table;
        TableRow row;
        TableCell cell;
        TableIterator tableIter = new TableIterator(range);

        // 若是有多个表格只读取须要的一个 set是设置须要读取的第几个表格，total是文件中表格的总数
        int set = 2, total = 7;
        int num = set;
        for (int i = 0; i < set - 1; i++) {
            tableIter.hasNext();
            tableIter.next();
        }

        try {
            while (tableIter.hasNext()) {
                table = (Table) tableIter.next();
                int rowNum = table.numRows();
                for (int j = 1; j < rowNum; j++) {
                    row = table.getRow(j);
                    int cellNum = row.numCells();
                    Map<Integer, String> map = new LinkedHashMap<>();
                    for (int k = 0; k < cellNum; k++) {
                        cell = row.getCell(k);
                        //输出单元格的文本
                        map.put(k, cell.text().trim());
                    }
                    summaryStatisticsMapList.add(map);
                }

                // 过滤多余的表格
                while (num < total) {
                    tableIter.hasNext();
                    tableIter.next();
                    num += 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据解析失败");
        }

        return summaryStatisticsMapList;
    }

    /**
     * 每日统计信息
     *
     * @param range range
     * @return list
     */
    public static List<Map<Integer, String>> getDailyStatisticsMapList(Range range) {

        List<Map<Integer, String>> dailyStatisticsMapList = new ArrayList<>();

        Table table;
        TableRow row;
        TableCell cell;
        TableIterator tableIter = new TableIterator(range);

        // 若是有多个表格只读取须要的一个 set是设置须要读取的第几个表格，total是文件中表格的总数
        int set = 6, total = 7;
        int num = set;
        for (int i = 0; i < set - 1; i++) {
            tableIter.hasNext();
            tableIter.next();
        }

        try {
            while (tableIter.hasNext()) {
                table = (Table) tableIter.next();
                int rowNum = table.numRows();
                for (int j = 1; j < rowNum; j++) {
                    row = table.getRow(j);
                    int cellNum = row.numCells();
                    Map<Integer, String> map = new LinkedHashMap<>();
                    for (int k = 0; k < cellNum; k++) {
                        cell = row.getCell(k);
                        //输出单元格的文本
                        map.put(k, cell.text().trim());
                    }
                    dailyStatisticsMapList.add(map);
                }

                // 过滤多余的表格
                while (num < total) {
                    tableIter.hasNext();
                    tableIter.next();
                    num += 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据解析失败");
        }

        return dailyStatisticsMapList;
    }


    /**
     * 处理 汇总统计信息 数据
     *
     * @param summaryStatisticsMapList list
     * @return 汇总统计信息
     */
    public static List<SummaryStatisticsVO> getSummaryStatisticsList(List<Map<Integer, String>> summaryStatisticsMapList) {

        List<SummaryStatisticsVO> summaryStatisticsList = new ArrayList<>();

        // 转换数据
        for (int i = 0; i < summaryStatisticsMapList.size(); i++) {

            Map<Integer, String> map = summaryStatisticsMapList.get(i);

            SummaryStatisticsVO summaryStatisticsVO = SummaryStatisticsVO.builder()
                    .type(map.get(0))
                    .bedTime(map.get(1))
                    .getUpTime(map.get(2))
                    .timeInBed(map.get(3))
                    .totalSleepTime(map.get(4))
                    .onsetLatency(map.get(5))
                    .sleepEfficiency(map.get(6))
                    .waso(map.get(7))
                    .awak(map.get(8))
                    .build();
            summaryStatisticsList.add(summaryStatisticsVO);
        }

        return summaryStatisticsList;

    }


    /**
     * 处理 每日统计信息 数据
     *
     * @param dailyStatisticsMapList list
     * @return 每日统计信息
     */
    public static List<DailyStatisticsVO> getDailyStatisticsList(List<Map<Integer, String>> dailyStatisticsMapList) {

        List<DailyStatisticsVO> dailyStatisticsList = new ArrayList<>();

        for (int i = 0; i < dailyStatisticsMapList.size(); i++) {

            Map<Integer, String> map = dailyStatisticsMapList.get(i);

            DailyStatisticsVO dailyStatisticsVO = DailyStatisticsVO.builder()
                    .date(map.get(0))
                    .bedTime(map.get(1))
                    .getUpTime(map.get(2))
                    .timeInBed(map.get(3))
                    .totalSleepTime(map.get(4))
                    .onsetLatency(map.get(5))
                    .sleepEfficiency(map.get(6))
                    .waso(map.get(7))
                    .awak(map.get(8))
                    .build();
            dailyStatisticsList.add(dailyStatisticsVO);
        }

        return dailyStatisticsList;

    }


    /**
     * 解析docx文档 图片
     *
     * @param doc XWPFDocument
     * @return SleepDetectionActionDiagramVO
     */
    public static SleepDetectionActionDiagramVO reaDocxImage(XWPFDocument doc, String path) {

        Map<Integer, String> map = new HashMap<>();

        List<XWPFPictureData> picList = doc.getAllPictures();

        List<String> fileList = new ArrayList<>();

        for (XWPFPictureData pic : picList) {
            // 获取的图片是无序的，需要处理
            byte[] bytev = pic.getData();

            String base64Str = "";

            try {
                // 是 wmf 格式图片 需要处理成 png
                if (pic.getFileName().toLowerCase().contains("wmf")) {

                    String filePath = path + UUIDUtil.shortUuid() + "_" + pic.getFileName();

                    // 下载到本地
                    FileOutputStream fos = new FileOutputStream(filePath);
                    fos.write(bytev);

                    String pngPath = WmfUtil.wmfConversionPng(filePath);

                    base64Str = WmfUtil.imageToBase64NoPrefix(pngPath);

                    fileList.add(filePath);

                } else {
                    base64Str = Base64.getEncoder().encodeToString(bytev);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 去除 \r\n
            base64Str = base64Str.replaceAll("\r|\n", "");

//            System.out.println(base64Str + "\n");
            String fileName = pic.getFileName();
            String fileName2 = fileName.substring(5, fileName.length());
            String key = fileName2.substring(0, fileName2.length() - 4);
            map.put(Integer.valueOf(key), base64Str);
        }

        Map<Integer, String> mp = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<String> list = new ArrayList<>(mp.values());
        list.remove(list.size() - 1);
        return SleepDetectionActionDiagramVO.builder()
                .reportUpImage(list)
                .reportBottomImage(BOTTOM_IMAGE_BASE64)
                .build();
    }


    /**
     * 解析doc文档 图片
     *
     * @param doc XWPFDocument
     * @return SleepDetectionActionDiagramVO
     */
    public static SleepDetectionActionDiagramVO reaDocImage(HWPFDocument doc,String path) {

        PicturesTable picturesTable = doc.getPicturesTable();
        List<Picture> picList = picturesTable.getAllPictures();
        List<String> fileList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        picList.forEach(picture -> {
            System.out.println(picture);
            byte[] content = picture.getContent();
            String base64Str = "";

            try {
                if (picture.getMimeType().contains("wmf")) {

                    System.out.println(picture.suggestFullFileName());

                    String filePath = path + UUIDUtil.shortUuid() + "_" + picture.suggestFullFileName();

                    // 下载到本地
                    FileOutputStream fos = new FileOutputStream(filePath);

                    fos.write(content);

                    String pngPath = WmfUtil.wmfConversionPng(filePath);

                    base64Str = WmfUtil.imageToBase64NoPrefix(pngPath);

                    fileList.add(filePath);

                } else {
                    base64Str = Base64.getEncoder().encodeToString(content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(base64Str + "\n");
            // 去除 \r\n
            base64Str = base64Str.replaceAll("\r|\n", "");
            list.add(base64Str);
        });

        list.remove(list.size() - 1);

        return SleepDetectionActionDiagramVO.builder()
                .reportUpImage(list)
                .reportBottomImage(BOTTOM_IMAGE_BASE64)
                .build();
    }

    /**
     * 读取 Docx text 文本
     *
     * @param doc XWPFDocument
     * @return SleepDetectionActionDiagramVO
     */
    public static SleepDetectionActionDiagramVO readDocxText(XWPFDocument doc) {

        List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();

        List<XWPFRun> runs = xwpfParagraphList.get(17).getRuns();
        System.out.println("---" + runs.get(0).text());

        /*
         * 数据格式不固定
         * 可能存在 Activity Scale: 394/0, White Light Scale: 26850.0/0.1, Color Light Scale: 2.700E+04/1.000E-02
         * 也可能是 Activity Scale: 394/0
         * 需要 取 394/0  26850.0/0.1
         */
        String paragraphText = runs.get(0).text().trim();
        String[] str = new String[3];

        if (StringUtils.hasLength(paragraphText)) {
            // 判断是否包含 ,
            if (paragraphText.contains(", ")) {
                // 说明至少存在两组数据
                String[] arr = paragraphText.split(", ");

                for (int i = 0; i < arr.length; i++) {
                    String[] val = arr[i].split(": ");
                    str[i] = val[1];
                }
            } else {
                String[] val = paragraphText.split(": ");
                str[0] = val[1];
            }
        }

        return SleepDetectionActionDiagramVO.builder()
                .activityScale(Objects.isNull(str[0]) ? "" : str[0])
                .whiteLightScale(Objects.isNull(str[1]) ? "" : str[1])
                .colorLightScale(Objects.isNull(str[2]) ? "" : str[2])
                .build();

    }


    /**
     * 读取 Doc text 文本
     *
     * @param doc XWPFDocument
     * @return SleepDetectionActionDiagramVO
     */
    public static SleepDetectionActionDiagramVO readDocText(HWPFDocument doc) {

        Range range = doc.getRange();

        Paragraph p = range.getParagraph(79);
        String paragraphText = p.text().trim();

        /*
         * 数据格式不固定
         * 可能存在 Activity Scale: 394/0, White Light Scale: 26850.0/0.1, Color Light Scale: 2.700E+04/1.000E-02
         * 也可能是 Activity Scale: 394/0
         * 需要 取 394/0  26850.0/0.1
         */
        String[] str = new String[3];

        if (StringUtils.hasLength(paragraphText)) {
            // 判断是否包含 ,
            if (paragraphText.contains(", ")) {
                // 说明至少存在两组数据
                String[] arr = paragraphText.split(", ");

                for (int i = 0; i < arr.length; i++) {
                    String[] val = arr[i].split(": ");
                    str[i] = val[1];
                }
            } else {
                String[] val = paragraphText.split(": ");
                str[0] = val[1];
            }
        }

        return SleepDetectionActionDiagramVO.builder()
                .activityScale(Objects.isNull(str[0]) ? "" : str[0])
                .whiteLightScale(Objects.isNull(str[1]) ? "" : str[1])
                .colorLightScale(Objects.isNull(str[2]) ? "" : str[2])
                .build();

    }

}
