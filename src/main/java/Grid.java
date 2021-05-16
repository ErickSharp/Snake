import java.awt.*;
import java.util.Random;

public class Grid {

    private Tile[][] grid;
    private boolean dark = false;
    private Snake snake;
    private boolean lost = false;
    private Random random = new Random();
    private Apple apple;

    Grid (int width, int height){
        grid = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (dark){
                    grid[i][j] = new Tile(i * (width/15), j * (height/15), new Color(0x202C37));
                } else{
                    grid[i][j] = new Tile(i * (width/15), j * (height/15), new Color(0x283547));
                }
                dark = !dark;
            }
            dark = !dark;
            //snake color: #fcca03
        }
        snake = new Snake(8);
        generateApple();
    }

    public void render(Graphics g) {
        for (Tile[] row : grid) {
            for (Tile tile : row) {
                tile.render(g);
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        goesOutOfBounds();
        intersectsSelf();

        if (!lost) {
            snake.render(g);
            snake.update();
            apple.render(g);
            checkApple();
//            displayLoseScreen(g);
        } else {
//            displayLoseScreen(g);
        }
    }

    public Snake getSnake() {
        return snake;
    }

    private void checkApple() {
        if (snake.getSnakeHead().getBounds().intersects(apple.getBounds())) {
            generateApple();
            SnakeTile backTile = snake.getSnakeTiles().get(0);
            switch (backTile.getDirection()) {
                case UP -> {
                    snake.addTile(0, new SnakeTile(backTile.getX(), backTile.getY()+Tile.SIZE, backTile.getDirection()));
                }
                case DOWN -> {
                    snake.addTile(0, new SnakeTile(backTile.getX(), backTile.getY()-Tile.SIZE, backTile.getDirection()));
                }
                case LEFT -> {
                    snake.addTile(0, new SnakeTile(backTile.getX() + Tile.SIZE, backTile.getY(), backTile.getDirection()));
                }
                case RIGHT -> {
                    snake.addTile(0, new SnakeTile(backTile.getX() - Tile.SIZE, backTile.getY(), backTile.getDirection()));
                }
            }
        }
    }

    public void goesOutOfBounds(){
        SnakeTile snakeHead = snake.getSnakeHead();

        if(snakeHead.getX() < 0 || snakeHead.getX() > Main.WIDTH || snakeHead.getY() < 0 || snakeHead.getY() > Main.WIDTH){
            lost = true;
        }
    }

    public void intersectsSelf(){
        SnakeTile snakeHead = snake.getSnakeHead();

        for(int i = 0; i < snake.getSnakeTiles().size() - 2; i++){
            if(snakeHead.getBounds().intersects(snake.getSnakeTiles().get(i).getBounds())){
                lost = true;
            }
        }
    }

    public void generateApple() {
        Tile appleTile = grid[random.nextInt(15)][random.nextInt(15)];
        apple = new Apple(appleTile.getX(), appleTile.getY());
    }

//    private void displayLoseScreen(Graphics g){
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0,Main.WIDTH, Main.HEIGHT);
//
//        g.setColor(Color.YELLOW);
//        g.setFont(new Font("Arial", Font.BOLD, 40));
//        g.drawString("You lost!", 370, 450);
//
//        g.setColor(Color.WHITE);
//        g.fill3DRect(370,500,200,50,true);
//
//        g.setColor(Color.BLUE);
//        g.setFont(new Font("Arial", Font.PLAIN, 20));
//        g.drawString("Press F to restart", 380, 530);
//    }
}
