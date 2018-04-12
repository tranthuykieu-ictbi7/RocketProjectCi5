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

    public GameCanvas(){
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.stars = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.random = new Random();
        this.setVisible(true);
    }

//    private void setupStar(){
//        // thong qua constructor
//        this.star = new Star(900, 600,this.loadImage("/Users/tranthuykieu/IdeaProjects/Rocket/resources/images/star.png"), 5, 5, 2);
//    }

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
        this.repaint();
    }

//    private void drawBackground(){
//        this.graphics.setColor(Color.BLACK);
//        this.graphics.fillRect(0, 0, 1024, 600);
//    }

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
    }

    private void createStar() {
        if (this.countStar == 30) {
            Star star = new Star(1024, this.random.nextInt(600), this.loadImage("/Users/tranthuykieu/IdeaProjects/Rocket/resources/images/star.png"), 5, 5, this.random.nextInt(2) + 1);
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void createEnemy(){
        if (this.countEnemy == 40) {
            Enemy enemy = new Enemy(0, this.random.nextInt(600), this.loadImage("/Users/tranthuykieu/IdeaProjects/Rocket/resources/images/circle.png"), 6, 6, this.random.nextInt(3) + 1);
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
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
