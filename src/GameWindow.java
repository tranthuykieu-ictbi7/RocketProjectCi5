import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;


    public GameWindow(){
        this.setSize(1024, 600);
        this.setupGameCanvas();
        this.eventKeyboard();
        this.windowEvent();
        this.setVisible(true);
    }

    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void eventKeyboard(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    // gameCanvas.player.angle += 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    // gameCanvas.player.angle -= 5;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    //System.out.println("keyReleased");
                }
            }
        });
    }

    private void windowEvent(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop(){
        while (true){
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000){
               this.gameCanvas.runAll();
               this.gameCanvas.renderAll();
               this.lastTime = currentTime;
            }

        }

    }
}
