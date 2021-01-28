import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Main window = new Main();
        window.run();
    }

        private Main(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            App canvas = new App();
            this.setContentPane(canvas);
            this.pack();
            this.setVisible(true);
            //canvas.paint(g);
        }

        public void run(){
            while(true){
                this.repaint();
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                }
            }
        }
}
