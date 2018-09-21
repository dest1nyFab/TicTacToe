
// Tic Tac Toe console game 

import java.util.Scanner;

public class TicTac
{
   public static boolean Winning(int x, int y, char[][] a)
   {
      String column = "";
      String line = "";
      String diag = "";
      String diag2 = "";
      //the way of verifying if we have a winner is by adding characters from line/column/diagonal 1/diagonal 2and comparing that string with XXX/OOO/xxx/ooo
      for (int i = 0; i < 3; i++)
      {
         column = column + a[i][y];
      }
      if (column.equals("XXX") || column.equals("xxx") || column.equals("OOO")
            || column.equals("ooo"))
         return true;
      for (int i = 0; i < 3; i++)
      {
         line = line + a[x][i];
      }
      if (line.equals("XXX") || line.equals("xxx") || line.equals("OOO")
            || line.equals("ooo"))
         return true;
      for (int i = 0; i < 3; i++)
      {
         diag = diag + a[i][i];
      }
      if (diag.equals("XXX") || diag.equals("xxx") || diag.equals("OOO")
            || diag.equals("ooo"))
         return true;
      for (int i = 0; i < 3; i++)
      {
         diag2 = diag2 + a[i][3 - i - 1];
      }
      if (diag2.equals("XXX") || diag2.equals("xxx") || diag2.equals("OOO")
            || diag2.equals("ooo"))
         return true;

      return false;    
   }

   static char[][] board = new char[][] 
      { 
      
      { ' ', ' ', ' ' }, 
      { ' ', ' ', ' ' },
      { ' ', ' ', ' ' } 
      
      };

   public static void main(String[] args)
   {
      Scanner read = new Scanner(System.in);
      
      //implementing which player has X and which has O
      System.out.println("Player one pick X or O:");
      char p1 = read.next().charAt(0);
      char p2 = ' ';
      if (p1 == 'X')
         p2 = 'O';
      else if (p1 == 'x')
         p2 = 'o';
      else if (p1 == 'O')
         p2 = 'X';
      else if (p1 == 'o')
         p2 = 'x';
      System.out.println("So player one has: " + p1);
      System.out.println("So player two has: " + p2);
      
      int x, y; //coordinates
      int ct = 0; //used for tie alternative, basically used for counting how many times a X or a O is generated, tie is when the programme generates 9 times an output
      char winner = ' ';  // gives the winner of the game, the last item drawn
      boolean turn = true;// true=X false = O
      do
      {
       //setting the coordinates
         boolean ok = false;
         do
         {
            System.out.println("Give good coordinates(between 0 and 2):");
            System.out.println("x: ");
            x = read.nextInt();
            System.out.println("y: ");
            y = read.nextInt();
            if (x < 3 && x >= 0 && y < 3 && y >= 0)
               if (board[x][y] == ' ')
                  ok = true;
         }
         while (ok == false);
         ct++; //counting how many elements are drawn
         //setting the element X || O
         if (turn)
         {
            board[x][y] = p1;
            winner = p1;
         }
         else
         {
            board[x][y] = p2;
            winner = p2;
         }
         turn = !turn;
         
         System.out.println();
         //drawing the board
         for (int i = 0; i < 3; i++)
         {
            System.out.print("  ");
            for (int j = 0; j < 3; j++)
            {
               if (board[i][j] == 'O' || board[i][j] == 'X'
                     || board[i][j] == 'x' || board[i][j] == 'o')
               {
                  if (j == 0)
                     System.out.print(board[i][j]);
                  else
                     System.out.print("|" + board[i][j]);
               }
               else if (j == 0)
                  System.out.print(" ");
               else
                  System.out.print("| ");
            }
            System.out.println();
            System.out.println("---------");
         }
         //tie check
         if (ct == 9)
         {
            System.out.println("No one has won! Tie!!!");
            break;
         }
      }
      while (!Winning(x, y, board));
      //printing the winner
      if (p1 == winner)
         System.out.println("The winner is player 1!");
      else
         System.out.println("The winner is player 2!");
      read.close();
   }
}
