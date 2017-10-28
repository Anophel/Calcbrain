package cz.anopheles.view;

import java.net.URL;
import java.util.ResourceBundle;

import cz.anopheles.MainClass;
import cz.anopheles.exception.CalcbrainException;
import cz.anopheles.util.Configuration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MainMenuController implements Initializable{

	@FXML
	private Text version;
	
	@FXML
	private Button matrixOperations;
	
	private MainClass mainClass;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			version.setText(Configuration.getConfiguration().getVersion());
		} catch (CalcbrainException e) {
			System.err.println(e);
		}
	}

	@FXML
	private void openMatrixCalculator(ActionEvent e){
		mainClass.showMatrixCalculator();
	}

	public void setMainClass(MainClass mainClass) {
		this.mainClass = mainClass;
	}
}
