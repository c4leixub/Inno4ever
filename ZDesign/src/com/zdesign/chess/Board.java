package com.zdesign.chess;

import com.zdesign.chess.piece.Piece;

public class Board {
	/*
	private Spot[][] spots;
    private boolean win; // mark the win or not

    public Board(){
        win = false;
        spots = new Spot[8][8];
    }

    public void initialize(Player p){
        // put the pieces with initial status
        for(int i=0; i<p.getPieces().size(); i++){
            spots[p.getPieces().get(i).getX()][p.getPieces().get(i).getY()].occupySpot(p.getPieces().get(i));
        }
    }

    public boolean executeMove(Player p) {
        Command cmd = p.getCurrentCmd();
        Piece piece = cmd.getPiece();

        // check the move step is valid for piece
        if(!piece.isValid(this, cmd.curX, cmd.curY, cmd.desX, cmd.desY)) {
            // if not valid cmd remove the command and return false
            p.removeCurrentCmd();
            return false;
        }

        // check the two pieces side
        if(spots[cmd.desX][cmd.desY] != null && spots[cmd.desX][cmd.desY].color == piece.color)
            return false;

        // check and change the state on spot
        Piece taken = spots[cmd.desX][cmd.desY].occupySpot(piece);
        if(taken != null &&taken.getClass().getName().equals("King")) {
        	win = true;
        }
        spots[cmd.curX][cmd.curY].releaseSpot();
        return true;
    }

    public boolean getWin() {
        return win;
    }
    */
}
