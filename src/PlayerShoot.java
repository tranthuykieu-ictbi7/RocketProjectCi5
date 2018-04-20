import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {

    public List<Bullet> bullets;
    private FrameCounter frameCounter;
    public boolean isPlayerShoot = false;

    public PlayerShoot() {
        this.bullets = new ArrayList<>();
        this.frameCounter = new FrameCounter(10);
    }

    public void run(Player player){
        if (this.isPlayerShoot){
            if (this.frameCounter.run()) {
                Bullet bullet = new Bullet();
                bullet.position.set(player.position);
                Vector2D vector2D = new Vector2D(7,0);
                Vector2D rotate = vector2D.rotate(player.playerMove.angle);
                bullet.velocity.set(rotate);
                this.bullets.add(bullet);
                this.frameCounter.reset();
            }
        } else {
            this.frameCounter.reset();
        }
    }
}
