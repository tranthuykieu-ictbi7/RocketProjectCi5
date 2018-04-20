import java.awt.*;

public class BackgroundRender implements Renderer{
    private Color color;
    private int width;
    private int hight;

    public BackgroundRender(Color color, int width, int hight) {
        this.color = color;
        this.width = width;
        this.hight = hight;
    }

    public void render(Graphics graphics, Vector2D position){
        graphics.setColor(this.color);
        graphics.fillRect((int)position.x, (int)position.y, this.width, this.hight);
    }
}
