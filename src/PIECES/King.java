package PIECES;

import javax.swing.*;
import GAME.*;
public class King extends Piece{

    private String image_Path ;
    private String color;
    private boolean castled;//to be used for castling....


    public King(Player w,Player b,JButton board[][],String p, String pColor){
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
        if(Math.abs(newRow - currentRow) <= 1 && Math.abs(newCol - currentCol) <= 1) {

            if(isAtPosition(newRow,newCol)){
                if(isEmpty(newRow,newCol).getColor()==color){
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
