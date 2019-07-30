import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Stack;

/**
 * Controller class responsible to provide data to Model for Calculation taken from the View
 * @author rahls7
 *
 */
public class Controller {

    @FXML
    private Text output;
    
    private Stack<Long> numbers = new Stack<Long>();
    
    private String numAsString = "";
    
    private Stack<String> operators = new Stack<String>();

    private Model model = new Model();
    
    /**
     * Displays value corresponding to the numpad on the click on Numpad UI
     * @param event
     */
    @FXML
    private void processNumpad(ActionEvent event) {

        String value = ((Button) event.getSource()).getText();
//        numAsString += value;
        output.setText(output.getText() + value);
    }
    
    /**
     * Calls appropriate operator function in Model.
     * @param event
     */
    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);

    }
     /**
      * Calls appropriate function on clicking clear
      * @param event
      */
    @FXML
    private void processClear(ActionEvent event) {
    	output.setText("");
    }
  /**
   * Calls appropriate calculation function in Model.
   * @param event
   */
  @FXML
  private void calculate(ActionEvent event) {

      double result = Model.calculateExpression(output.getText());
      output.setText(String.valueOf(result));

  }
}
