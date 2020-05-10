package sample;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button truthButton;

    @FXML
    private Button dareButton;

    @FXML
    private Label taskLabel;

    @FXML
    void initialize() {
        truthButton.setOnAction(e -> getTruth());
        dareButton.setOnAction(e -> getTask());
    }

    public void getTruth(){
        String question = getRandomQuestion();
        taskLabel.setText(question);
    }

    public void getTask(){
        String task = getRandomTask();
        taskLabel.setText(task);
    }


    public String getRandomQuestion(){
        ArrayList questions = new ArrayList();
        try {
            File file = new File("/Users/mac/Downloads/TruthOrDare/src/sample/truth.txt"); //reading a file
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String q = myReader.nextLine();
                questions.add(q);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        Random r = new Random();
        String question = (questions.get(r.nextInt(questions.size())) + " ");
        return question;
    }

    public String getRandomTask(){
        ArrayList tasks = new ArrayList();
        try {
            File file = new File("/Users/mac/Downloads/TruthOrDare/src/sample/dare.txt"); //reading a file
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String t = myReader.nextLine();
                tasks.add(t);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        Random r = new Random();
        String task = (tasks.get(r.nextInt(tasks.size())) + " ");
        return task;
    }
}
