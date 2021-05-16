import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyInput implements KeyListener {

    private Grid grid;

    public KeyInput(Grid grid){
        this.grid = grid;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        SnakeTile snakeHead = grid.getSnake().getSnakeHead();
        switch (c) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                if(snakeHead.getDirection() != SnakeTile.Direction.DOWN) {
                    snakeHead.setDirection(SnakeTile.Direction.UP);
                }
            }
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                if(snakeHead.getDirection() != SnakeTile.Direction.UP) {
                    snakeHead.setDirection(SnakeTile.Direction.DOWN);
                }
            }
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                if(snakeHead.getDirection() != SnakeTile.Direction.RIGHT) {
                    snakeHead.setDirection(SnakeTile.Direction.LEFT);
                }
            }
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                if(snakeHead.getDirection() != SnakeTile.Direction.LEFT) {
                    snakeHead.setDirection(SnakeTile.Direction.RIGHT);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
