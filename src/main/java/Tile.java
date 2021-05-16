import java.awt.*;

public class Tile {

    private int x, y;
    public static final int SIZE = 60;
    private Color color;
    //#283547 light blue
    //#202C37 dark blue

    public Tile(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }


    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, SIZE, SIZE);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
