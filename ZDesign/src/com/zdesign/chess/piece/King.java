package com.zdesign.chess.piece;

import com.zdesign.chess.Board;

public class King extends Piece{ 
    public King(boolean available, int x, int y, int color) {
		super(available, x, y, color);
	}

	@Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		return true;
	}    
}
