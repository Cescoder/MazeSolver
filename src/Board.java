import javax.swing.JPanel;
import java.awt.Graphics;

public class Board extends JPanel{
    private Maze maze;

    public Board(Maze maze) {
        setLayout(null);
        setVisible(true);
        setBounds(0, 0, maze.getWidth()*100, maze.getHeight()*100);

        this.maze = maze;
        
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        for(int i = 0; i < maze.getHeight(); i++){
            for(int j = 0; j<maze.getWidth(); j++){
                add(maze.getMap()[i][j]);
            }
        }
    }

    
}
