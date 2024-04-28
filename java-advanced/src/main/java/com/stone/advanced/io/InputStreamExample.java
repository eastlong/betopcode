package com.stone.advanced.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Description:
 * @Date 2023/09/30 10:12:00
 **/
public class InputStreamExample {
    public static void main(String[] args) {
        try {
            InputStream fis = new FileInputStream("java-advanced/input.txt");
            int read = fis.read();
            System.out.println("read:" + read);
            System.out.println("Number of remaining bytes:" + fis.available());
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }

        try (InputStream fis = new FileInputStream("java-advanced/input.txt")) {
            System.out.println("Number of remaining bytes:" + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
