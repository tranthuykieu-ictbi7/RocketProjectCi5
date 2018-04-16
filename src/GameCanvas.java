import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel{


    private List<Star> stars; //containing star image
    private List<Enemy> enemies;

    private DrawBackGround backGround;
    private BufferedImage backBuffered;
    private Graphics graphics;

    private Random random;
    private int countStar;
    private int countEnemy;
    private int countPlayer;

    private Player player;

    public GameCanvas(){
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.stars = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.random = new Random();
        this.setVisible(true);
    }

    private void setupBackBuffered(){
        // khoi tao backbuffered
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll(){
        this.drawBackground();
        this.stars.forEach(star -> star.render(graphics)); // tinh nang lambdas trong java
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(this.graphics);
        this.repaint();
    }

    private void drawBackground(){
        this.backGround = new DrawBackGround(0, 0, 1024, 600, Color.BLACK);
        this.backGround.draw(this.graphics);
    }

    public void runAll(){
        // update everything
        this.createStar();
        this.stars.forEach(star -> star.run());

        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run());

        this.createPlayer();
        this.player.run();
    }

    private void createStar() {
        if (this.countStar == 30) {
            Star star = new Star(
                    new Vector2D(1024, this.random.nextInt(600)),
                    this.loadImage("resources/images/star.png"),
                    5, 5,
                    new Vector2D( this.random.nextInt(2) + 1, 0)
            );
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }
    private void createEnemy(){
        if (this.countEnemy == 40) {
            Enemy enemy = new Enemy(
                    new Vector2D(0, this.random.nextInt(600)),
                    this.loadImage("resources/images/circle.png"),
                    6, 6,
                    new Vector2D(this.random.nextInt(3) + 1, 0)
            );
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
    }

    private void createPlayer(){
        this.player = new Player(
                new Vector2D(random.nextInt(1024),random.nextInt(600)),
                new Vector2D(10,10),
                Color.RED
        );
    }

    private BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
