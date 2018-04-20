import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Star {

    public Vector2D position;
    public Vector2D velocity;
    private ImageRenderer renderer;

    //constructor: dc goi dau tien khi khoi tao object
    //              ko co gia tri tra ve
    //              ko co tham so dau vao, dc quyen khai bao tham so dau vao bth
    //              khi truyen tham so dau vao, co the xet truc tiep cho cac propertype

    public Star(){
        this.position = new Vector2D();
        this.velocity = velocity;
        this.renderer = new ImageRenderer("resources/images/star.png",5,5);
    }


    public void run(){
        this.position.subtractBy(this.velocity);
    }
    public void render(Graphics graphics){
       this.renderer.render(graphics, this.position);
    }
}

