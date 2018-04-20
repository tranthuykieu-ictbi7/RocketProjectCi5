import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    public List<BulletEnemy> bulletEnemies;
    public int count = 0;

    public EnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(Enemy enemy){
        if (this.count == 100) {
            Vector2D vector2D = new Vector2D(7,0);
            for (int i = 0; i < 7; i++){
                BulletEnemy bulletEnemy  = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                Vector2D rotate = vector2D.rotate(i * 50);
                bulletEnemy.velocity.set(rotate);
                this.bulletEnemies.add(bulletEnemy);
            }
            this.count = 0;
        } else {
            this.count += 1;
        }


    }
}
