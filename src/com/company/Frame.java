package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the controller of the project.
 */
public class Frame {
    //new frame variable
    private JFrame frame;

    // model panel
    private Keypad keypad = new Keypad();

    public Frame() {
        //initializing main frame and setting title
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setLayout(new BorderLayout());

        //setting initial size of screen
        frame.setSize(500, 330);


    }



}
