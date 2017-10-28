package cz.anopheles.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cz.anopheles.exception.CalcbrainCalculationException;
import cz.anopheles.matrix.controller.CalculationController;
import cz.anopheles.matrix.model.Matrix;
import cz.anopheles.matrix.model.Operand;
import cz.anopheles.matrix.view.MatrixView;
import cz.anopheles.matrix.view.OperandView;
import cz.anopheles.view.components.IView;
import cz.anopheles.view.components.NumberField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MatrixCalculatorController implements Initializable {

	@FXML
	private GridPane addMatrixGrid;
	
	@FXML
	private Button addMatrixButton;
	
	@FXML
	private HBox workspace;
	
	@FXML
	private ChoiceBox<Operand> operands;
	
	private NumberField rows;
	private NumberField columns;
	
	private ArrayList<IView> equation = new ArrayList<IView>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rows = new NumberField();
		columns = new NumberField();
		addMatrixGrid.add(rows, 1, 0);
		addMatrixGrid.add(columns, 1, 1);
		operands.setItems(getOperands());
		operands.getSelectionModel().select(0);
	}

	@FXML
	private void addMatrix(ActionEvent e){
		Integer ros = rows.getInteger();
		Integer cols = columns.getInteger();
		if(ros != null && cols != null && ros >= 1 && cols >= 1){
			Matrix newMat = new Matrix(ros, cols);
			MatrixView view = new MatrixView(newMat);
			workspace.getChildren().add(view.getBody());
			equation.add(view);
		}
	}
	
	@FXML
	private void addOperand(ActionEvent e){
		Operand op = operands.getSelectionModel().getSelectedItem();
		OperandView view = new OperandView(op);
		workspace.getChildren().add(view.getBody());
		equation.add(view);
	}
	
	@FXML
	private void calculate(ActionEvent e){
		// TODO
		CalculationController calc = new CalculationController();
		try {
			Matrix result = calc.computeEquation(equation);
			workspace.getChildren().add(new Text("="));
			workspace.getChildren().add(new MatrixView(result).getBody());
		} catch (CalcbrainCalculationException e1) {
			System.err.println(e1);
		}
	}
	
	private ObservableList<Operand> getOperands(){
		ObservableList<Operand> list = FXCollections.observableArrayList(Operand.ADDITION, Operand.DEDUCT, Operand.MULTIPLY);
		return list;
	}
}
