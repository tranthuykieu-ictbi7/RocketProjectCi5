import java.awt.*;

public class Background extends GameObject{

    public Background(){
        this.renderer = new BackgroundRender(Color.BLACK, 1024, 600);
    }
}

