package top.lxpsee.javaday03.screenbroadcast;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 努力常态化  2018/7/4 15:22 The world always makes way for the dreamer
 * 工具类
 */
public class ScreenBroadCastUtils {
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 抓图（截屏）
     */
    public static byte[] captrueScreen() {
        try {
            BufferedImage screenCapture = robot.createScreenCapture(new Rectangle(0, 0, 1366, 768));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(screenCapture, "jpg", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将长整形数据转换成字节数组
     */
    public static byte[] long2Bytes(long l) {
        byte[] bytes = new byte[8];
        bytes[0] = (byte) l;
        bytes[1] = (byte) ((byte) l >> 8);
        bytes[2] = (byte) ((byte) l >> 16);
        bytes[3] = (byte) ((byte) l >> 24);
        bytes[4] = (byte) ((byte) l >> 32);
        bytes[5] = (byte) ((byte) l >> 40);
        bytes[6] = (byte) ((byte) l >> 48);
        bytes[7] = (byte) ((byte) l >> 56);
        return bytes;
    }

    /**
     * 将数组转成长整形
     */
    public static long bytes2Long(byte[] bytes) {
        int i1 = bytes[0] & 0xFF;
        int i2 = bytes[1] & 0xFF << 8;
        int i3 = bytes[2] & 0xFF << 16;
        int i4 = bytes[3] & 0xFF << 24;
        int i5 = bytes[4] & 0xFF << 32;
        int i6 = bytes[5] & 0xFF << 40;
        int i7 = bytes[6] & 0xFF << 48;
        int i8 = bytes[7] & 0xFF << 56;
        return (long) i1 | i2 | i3 | i4 | i5 | i6 | i7 | i8;
    }

    /**
     * 将整形数据转换成字节数组
     */
    public static byte[] int2Bytes(int i) {
        byte[] arr = new byte[4];
        arr[0] = (byte) i;
        arr[1] = (byte) (i >> 8);
        arr[2] = (byte) (i >> 16);
        arr[3] = (byte) (i >> 24);
        return arr;
    }

    /**
     * 将数组转换成整形
     */
    public static int bytes2Int(byte[] arr) {
        int i0 = arr[0];
        int i1 = (arr[1] & 0xFF) << 8;
        int i2 = (arr[2] & 0xFF) << 16;
        int i3 = (arr[3] & 0xFF) << 24;
        return i0 | i1 | i2 | i3;
    }

}