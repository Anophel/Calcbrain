package cz.anopheles.matrix.model;

public enum Operand {

	ADDITION("+"), DEDUCT("-"), MULTIPLY_BY_CONSTANT("*"), MULTIPLY("*");
	
	private String symbol;
	
	private Operand(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public String toString(){
		return symbol;
	}
}
