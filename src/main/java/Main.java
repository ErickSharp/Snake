import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    private Grid grid;

    private KeyInput keyInput;

    public static void main(String[] args) {
        Main main = new Main();
        main.frame.setVisible(true);
        main.frame.setResizable(false);
        main.frame.add(main);
        main.frame.setTitle("Snake!");
        main.frame.pack();
        main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.frame.setLocationRelativeTo(null);
        main.start();
    }

    public Main() {
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
        frame = new JFrame("Snake");
        grid = new Grid(WIDTH,HEIGHT);

        keyInput = new KeyInput(grid);
        addKeyListener(keyInput);
    }

    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            requestFocus();
            render();
            update();
        }
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH, HEIGHT);

        grid.render(g);

        g.dispose();
        bs.show();
    }

    public void update() {

    }



}
