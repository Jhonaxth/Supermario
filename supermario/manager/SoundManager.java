package manager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class SoundManager {

    private Clip background;
    private long clipTime = 0;
    private Clip Dead;

    public SoundManager() {
        background = getClip(loadAudio("backgrounds"));
        background.loop(Clip.LOOP_CONTINUOUSLY);
    }

    private AudioInputStream loadAudio(String url) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream("/media/audio/" + url + ".wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            return AudioSystem.getAudioInputStream(bufferedIn);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    private Clip getClip(AudioInputStream stream) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void resumeBackground(){
        background.setMicrosecondPosition(clipTime);
        background.start();
    }

    public void pauseBackground(){
        clipTime = background.getMicrosecondPosition();
        background.stop();
    }

    public void restartBackground() {
        clipTime = 0;
        resumeBackground();
    }
    public void playDead()
    {
        Dead = getClip(loadAudio("Dead"));
        Dead.start();

    }
    public void playJump() {
        Clip clip = getClip(loadAudio("jump"));
        clip.start();

    }
    public void brickBreak()
    {
        Clip clip = getClip(loadAudio("brickBreak"));
        clip.start();
    }
    public void playCoin() {
        Clip clip = getClip(loadAudio("coin"));
        clip.start();

    }

    public void playFireball() {
        Clip clip = getClip(loadAudio("fireball"));
        clip.start();

    }

    public void playGameOver() {
        Clip clip = getClip(loadAudio("gameOver"));
        clip.start();

    }

    public void playStomp() {
        Clip clip = getClip(loadAudio("stomp"));
        clip.start();

    }

    public void playOneUp() {
        Clip clip = getClip(loadAudio("oneUp"));
        clip.start();

    }

    public void playSuperMushroom() {

        Clip clip = getClip(loadAudio("superMushroom"));
        clip.start();

    }
    public void playstageclear()
    {
        Clip clip = getClip(loadAudio("stageclear"));
        clip.start();
    }
    public void pauseSound()
    {
        Clip clip = getClip(loadAudio("pauseSound"));
        clip.start();
    }
    public void playpowerDown()
    {
        Clip clip = getClip(loadAudio("powerDown"));
        clip.start();
    }
    public void playMarioDies() {

        Clip clip = getClip(loadAudio("marioDies"));
        clip.start();

    }

    public void playFireFlower() {
        Clip clip = getClip(loadAudio("superMushroom"));
        clip.start();
    }
}
