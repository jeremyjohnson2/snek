import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class App extends JPanel implements KeyListener{
    static int xx = 1200;
    static int yy = 800;
    static int xRowsTotal = xx/10;
    static int yRowsTotal = yy/10;
    //keep 3:2 ratio
    Grid grid;
    Snek snake;
    Fruit[] apples = new Fruit[5];
    Random rand = new Random();

    public App(){
        setPreferredSize(new Dimension(xx+200+(Cell.xSize*1), yy+(Cell.ySize*2)));
        this.addKeyListener(this);
        grid = new Grid();
        snake = new Snek();
        for (int i =0; i < apples.length; i++){
            apples[i]=new Fruit(rand.nextInt(xRowsTotal),rand.nextInt(yRowsTotal));
        }
    }

    public void paint(Graphics g){
        grid.paint(g);
        snake.move();
        snake.paint(g);
        for(int i =0; i < apples.length; i++){
            if (apples[i] == null){
                continue;
            }
            apples[i].paint(g);
            score(i);
        }
    }

    public void score (int i){      
        if(apples[i].loc.col == snake.body.get(0).col && apples[i].loc.row == snake.body.get(0).row){
            snake.score = snake.score+1;
            snake.body.add(new Cell(apples[i].loc.row, apples[i].loc.col));//grow snek
            apples[i] = new Fruit(rand.nextInt(xRowsTotal),rand.nextInt(yRowsTotal));
            System.out.println("Score: "+ snake.score);
            }
    }

    @Override
    public void addNotify() {//this method automatically runs
        super.addNotify();
        this.requestFocus();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        snake.keyPressed(e.getKeyChar());
        repaint();
        try{
            Thread.sleep(20);//stop the snake speeding up if any key is held down
        }catch(Exception ee){
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
