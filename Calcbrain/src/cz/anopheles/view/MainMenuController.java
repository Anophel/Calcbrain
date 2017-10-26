package cz.anopheles.view;

import java.net.URL;
import java.util.ResourceBundle;

import cz.anopheles.util.Configuration;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MainMenuController implements Initializable{

	@FXML
	private Text version;
	
	@FXML
	private Button matrixOperations;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		version.setText(Configuration.getConfiguration().getVersion());
	}

}
