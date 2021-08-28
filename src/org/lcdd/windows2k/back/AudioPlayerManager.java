package org.lcdd.windows2k.back;

import javax.sound.sampled.*;
import java.io.*;

public class AudioPlayerManager {
	public AudioInputStream stream;
    public AudioFormat format;
    public DataLine.Info info;
    public Clip clip;
    public void playAudioFile(File f){
        try {

            stream = AudioSystem.getAudioInputStream(f);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stopAudioFile(){
        if(clip != null){
            clip.stop();
        }
    }
}
