package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    private int selectedEquation = 0, selectedMethod = 0, selectedSystem = 0;
    private double a, b, accuracy, tmp;
    private double ni = (a - b);

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Function function = new Function();
        SystemOfEquations systemOfEquations = new SystemOfEquations();
        ListOfFunctions listOfFunctions = new ListOfFunctions();
        ListOfSystems listOfSystems = new ListOfSystems();
        HalfDivisionMethod hDMethod = new HalfDivisionMethod();
        TangentialMethod tMethod = new TangentialMethod();
        IterationMethod iMethod = new IterationMethod();

        //TODO: PROCESSING CORRECTIONS OF USER'S INPUT
        BorderPane root = new BorderPane();


        //user interaction

        //simple equations
        //buttons
        Label labelEqMethodChoice = new Label("Solve an equation: ");
        Button button1 = new Button();
        button1.setText("Half Division Method");
        Button button2 = new Button();
        button2.setText("Tangential Method");

        button1.setOnAction(event -> {
            selectedMethod = 1;
            button1.setText("Selected");
            button2.setText("Tangential Method");
        });


        button2.setOnAction(event -> {
            selectedMethod = 2;
            button1.setText("Half Division Method");
            button2.setText("Selected");
        });


        Group btn1Group = new Group(button1);
        Group btn2Group = new Group(button2);


        //Radio-buttons
        Label labelEqNumber = new Label("Choose the equation to be solved: ");
        RadioButton firstEquationChoice = new RadioButton(listOfFunctions.getFirstFunctionAsString());
        RadioButton secondEquationChoice = new RadioButton(listOfFunctions.getSecondFunctionAsString());
        //TODO: third function as string
        RadioButton thirdEquationChoice = new RadioButton();

        ToggleGroup rdBtnGroup = new ToggleGroup();
        firstEquationChoice.setToggleGroup(rdBtnGroup);
        secondEquationChoice.setToggleGroup(rdBtnGroup);
        thirdEquationChoice.setToggleGroup(rdBtnGroup);

        firstEquationChoice.setOnAction(event -> {
            selectedEquation = 1;
        });

        secondEquationChoice.setOnAction(event -> {
            selectedEquation = 2;
        });

        thirdEquationChoice.setOnAction(event -> {
            selectedEquation = 3;
        });


        FlowPane eqGroup = new FlowPane(Orientation.VERTICAL);
        eqGroup.getChildren().addAll(firstEquationChoice, secondEquationChoice, thirdEquationChoice);

        //text fields

        Label labelUp = new Label("Upper limit of the interval: ");
        TextField upperLimitField = new TextField();
        Label labelLow = new Label("Lower limit of the interval: ");
        TextField lowerLimitField = new TextField();
        Label labelAccuracy = new Label("Accuracy: ");
        TextField accuracyField = new TextField();

        Button buttonApply = new Button();
        buttonApply.setText("Apply");
        Label outputLabel = new Label();
        Label numPartitionsLabel = new Label();


        Group applyButton = new Group(buttonApply);

        FlowPane ctrlGroup = new FlowPane(Orientation.VERTICAL, labelEqMethodChoice, btn1Group, btn2Group, labelEqNumber,
                firstEquationChoice, secondEquationChoice, thirdEquationChoice, labelUp, upperLimitField,
                labelLow, lowerLimitField, labelAccuracy, accuracyField, applyButton, outputLabel, numPartitionsLabel);



        //___________________________________________________________



        //System of equations interface
        //buttons
        Label labelSysEqIntro = new Label("Solve a system of equations.");


        //Radio-buttons
        Label labelSysEqNumber = new Label("Choose the system to be solved: ");
        RadioButton firstSysEquationChoice = new RadioButton(listOfSystems.get11FunctionAsString()
                + "\n" + listOfSystems.get12FunctionAsString());
        RadioButton secondSysEquationChoice = new RadioButton(listOfSystems.get21FunctionAsString()
                + "\n" + listOfSystems.get22FunctionAsString());
        //TODO: third system as string if needed
        //RadioButton thirdSysEquationChoice = new RadioButton();

        ToggleGroup rdBtnGroupSys = new ToggleGroup();
        firstSysEquationChoice.setToggleGroup(rdBtnGroupSys);
        secondSysEquationChoice.setToggleGroup(rdBtnGroupSys);
        //thirdSysEquationChoice.setToggleGroup(rdBtnGroupSys);

        firstSysEquationChoice.setOnAction(event -> {
            selectedSystem = 1;
        });

        secondSysEquationChoice.setOnAction(event -> {
            selectedSystem = 2;
        });

        //thirdSysEquationChoice.setOnAction(event -> {
        //selectedSystem = 3;
        //});


        FlowPane sysEqGroup = new FlowPane(Orientation.VERTICAL);
        sysEqGroup.getChildren().addAll(firstSysEquationChoice, secondSysEquationChoice);

        //text fields

        Label labelXUp = new Label("Upper limit of the interval of X: ");
        TextField upperXLimitField = new TextField();
        Label labelXLow = new Label("Lower limit of the interval of X: ");
        TextField lowerXLimitField = new TextField();
        Label labelSysAccuracy = new Label("Accuracy: ");
        TextField sysAccuracyField = new TextField();

        Button buttonSysApply = new Button();
        buttonSysApply.setText("Apply");
        Label sysOutputLabel = new Label();
        Label sysNumPartitionsLabel = new Label();


        Group applySysButton = new Group(buttonSysApply);

        FlowPane sysCtrlGroup = new FlowPane(Orientation.VERTICAL, labelSysEqIntro, labelSysEqNumber,
                firstSysEquationChoice, secondSysEquationChoice,
                //thirdSysEquationChoice,
                labelXUp, upperXLimitField, labelXLow, lowerXLimitField, labelSysAccuracy, sysAccuracyField, applySysButton, sysOutputLabel, sysNumPartitionsLabel);





        BorderPane.setAlignment(ctrlGroup, Pos.CENTER_LEFT);
        BorderPane.setAlignment(sysCtrlGroup, Pos.CENTER_LEFT);
        //root.setLeft(ctrlGroup);



        FlowPane generalGroup = new FlowPane(Orientation.VERTICAL, ctrlGroup, sysCtrlGroup);
        BorderPane.setAlignment(generalGroup, Pos.CENTER_LEFT);
        root.setLeft(generalGroup);


        //_______________________________________________________________


        //graph
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        final LineChart<Number, Number> lineChart =
                new LineChart<>(xAxis,yAxis);

        lineChart.setTitle("Graph of the function");

        XYChart.Series series = new XYChart.Series();
        series.setName("Function");

        /*
        for(double i = 0; i <= ni; i++){
            series.getData().add(new XYChart.Data((b + i), (function.getValue(selectedEquation,(b + i)))));
        }
        lineChart.getData().add(series);
        */


        BorderPane.setAlignment(lineChart, Pos.CENTER);
        root.setCenter(lineChart);

        //TODO: processing of the intervals that don't contain the root



        //_________________________________________________


        buttonApply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                a = Double.parseDouble(upperLimitField.getText());
                b = Double.parseDouble(lowerLimitField.getText());
                accuracy = Double.parseDouble(accuracyField.getText());

                if (a < b) {
                    tmp = a;
                    a = b;
                    b = tmp;
                }

                series.getData().clear();


                    if (a != b) {
                        if (selectedMethod == 1) {

                            EquationResult result = hDMethod.solve(selectedEquation, a, b, accuracy);
                            outputLabel.setText("Result is: " + result.getResult());
                            numPartitionsLabel.setText("Number of partitions is: " + result.getNumberOfPartitions());
                            System.out.println(result.getWarningText());

                            ni = (a - b);
                            for (double i = 0; i <= ni; i++) {
                                series.getData().add(new XYChart.Data((b + i), (function.getValue(selectedEquation, (b + i)))));
                            }
                            lineChart.getData().add(series);
                        }
                        if (selectedMethod == 2) {
                            final EquationResult result = tMethod.solve(selectedEquation, a, b, accuracy);
                            outputLabel.setText("Result is: " + result.getResult());
                            numPartitionsLabel.setText("Number of partitions is: " + result.getNumberOfPartitions());

                            ni = (a - b);
                            for (double i = 0; i <= ni; i++) {
                                series.getData().add(new XYChart.Data((b + i), (function.getValue(selectedEquation, (b + i)))));
                            }
                            lineChart.getData().add(series);
                        }
                    } else {
                        outputLabel.setText("The limits are equal. Change them and try once more.");
                    }
                }
                catch(NumberFormatException e){
                    outputLabel.setText("Wrong format of input detected. Correct it and try once more.");
                }
            }
        });



        buttonSysApply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    a = Double.parseDouble(upperXLimitField.getText());
                    b = Double.parseDouble(lowerXLimitField.getText());
                    accuracy = Double.parseDouble(sysAccuracyField.getText());

                    if (a < b) {
                        tmp = a;
                        a = b;
                        b = tmp;
                    }

                    series.getData().clear();



                    if (a != b) {

                        SystemResult result = iMethod.solve(selectedSystem, a, b, accuracy);
                        //TODO: check the order of X1 and X2 (and rename if needed)
                        sysOutputLabel.setText("X equals: " + result.getX1Result() + " Y equals: " + result.getX2Result());
                        sysNumPartitionsLabel.setText("Number of partitions is: " + result.getNumberOfPartitions());
                        //TODO: add if any warnings are needed
                        //System.out.println(result.getWarningText());

                        ni = (a - b);
                        for (double i = 0; i <= ni; i++) {
                            series.getData().add(new XYChart.Data((b + i), (function.getValue(selectedEquation, (b + i)))));
                        }
                        lineChart.getData().add(series);

                    } else {
                        sysOutputLabel.setText("The limits are equal. Change them and try once more.");
                    }
                }
                catch(NumberFormatException e){
                    sysOutputLabel.setText("Wrong format of input detected. Correct it and try once more.");
                }
            }
        });




        //TODO: cleaning the lineChart to avoid multi-graph in the app
        //TODO: adaptation of the graph to displaying systems (multiple data in lineCharts)




        //______________________________________________________________






        //general settings
        Scene scene = new Scene(root);
        scene.setFill(Color.BEIGE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Equations calculator");


        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);



        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);

        /*
        Scanner scanner = new Scanner(System.in);
        int selectedEquation = Integer.parseInt(scanner.nextLine());
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double accuracy = Double.parseDouble(scanner.nextLine());
        //HalfDivisionMethod method = new HalfDivisionMethod();
        TangentialMethod method = new TangentialMethod();
        EquationResult result = method.solve(selectedEquation, a, b, accuracy);
        System.out.println(result.getResult());
        System.out.println(result.getNumberOfPartitions());
        System.out.println(result.getNameOfTheMethod());
        */
    }
}
