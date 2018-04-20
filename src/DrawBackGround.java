import java.awt.*;

public class DrawBackGround {
    public int x;
    public int y;
    public Color colorBackGround;

    // not necessary for 2 variables height and width

    public DrawBackGround(int x, int y, Color colorBackGround) {
        this.x = x;
        this.y = y;
        this.colorBackGround = colorBackGround;
    }

    public void render(Graphics g) {
        g.setColor(this.colorBackGround);
        g.fillRect(x, y, 1024, 600);
    }
}
