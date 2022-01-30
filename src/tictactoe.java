import java.util.Scanner;
import java.io.*;
class Main 
{
  public static void main(String[] args) throws FileNotFoundException 
  {
    // print intro
    //duck
    System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⣩⣭⣶⣶⣮⣭⡙⠿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⠿⣋⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡙⢿⣿⣿⣿\n⣿⣿⣿⣿⣿⡃⠄⠹⡿⣿⣿⣿⣿⠟⠛⣿⣿⣿⣿⣷⡌⢿⣿⣿\n⣿⣿⣿⣿⣿⠐⣠⡶⣶⣲⡎⢻⣿⣤⣴⣾⣿⣿⣿⣿⣿⠸⣿⣿\n⣿⠟⣋⡥⡶⣞⡯⣟⣾⣺⢽⡧⣥⣭⣉⢻⣿⣿⣿⣿⣿⣆⢻⣿\n⡃⣾⢯⢿⢽⣫⡯⣷⣳⢯⡯⠯⠷⠻⠞⣼⣿⣿⣿⣿⣿⣿⡌⣿\n⣦⣍⡙⠫⠛⠕⣋⡓⠭⣡⢶⠗⣡⣶⡝⣿⣿⣿⣿⣿⣿⣿⣧⢹\n⣿⣿⣿⣿⣿⣿⣘⣛⣋⣡⣵⣾⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⢸\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⢸\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⢸");
    System.out.println("Welcome to ULTIMATE TICTACTOE!");
    
    tictactoe t; 
    // Uncomment below to test cases
    Scanner sc = new Scanner(new File("win0.dat"));
   //Scanner sc = new Scanner(System.in);
    t = new tictactoe(sc);
    t.play();
  }


  
}
public class tictactoe
{
  // declare instance variables below
  private Scanner sc;
  private int row, col; 
  private int ultrow, ultcol;
  private int player;
  private boolean freeMove;
  private char[][] board;
  private char[][] ult;
  

  // constructor with 1 parameter
  public tictactoe(Scanner sc)
  {
    this.sc = sc;
    // add code below
    freeMove = true;//first move
    row = 0;
    col = 0;
    ultrow = 0;
    ultcol = 0;
    player = 1;
    board = new char[9][9];
    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++){
        board[i][j] = ' ';
      }
    }
    ult = new char[3][3];
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        ult[i][j] = ' ';
      }
    }
  }


  public void play()
  {
    printGrid();
    printUltGrid();
    takeInput();
    setInput();
    printGrid();
    printUltGrid();
    playerSwitch();
    while(!win()){
      do{takeInput();} while(!checkInput());
      setInput();
      checkSubWin();
      printGrid();
      printUltGrid();
      playerSwitch();
    }
    end();
  }

  // add more helper methods
  public void printGrid()
  {
    //print board
    int gridrow = 0;
    int gridcol = 0;
    //print top margin
    System.out.println("    0 1 2   3 4 5   6 7 8  ");
    for(int r=0; r<13; r++){
      //print left margin
      if(r%4 != 0){
        System.out.print(gridrow + " ");
      }
      else
        System.out.print("  ");
      //print grid and values
      for(int c=0; c<13; c++){
        if(r%4==0)
          System.out.print("- ");
        else if(c%4==0)
          System.out.print("| ");
        else{
           System.out.print(board[gridrow][gridcol] + " ");
           gridcol++;
        }
      }
      System.out.println();
      gridcol=0;
      if(r%4 != 0)
      gridrow++;
    }
    System.out.println();
  }

  public void playerSwitch(){
    if(player == 1)
      player = 2;
    else
      player = 1;
  }
  
  public void printUltGrid(){
    System.out.println("ultimate grid:");
    for(int r=0; r<5; r++){
      System.out.print("- ");
    }
    System.out.println();
    for(int j=0; j<3; j++){
      System.out.print("|");
      for(int k=0; k<3; k++){
        System.out.print(" "+ ult[j][k]); //add input from wins later
      }
      System.out.println(" |");
    }
    for(int l=0; l<5; l++){
      System.out.print("- ");
    }
    System.out.println();
  }

  public void takeInput(){ 
    System.out.println("Player " + player + ": \nrow?");
    row = isValid(0,8); 
    System.out.println("col?");
    col = isValid(0,8);
  }

  public void setInput(){
      if(player == 1)
        board[row][col] = 'X';
      else
        board[row][col] = 'O';
      ultrow = row%3;  ultcol = col%3;
  }

  public boolean checkInput(){
    boolean pass = false;
    freeMove();
    if(!freeMove){
      if(correctSquare() && !taken() && !squareWon()) pass=true;
    }
    else if(!taken() && !squareWon()) pass = true;
    return pass;
  }

  public void setUlt(){
    if(player == 1)
       ult[row/3][col/3] = 'X';
    else 
       ult[row/3][col/3] = 'O';
  }

  public void checkSubWin(){//sets mini board
    int storow= row/3;
    int stocol= col/3;
    //check row
    for(int r=storow*3; r<=storow*3+2; r++) {
      if(board[r][stocol*3]==board[r][stocol*3+1] && board[r][stocol*3+1]==board[r][stocol*3+2] && board[r][stocol*3]!=' '){
        setUlt();
        break;
      }
    }   
    //check col
    for(int c=stocol*3; c<=stocol*3+2; c++) {
      if(board[storow*3][c]==board[storow*3+1][c] && board[storow*3+1][c]==board[storow*3+2][c] && board[storow*3][c]!=' '){
        setUlt();
        break;
      }
    }
    //check topleft diagonal
    if(board[storow*3][stocol*3]==board[storow*3+1][stocol*3+1] && board[storow*3+1][stocol*3+1]==board[storow*3+2][stocol*3+2] && board[storow*3][stocol*3]!=' ') 
      setUlt();
    //check topright diagonal
    if(board[storow*3+2][stocol*3]==board[storow*3+1][stocol*3+1] && board[storow*3+1][stocol*3+1]==board[storow*3][stocol*3+2] && board[storow*3+2][stocol*3]!=' ') 
      setUlt();
  }

  public void freeMove() {
    if(ult[ultrow][ultcol]==' ')
      freeMove=false;
    else freeMove=true;
  }

  public boolean squareWon() {
    if(ult[row/3][col/3]!=' '){
      return true;
    }
    else return false; 
  }

//return winner ask to play again
  public void end(){
    int stoplayer = 0;
    if(player==1) stoplayer = 2;
    else stoplayer = 1;
    System.out.println("Player " + stoplayer + " wins!"); 
    // System.out.println("Would you like to play again? y/n");
    // if(sc.next().equals("y"))
    //   play();
  }

  public boolean correctSquare(){ //check if move is legal 
    boolean sto=false;
    if(row >= ultrow*3 && row <= ultrow*3+2 && col >= ultcol*3 && col <= ultcol*3+2)
      sto=true;
    if(!sto) System.out.println("Idiot, wrong square");
    return sto;    
  }

  public boolean taken(){ //check if space is occupied
    if(!(board[row][col]== ' ')){
      System.out.println("Idiot, that's taken");
      return true;
    }
    else return false;
  }

  public int isValid(int min, int max){
    int num = -1;
    boolean valid=false;
    while(!valid){
      try {
        num=sc.nextInt();
        if(num>=min && num<=max)
          valid = true;
        else
          System.out.println(num + " is not in range dummy. Try again.");
      }
      catch(Exception e){
        System.out.println(sc.next() + " ain't valid. Try again.");
      }
    }
    return num; 
  }

  public boolean win(){
    boolean win = false;
    for(int r=0; r<2; r++) {
      if(ult[r][0]==ult[r][1] && ult[r][1]==ult[r][2] && ult[r][0]!=' ')
        win = true;
    }   
    //check col
    for(int c=0; c<2; c++) {
      if(ult[0][c]==ult[1][c] && ult[1][c]==ult[2][c] && ult[0][c]!=' ')
        win = true;
    }
    //check topleft diagonal
    if(ult[0][0]==ult[1][1] && ult[1][1]==ult[2][2] && ult[0][0]!=' ') 
      win = true;
    //check topright diagonal
    if(ult[2][0]==ult[1][1] && ult[1][1]==ult[0][2] && ult[2][0]!=' ') 
      win = true;
    if(win)sc.close();
      return win;
  }
  
}