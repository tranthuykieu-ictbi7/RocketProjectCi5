import java.awt.*;

public class Enemy extends GameObject{

    public Vector2D velocity;
    public EnemyShoot enemyShoot;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 11,11);
        this.enemyShoot = new EnemyShoot();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }

}
