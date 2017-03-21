package com.zdesign.chess;

public class Game {
	/*
	private Board board;
    private Player p1;
    private Player p2;

    public Game() {
        board = new Board();
    }

    public boolean enterPlayer(Player p) {
        if(p1 == null)
            this.p1 = p;
        else if(p2 == null)
            this.p2 = p;
        else
            return false;

        board.initialize(p);
        return true;
    }

    public void processTurn(Player p) {
        // Player make a command and until it is valid
        // System input
        do{
            Command cmd = new Command(input);
            p.addCommand(cmd);
        }while(!board.executeMove(p));
    }

    public void startGame(){
        // player enter the game:
//        enterPlayer(new ComputerPlayer("Computer"));
//        enterPlayer(new HumanPlayer("Bill"));
    	enterPlayer(new Player(0));
	    enterPlayer(new Player(1));

        while(true) {
            processTurn(p1);
            if(this.board.getWin()) {
                System.out.println("P1 win!");
                break;
            }
            processTurn(p2);
            if(this.board.getWin()) {
                System.out.println("P2 win!");
                break;
            }
        }
    }
    */
}
