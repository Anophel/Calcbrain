package cz.anopheles.matrix.model;

/**
 * Model class for matrix.
 * Values are saved in array values[width][height].
 * Do not change the order.
 * 
 * @author Anopheles
 *
 */
public class Matrix {

	private Integer width;
	private Integer height;
	private Double[][] values;
	
	public Matrix(Integer width, Integer height){
		this.height = height;
		this.width = width;
		values = new Double[height][];
		for(int j = 0; j < height; j++){
			values[j] = new Double[width];
			for(int i = 0; i < width; i++){
				values[j][i] = 0.0;
			}
		}
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}
	
	public Double getValue(int i, int j){
		return values[i][j];
	}
	
	public void setValue(int i, int j, Double value){
		values[i][j] = value;
	}
}
