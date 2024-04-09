// So I think question is not asking us to create a full chess game, just
// only the classes and method required and even chess got some great rules fo checkmate and all
// so probably I'm not required to go for fully detailed game


// So I've missed few important and complex details like checkmate detection etc
// which makes it a fully chess game
// Also I've not added initialized the board with all types of piece, as it was not asked
// also missed logic for pawn promotion, as I quite don't know the logic of it

import java.util.Scanner;


abstract class ChessPiece {
    protected int x, y;
    protected boolean isWhite;
    public ChessPiece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }


    public abstract boolean canMove(Board board, int destX, int destY);
}
class King extends ChessPiece {
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean canMove(Board board, int destX, int destY) {
        return Math.abs(x - destX) <= 1 && Math.abs(y - destY) <= 1;
    }
}

class Knight extends ChessPiece {
    public Knight(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }


    @Override
    public boolean canMove(Board board, int destX, int destY) {
        if ((Math.abs(x - destX) == 2 && Math.abs(y - destY) == 1) ||
                (Math.abs(x - destX) == 1 && Math.abs(y - destY) == 2)) {
            return true;
        }
        return false;
    }
}
class Queen extends ChessPiece {
    public Queen(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean canMove(Board board, int destX, int destY) {
        return x == destX || y == destY ||
                Math.abs(x - destX) == Math.abs(y - destY);
    }
}
class Bishop extends ChessPiece {
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean canMove(Board board, int destX, int destY) {
        return Math.abs(x - destX) == Math.abs(y - destY);
    }
}
class Rook extends ChessPiece {
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean canMove(Board board, int destX, int destY) {
        return x == destX || y == destY;
    }
}
class Pawn extends ChessPiece {
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean canMove(Board board, int destX, int destY) {
        int forward = isWhite ? 1 : -1;
        if (x == destX && y + forward == destY) {
            return true;
        }
        if (Math.abs(x - destX) == 1 && y + forward == destY) {
            return true;
        }

        return false;
    }
}


class Board {
    private ChessPiece[][] board;

    public Board() {
        board = new ChessPiece[8][8];

        // So we have to set all pieces to their places here
        //white piece on one side and black on other side

    }
    public boolean movePiece(int startX, int startY, int destX, int destY) {
        if (board[startX][startY] != null && board[startX][startY].canMove(this, destX, destY)) {
            board[destX][destY] = board[startX][startY];
            board[startX][startY] = null;
            return true;
        }
        return false;
    }
    public boolean isOccupiedByOpponent(int x, int y, boolean isWhite) {
        return board[x][y] != null && board[x][y].isWhite != isWhite;
    }
}

class ChessGame {
    private Board board;
    private boolean isWhiteTurn;

    public ChessGame() {
        board = new Board();
        isWhiteTurn = true;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver()) {
            System.out.println(isWhiteTurn ? "White's move: " : "Black's move: ");
            System.out.println("Enter start X: ");
            int startX = scanner.nextInt();
            System.out.println("Enter start Y: ");
            int startY = scanner.nextInt();
            System.out.println("Enter destination X: ");
            int destX = scanner.nextInt();
            System.out.println("Enter destination Y: ");
            int destY = scanner.nextInt();

            if (board.movePiece(startX, startY, destX, destY)) {
                isWhiteTurn = !isWhiteTurn;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
        scanner.close();
    }

    private boolean is_king_checkmated(){
        return false;
    }
    private boolean isGameOver() {

        // We would need to check here, if the opponent or our's king ran out of pieces
        // or checkmate condition, etc to check if we need to end the game

        return false;
    }

}

public class Chess {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.startGame();
    }
}

