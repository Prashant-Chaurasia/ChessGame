package PIECES;
import javax.swing.*;
import GAME.*;
public class Rook extends Piece{

    private String image_Path ;
    //    int loc_x, loc_y;
    private String color;

    public Rook(Player w,Player b,JButton board[][],String pcolor){
        super(w,b,board);
        color = pcolor;
    }

    public Rook(Player w,Player b,JButton board[][],String p, String pColor){
        super(w,b,board);
        ImageIcon icon = createImageIcon(p);
        //this.setBackground(color);
        this.setIcon(icon);
        image_Path= p;
        color = pColor;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getImage_Path() {
        return image_Path;
    }

    public boolean validateMove( int currentRow, int currentCol, int newRow, int newCol) {

        if(currentRow != newRow && currentCol != newCol){
            //Did not move along one rank/file
            return false;
        }

        //First I will assumed the Rook is moving along the rows.


        if(currentRow != newRow) {

            int i = Math.abs(currentRow - newRow);
            int count;
            if (color.equals("black")) {
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