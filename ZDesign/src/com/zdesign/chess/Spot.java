package com.zdesign.chess;

import com.zdesign.chess.piece.Piece;

public class Spot {
	int x;
	int y;
	Piece piece;

	public Spot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		piece = null;
	}

	// return original piece
	public Piece occupySpot(Piece piece) {
		Piece origin = this.piece;
		// if piece already here, delete it, i. e. set it dead
		if (this.piece != null) {
			this.piece.setAvailable(false);
		}
		// place piece here
		this.piece = piece;
		return origin;
	}

	public boolean isOccupied() {
		if (piece != null)
			return true;
		return false;
	}

	public Piece releaseSpot() {
		Piece releasedPiece = this.piece;
		this.piece = null;
		return releasedPiece;
	}

	public Piece getPiece() {
		return this.piece;
	}
}
