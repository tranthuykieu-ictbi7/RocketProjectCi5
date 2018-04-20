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
    private List<Bullet> bullets;
    public  Player player;

    private Background background;
    private BufferedImage backBuffered;
    private Graphics graphics;
    private Random random;
    private int countStar = 0;
    private int countEnemy = 0;

    public GameCanvas(){

        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.background = new Background();
        this.stars = new ArrayList<>();
        this.enemies = new ArrayList<>();

        this.random = new Random();
        this.player = new Player();
        this.player.position.set(200,200);
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
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics)); // tinh nang lambdas trong java
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(this.graphics);
        this.repaint();
    }


    public void runAll(){
        // update everything
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.player.run();
        this.createEnemy();
        this.runEnemies();
    }

    private void createEnemy(){
        if (this.countEnemy == 400) {
            Enemy enemy = new Enemy();
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
    }

    private void runEnemies(){
        this.enemies.forEach(enemy -> enemy.velocity.set(
                player.position
                        .subtract(enemy.position)
                        .normailize()
                        ).multiply(2));
        this.enemies.forEach(enemy -> enemy.run());
    }


    private void createStar() {
        if (this.countStar == 30) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(this.random.nextInt(2) + 1, 0);
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
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
