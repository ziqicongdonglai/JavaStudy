package io.github.ziqicongdonglai.netty.demo;

/**
 * @author ke_zhang
 * @create 2021-10-20 22:45
 * @description 字节转换工具类
 */
public class BytesUtils {

    private final static char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    /**
     * 十六进制字符串转换成字节数组
     *
     * @param hexString 十六进制字符串
     * @return 字节数组
     */
    public static byte[] hexStrToBuff(String hexString) {
        hexString = hexString.replace(" ", "");
        int length = hexString.length();
        byte[] buffer = new byte[length / 2];

        for (int i = 0; i < length; i += 2) {
            buffer[i / 2] = (byte) ((toByte(hexString.charAt(i)) << 4) | toByte(hexString.charAt(i + 1)));
        }

        return buffer;
    }

    private static int toByte(char c) {
        if (c >= '0' && c <= '9')
            return (c - '0');
        if (c >= 'A' && c <= 'F')
            return (c - 'A' + 10);
        if (c >= 'a' && c <= 'f')
            return (c - 'a' + 10);

        throw new RuntimeException("Invalid hex char '" + c + "'");
    }

    /**
     * 字节数组转十六进制字符串
     *
     * @param array 字节数组
     * @return 十六进制字符串
     */
    public static String toHexString(byte[] array) {
        int length = array.length;
        StringBuilder sb = new StringBuilder(length);
        for (byte b : array) {
            sb.append(HEX_DIGITS[(b >>> 4) & 0x0F])
                    .append(HEX_DIGITS[b & 0x0F]);
        }

        return sb.toString();
    }
}
