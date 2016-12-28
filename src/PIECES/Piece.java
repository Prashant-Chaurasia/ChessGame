package PIECES;
import GAME.*;
import ChessBoard.Board;
import javax.swing.*;

public abstract class Piece extends JButton{
    private String color;
    private JButton board[][];
    private Player white;
    private Player black;

    Piece(Player w,Player b,JButton bd[][]){
        white = w;
        black = b;
        board = bd;


    }

    public abstract String getColor();

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Board.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public abstract String getImage_Path();

    public abstract boolean validateMove(int currentRow,int currentCol,int newRow , int newCol);

    public boolean isAtPosition(int row,int col){

        JButton pieceAtLocation = isEmpty(row,col);
        //System.out.println(row+" "+col+" "+pieceAtLocation);
        if(pieceAtLocation != null)
            return true;
        else
            return false;

    }

    public Piece isEmpty(int r ,int c){


        if(board[r][c] == null)
            return null;
        for(int i=0;i<8;i++){
            if(board[r][c]==white.pawn[i]) {
                return white.pawn[i];
            }
            else if(board[r][c]==black.pawn[i]) {
                return black.pawn[i];
            }
        }
        for(int i = 0 ;i<2 ;i++){
            if(board[r][c] == white.rook[i]) {
                return white.rook[i];
            }
            else if(board[r][c] == black.rook[i]) {
                return black.rook[i];
            }
            else if(board[r][c] == white.bishop[i]) {
                return white.bishop[i];
            }
            else if(board[r][c] == black.bishop[i]) {
                return black.bishop[i];
            }
            else if(board[r][c] == white.knight[i]) {
                return white.knight[i];
            }
            else if(board[r][c] == black.knight[i]) {
                return black.knight[i];
            }
        }
        if(board[r][c] == white.king)
            return white.king;
        else if(board[r][c] == black.king)
            return black.king;
        else if(board[r][c] == white.queen)
            return white.queen;
        else if(board[r][c] == black.queen)
            return black.queen;
        else
            return null;
    }

    public boolean isInCheck(Player player){
        King king = player.king;
        int r =0,c=0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == king) {
                    r = row;
                    c = col;
                }
            }
        }
        for(int x = 0; x<board.length; x++){
            for(int y = 0; y<board[0].length; y++){
                if(isAtPosition(x,y)){
                    if(isEmpty(x,y).validateMove( x, y, r, c) && !isEmpty(x,y).getColor().equals(color)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

