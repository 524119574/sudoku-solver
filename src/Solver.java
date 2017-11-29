public class Solver {
  public static void main(String[] args) {
    Grid mySudoku = new Grid(game);
    mySudoku.print();
    solve(mySudoku);
    mySudoku.print();
  }

  static void solve(Grid grid) {
    while (grid.hasFreeSpace()) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          grid.removePMarks(i, j);
          grid.makeMove(i, j);
//          grid.makeAdvancedMove(i,j);
        }
      }
      System.out.println("new");
      grid.print();
    }
  }

  static int[][] game = {
          {0, 6, 0, 3, 0, 0, 8, 0, 4},
          {5, 3, 7, 0, 9, 0, 0, 0, 0},
          {0, 4, 0, 0, 0, 6, 3, 0, 7},
          {0, 9, 0, 0, 5, 1, 2, 3, 8},
          {0, 0, 0, 0, 0, 0, 0, 0, 0},
          {7, 1, 3, 6, 2, 0, 0, 4, 0},
          {3, 0, 6, 4, 0, 0, 0, 1, 0},
          {0, 0, 0, 0, 6, 0, 5, 2, 3},
          {1, 0, 2, 0, 0, 9, 0, 8, 0},
  };
}
