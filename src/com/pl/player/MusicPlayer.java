package com.pl.player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MusicPlayer extends JPanel implements ActionListener {
    JFrame windowPlayer = new JFrame("A Window");

    // creating buttons;
    JLabel label = new JLabel("A Music Player");

    // adding buttons
    JButton addButton = new JButton("Adding Song");
    JButton playButton = new JButton("Play Music");
    JButton stopButton = new JButton("Stop Playing");
    //adding font
    Font buttonFont = new Font("", Font.ITALIC, 15);
    //adding combo box
    JComboBox dropdown = new JComboBox();
    // defining Add button functionality
    JFileChooser browser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV name", "wav");
    int valueReturned;
    // displaying chosen file in the CcomboBox
    String[] musicList = new String[5];
    int index = 0;
    File selectedFile; // representing selected file
    File sound;
    // play button
    AudioInputStream ais;
    Clip clip;


    //constructor - class name
    //1.adding panel to the window - adding JPanel to the window
    MusicPlayer() {

        this.setBackground(Color.blue);
        windowPlayer.add(this);

        // adding actions listeners to the buttons

        addButton.addActionListener(this);
        playButton.addActionListener(this);
        stopButton.addActionListener(this);


        // adding layout

        label.setFont(new Font("", Font.BOLD, 25));
        windowPlayer.add(label, BorderLayout.PAGE_END);

        //adding buttons to the main window
        // changing buttons color
        // setting font

        addButton.setFont(buttonFont);
        addButton.setBackground(Color.blue);
        addButton.setForeground(Color.yellow);   // font color
        windowPlayer.add(addButton, BorderLayout.LINE_START);

        playButton.setFont(buttonFont);
        playButton.setBackground(Color.blue);
        playButton.setForeground(Color.green);  // font color
        windowPlayer.add(playButton, BorderLayout.CENTER);

        stopButton.setFont(buttonFont);
        stopButton.setBackground(Color.blue);
        stopButton.setForeground(Color.red);  // font color
        windowPlayer.add(stopButton, BorderLayout.LINE_END);

        // adding dropdown to the main view
        dropdown.setBackground(Color.blue);
        dropdown.setForeground(Color.darkGray);
        windowPlayer.add(dropdown, BorderLayout.PAGE_START);

        // filter setting

        browser.setFileFilter(filter);

        windowPlayer.setSize(400, 200);
        windowPlayer.setLocation(300, 150);
        windowPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowPlayer.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent chosenOption) {
        if (chosenOption.getSource() == addButton) {
            valueReturned = browser.showOpenDialog(windowPlayer); // opening dialog box

            if (valueReturned == browser.APPROVE_OPTION) {

                selectedFile = browser.getSelectedFile();  // path displayed
                musicList[index] = selectedFile.toString();
                dropdown.addItem("Chosen song-" + index);
                index++;
            }
        }

        //defining Play button

        else if (chosenOption.getSource() == playButton){

            try{
                if(dropdown.getSelectedIndex() == 0)
                {
                   sound = new File(musicList[dropdown.getSelectedIndex()]);
                   ais = AudioSystem.getAudioInputStream(sound);
                   clip = AudioSystem.getClip();
                   clip.open(ais);
                   clip.start();
                }

                else if (dropdown.getSelectedIndex() == 1 ){
                    sound = new File(musicList[dropdown.getSelectedIndex()]);
                    ais = AudioSystem.getAudioInputStream(sound);
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                }

                else if (dropdown.getSelectedIndex() ==2){
                    sound = new File(musicList[dropdown.getSelectedIndex()]);
                    ais = AudioSystem.getAudioInputStream(sound);
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                }

                else if (dropdown.getSelectedIndex() == 3){
                    sound = new File(musicList[dropdown.getSelectedIndex()]);
                    ais = AudioSystem.getAudioInputStream(sound);
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                }

                else if (dropdown.getSelectedIndex() == 4){
                    sound = new File(musicList[dropdown.getSelectedIndex()]);
                    ais = AudioSystem.getAudioInputStream(sound);
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                }
            }
            catch (Exception exception) {JOptionPane.showMessageDialog(null,exception);}

        }

        else if (chosenOption.getSource() == stopButton){
            clip.stop();
        }
    }
}
