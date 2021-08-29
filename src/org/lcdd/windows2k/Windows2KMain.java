package org.lcdd.windows2k;

import org.lcdd.windows2k.frame.Windows2KFrame;

import java.io.IOException;

public class Windows2KMain {

    public static Windows2KFrame frame;
    public static boolean isInstalled = false;

    public static void main(String[] args) {
        try {
            frame = new Windows2KFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
