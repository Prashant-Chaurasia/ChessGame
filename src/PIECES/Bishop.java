package PIECES;
import javax.swing.*;
import GAME.*;
public class Bishop extends Piece {

    public String image_Path;
    //    int loc_x, loc_y;
    public String color;

    public Bishop(Player w,Player b,JButton board[][],String pcolor){
        super(w,b,board);
        color = pcolor;
    }

    public Bishop(Player w,Player b,JButton board[][],String p, String pColor) {
        super(w,b,board);
        ImageIcon icon = createImageIcon(p);
        //this.setBackground(color);
        this.setIcon(icon);
        image_Path = p;
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

    @Override
    public boolean validateMove( int currentRow, int currentCol, int newRow, int newCol) {

        //System.out.println(newRow+" "+ newCol+ " "+ currentRow+" "+ currentCol);
        if(color.equals("black")){
            int cR;
            int cL;
            if(currentRow == newRow || currentCol == newCol){
                //Did not move diagonally
                return false;
            }

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
                if(isEmpty(newRow,newCol).getColor().equals("black")){
                    return false;
                }
            }
            return true;

        }


        else if(color.equals("white")){
            int cR;
            int cL;
            if(currentRow == newRow || currentCol == newCol){
                //Did not move diagonally
                return false;
            }

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
                if(isEmpty(newRow,newCol).getColor().equals("white")){
                    return false;
                }
            }
            return true;

        }


        return true;

    }
}
