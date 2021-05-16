import java.awt.*;

public class SnakeTile extends Tile {

    private Direction direction;

    public enum Direction {
        DOWN,
        UP,
        LEFT,
        RIGHT
    }

    public SnakeTile(int x, int y){
        super(x, y, new Color(0xfcca03));
        direction = Direction.RIGHT;
    }

    public SnakeTile(int x, int y, Direction direction){
        super(x, y, new Color(0xfcca03));
        this.direction = direction;
    }

    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(),getY(),60,60);
    }
}
