package cz.anopheles.view.components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.TextField;

public class NumberField extends TextField {

	public NumberField(){
		this("");
	}
	
	public NumberField(String arg){
		super(arg);
		this.setOnKeyTyped((e)->{
			if(!isCorrectCharacter(e.getCharacter())){
				e.consume();
			}
		});
	}
	
	private boolean isCorrectCharacter(String text){
		Matcher m = Pattern.compile("[+-]|\\d|\\.").matcher(text);
		return m.matches();
	}
	
	private boolean isCorrectFormatToParse(String text){
		Matcher m = Pattern.compile("[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))").matcher(text);
		return m.matches();
	}
	
	public Integer getInteger(){
		if(isCorrectFormatToParse(this.getText()))
			return Integer.parseInt(this.getText());
		else
			return null;
	}
	
	public Double getDouble(){
		if(isCorrectFormatToParse(this.getText()))
			return Double.parseDouble(this.getText());
		else
			return null;
	}
}
