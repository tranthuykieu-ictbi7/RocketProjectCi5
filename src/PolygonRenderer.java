import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PolygonRenderer {

    private Color color;
    private Polygon polygon;
    private List<Vector2D> vertices;
    public double angle = 0.0;

    public PolygonRenderer(Color color, Vector2D... vertices) {
        this.color = color;
        this.polygon = new Polygon();
        this.vertices = Arrays.asList(vertices);
        this.vertices.forEach(vector2D -> polygon.addPoint((int)vector2D.x, (int)vector2D.y));
    }

    public void render(Graphics graphics, Vector2D position){
        this.update(position);
        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);
    }

    private void update(Vector2D position){
        this.polygon.reset();
        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1.0f / (float)this.vertices.size());

        Vector2D translate = position.subtract(center); //trong tam cua tam giac tai vi tri moi

        this.vertices
                .stream()
                .map(vector2D -> vector2D.rotate(angle))
                .map(vector2D -> vector2D.add(translate))
                .forEach(vector2D -> this.polygon.addPoint((int)vector2D.x, (int)vector2D.y));
    }
}
