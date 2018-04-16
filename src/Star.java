import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Star {

    public Vector2D position;
    public int x;
    public int y;
    public BufferedImage image;
    public int width;
    public int height;
    public Vector2D velocity;

    //constructor: dc goi dau tien khi khoi tao object
    //              ko co gia tri tra ve
    //              ko co tham so dau vao, dc quyen khai bao tham so dau vao bth
    //              khi truyen tham so dau vao, co the xet truc tiep cho cac propertype


    public Star(Vector2D position, BufferedImage image, int width, int height, Vector2D velocity){
        this.position = position;
        this.image = image;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
    }

    // dc phep co nhieu constructor, nhung phai khac tham so dau vao
    // khi goi cac constructor: dau vao tham so dau vao

    public void run(){
        this.position.subtractBy(this.velocity);
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image, (int)position.x, (int)position.y, this.width, this.height, null);
    }
}

