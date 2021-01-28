import java.util.Iterator;
import java.awt.*;


public class Grid implements Iterable<Cell> {

    Cell[][] cells= new Cell[App.xRowsTotal][App.yRowsTotal];//120 x 80 cells

    public Grid(){
        for(int i =0; i<cells.length;i++){
            for(int j =0; j<cells[i].length;j++){
                cells[i][j]= new Cell(xLoc(i), yLoc(j));
            }
        }
    }

    public void paint(Graphics g){
        for(int i =0; i<cells.length;i++){
            for(int j =0; j<cells[i].length;j++){
                cells[i][j].paint(g);
            }
        }
    }

    public static int xLoc(int x){
        return x*Cell.xSize+Cell.xSize;
    }
    public static int yLoc(int y){
        return y*Cell.ySize+Cell.ySize;
    }



    @Override
    public Iterator<Cell> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
