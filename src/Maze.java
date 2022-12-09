import java.util.Scanner;

public class Maze {
    //ATTRIBUTES
    private Scanner input;

    private int width;
    private int height;

    private Place map[][];

    static final char WALL = '1';
    static final char ROAD = '0';
    static final char START = '2';
    static final char END = '3';
    
    //CONSTRUCTOR
    public Maze(String givenMap) {
        //the string will be divided by \n character
        String[] raw = givenMap.split("\n");

        int length = raw[0].length();

        for(int i = 1; i < raw.length; i++){
            if(raw[i].length() != length){
                throw new IllegalArgumentException("All lines must have the same length");
            }
        }

        map = new Place[raw.length][length];

        height = raw.length;
        width = length;

        for(int i = 0; i < raw.length; i++){
            for(int j = 0; j < length; j++){
                switch(raw[i].charAt(j)){
                    case ROAD -> map[i][j] = new Place(i, j, "road");
                    case WALL -> map[i][j] = new Place(i, j, "wall");
                    case START -> map[i][j] = new Place(i, j, "start");
                    case END -> map[i][j] = new Place(i, j, "end");
                    default -> throw new IllegalArgumentException("There can only be chars 0, 1, 2, 3...");
                }
            }
        }

        println(toString());
    }

    //TOSTRING
    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                switch(map[i][j].getType()){

                    case "road"     -> result += "0";
                    case "wall"     -> result += "1";
                    case "start"    -> result += "2";
                    case "end"      -> result += "3";
                }
                
            }
            result += "\n";
        }
        return result;
    }

    //PRINTER METHODS
    private void println(Object string) {
        System.out.println(string);
    }

    //GETTERS
    public Scanner getInput() {
        return input;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Place[][] getMap() {
        return map;
    }

}
