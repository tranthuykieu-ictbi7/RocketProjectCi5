import java.awt.*;

public class DrawBackGround {
    public int x;
    public int y;
    public int height;
    public int width;
    public Color colorBackGround;

    public DrawBackGround(int x, int y, int width, int height, Color colorBackGround){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colorBackGround = colorBackGround;
    }

    public void draw(Graphics g){
        g.setColor(this.colorBackGround);
        g.fillRect(x, y, width, height);
    }
}
