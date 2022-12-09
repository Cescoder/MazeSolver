import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class Place extends JPanel {
    //ATTRIBUTES
    private final int coordX;
    private final int coordY;

    private final int width;
    private final int height;

    private String type;
    private boolean taken;

    //CONSTRUCTOR
    public Place(int coordY, int coordX, String type) {
        this.coordX = coordX;
        this.coordY = coordY;

        this.type = type;

        taken = false;

        width = 5;
        height = 5;

        setBounds(width*coordX, height*coordY, width, height);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public String toString() {
        return "Place [coordX=" + coordX + ", coordY=" + coordY + ", type=" + type + "]";
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
  

        //Disegno del colore
        switch(type){
            case "road" -> g.setColor(Color.WHITE);
            case "wall" -> g.setColor(Color.BLACK);
            case "start" -> g.setColor(Color.RED);
            case "end" -> g.setColor(Color.GREEN);
            case "path" -> g.setColor(Color.BLUE);
        }

        g.fillRect(0, 0, width, height);
    }

    //GETTERS
    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public String getType(){
        return type;
    }

    public boolean isTaken() {
        return taken;
    }

    public boolean isRoad(){
        if(type.equals("road"))
            return true;
        
        return false;
    }

    public boolean isWall(){
        if(type.equals("wall"))
            return true;
        
        return false;
    }

    public boolean isStart(){
        if(type.equals("start"))
            return true;
        
        return false;
    }

    public boolean isEnd(){
        if(type.equals("end"))
            return true;
        
        return false;
    }

    

    //SETTERS
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
