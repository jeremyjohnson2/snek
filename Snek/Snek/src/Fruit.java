import java.awt.*;

public class Fruit extends Rectangle{
    Cell loc;
    public Fruit(int x, int y){
        loc = new Cell(Grid.xLoc(x), Grid.yLoc(y));
    }
    /*
    public boolean contains(int x, int y){
        //if(x!= null){
            return super.contains(x, y);
        //}
        //return false;
    }
    public boolean contains(Cell c){
        //if(x!= null){
            return super.contains(c);
        //}
        //return false;
    }*/
    public void paint(Graphics g){
        if(loc == null){
            return;
        }
        g.setColor(Color.ORANGE);
        g.fillRect(loc.x+Cell.xSize/3, loc.y+Cell.ySize/3, Cell.xSize/2, Cell.ySize/2);
    }
}
