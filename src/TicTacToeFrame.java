import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.JFrame; 



/**
 *
 * @author Yisroel
 */
public class TicTacToeFrame implements ActionListener {
    
    private JFrame game = new JFrame("Tic Tac Toe"); 
    
    private JPanel board;
    private JPanel buttonPnl;

    private JButton button1 = new JButton(""); 
    private JButton button2 = new JButton(""); 
    private JButton button3 = new JButton(""); 
    private JButton button4 = new JButton(""); 
    private JButton button5 = new JButton(""); 
    private JButton button6 = new JButton(""); 
    private JButton button7 = new JButton(""); 
    private JButton button8 = new JButton(""); 
    private JButton button9 = new JButton(""); 
    private JButton quitBtn = new JButton("Quit");
    private JButton resetBtn = new JButton("Reset");
    private JButton scoreBtn = new JButton("Score");
    private String letter = ""; 
    private int count = 0; 
    private int XWins, OWins = 0; 
    private boolean win = false; 

    public TicTacToeFrame() 
    { 
    //create panel for the board(the buttons)
    board = new JPanel();
    board.setLayout(new GridLayout(3, 3));
    
    //Buttons 
    board.add(button1); 
    board.add(button2); 
    board.add(button3); 
    board.add(button4); 
    board.add(button5); 
    board.add(button6); 
    board.add(button7); 
    board.add(button8); 
    board.add(button9); 

    button1.addActionListener(this); 
    button2.addActionListener(this); 
    button3.addActionListener(this); 
    button4.addActionListener(this); 
    button5.addActionListener(this); 
    button6.addActionListener(this); 
    button7.addActionListener(this); 
    button8.addActionListener(this); 
    button9.addActionListener(this); 

    //create game the frame and ass the jpanels to it
    createButtonPnl();
    game.setLayout(new BorderLayout());
    game.add(board, BorderLayout.CENTER);
    game.add(buttonPnl, BorderLayout.SOUTH);
    game.setSize(400, 400); 
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    game.setLocation(500, 300); 
    game.setVisible(true); 
    } 
    
    @Override
    public void actionPerformed(ActionEvent z) 
    { 
        count++; 
        if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9) 
        { 
            letter = "X"; 
        } 
        else if (count == 2 || count == 4 || count == 6 || count == 8 || count == 10) 
        { 
            letter = "O"; 
        } 
        //Displaying an X or O on the buttons 
        if (z.getSource() == button1) 
        { 
            button1.setText(letter); 
            button1.setEnabled(false); 
            CheckForWin();
        } 
        else if (z.getSource() == button2) 
        { 
            button2.setText(letter); 
            button2.setEnabled(false); 
            CheckForWin();
        } 
        else if (z.getSource() == button3) 
        { 
            button3.setText(letter); 
            button3.setEnabled(false); 
            CheckForWin();
        } 
        else if (z.getSource() == button4) 
        { 
            button4.setText(letter); 
            button4.setEnabled(false); 
            CheckForWin();
        } 
        else if (z.getSource() == button5) 
        { 
            button5.setText(letter); 
            button5.setEnabled(false); 
            CheckForWin();
        } 
        else if (z.getSource() == button6) 
        { 
            button6.setText(letter); 
            button6.setEnabled(false); 
            CheckForWin();
        } 
        else if (z.getSource() == button7) 
        { 
            button7.setText(letter); 
            button7.setEnabled(false);
            CheckForWin();
        } 
        else if (z.getSource() == button8) 
        { 
            button8.setText(letter); 
            button8.setEnabled(false);
            CheckForWin();
        } 
        else if (z.getSource() == button9) 
        { 
            button9.setText(letter); 
            button9.setEnabled(false); 
            CheckForWin();
        } 
        
    }

    public void CheckForWin()
    {		
	        //looking who wins horizontally
	        if (button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "") 
	        { 
	            win = true;
	            Win();
	        } 
	        else if (button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != "") 
	        { 
	            win = true; 
	            Win();
	        } 
	        else if (button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != "") 
	        { 
	            win = true;
	            Win();
	        } 
	        //looking for who wins vertically
	        else if (button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "") 
	        { 
	            win = true; 
	            Win();
	        } 
	        else if (button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "") 
	        { 
	            win = true;
	            Win();
	        } 
	        else if (button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "") 
	        { 
	            win = true;
	            Win();
	        } 
	        //looking for who wins diagonally
	        else if (button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "") 
	        { 
	            win = true; 
	            Win();
	        } 
	        else if (button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "") 
	        { 
	            win = true; 
	            Win();
	        } 
	        else 
	        { 
	            win = false; 
	            Win();
	        }    
    }
 
    public void Win()
    {
        if (win == true) 
        { 
            JOptionPane.showMessageDialog(null, "Player " + letter + "  Won!");          
            if(letter.equalsIgnoreCase("X"))
            {
            	XWins++;
            }
            else
            {
            	OWins++;
            }           
        } 
        else if (count == 9 && win == false) 
        { 
            JOptionPane.showMessageDialog(null, "It's a Tie!");
        } 
    }
    
    public void reset() 
    { 
        button1.setText(""); 
        button1.setEnabled(true); 
        button2.setText(""); 
        button2.setEnabled(true); 
        button3.setText(""); 
        button3.setEnabled(true); 
        button4.setText(""); 
        button4.setEnabled(true); 
        button5.setText(""); 
        button5.setEnabled(true); 
        button6.setText(""); 
        button6.setEnabled(true); 
        button7.setText(""); 
        button7.setEnabled(true); 
        button8.setText(""); 
        button8.setEnabled(true); 
        button9.setText(""); 
        button9.setEnabled(true);  
        win = false; 
        count = 0; 
    } 

    public void createButtonPnl()
    {
       buttonPnl = new JPanel();
       buttonPnl.setLayout(new GridLayout(1,3));
      
       buttonPnl.add(resetBtn);
       resetBtn.addActionListener((ActionEvent ae) -> {
            int reply = JOptionPane.showConfirmDialog(null, "Reset game?", "Confirm", JOptionPane.YES_NO_OPTION); 
            if(reply == JOptionPane.YES_OPTION) 
            { 
                reset(); 
                count = 0; 
            } 
       });
       
       buttonPnl.add(scoreBtn);
       scoreBtn.addActionListener((ActionEvent ae) -> {
           JOptionPane.showMessageDialog(null, "Player X's number of Wins" + " " + XWins + " \nPlayer O's number of Wins" + " " + OWins);
       });
       
        buttonPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exiting Tic Tac Toe",  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
        });
        
    }

}



