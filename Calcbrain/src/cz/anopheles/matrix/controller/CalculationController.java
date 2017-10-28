package cz.anopheles.matrix.controller;

import java.util.ArrayList;

import cz.anopheles.exception.CalcbrainCalculationException;
import cz.anopheles.matrix.model.Matrix;
import cz.anopheles.matrix.model.Operand;
import cz.anopheles.matrix.view.MatrixView;
import cz.anopheles.matrix.view.OperandView;
import cz.anopheles.util.ViewType;
import cz.anopheles.view.components.IView;

public class CalculationController {

	
	public Matrix computeEquation(ArrayList<IView> equation) throws CalcbrainCalculationException{
		Matrix result = null;
		if(checkIntegrity(equation)){
			for(IView v : equation){
				v.doChanges();
			}
			// TODO
			OperandView opv = (OperandView) equation.get(1);
			MatrixView first = (MatrixView)equation.get(0);
			MatrixView second = (MatrixView)equation.get(2);
			result = doOperation(opv.getOperand(), first.getModel(), second.getModel());
		} else {
			throw new CalcbrainCalculationException("Wrong format of equation.");
		}
		return result;
	}
	
	/**
	 * Checks if there is no two operands next to each other. (For now)
	 * And if it is not empty.
	 * 
	 * @param equation
	 * @return
	 */
	private boolean checkIntegrity(ArrayList<IView> equation){
		if(equation.isEmpty())
			return false;
		else if(equation.size() == 1)
			return true;
		else{
			IView last = equation.get(0);
			if(last.getViewType().equals(ViewType.OPERAND))
				return false;
			
			for(int i = 1; i < equation.size(); i++){
				if(equation.get(i).getViewType().equals(last.getViewType()) && last.getViewType().equals(ViewType.OPERAND)){
					return false;
				}
			}
		}
		return true;
	}
	
	private Matrix doOperation(Operand op, Matrix first, Matrix second) throws CalcbrainCalculationException{
		Matrix result = null;
		MatrixController controller = new MatrixController();
		
		switch (op) {
		case ADDITION:
			result = controller.addition(first, second);
			break;
		case DEDUCT:
			result = controller.deduct(first, second);
			break;
		case MULTIPLY:
			result = controller.multiply(first, second);
			break;
		default:
			break;
		}
		
		return result;
	}
}
