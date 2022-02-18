package xjar.util;

import io.xjar.XCryptos;

/**
 * 测试jar是否加密成功
 */
public class TestJar {


    /**
     * 文件地址
     */
    private static final String IN_PATH = "D:\\Desktop\\code\\springboot-demo\\xjar-demo\\target\\xjar-demo-1.0-SNAPSHOT.jar";

    /**
     * 输出地址
     */
    private static final String OUT_PATH = "D:\\Desktop\\code\\springboot-demo\\xjar-demo\\target\\new-xjar-demo-1.0-SNAPSHOT.jar";

    /**
     * 加密秘钥
     */
    private static final String SECRET = "123456";


    /**
     * 加密jar
     */
    private static void hanlderEncryptionJar() throws Exception {
        XCryptos.encryption()
                .from(IN_PATH)
                .use(SECRET)
                .include("/**.class")
                .include("/**/*.xml")
                .to(OUT_PATH);
    }


    public static void main(String[] args) throws Exception {
        System.out.println("----- 准备开始加密------");
        hanlderEncryptionJar();
        System.out.println("----- 加密完成------");
    }

}
