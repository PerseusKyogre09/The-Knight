
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI {
    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(GameManager gm) {

        this.gm = gm;

        createMainField();
        generateSceen();

        window.setVisible(true);

    }
    public void createMainField(){

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("This is a test message");
        messageText.setBounds(50, 400, 700, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }

    public void createBackground(int bgNum, String bgFilename){

        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(Color.blue);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFilename));
        bgLabel[bgNum].setIcon(bgIcon);

    }
    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFilename, String choice1Name, String choice2Name, String choice3Name) {
        // Create New Popup Menu
        JPopupMenu popMenu = new JPopupMenu();
        // Create Popup Menu Items
        JMenuItem menuItem[] = new JMenuItem[3];
        menuItem[0] = new JMenuItem(choice1Name);
        popMenu.add(menuItem[0]);

        menuItem[1] = new JMenuItem(choice2Name);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice3Name);
        popMenu.add(menuItem[2]);

        // Create Objects
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx, objy, objWidth, objHeight);

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFilename));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
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
        });

        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }

    public void generateSceen(){
        //Screen 1
        createBackground(1, "forest.png");
        createObject(1, 475,125,200,200, "house.png", "Look", "Talk", "Rest");
        createObject(1, 70,137,200,200, "knight.png", "Look", "Talk", "Attack");
        createObject(1, 350,240,70,70, "chest.png", "Look", "Open", "");

    }

}
