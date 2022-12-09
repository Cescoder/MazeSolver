import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame(Maze maze){
        setBounds(0, 0, maze.getHeight(), maze.getWidth());
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        add(new Board(maze));
        this.pack();
        setVisible(true);
    }
}
