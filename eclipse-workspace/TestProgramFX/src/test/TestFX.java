package test;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.shape.*;

public class TestFX extends Application {


	    @Override
	    public void start(Stage primaryStage) throws Exception{
	        Group root = new Group();
	        double width = 1400;
	        double height = 840;

	        Scene scene = new Scene(root, width, height);
	        primaryStage.setTitle("Variant 19");
	        primaryStage.setScene(scene);

	        Polygon polygon = new Polygon();
	        polygon.getPoints().addAll(new Double[]{
	                width/7*2, height/4.2*0.6,
	                width/7*2.8, height/4.2*1.5,
	                width/7*5, height/4.2*1.5,
	                width/7*5, height/4.2*2.3,
	                width/7*2, height/4.2*2.3 });
	        Line line1 = new Line(width/7*2.6, height/4.2*2.3, width/7*4, height/4.2*3.2);
	        Line line2 = new Line(width/7*4.4, height/4.2*2.3, width/7*3, height/4.2*3.2);
	        Line line3 = new Line(width/7*5, height/4.2*1.5, width/7*5.65, height/4.2*0.8);
	        Circle wheel1 = new Circle(width/7*2.6,height/4.2*3.4,width/7*0.44,Color.BLUEVIOLET);
	        Circle wheel2 = new Circle(width/7*4.4,height/4.2*3.4,width/7*0.44,Color.BLUEVIOLET);

	        root.getChildren().add(line1);
	        root.getChildren().add(line2);
	        root.getChildren().add(line3);
	        root.getChildren().add(polygon);
	        root.getChildren().add(wheel1);
	        root.getChildren().add(wheel2);

	        line1.setStroke(Color.rgb(117,77,0));
	        line2.setStroke(Color.rgb(117,77,0));
	        line3.setStroke(Color.rgb(155,102,0));

	        polygon.setFill(Color.AQUA);; 
	        scene.setFill(Color.ORANGE); 
	        primaryStage.show();
	    }


	    public static void main(String[] args) {
	        launch(args);
	    }
}
