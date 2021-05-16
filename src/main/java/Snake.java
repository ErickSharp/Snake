import java.awt.*;
import java.util.ArrayList;

public class Snake {

/**
 * index 0 is the back of the snake, size()-1 is the front of the snake
 */
 private ArrayList<SnakeTile> snake;
 private int length;

 public Snake(int length) {
     this.length = length;
     snake = new ArrayList<>();
     for(int i = 0; i < length; i++){
        snake.add(new SnakeTile(i * 60, 0));
     }
 }

 public void render(Graphics g) {
     for (SnakeTile tile : snake) {
         tile.render(g);
     }
 }

 public SnakeTile getSnakeHead() {
     return this.snake.get(snake.size()-1);
 }

 public void addTile(int index, SnakeTile tile) {
     snake.add(index, tile);
 }

 public void update() {
     SnakeTile snakeHead = getSnakeHead();
     switch (snakeHead.getDirection()) {
         case UP -> {
             snake.remove(0);
             snake.add(new SnakeTile(snakeHead.getX(), snakeHead.getY()-Tile.SIZE, snakeHead.getDirection()));
         }
         case DOWN -> {
             snake.remove(0);
             snake.add(new SnakeTile(snakeHead.getX(), snakeHead.getY()+Tile.SIZE, snakeHead.getDirection()));
         }
         case LEFT -> {
             snake.remove(0);
             snake.add(new SnakeTile(snakeHead.getX()-Tile.SIZE, snakeHead.getY(), snakeHead.getDirection()));
         }
         case RIGHT -> {
             snake.remove(0);
             snake.add(new SnakeTile(snakeHead.getX()+Tile.SIZE, snakeHead.getY()));
         }
     }
 }

 public ArrayList<SnakeTile> getSnakeTiles(){
     return snake;
 }

}
