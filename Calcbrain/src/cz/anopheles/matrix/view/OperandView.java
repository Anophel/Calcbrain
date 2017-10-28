package cz.anopheles.matrix.view;

import cz.anopheles.matrix.model.Operand;
import cz.anopheles.util.ViewType;
import cz.anopheles.view.components.IView;
import javafx.scene.text.Text;

public class OperandView implements IView{

	private Operand operand;
	private Text body;
	
	public OperandView(Operand operand){
		this.operand = operand;
		this.body = new Text(operand.getSymbol());
	}
	
	public Operand getOperand() {
		return operand;
	}

	public Text getBody() {
		return body;
	}

	@Override
	public ViewType getViewType() {
		return ViewType.OPERAND;
	}

	@Override
	public void doChanges() {
		// There is no changes :)
	}
}
