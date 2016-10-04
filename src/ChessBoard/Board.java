package ChessBoard;

import GAME.*;
import PIECES.*;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private float sizeX = (float) 80.0, sizeY = (float) 80.0;
    private float posX = (float) 0.0, posY = (float) 0.0;
    private Color boxColor = Color.BLACK;
    private JPanel pane;
    private JButton board[][] = new JButton[8][8];
    GridLayout boardLayout = new GridLayout(8, 8);
    Player black;
    Player white;

    public Board(Player b, Player w) {
        black = b;
        white = w;
        setPieces('W', white);
        setPieces('B', black);
        createBoard();
    }

    public void createBoard() {

        GridLayout boardLayout = new GridLayout(8, 8);
        setLayout(boardLayout);
        setTitle("Chess Game");
        setBounds(0, 0, 660, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                setBoxColor((i + j) % 2);
                if (board[i][j] != null) {
                    board[i][j].setBackground(boxColor);
                    this.getContentPane().add(board[i][j], boardLayout);

                } else {
                    board[i][j] = new JButton();
                    board[i][j].setSize(new Dimension(80, 80));
                    board[i][j].setBackground(boxColor);
                    this.getContentPane().add(board[i][j], boardLayout);
                    validate();
                }
            }
        }
        //add(pane);
        setVisible(true);

    }

    protected void setPieces(char ch, Player p) {
        int i;
        String s = "";
        if (ch == 'W') {
            i = 0;
        } else {
            i = 6;
        }
        int count = 0;
        while (count < 2) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    p.pawn[j] = new Pawn("Photos//" + ch + "P.gif");
                    board[i][j] = p.pawn[j];
                    board[i][j].setSize(new Dimension(80, 80));

                } else if (i == 6) {
                    p.pawn[j] = new Pawn("Photos//" + ch + "P.gif");
                    board[i][j] = p.pawn[j];
                    board[i][j].setSize(new Dimension(80, 80));
                } else {
                    if (j == 0 || j == 7) {
                        p.rook[count] = new Rook("Photos//" + ch + "R.gif");
                        board[i][j] = p.rook[count];
                        board[i][j].setSize(new Dimension(80, 80));
                    } else if (j == 1 || j == 6) {
                        p.knight[count] = new Knight("Photos//" + ch + "N.gif");
                        board[i][j] = p.knight[count];
                        board[i][j].setSize(new Dimension(80, 80));
                    } else if (j == 2 || j == 5) {
                        p.bishop[count] = new Bishop("Photos//" + ch + "B.gif");
                        board[i][j] = p.bishop[count];

                        board[i][j].setSize(new Dimension(80, 80));
                    } else if (j == 3) {
                        p.king = new King("Photos//" + ch + "Q.gif");
                        board[i][j] = p.king;
                        board[i][j].setSize(new Dimension(80, 80));
                    } else if (j == 4) {
                        p.queen = new Queen("Photos//" + ch + "K.gif");
                        board[i][j] = p.queen;
                        board[i][j].setSize(new Dimension(80, 80));
                    }
                }
            }
            count++;
            i++;
        }
    }

    public void setBoxColor(int x) {

        if (x == 0)
            boxColor = Color.GRAY;
        else
            boxColor = Color.WHITE;

    }
}

