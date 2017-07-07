package PIECES;

import javax.swing.*;
import GAME.*;
public class Queen extends Piece{

    private String image_Path ;
    private String color;
    private Player white ,black;

    public Queen(Player w,Player b,JButton board[][],String p, String pColor){
        super(w,b,board);
        ImageIcon icon = createImageIcon(p);
        //this.setBackground(color);
        this.setIcon(icon);
        image_Path= p;
        color = pColor;
        white = w;
        black = b;
        board = board;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getImage_Path() {
        return image_Path;
    }

    @Override
    public boolean validateMove( int currentRow, int currentCol, int newRow, int newCol) {
        if(validBishopMove(currentRow,currentCol,newRow,newCol)||validRookMove(currentRow,currentCol,newRow,newCol)){
            return true;
        }
        return false;
    }

    public boolean validBishopMove(int currentRow, int currentCol, int newRow, int newCol){
            int cR;
            int cL;
            if(currentRow == newRow || currentCol == newCol)
                //Did not move diagonally
                return false;

            if(Math.abs(newRow - currentRow) != Math.abs(newCol - currentCol)){
                return false;
            }
            int count ;
            if(newRow<currentRow && newCol<currentCol){
                count = 1;
                cR = currentRow-1;
                cL = currentCol-1;
                while(count<Math.abs(newRow - currentRow)){
                    if(isAtPosition(cR,cL))
                        return false;
                    cR--;
                    cL--;
                    count++;
                }
            }
            else if(newRow>currentRow&&newCol<currentCol){
                count = 1;
                cR = currentRow+1;
                cL = currentCol-1;
                while(count<Math.abs(newRow - currentRow)){
                    if(isAtPosition(cR,cL))
                        return false;
                    cR++;
                    cL--;
                    count++;
                }
            }
            else if(newRow<currentRow&&newCol>currentCol){
                count = 1;
                cR = currentRow-1;
                cL = currentCol+1;
                while(count<Math.abs(newRow - currentRow)){
                    //System.out.println(cR+" "+cL);
                    if(isAtPosition(cR,cL))
                        return false;
                    cR--;
                    cL++;
                    count++;
                }
            }
            else if(newRow>currentRow&&newCol>currentCol){
                count = 1;
                cR = currentRow+1;
                cL = currentCol+1;
                while(count<Math.abs(newRow - currentRow)){
                    if(isAtPosition(cR,cL))
                        return false;
                    cR++;
                    cL++;
                    count++;
                }
            }

            if(isAtPosition(newRow,newCol)){
                if((isEmpty(newRow,newCol).getColor().equals("black")&&color.equals("black"))||
                        (isEmpty(newRow,newCol).getColor().equals("white")&&color.equals("white"))){
                    return false;
                }
            }
            return true;

    }


    public boolean validRookMove(int currentRow, int currentCol, int newRow, int newCol){
        if(currentRow != newRow && currentCol != newCol){
            //Did not move along one rank/file
            return false;
        }

        //First I will assumed the Rook is moving along the rows.


        if(currentRow != newRow) {

            int i = Math.abs(currentRow - newRow);
            int count;
            if (currentRow>newRow) {
                count = 1;
                int cR = currentRow-1;
                int cL = currentCol;
                while (count < i) {
                    System.out.println(cR+"  "+ cL + " "+ i);
                    if (isAtPosition(cR, cL)) {
                        return false;
                    }
                    count++;
                    cR--;
                }

                if(!enemyAtLocation(newRow,newCol,color))
                    return false;
                return true;
            }
            else {
                int cR = currentRow+1;
                int cL = currentCol;
                count = 1;
                while (count < i) {
                    if (isAtPosition(cR, cL)) {
                        return false;
                    }
                    count++;
                    cR++;
                }

                if(!enemyAtLocation(newRow,newCol,color))
                    return false;
                return true;

            }
        }

        //Now do the same for columns
        if(currentCol != newCol){
            int i = Math.abs(currentCol - newCol);
            int count;
            count = 1;
            if(currentCol>newCol){
                int cR = currentRow;
                int cL = currentCol-1;
                while (count < i) {
                    if (isAtPosition(cR, cL)) {
                        return false;
                    }
                    count++;
                    cL--;
                }
                if(!enemyAtLocation(newRow,newCol,color))
                    return false;
                return true;
            }
            else if(currentCol<newCol){
                int cR = currentRow;
                int cL = currentCol+1;
                while (count < i) {
                    if (isAtPosition(cR, cL)) {
                        return false;
                    }
                    count++;
                    cL++;
                }

                if(!enemyAtLocation(newRow,newCol,color))
                    return false;
                return true;
            }
        }

        return true;
    }

    public boolean enemyAtLocation(int r,int c,String col){
        if(isAtPosition(r,c)){
            if(isEmpty(r, c).getColor().equals(col)){
                return false;
            }
            else
                return true;
        }
        return true;
    }

}

