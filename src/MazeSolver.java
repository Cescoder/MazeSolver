import java.util.ArrayList;

public class MazeSolver {
    //ATTRIBUTES
    private ArrayList<Place> path;
    private Maze maze;

    private Place start;
    private Place end;

    private boolean isSolvable;

    //CONSTRUCTOR
    public MazeSolver(Maze maze) {
        this.maze = maze;

        findStart();
        findEnd();

        path = new ArrayList<>();

    }

    //FINDERS METHODS
    private void findEnd() {
        int counter = 0;

        for(int i = 0; i < maze.getHeight(); i++)
            for(int j = 0; j<maze.getWidth(); j++)
                if(maze.getMap()[i][j].isEnd()){
                    end = maze.getMap()[i][j];
                    counter++;
                }

        if(counter > 1)
            throw new IllegalArgumentException("There is more than one end...");
        
        else if(counter == 0)
            throw new IllegalArgumentException("There is no end...");
        
    }

    private void findStart() {
        int counter = 0;

        for(int i = 0; i < maze.getHeight(); i++)
            for(int j = 0; j<maze.getWidth(); j++)
                if(maze.getMap()[i][j].isStart()){
                    start = maze.getMap()[i][j];
                    counter++;
                }

        if(counter > 1)
            throw new IllegalArgumentException("There is more than one start...");
        
        else if(counter == 0)
            throw new IllegalArgumentException("There is no start...");
        
    }

    //SOLVERS METHODS
    public void solve(){
        isSolvable = checkPlace(start);
    }

    private boolean checkPlace(Place place) {
        boolean found;


        if(place.toString().equals(end.toString())) return true;

        if(noWay(place)) return false;

        if(wayUp(place)){
            place.setTaken(true);
            found = checkPlace(maze.getMap()[place.getCoordY()-1][place.getCoordX()]);
            
            if(found){
                path.add(place);
                return true;
            }

            if(!found){
                place.setTaken(false);
            }
        }

        if(wayRight(place)){
            place.setTaken(true);
            found = checkPlace(maze.getMap()[place.getCoordY()][place.getCoordX()+1]);
            
            if(found){
                path.add(place);
                return true;
            }

            if(!found){
                place.setTaken(false);
            }
        }

        if(wayDown(place)){
            place.setTaken(true);
            found = checkPlace(maze.getMap()[place.getCoordY()+1][place.getCoordX()]);
            
            if(found){
                path.add(place);
                return true;
            }

            if(!found){
                place.setTaken(false);
            }
        }

        if(wayLeft(place)){
            place.setTaken(true);
            found = checkPlace(maze.getMap()[place.getCoordY()][place.getCoordX()-1]);
            
            if(found){
                path.add(place);
                return true;
            }

            if(!found){
                place.setTaken(false);
            }
        }

        

        return false;

    }

    private boolean wayDown(Place place) {
        if(place.getCoordY() == maze.getHeight()-1) return false;
        if(maze.getMap()[place.getCoordY()+1][place.getCoordX()].isEnd()) return true;
        if(maze.getMap()[place.getCoordY()+1][place.getCoordX()] == null) return false;
        if(maze.getMap()[place.getCoordY()+1][place.getCoordX()].isTaken()) return false;
        if(maze.getMap()[place.getCoordY()+1][place.getCoordX()].isRoad() == false) return false;

        return true;

    }

    private boolean wayLeft(Place place) {
        if(place.getCoordX() == 0) return false;
        if(maze.getMap()[place.getCoordY()][place.getCoordX()-1].isEnd()) return true;
        if(maze.getMap()[place.getCoordY()][place.getCoordX()-1] == null) return false;
        if(maze.getMap()[place.getCoordY()][place.getCoordX()-1].isTaken()) return false;
        if(maze.getMap()[place.getCoordY()][place.getCoordX()-1].isRoad() == false) return false;

        return true;
    }

    private boolean wayRight(Place place) {
        if(place.getCoordX() == maze.getWidth()-1) return false;
        if(maze.getMap()[place.getCoordY()][place.getCoordX()+1].isEnd()) return true;
        if(maze.getMap()[place.getCoordY()][place.getCoordX()+1] == null) return false;
        if(maze.getMap()[place.getCoordY()][place.getCoordX()+1].isTaken()) return false;
        if(maze.getMap()[place.getCoordY()][place.getCoordX()+1].isRoad() == false) return false;

        return true;
    }

    private boolean wayUp(Place place) {
        if(place.getCoordY() == 0) return false;
        if(maze.getMap()[place.getCoordY()-1][place.getCoordX()].isEnd()) return true;
        if(maze.getMap()[place.getCoordY()-1][place.getCoordX()] == null) return false;
        if(maze.getMap()[place.getCoordY()-1][place.getCoordX()].isTaken()) return false;
        if(maze.getMap()[place.getCoordY()-1][place.getCoordX()].isRoad() == false) return false;
        

        return true;
    }

    private boolean noWay(Place place) {
        if(wayUp(place) == false && wayDown(place) == false && wayLeft(place) == false && wayRight(place) == false){
            return true;
        }

        return false;
    }

    //GETTERS
    public ArrayList<Place> getPath() {
        return path;
    }

    public Maze getMaze() {
        return maze;
    }

    public Place getStart() {
        return start;
    }

    public Place getEnd() {
        return end;
    }

    public boolean isSolvable() {
        return isSolvable;
    }

    //PRINTER METHOD
    private void println(Object string) {
        System.out.println(string);
    }

    public void printPath(){
        for(Place place : path)
            println(place.toString());
    }


    

}
