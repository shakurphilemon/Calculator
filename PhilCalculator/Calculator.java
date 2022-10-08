
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Calculator implements  ActionListener{
    JFrame Frame;
    TextField textField;
    Button[] myNumbersButton = new Button[10];
    Button[] myFunctionsButton = new Button[9];
    Button addButton, divButton, subButton,mulButton,decButton,equalButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myFont = new Font("Helvetica Neu", Font.BOLD,30);

    double firstNum=0, SecondNum=0,  Result=0;
    char alphabetOperator;

    Calculator (){
        Frame = new JFrame("Phil Calculator ");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(420, 550);
        Frame.setLayout(null);

        textField = new TextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);


        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        decButton = new Button(".");
        equalButton = new Button("=");
        delButton = new Button("Delete");
        clrButton = new Button("Clear");
        negButton = new Button("(-)");

        myFunctionsButton[0] =  addButton;
        myFunctionsButton[1] = subButton;
        myFunctionsButton[2] = mulButton;
        myFunctionsButton[3] = divButton;
        myFunctionsButton[4] = decButton;
        myFunctionsButton[5] = delButton;
        myFunctionsButton[6] = clrButton;
        myFunctionsButton[7] = equalButton;
        myFunctionsButton[8] = negButton;



        for (int i = 0; i < 9; i++){
            myFunctionsButton[i].addActionListener(this);
            myFunctionsButton[i].setFont(myFont);
            myFunctionsButton[i].setFocusable(false);
        }


        for (int i = 0; i < 10; i++){
            myNumbersButton[i] = new Button(String.valueOf(i));
            myNumbersButton[i].addActionListener(this);
            myNumbersButton[i].setFont(myFont);
            myNumbersButton[i].setFocusable(false);
        }
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);



        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(myNumbersButton[1]);
        panel.add(myNumbersButton[2]);
        panel.add(myNumbersButton[3]);
        panel.add(addButton);

        panel.add(myNumbersButton[4]);
        panel.add(myNumbersButton[5]);
        panel.add(myNumbersButton[6]);
        panel.add(subButton);

        panel.add(myNumbersButton[7]);
        panel.add(myNumbersButton[8]);
        panel.add(myNumbersButton[9]);
        panel.add(mulButton);
        panel.add(decButton);

        panel.add(myNumbersButton[0]);
        panel.add(equalButton);
        panel.add(divButton);






        //Frames for my Calculator//

        Frame.add(panel);
        Frame.add(negButton);
        Frame.setVisible(true);
        Frame.add(textField);
        Frame.add(delButton);
        Frame.add(clrButton);

    }
    public static void main(String[] args) {

        Calculator myCal = new Calculator();

    }

    @Override
    public void actionPerformed (ActionEvent e){
        for (int i = 0; i < 10; i++){
            if (e.getSource() == myNumbersButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
       if (e.getSource() == addButton){
           firstNum = Double.parseDouble(textField.getText());
           alphabetOperator = '+';
           textField.setText("");
       }
       if (e.getSource() == mulButton) {
           firstNum = Double.parseDouble(textField.getText());
           alphabetOperator = '-';
           textField.setText("");

       }
       if (e.getSource() == divButton){
           firstNum = Double.parseDouble(textField.getText());
           alphabetOperator = '/';
           textField.setText("");

       }
       if (e.getSource() == equalButton){
           SecondNum = Double.parseDouble(textField.getText());

           switch (alphabetOperator){
               case '+':
                   Result = firstNum + SecondNum;
                   break;
               case '-':
                   Result = firstNum - SecondNum;
                   break;
               case '*':
                   Result = firstNum * SecondNum;
                   break;
               case '/':
                   Result = firstNum / SecondNum;
                   break;
           }
           textField.setText(String.valueOf(Result));
           firstNum = Result;
       }
       if (e.getSource() == clrButton) {
           textField.setText("");
       }
       if (e.getSource() == delButton) {
           String delText = textField.getText();
           textField.setText("");
           for (int i = 0; i <delText.length()-1; i++) {
               textField.setText(textField.getText()+delText.charAt(i));
           }
           if (e.getSource() == negButton){
               double temp = Double.parseDouble(textField.getText());
               temp*=-1;
               textField.setText(String.valueOf(temp));
           }
       }
    }


}