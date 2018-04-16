
public class Vector2D {

    public float x;
    public float y;

    public Vector2D(float x, float y) { //construct 1
        this.x = x;
        this.y = y;
    }

    public Vector2D() { //construct 2
        this.x = 0;
        this.y = 0;
    }

    public Vector2D set(float x, float y){ // return 1 vector2D có toa do là (x,y)
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D vector2D){ //nhận vào 1 vector2d và return 1 vector2d có cùng toạ độ
        return this.set(vector2D.x, vector2D.y);
    }

    public Vector2D addUp(float x, float y){ //nhận vào 2 biến x,y và trả về 1 vector2d có toạ độ đc cộng thêm x,y vừa nhận
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addUp(Vector2D vector2D){ //nhận vào 1 vector2d và trả về 1 vector2d cùng toạ độ
        return this.addUp(vector2D.x, vector2D.y);
    }

    public Vector2D add(float x, float y){ //nhận vào 2 biến x,y và trả về 1 vector2d mới có toạ độ đc cộng thêm x,y
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D vector2D){
        return this.add(vector2D.x,  vector2D.y);
    }

    public Vector2D subtractBy(float x, float y){
        this.x -= x;
        this.y -= y;
        return this;
    }
    public Vector2D subtractBy(Vector2D vector2D){
        return  this.subtractBy(vector2D.x, vector2D.y);
    }

    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x - x, this.y - y);
    }
    public Vector2D subtract(Vector2D vector2D){
        return this.subtract(vector2D.x, vector2D.y);
    }

    public Vector2D multiply(float factor){
        this.x *= factor;
        this.y *= factor;
        return this;
    }

    public Vector2D copyVector(){
        return new Vector2D(this.x, this.y);
    }

    public float length(){
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D rotate(double angle){
        double radian = Math.toRadians(angle);
        float sin = (float)Math.sin(radian);
        float cos = (float)Math.cos(radian);
        return new Vector2D(this.x * cos - this.y + sin,  this.x * sin + this.y * cos);
    }

    public Vector2D normailize(){
        float length = this.length();
        return new Vector2D(this.x/length,  y/length);
    }
}

