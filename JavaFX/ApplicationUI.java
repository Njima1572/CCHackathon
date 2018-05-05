
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ApplicationUI extends Application{
	
	private Button find_btn;
	private Button review_btn;
	private Button add_btn;
	private BorderPane border;
	private StackPane root;
	private Scene scene;
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		border = new BorderPane();
		root = new StackPane();
		scene = new Scene(border, WIDTH, HEIGHT);
		primaryStage.setTitle("CC Apartments");
		setTemplate();
		primaryStage.setResizable(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void setTemplate() {
		find_btn = new Button("Find Apartment");
		review_btn = new Button("Review Apartment");
		add_btn = new Button("Add Apartment");
		ToolBar toolbar = new ToolBar(find_btn, review_btn, add_btn);
		initializeButtons(this);
		root.getChildren().add(toolbar);
		
		border.setTop(root);
	}
	
	public void initializeButtons(ApplicationUI frame) {
		
		find_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				border.setCenter(new Search_fx(frame));
			}
		});
		
		review_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				border.setCenter(new Review_fx(frame));
			}
		});
		
		add_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				border.setCenter(new addApartment_fx(frame));
			}
		});
	}
	
	
	public static void main(String[] args) {
		Database.createAndUseDatabase();
		launch(args);
		
	}

}
