import java.awt.*;

public class Apple {

    private int x, y;

    public Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,60,60);
    }

}
