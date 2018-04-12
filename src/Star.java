import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    private int x;
    private int y;
    private BufferedImage image;
    private int width;
    private int height;
    private int velocityX;

    public int getX() {
        return x;
    }
    public void setX(){}{
        this.x = x;
    }


    public int getY() {
        return y;
    }
    public void setY(){
        this.y = y;
    }


    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image){
        this.image = image;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(){
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(){
        this.height = height;
    }


    public int getVelocityX() {
        return velocityX;
    }
    public void setVelocityX(){
        this.velocityX = velocityX;
    }

    //constructor: dc goi dau tien khi khoi tao object
    //              ko co gia tri tra ve
    //              ko co tham so dau vao, dc quyen khai bao tham so dau vao bth
    //              khi truyen tham so dau vao, co the xet truc tiep cho cac propertype


    public Star(int x, int y, BufferedImage image, int width, int height, int velocityX){
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
    }

    // dc phep co nhieu constructor, nhung phai khac tham so dau vao
    // khi goi cac constructor: dau vao tham so dau vao

    public void run(){
        this.x -= this.velocityX;
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}

