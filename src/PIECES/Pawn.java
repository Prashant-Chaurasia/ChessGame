package PIECES;
import GAME.*;
import javax.swing.*;

public class Pawn extends Piece{


    public String image_Path ;
    //    int loc_x, loc_y;
    public String color;
    public boolean ep_able;
    public boolean hasMoved = false;


    public Pawn(Player w,Player b,JButton board[][], String p, String pColor){
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

    @Override
    public boolean validateMove( int currentRow, int currentCol, int newRow, int newCol) {
        //System.out.println(isAtPosition(newRow,newCol));
        //System.out.print(hasMoved);
        if(color.equals("white")){
            if((currentRow+1==newRow && currentCol-1 == newCol) || (currentRow+1 == newRow && currentCol+1 == newCol)){
                if(isAtPosition(newRow,newCol)){
                    if(isEmpty(newRow,newCol).getColor() == "black"){
                        return true;
                    }
                }
                return false;
            }
            if(newCol==currentCol) {
                for(int row = currentRow;row<=newRow;row++){
                    if(isAtPosition(row,currentCol)){
                        return false;
                    }
                }
                if (hasMoved) {
                    if (newRow < currentRow)
                        return false;
                    else {
                        if (newRow - currentRow >1)
                            return false;

                    }
                    return true;
                } else {
                    if (newRow < currentRow)
                        return false;
                    else if (newRow - currentRow > 2)
                        return false;
                    else if(newRow - currentRow == 2){
                        hasMoved = true;
                        return true;
                    }
                    hasMoved = true;
                    return true;
                }
            }
        }

        else if(color.equals("black")){
            if((currentRow-1==newRow && currentCol+1 == newCol) || (currentRow-1 == newRow && currentCol-1 == newCol)){
                if(isAtPosition(newRow,newCol)){
                    if(isEmpty(newRow,newCol).getColor() == "white"){
                        return true;
                    }
                }
                return false;
            }
            else if(newCol==currentCol){

                for(int row = newRow;row<=currentRow;row++){
                    if(isAtPosition(row,currentCol)){
                        return false;
                    }
                }

                if (hasMoved) {
                    if (newRow > currentRow)
                        return false;
                    else {
                        if (currentRow - newRow== 2)
                            return false;
                    }
                    return true;
                }
                else{
                    if(newRow > currentRow)
                        return false;
                    else if(currentRow - newRow > 2)
                        return false;
                    else if(currentRow - newRow == 2){
                        hasMoved = true;
                        return true;
                    }
                    hasMoved = true;
                    return true;

                }
            }
        }

        return false;
    }


}


