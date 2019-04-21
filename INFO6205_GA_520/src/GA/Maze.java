package GA;

import java.util.ArrayList;


public class Maze {
    private final int maze[][];
    private int startPosition[] = {-1,-1};
    
    public Maze(int maze[][]){
        this.maze = maze;
    }
   
    public int[] getStartPosition(){

        if(this.startPosition[0]!=-1&&this.startPosition[1]!=-1){
            return this.startPosition;
        }
        
        int startPosition[] = {0,0};
       //Find the start position, it is the point of value '2'
        for (int rowIndex = 0; rowIndex < this.maze.length; rowIndex++) {
            for (int colIndex = 0; colIndex < this.maze[rowIndex].length; colIndex++) {
                
                if(this.maze[rowIndex][colIndex]==2){
                    this.startPosition = new int[]{colIndex,rowIndex};
                    return new int[]{colIndex,rowIndex};
                }
            }
        }
        return startPosition;
    }
    
   
    public int getPositionValue(int x,int y){
        
        if(x<0||y<0||x>=this.maze.length||y>=this.maze[0].length){
            return 1;
        }
        return this.maze[y][x];
    }
    
   
    public boolean isWall(int x,int y){
        return (this.getPositionValue(x, y)==1);
    }
    
    
    public int getMaxX(){
        return this.maze[0].length-1;
    }
    
    public int getMaxY(){
        return this.maze.length-1;
    }
    
    
    public int scoreRoute(ArrayList<int[]> route){
        int score = 0;
        boolean visited[][] = new boolean[this.getMaxY()+1][this.getMaxX()+1];
        for(int[] routeStep:route){
            //when the entity steps on the right & not arrived position, then score.

            int step[] = (int[])routeStep;
            if(this.maze[step[1]][step[0]]==3 && visited[step[1]][step[0]]==false){
            	
                score++;
                visited[step[1]][step[0]] = true;
            }
        }
        return score;
    }
}
