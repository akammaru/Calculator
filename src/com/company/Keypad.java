package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadPoolExecutor;

public class Keypad {

    private JFrame mainPanel;

    private CalcController calclogic = new CalcController();

    // creating output screens
    private JTextField stored;
    private JTextField current;

    // buttons 0 to 9
    private JButton numberZero;
    private JButton numberOne;
    private JButton numberTwo;
    private JButton numberThree;
    private JButton numberFour;
    private JButton numberFive;
    private JButton numberSix;
    private JButton numberSeven;
    private JButton numberEight;
    private JButton numberNine;

    //opperation buttons
    private JButton operatorMinus;
    private JButton operatorPlus;
    private JButton operatorMultiply;
    private JButton operatorDevide;
    private JButton operatorDot;
    private JButton squarRoot;
    private JButton operatorToPercentage;
    private JButton operator1DevidedByX;

    //result buttons
    private JButton removeOne;
    private JButton clearCurrent;
    private JButton clearAll;
    private JButton reverse;
    private JButton result;

    // row position (x)
    int FIRST = 1;
    int SECOND = 2;
    int THIRD = 3;
    int FOURTH = 4;
    int FIFTH = 5;

    /**
     *  setting up ketpad, This will hold all visual elements.
     */
    public Keypad() {
        mainPanel = new JFrame();
        mainPanel.setTitle("Calculator");
        mainPanel.setLayout(new BorderLayout());

        //setting initial size of screen
        mainPanel.setSize(500, 330);

        //create different pannels
        //output screen
        JPanel outputScreen = new JPanel();
        outputScreen.setPreferredSize(new Dimension(500, 150));
        outputScreen.setLayout(new BoxLayout(outputScreen, BoxLayout.PAGE_AXIS));
        outputScreen.setBackground(Color.magenta);
        mainPanel.add(outputScreen);
        //keypad
        JPanel keyboard = new JPanel();
        keyboard.setPreferredSize(new Dimension(550, 150));
        mainPanel.add(keyboard);

        //setting up base values for Gridbag layout
        keyboard.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.weighty = 1;

        //initialising the textfields
        stored = new JTextField(5);
        current = new JTextField(5);

        //disabeling textfield input
        stored.setEnabled(false);
        current.setEnabled(false);

        //adding output fields to output panel
        outputScreen.add(stored, BorderLayout.NORTH);
        outputScreen.add(current, BorderLayout.SOUTH);

        //keypad buildup
        //Utility row & first row

        //remove one
        removeOne = new JButton("<-");
        gc.gridx = FIRST;
        gc.gridy = FIRST;
        gc.weightx = 1;
        keyboard.add(removeOne, gc);
        removeOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.removeLastCharacter());
            }
        });

        //Clear all
        clearAll = new JButton("CE");
        gc.gridx = SECOND;
        keyboard.add(clearAll, gc);
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.clearAll());
            }
        });

        //Clear current
        clearCurrent = new JButton();
        gc.gridx = THIRD;
        keyboard.add(clearCurrent, gc);
        clearCurrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.clearCurrent());
            }
        });

        // ±
        reverse = new JButton("±");
        gc.gridx = FOURTH;
        keyboard.add(reverse, gc);
        reverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.reverse());
            }
        });

        // √
        squarRoot = new JButton("√");
        gc.gridx = FIFTH;
        keyboard.add(squarRoot, gc);
        squarRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.squareRoot());
            }
        });

        // second row
        // 7
        numberSeven = new JButton("7");
        gc.gridy = SECOND;
        gc.gridx = FIRST;
        keyboard.add(numberSeven, gc);
        numberSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("7"));
            }
        });

        // 8
        numberEight = new JButton("8");
        gc.gridx = SECOND;
        keyboard.add(numberEight, gc);
        numberEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("8"));
            }
        });

        // 9
        numberNine = new JButton("9");
        gc.gridx = THIRD;
        keyboard.add(numberNine, gc);
        numberNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("9"));
            }
        });

        // %
        operatorDevide = new JButton("%");
        gc.gridx = FOURTH;
        keyboard.add(operatorDevide, gc);
        operatorDevide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.setOpperator('%'));
            }
        });

        // third row
        // 4
        numberFour = new JButton("4");
        gc.gridy = THIRD;
        gc.gridx = FIRST;
        keyboard.add(numberFour, gc);
        numberFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("4"));
            }
        });

        // 5
        numberFive = new JButton("5");
        gc.gridx = SECOND;
        keyboard.add(numberFive, gc);
        numberFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("5"));
            }
        });

        // 6
        numberSix = new JButton("6");
        gc.gridx = THIRD;
        keyboard.add(numberSix, gc);
        numberSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("6"));
            }
        });

        // fourth row
        // 1
        numberOne = new JButton("1");
        gc.gridy = FOURTH;
        gc.gridx = FIRST;
        keyboard.add(numberOne, gc);
        numberOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("1"));
            }
        });

        // 2
        numberTwo = new JButton("2");
        gc.gridx = SECOND;
        keyboard.add(numberTwo, gc);
        numberTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("2"));
            }
        });

        // 3
        numberThree = new JButton("3");
        gc.gridx = THIRD;
        keyboard.add(numberThree, gc);
        numberThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setViewValues(calclogic.addNumber("3"));
            }
        });
    }


    public void setViewValues(String[] result) {
        this.current.setText(result[0]);
        this.stored.setText(result[1]);
    }
}
