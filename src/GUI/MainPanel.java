package GUI;

import Logic.Library;
import Logic.SaveData;
import Logic.Song;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {

    private LeftToolbar leftToolbar ;
    private PlayerPanel playerPanel ;
    private FriendActivityPanel friendActivityPanel ;
    private static ShowSongsPanel showSongsPanel ;
    private static JScrollPane scrollPane ;

    public MainPanel() throws Exception{
        super("JPotify Music Player");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("src\\Icons\\JPotifyApp.png").getImage());
        setSize(1600,900);
        setMinimumSize(new Dimension(1500 , 900));
        setLocation(50,50);
        setLayout(new BorderLayout());

        SaveData saveData = new SaveData();

        showSongsPanel = new ShowSongsPanel();
        playerPanel = new PlayerPanel();

        playerPanel.setShowSongsPanel(showSongsPanel);
        add(playerPanel , BorderLayout.SOUTH);

        showSongsPanel.setPlayerPanel(playerPanel);
        scrollPane = new JScrollPane(showSongsPanel);
        add(scrollPane , BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftToolbar = new LeftToolbar();
        leftToolbar.setShowSongsPanel(showSongsPanel);
        leftPanel.add(leftToolbar , BorderLayout.NORTH);

        JPanel justForLeftColor = new JPanel();
        justForLeftColor.setBackground(new Color(0xD6000821,true));
        leftPanel.add(justForLeftColor , BorderLayout.CENTER);

        add(leftPanel , BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        friendActivityPanel = new FriendActivityPanel();
        rightPanel.add(friendActivityPanel , BorderLayout.NORTH);

        JPanel justForRightColor = new JPanel();
        justForRightColor.setBackground(new Color(0xD6000821,true));
        rightPanel.add(justForRightColor , BorderLayout.CENTER);

        JScrollPane rightScrollPane = new JScrollPane(rightPanel);

        add(rightScrollPane , BorderLayout.EAST);

        showSongsPanel.createNorthPanel("Library");
        showSongsPanel.updatePanelBySong(Library.allSongs , showSongsPanel);
    }

    public static void updateSongsPanel(){
        showSongsPanel = new ShowSongsPanel();
        scrollPane = new JScrollPane(showSongsPanel);
    }

}
