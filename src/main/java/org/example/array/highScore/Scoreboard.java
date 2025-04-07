package org.example.array.highScore;

public class Scoreboard {
  private int numEntries = 0;
  private GameEntry[] board;

  public Scoreboard(int capacity){
    board = new GameEntry[capacity];
  }

  /**
   * One of the most common updates we might want to make to a Scoreboard is to add
   * a new entry. Keep in mind that not every entry will necessarily qualify as a high
   * score. If the board is not yet full, any new entry will be retained. Once the board is
   * full, a new entry is only retained if it is strictly better than one of the other scores,
   * in particular, the last entry of the scoreboard, which is the lowest of the high scores.
   * */

  /** Attempt to add a new score to the collection (if it is high enough) */
  public void add(GameEntry e){
    int newScore = e.getScore();

    // is the new entry e really a high score
    if(numEntries < board.length || newScore > board[numEntries - 1].getScore()){
      if(numEntries < board.length) numEntries++;

      //shift any lower scores rightward to make room for the new entry
      int j = numEntries - 1;
      while(j > 0 && board[j-1].getScore() < newScore){
        board[j] = board[j-1];
        j--;
        this.printBoard();
      }

      board[j] = e;

    }
  }

  private void printBoard(){
    int a = 0;
    System.out.print("[");

    for(GameEntry score: this.board){
      if(score == null) break;
      System.out.print(score.getScore());
      System.out.print(", ");
    }
    a++;

    System.out.print("]");
    System.out.println();
  }

  public static void main(String[] args) {
    Scoreboard a = new Scoreboard(3);
    a.add(new GameEntry("Kadima", 20));
    a.add(new GameEntry("Kadima", 25));
  }
}
