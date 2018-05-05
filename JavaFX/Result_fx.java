import java.util.ArrayList;
import javafx.scene.control.ScrollPane;


import javafx.scene.layout.BorderPane;

public class Result_fx extends BorderPane implements PaneState{
	
	private ArrayList<Integer> results;
	
	private ApplicationUI frame;

	private ScrollPane sp;
	
	public void addComponents(ApplicationUI _frame, ArrayList<Integer> _results) {
		results = _results;
		sp.setContent(this);
		frame = _frame;
	}

	public void addComponents() {
		
	}

}
