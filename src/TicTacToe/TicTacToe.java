package TicTacToe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TicTacToe implements Runnable{

    private String ip = "localhost";
    private int port  = 6000;
    private Scanner scanner = new Scanner(System.in);
    private JFrame frame;
    private final int WIDTH = 506;
    private final int HEIGHT = 537;
    private Thread thread;

    private Painter painter;
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ServerSocket serverSocket;

    private BufferedImage board;
    private BufferedImage redX;
    private BufferedImage blueX;
    private BufferedImage redCircle;
    private BufferedImage blueCircle;

    private String[] spaces = new String[9];

    private boolean yourTurn =false;
    private boolean circle = true;
    private boolean accepted = false;
    private boolean unableToCommunicateWithOpponent = false;
    private boolean won = false;
    private boolean enemyWon= false;

    private int lengthOfSpace= 160;
    private int errors = 0;
    private int firstSpot = -1;
    private int secondSpot =-1;

    private Font font = new Font("Verdana", Font.BOLD, 32);
    private Font smallerFont = new Font("Verdona",Font.BOLD,20);
    private Font LargerFont = new Font("Verdona",Font.BOLD,50);

    private String waitingString = "Waiting for another player";
    private String unableToCommunicateWithOpponentString = "Unable to communicate with opponent";
    private String wonString = "You Won!";
    private String enemyWonString = "Opponent Won";


    public TicTacToe() {
        System.out.println("Please input the IP: ");
        ip = scanner.nextLine();
        System.out.println("Please enter the port: ");
        port = scanner.nextInt();
        while(port < 1 || port > 65535){
            System.out.println("Invalid port, input another port: ");
            port = scanner.nextInt();
        }
        loadImages();

        painter = new Painter();
        painter.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    private void loadImages(){
        try{
            board = ImageIO.read(getClass().getResourceAsStream("/board.png"));
            redX = ImageIO.read(getClass().getResourceAsStream("/redX.png"));
            redCircle = ImageIO.read(getClass().getResourceAsStream("/redCircle.png"));
            blueX = ImageIO.read(getClass().getResourceAsStream("/blueX.png"));
            blueCircle = ImageIO.read(getClass().getResourceAsStream("/blueCircle.png"));

        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
    }

    @Override
    public void run() {

    }
    public class Painter extends JPanel implements MouseListener {

        public Painter(){
            setFocusable(true);
            requestFocus();
            setBackground(Color.WHITE);
            addMouseListener(this);
        }

        public void painterComponent(Graphics g){
            super.paintComponent(g);
            render(g);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private void render(Graphics g) {
    }

    private void tick() {

    }

    private void checkForWin(){

    }

    private void checkForEnemyWin(){

    }

    private void checkForTie(){

    }
}
