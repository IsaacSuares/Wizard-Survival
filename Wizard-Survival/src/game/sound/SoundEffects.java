package game.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import java.net.URL;

public class SoundEffects extends JPanel {

    public SoundEffects() {

        setDoubleBuffered(true);
    }

    public void playFireSound() {
        try {
            URL soundFile = getClass().getResource("fire-ball-sound.wav");
            AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showInputDialog(this, e);
        }
    }

}
