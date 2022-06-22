package com.demain.poi.doc.demo.util;

import net.arnx.wmf2svg.gdi.svg.SvgGdi;
import net.arnx.wmf2svg.gdi.wmf.WmfParser;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class WmfUtil {


    /**
     * wmf转换为png图片格式
     * @param list wmf格式集合
     * @return png格式图片
     */
    public static String wmfConversionPng(List<String> list){
        if (list.size() > 0) {
            // 对文件的命名进行重新修改
            for (int i = 0; i < list.size(); i++) {
                String saveUrl = list.get(i);
                // 从doc文档解析的图片很有可能已经是png了，所以此处需要判断
                if (saveUrl.contains("wmf") || saveUrl.contains("WMF")) {
                    // 将wmf转svg
                    String svgFile = saveUrl.substring(0,
                            saveUrl.lastIndexOf(".wmf"))
                            + ".svg";
                    wmfToSvg(saveUrl, svgFile);
                    // 将svg转png
                    String jpgFile = saveUrl.substring(0,
                            saveUrl.lastIndexOf(".wmf"))
                            + ".png";
                    svgToJpg(svgFile, jpgFile);
                    return jpgFile;
                }
            }
        }
        return null;
    }


    /**
     * wmf转换为png图片格式
     * @param str wmf格式
     * @return png格式图片
     */
    public static String wmfConversionPng(String str) throws IOException {
        if (!StringUtils.isEmpty(str)) {
            // 对文件的命名进行重新修改
            String saveUrl = str;
            // 从doc文档解析的图片很有可能已经是png了，所以此处需要判断
            if (saveUrl.contains("wmf") || saveUrl.contains("WMF")) {
                // 将wmf转svg
                String svgFile = saveUrl.substring(0,
                        saveUrl.lastIndexOf(".wmf"))
                        + ".svg";
                wmfToSvg(saveUrl, svgFile);
                // 将svg转png
                String jpgFile = saveUrl.substring(0,
                        saveUrl.lastIndexOf(".wmf"))
                        + ".png";
                svgToJpg(svgFile, jpgFile);
                return jpgFile;
            }
        }
        return null;
    }


    /**
     * 将wmf转换为svg
     *
     * @param src 源文件地址
     * @param dest 目标文件地址
     */
    public static void wmfToSvg(String src, String dest) {
        File file = new File(src);
        boolean compatible = false;
        try {
            InputStream in = new FileInputStream(file);
            WmfParser parser = new WmfParser();
            final SvgGdi gdi = new SvgGdi(compatible);
            parser.parse(in, gdi);

            Document doc = gdi.getDocument();
            OutputStream out = new FileOutputStream(dest);
            if (dest.endsWith(".svgz")) {
                out = new GZIPOutputStream(out);
            }
            output(doc, out);
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }


    /**
     * 输出信息
     *
     * @param doc 文档
     * @param out 输出
     * @throws Exception e
     */
    private static void output(Document doc, OutputStream out) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,
                "-//W3C//DTD SVG 1.0//EN");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
                "http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd");
        transformer.transform(new DOMSource(doc), new StreamResult(out));
        if (out != null) {
            out.flush();
            out.close();
        }
    }


    /**
     * 将svg转化为JPG
     *
     * @param src 源文件地址
     * @param dest 目标文件地址
     */
    public static void svgToJpg(String src, String dest) {
        FileOutputStream jpgOut = null;
        FileInputStream svgStream = null;
        ByteArrayOutputStream svgOut = null;
        ByteArrayInputStream svgInputStream = null;
        ByteArrayOutputStream jpg = null;
        File svg = null;
        try {
            // 获取到svg文件
            svg = new File(src);
            svgStream = new FileInputStream(svg);
            svgOut = new ByteArrayOutputStream();
            // 获取到svg的stream
            int noOfByteRead = 0;
            while ((noOfByteRead = svgStream.read()) != -1) {
                svgOut.write(noOfByteRead);
            }
            ImageTranscoder it = new PNGTranscoder();
            it.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, new Float(1f));
            it.addTranscodingHint(ImageTranscoder.KEY_WIDTH, new Float(600f));
            jpg = new ByteArrayOutputStream();
            svgInputStream = new ByteArrayInputStream(svgOut.toByteArray());
            it.transcode(new TranscoderInput(svgInputStream),
                    new TranscoderOutput(jpg));
            jpgOut = new FileOutputStream(dest);
            jpgOut.write(jpg.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (svgInputStream != null) {
                    svgInputStream.close();
                }
                if (jpg != null) {
                    jpg.close();
                }
                if (svgStream != null) {
                    svgStream.close();

                }
                if (svgOut != null) {
                    svgOut.close();
                }
                if (jpgOut != null) {
                    jpgOut.flush();
                    jpgOut.close();
                }
                if (svg != null) {
                    svg.delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 图片转base64
     * @param imgFilePath 图片路径
     * @return str
     */
    public static String imageToBase64(String imgFilePath) {

        //   将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
//        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        String str = "data:image/png;base64," + new String(Base64Utils.encode(data));
        return str;
    }

    /**
     * 图片转base64
     * @param imgFilePath 图片路径
     * @return str
     */
    public static String imageToBase64NoPrefix(String imgFilePath) {

        //   将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        // 返回Base64编码过的字节数组字符串
        return new String(Base64Utils.encode(data));
    }


    /**
     * 删除文件
     * @param list 文件集合
     */
    public static void deleteTempFile(List<String> list) {

        list.forEach(s -> {
            String s1 = s.substring(0,s.lastIndexOf(".wmf")) + ".png";
            File file = new File(s);
            File file1 = new File(s1);
            file.delete();
            file1.delete();
            System.out.println("删除 ====" + s);
        });
    }
}
