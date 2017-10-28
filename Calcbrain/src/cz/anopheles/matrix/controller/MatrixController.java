package cz.anopheles.matrix.controller;

import cz.anopheles.exception.CalcbrainCalculationException;
import cz.anopheles.exception.CalcbrainException;
import cz.anopheles.matrix.model.Matrix;

public class MatrixController {

	public boolean isSameSize(Matrix first, Matrix second){
		return ((first.getWidth() == second.getWidth()) && (first.getHeight() == second.getHeight()));
	}
	
	public boolean equals(Matrix first, Matrix second){
		boolean result = true;
		if(isSameSize(first, second)){
			for(int i = 0; i < first.getHeight(); i++){
				for(int j = 0; j < first.getWidth(); j++){
					if(!first.getValue(i, j).equals(second.getValue(i, j))){
						result = false;
						break;
					}
				}
			}
		} else {
			result = false;
		}
		return result;
	}
	
	public Matrix addition(Matrix first, Matrix second) throws CalcbrainCalculationException{
		if(!isSameSize(first, second))
			throw new CalcbrainCalculationException("Matrices are not same!");
		
		Matrix result = new Matrix(first.getWidth(), first.getHeight());
		
		for(int i = 0; i < first.getHeight(); i++){
			for(int j = 0; j < first.getWidth(); j++){
				result.setValue(i, j, first.getValue(i, j) + second.getValue(i, j));
			}
		}
		
		return result;
	}
	
	public Matrix multiplyByConstant(Matrix matrix, Double constant){
		Matrix result = new Matrix(matrix.getWidth(), matrix.getHeight());
		
		for(int i = 0; i < matrix.getHeight(); i++){
			for(int j = 0; j < matrix.getWidth(); j++){
				result.setValue(i, j, matrix.getValue(i, j) * constant);
			}
		}
		
		return result;
	}
	
	public Matrix multiply(Matrix first, Matrix second) throws CalcbrainCalculationException{
		if(!isCapableForMultiplication(first, second))
			throw new CalcbrainCalculationException("These matrices are not capable for multiplication. " + first.getWidth() + " != " + second.getHeight());
		
		Matrix result = new Matrix(second.getWidth(), first.getHeight());
		
		for(int i = 0; i < first.getHeight(); i++){
			for(int j = 0; j < second.getWidth(); j++){
				Double sum = 0.0;
				for(int k = 0; k < first.getWidth(); k++){
					sum += first.getValue(i, k) * second.getValue(k, j);
				}
				result.setValue(i, j, sum);
			}
		}
		
		return result;
	}
	
	public boolean isCapableForMultiplication(Matrix first, Matrix second){
		return first.getWidth().equals(second.getHeight());
	}
	
	public Matrix deduct(Matrix first, Matrix second) throws CalcbrainCalculationException{
		return addition(first, multiplyByConstant(second, -1.0));
	}
}
