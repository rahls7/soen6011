import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Stack;

public class Controller {

    @FXML
    private Text output;
    
    private Stack<Long> numbers = new Stack<Long>();
    
    private String numAsString = "";
    
    private Stack<String> operators = new Stack<String>();

    private Model model = new Model();

    @FXML
    private void processNumpad(ActionEvent event) {

        String value = ((Button) event.getSource()).getText();
//        numAsString += value;
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
//        operators.push(value);
//        numbers.push(Long.parseLong(numAsString));
//        numAsString = "";

    }
    
    @FXML
    private void processClear(ActionEvent event) {
    	output.setText("");
//    	numAsString = "";
//    	operators = new Stack<String>();
//    	numbers = new Stack<Long>();
    }
    
  @FXML
  private void calculate(ActionEvent event) {
//      numbers.push(Long.parseLong(numAsString));
//      numAsString = "";
//      System.out.println(numbers.toString());
//      System.out.println(operators.toString());
      double result = Model.calculateExpression(output.getText());
      output.setText(String.valueOf(result));

  }
}
