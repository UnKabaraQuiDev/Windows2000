package org.lcdd.windows2k;

import java.io.IOException;

import org.lcdd.windows2k.frame.Windows2KFrame;

public class Windows2KMain {

	public static Windows2KFrame frame;
	
	public static void main(String[] args) {
		try {
			frame = new Windows2KFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
