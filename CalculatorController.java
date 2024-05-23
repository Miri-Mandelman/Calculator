import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CalculatorController {

    @FXML
    private TextField text;
    
    private String first, second;
    private boolean positiveF , positiveS;
    private boolean doubleF, doubleS;
    private final int ADD=1, SUB= 2, MULT= 3, DIVIDE= 4;
    private int action;
    private boolean flagAction;

    @FXML
	public void initialize() {
    	first="";
    	second="";
    	doubleF=false;
    	doubleS=false;
    	positiveF=true;
    	positiveS=true;
    	flagAction=false;
    	action =0;
    }
    
    @FXML
    void add(ActionEvent event) {
    	if(flagAction)
    		JOptionPane.showConfirmDialog(null, "This calculater supports mathmatic problems with only one arithmetic sign.",
    										"Error!", JOptionPane.CLOSED_OPTION);
    	else {
    		flagAction = true;
        	action =ADD;
        	print();
    	}
    }

    @FXML
    void addNum(ActionEvent event) {
    	Button b =(Button)event.getSource();
    	if(flagAction)
    		second+= b.getText();
    	else
    		first+= b.getText();
    	print();
    }

    @FXML
    void calculate(ActionEvent event) {
    	if(!positiveF)
    		first = "-" +first;
    	if(!positiveS)
    		second = "-" +second;
    	double f = Double.valueOf(first);
    	double s = Double.valueOf(second);
    	double cal;
    	switch (action) {
		case ADD:
			cal = f+s;
			break;
		case SUB:
			cal = f-s;
			break;
		case MULT:
			cal = f*s;
			break;
		default:
			cal = f/s;
			break;
		}
    	text.setText(""+cal);
    	initialize();
    }

    @FXML
    void divide(ActionEvent event) {
    	if(flagAction)
    		JOptionPane.showConfirmDialog(null, "This calculater supports mathmatic problems with only one arithmetic sign.",
    										"Error!", JOptionPane.CLOSED_OPTION);
    	else {
    		flagAction = true;
        	action =DIVIDE;
        	print();
    	}
    }

    @FXML
    void doubleNum(ActionEvent event) {
    	if(flagAction)
    		if(doubleS)
        		JOptionPane.showConfirmDialog(null, "Invalid number:"+second+".", "Error!", JOptionPane.CLOSED_OPTION);
    		else {
    			second+=".";
    			doubleS = true;
    		}
    	else
    		if(doubleF)
        		JOptionPane.showConfirmDialog(null, "Invalid number:"+first+".", "Error!", JOptionPane.CLOSED_OPTION);
    		else {
    			first+=".";
    			doubleF = true;
    		}
    	print();
    }

    @FXML
    void multiply(ActionEvent event) {
    	if(flagAction)
    		JOptionPane.showConfirmDialog(null, "This calculater supports mathmatic problems with only one arithmetic sign.",
    										"Error!", JOptionPane.CLOSED_OPTION);
    	else {
    		flagAction = true;
        	action =MULT;
        	print();
    	}
    }

    @FXML
    void posAndNeg(ActionEvent event) {
    	if(flagAction)
    		positiveS =! positiveS;
    	else
    		positiveF =! positiveF;
    	print();
    }

    @FXML
    void subtract(ActionEvent event) {
    	if(flagAction)
    		JOptionPane.showConfirmDialog(null, "This calculater supports mathmatic problems with only one arithmetic sign.",
    										"Error!", JOptionPane.CLOSED_OPTION);
    	else {
    		flagAction = true;
        	action =SUB;
        	print();
    	}
    }
    
    private void print() {
    	String temp ="";
    	if(!positiveF)
    		temp+="-";
    	temp+=first;
    	if (flagAction) {
    		switch (action) {
			case ADD:
				temp+= "+";
				break;
			case SUB:
				temp+= "-";
				break;
			case MULT:
				temp+= "*";
				break;
			default:
				temp+= "/";
				break;
			}
    		if(!positiveS)
    			temp+="-";
    		temp+=second;
    	}
    	text.setText(temp);
    }

}
