package cz.anopheles;

import cz.anopheles.util.Configuration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainClass extends Application{

	private Stage primaryStage;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		Configuration.initConfiguration();
		showMainMenu();
	}

	public void showMainMenu(){
		FXMLLoader loader = new FXMLLoader(MainClass.class.getResource("view/MainMenu.fxml"));
		try {
			AnchorPane pane = (AnchorPane) loader.load();
			primaryStage.setScene(new Scene(pane));
		} catch (Exception e) {
			showErrorPage(e);
			e.printStackTrace(System.err);
		}
		primaryStage.show();
	}
	
	private void showErrorPage(Exception e){
		VBox pane = new VBox();
		Text header = new Text(e.getMessage());
		Button showMore = new Button("Show more");
		Text info = new Text("");
		for(StackTraceElement ste : e.getStackTrace()){
			info.setText(info.getText() + "\n" + ste.getClassName() + ":" + ste.getMethodName() + ":" + ste.getLineNumber());
		}
		info.setVisible(false);
		showMore.setOnAction((ev)->info.setVisible(!info.isVisible()));
		Button goToMenu = new Button("Go back to main menu");
		goToMenu.setOnAction((ev)->showMainMenu());
		pane.getChildren().addAll(header, showMore,info,goToMenu);
		primaryStage.setScene(new Scene(pane));
	}
}
