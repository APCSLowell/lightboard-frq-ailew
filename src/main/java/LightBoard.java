public class LightBoard
{
  /** The lights on the board, where true represents on and false represents off.
   */
  private boolean[][] lights;

  /** Constructs a LightBoard object having numRows rows and numCols columns.
   * Precondition: numRows > 0, numCols > 0
   * Postcondition: each light has a 40% probability of being set to on.
   */
  public LightBoard(int numRows, int numCols)
  {
        lights = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double rnd = Math.random();
                lights[i][j] = rnd < 0.4;
            }
        }
    

  }

  /** Evaluates a light in row index row and column index col and returns a status
   *  as described in part (b).
   *  Precondition: row and col are valid indexes in lights.
   */
  public boolean evaluateLight(int row, int col)
  {
 int onCount = 0;


    // Count the number of lights in the same column that are on
    for (int i = 0; i < numRows; i++) {
        if (lights[i][col]) {
            onCount++;
        }
    }

    // Determine the status based on the rules
    if (lights[row][col] && onCount % 2 == 0 ){
      return false;
    }
    if(lights[row][col] && onCount % 3 == 0){
      return true;
    }
    return lights[row][col];
 
  }
  public boolean[][] getLights()
  {
    return lights;
  }
  //used for testing
  public String toString()
  {
    String s = "";
    for (int r = 0; r < lights.length; r++)
    {
      for (int c = 0; c < lights[0].length; c++)
        if (lights[r][c])
          s += "*";
        else
          s += ".";
      s += "\n";
    }
    return s;
  }
  
}
