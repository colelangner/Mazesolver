package hw3;


import maze.MazeObserver;
import maze.Status;

/**
 * A Maze consists of MazeCells arranged in a 2D grid.
 * 
 */
public class Maze
{
 
  
  /**
   * Observer to be notified in case of changes to cells
   * in this maze.
   */
  private MazeObserver observer;
  
 
  
  
  private MazeCell[][] Maze;
  private MazeCell goal;
  private MazeCell start;
  
  
  
  
 /**
  * Constructs a Maze
  * @param rows
  * 	Maze String 
  */
  
 public Maze(String[] rows) 
 {
	 
	  
	  String col = rows[0];
	 	   
	  Maze = new MazeCell[rows.length][col.length()]; 
	 
	  for(int i = 0; i < rows.length; i++) 
	  {
		 String temp = rows[i];
		 
		 for(int j = 0; j < col.length(); j ++) 
		  {
			  	MazeCell x = new MazeCell(i,j);
				x.setOwner(this);
				Maze[i][j] = x; 
				
			if(temp.charAt(j) == ' ')
			{
				x.setStatus(Status.UNVISITED);
			}
			
			if(temp.charAt(j) == '$')
			{
				x.setStatus(Status.GOAL);
				goal = x;
			
			}
			
			if(temp.charAt(j) == 'S') 
			{
				x.setStatus(Status.UNVISITED);
				start = x;
			}
		 }
	  }  

	  
	  
	  
	  //Adds Neighbours Up if 

	  for(int i = 1; i < rows.length; i++) 
	  {
		  String temp = rows[ i - 1];
		  
		  for(int j = 0; j < col.length(); j ++)
		  {
			  if (temp.charAt(j) != '#')
			  {
				  Maze[i][j].addNeighbor(Maze[i-1][j]);
			  }
				  
		  }	  
	  }	  
	 
	  
	  //Adds Neighbours Left
	   
	  for(int i = 0; i < rows.length; i ++) 
	  {
		
		  String temp = rows[ i ];
		  
		  for(int j = 1; j < col.length(); j ++)
		  {
			  
			  if(temp.charAt(j - 1) != '#' && temp.charAt(j) != '#' ) 
			  { 
				  Maze[i][j].addNeighbor(Maze[i][j-1]);
 
			  }
		 
		  }
		}
 
	  
	  //Adds Neighbours Bottom
	 
	  for(int i = 0 ; i < rows.length - 1 ; i++) 
	  {
		
		  String temp = rows[ i + 1 ];
		 
		for(int j = 0; j < col.length(); j ++)
		  {
			  String temp2 = rows[i];

			  if(temp.charAt(j) != '#' && temp2.charAt(j) != '#') 
			  { 
				  Maze[i][j].addNeighbor(Maze[i + 1][j]);
 
			  }
		 
		  }
		 }
	  
	//Adds Neighbours Right
	  for(int i = 0 ; i < rows.length ; i++) 
	  {
		String temp = rows[ i ];
		
		for(int j = 0; j < col.length() - 1; j ++)		  
		 {
			  
			 
			if(temp.charAt(j+1) != '#' && temp.charAt(j) != '#') 
			  { 
				  Maze[i][j].addNeighbor(Maze[i ][j + 1]);
 
			  }
		 
		  }
	  }
}
	  
	 
  /**
   * Sets the observer for the cells of this maze.
   * @param obs
   */
  public void setObserver(MazeObserver obs)
  {
    observer = obs;
  }

  /**
   * Updates Statues
   * @param cell
   */
  public void updateStatus(MazeCell cell)
  {
    if (observer != null)
    {
      observer.updateStatus(cell);
    }
  }

  
/**
 * Returns MazeCell at given location in the Maze
 * @param row
 * 		Row of the MazeCell
 * @param col
 * 		Column of the MazeCell
 * @return
 */
public  MazeCell getCell(int row, int col)
{
	return Maze[row][col];
}

/**
 * Returns number of columns in the Maze
 * @return
 * 		Columns in Maze
 */
public int getColumns() 
{
	return Maze[0].length;
}


/**
 * Returns the goal MazeCell
 * @return
 * 		Goal MazeCell
 */
public MazeCell getGoal() 
{
	return goal;
}


/**
 * Returns rows in Maze
 * @return
 * 		How many rows are in the Maze
 */
public int getRows() 
{	
	return Maze.length;	
}


/**
 * Returns the starting Cell of the Maze
 * @return
 * 		Maze starting cell
 */	
public MazeCell getStart() 
{
	return start;
}




}
