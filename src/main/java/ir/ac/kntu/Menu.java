/*package ir.ac.kntu;

 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Menu extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{

        FlowPane root=new FlowPane(Orientation.HORIZONTAL,5,5);

        Button lunch=new Button("lunch");
        Button breakfast=new Button(("breakfast"));
        root.getChildren().add(lunch);
        root.getChildren().add(breakfast);

        Scene scene=new Scene(root,400,300);

        EventHandler <ActionEvent> obj1=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("lunch");

                FlowPane root2=new FlowPane(Orientation.HORIZONTAL,5,5);
                root2.getChildren().add(new Button("kabab"));
                root2.getChildren().add(new Button("joje"));
                root2.getChildren().add(new Button("dogh"));
                root2.getChildren().add(new Button("noshabe"));
                root2.getChildren().add(new Button("shirazi"));
                root2.getChildren().add(new Button("fasl"));

                Scene scene1=new Scene(root2,500,300);
                primaryStage.setScene(scene1);
                primaryStage.show();
            }
        };
        lunch.setOnAction(obj1);
        EventHandler <ActionEvent> obj2=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("breakfast");
                FlowPane root1=new FlowPane(Orientation.HORIZONTAL,5,5);
                root1.getChildren().add(new Button("kare asal"));
                root1.getChildren().add(new Button("panir"));
                Scene scene1=new Scene(root1,500,300);
                primaryStage.setScene(scene1);
                primaryStage.show();

            }
        };
        breakfast.setOnAction(obj2);

        primaryStage.setTitle("FOOD");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
*/