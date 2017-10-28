package cz.anopheles.matrix.view;

import cz.anopheles.matrix.model.Matrix;
import cz.anopheles.util.ViewType;
import cz.anopheles.view.components.IView;
import cz.anopheles.view.components.NumberField;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class MatrixView implements IView{

	private Matrix model;
	private GridPane body;
	private NumberField[][] values;
	
	public MatrixView(Matrix model){
		this.setModel(model);
		body = new GridPane();
		body.setAlignment(Pos.CENTER);
		values = new NumberField[model.getHeight()][];
		for(int j = 0; j < model.getHeight(); j++){
			values[j] = new NumberField[model.getWidth()];
			for(int i = 0; i < model.getWidth(); i++){
				values[j][i] = new NumberField(Double.toString(model.getValue(j, i)));
				body.add(values[j][i], i, j);
			}
		}
	}

	private void setModel(Matrix model) {
		this.model = model;
	}
	
	public void setValue(int i, int j, Double value){
		model.setValue(i, j, value);
	}
	
	public Double getValue(int i, int j){
		return model.getValue(i, j);
	}
	
	public Integer getWidth(){
		return model.getWidth();
	}
	
	public Integer getHeight(){
		return model.getHeight();
	}

	public GridPane getBody() {
		return body;
	}

	@Override
	public ViewType getViewType() {
		return ViewType.MATRIX;
	}

	public Matrix getModel() {
		return model;
	}

	@Override
	public void doChanges() {
		for(int i = 0; i < model.getHeight(); i++){
			for(int j = 0; j < model.getWidth(); j++){
				model.setValue(i, j, values[i][j].getDouble());
			}
		}
	}
}
