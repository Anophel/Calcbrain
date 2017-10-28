package cz.anopheles.view.components;

import cz.anopheles.util.ViewType;

public interface IView {

	public ViewType getViewType();
	public void doChanges();
}
