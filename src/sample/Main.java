package sample;

import inferenceRules.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Hashtable;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Solver");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);
        // Lista de fatos
        FactContainer initFacts = new FactContainer();
        FactContainer inferedFacts = new FactContainer();
        initFacts
                //.addFact("P")
                .addFact("J")
                .addFact("L")
                .addFact("M");

        // Regra a ser avaliada
        //String str = "(¬Q->K)^(Q->R)^(¬KvT)";
        String str = "(P->K)^(K->Y)^(Y->J)^(J^L)^M";

        Solver solver = new Solver(str);

        //Solucionador
        solver
                .addRule(new ModusTolens())
                .addRule(new ModusPonens())
                .addRule(new Absorption())
                .addRule(new ConstructiveDilemma())
                .addRule(new DisjunctiveSyllogism())
                .addRule(new HypotheticalSyllogism());

        solver.setInferedFactContainer(inferedFacts);
        solver.setInitialFactContainer(initFacts);


        solver.generateFactBase();




        System.out.println("--------------------------------");
        if(initFacts.containsAll(inferedFacts)){
            System.out.println("A sentença de entrada é verdadeira");


        }else{
            System.out.println("A sentença de entrada é falsa");
        }

        System.out.println("\n--------------------------------");
        System.out.println("fatos iniciais: "+initFacts.getFactList()); // Lista de fatos iniciais
        System.out.println("fatos a serem satisfeitos: "+inferedFacts.getFactList()); // Lista de fatos a serem satisfeitos
        System.out.println("fatos inferidos: "+inferedFacts.getSpecialFactList()); // Lista de fatos inferidos
        System.out.println("sentença: "+ str); // String inicial
        System.out.println("Lista: "+solver.getLitteSentences()); // Lista final de sentenças
    }
}
