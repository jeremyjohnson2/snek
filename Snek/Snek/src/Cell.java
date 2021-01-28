import java.awt.*;

public class Cell extends Rectangle{
    static int xSize = App.xx/120;
    static int ySize = App.yy/80;
    int col;
    int row;

    public Cell(int x, int y){
        super(x, y, xSize, ySize);
        this.col = x;
        this.row = y;
    }
    public Cell(int x, int y, int sizeX, int sizeY){
        super(x, y, sizeX, sizeY);
        this.col = x;
        this.row = y;
    }

	public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.col, this.row, xSize, ySize);
        g.setColor(Color.BLACK);
        g.drawRect(this.col, this.row, xSize, ySize);
	}


}
