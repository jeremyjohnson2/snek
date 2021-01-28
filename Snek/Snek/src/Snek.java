import java.awt.*;
import java.util.ArrayList;

public class Snek {
    Cell loc;
    char direction = 0;
    ArrayList<Cell> body = new ArrayList<Cell>();
    int score = 0;

    public Snek(){
        loc = new Cell(Grid.xLoc(59), Grid.yLoc(39));
        body.add(loc);
    }

    public void paint(Graphics g){
        /*new Thread((Runnable) () -> {move();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }}).start();*/
        
        g.setColor(Color.RED);
        for(int i = 0; i<body.size(); i++){
            if(body.get(i)== null){
                continue;
            }
            g.fillRect(body.get(i).col+1, body.get(i).row+1, Cell.xSize-1, Cell.ySize-1);
        }
        //for loop to test if snek has touched itself and thus end the game
        if(body.size()>2){
            for(int j = 1; j < body.size(); j++){
                if (body.get(0).row == body.get(j).row && body.get(0).col == body.get(j).col){
                    System.out.println("Game Over");
                }
            }
        }
    }

    public void keyPressed(char ch){
        if(direction == 'w'&&ch =='s'){
            return;
        }else if(direction == 'a'&&ch =='d'){
            return;
        }else if(direction == 's'&&ch =='w'){
            return;
        }else if(direction == 'd'&&ch =='a'){
            return;
        }
        if(ch == 'w'|| ch =='a'||ch == 's'|| ch =='d'){
            direction = ch;
        }
    }
    public void move(){
        int x = body.get(0).col;
        int y = body.get(0).row;
        if (direction == 'a'){
            x = body.get(0).x-Cell.xSize;
        }
        if (direction == 'd'){
            x = body.get(0).x+Cell.xSize;
        }
        if (direction == 'w'){
            y = body.get(0).y-Cell.xSize;
        }
        if (direction == 's'){
            y = body.get(0).y+Cell.ySize;
        }
        
        if(score >=1){
            for(int i = body.size()-1; i >0; i--){
                if(i==0){
                }else{
                    body.set(i, body.get(i-1));
                }
            }
        }
        body.set(0, new Cell(x, y));

    }

}
