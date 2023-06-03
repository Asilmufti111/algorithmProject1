package PhoneNetworkApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import GraphFramework.*;

/*
 *  @authors Asil, Qamar, Aroub,Khalida
 * B9A
 * CPCS-324
 * Project Code
 * 18th may. 2023
 */
public class PhNWDesignApp {

    public static void main(String[] args) throws FileNotFoundException {
        //  ======================Main======================== //
        Scanner input = new Scanner(System.in);

        // Intilize variables
        int verticesNo = 0; // number of vertices
        int edgesNo = 0; // number of edges

        // ======================Header========================//
        System.out.println("""
                           \t\t--------------------------------------------------------------------
                           \t\t|Test to Compute the Minimum Spanning Tree and Compare Running Time|
                           \t\t|For Kruskal's Algorithm & Prim's Algorithm  (With Min-heap) |
                           \t\t-------------------------------------------------------------------
                           """);

        System.out.println("""
                           \t\t**********  (1) Requirement 1 Using Read_from_Graph Func. ********** 
                           \t\t**********  (2) Requirement 2 Using Make_Graph Func.      ********** 
                           """);

        // ------- Read User Input for the Selected Requirement -------- //
        System.out.print("Select Requirement Option --> ");

        int userInput = input.nextInt(); // Option of the Requirement

        // make sure user enter within option
        while (userInput != 1 && userInput != 2) {
            System.out.println("Wrong Selection. ");
            System.out.print("Select Requirement Option -> ");
            userInput = input.nextInt();
        }

        // ------------------------ Requirement 1 ------------------------ //
        if (userInput == 1) {
            System.out.println("\n\n\t\t\t-Requirement 1 Using Read From Graph function-");

            File graphFile = new File("graph.txt"); // Read from File	 
            BluePrintGraph phoneLine = new BluePrintGraph(graphFile); // Create An Object of Graph as CityMap
            MSTAlgorithm MSTAlgorithm;

            // --------------------------------------------- KRUSKAL ------------------------------------------------ //
            System.out.println("""
                               
                               The phone network (minimum spanning tree) generated by Kruskal algorithm is as follows""");

            MSTAlgorithm = new KruskalAlg(phoneLine);
            MSTAlgorithm.findMST(phoneLine); // Read Graph in Kruskal Algorithm

            MSTAlgorithm.displayResultingMST(); // Print info of MST List

            // --------------------------------------------- PQPRIM ------------------------------------------------- //
            System.out.println("""
                               
                               The phone network  (minimum spanning tree) generated by MinHeap Prim algorithm is as follows:""");

            MSTAlgorithm = new MHPrimAlg(phoneLine);
            MSTAlgorithm.findMST(phoneLine); // Read Graph in Prim Algorithm

            MSTAlgorithm.displayResultingMST(); // Print info of MST List

        } // End of Requirement 1

        // --------------------- Requirement 2 ------------------ //
        if (userInput == 2) {
            System.out.println("\t\t\t-Requirement 2 Using Make Graph function-");

            System.out.println("Cases of Edges(m) and Vertcies(n):");
            System.out.println("(1) n= 1000, m= 10000\n(2) n= 1000, m= 15000\n(3) n= 1000, m= 25000");
            System.out.println("(4) n= 5000, m= 15000\n(5) n= 5000, m= 25000");
            System.out.println("(6) n= 10000, m= 15000\n(7) n= 10000, m= 25000");

            do {
                // ------- Read User Input for the Selected Case -------- //
                System.out.print("Select your Test Option -> ");
                userInput = input.nextInt(); // Option of the Case
                switch (userInput) {

                    case 1: {
                        verticesNo = 1000;
                        edgesNo = 10000;
                    }
                    break;

                    case 2: {
                        verticesNo = 1000;
                        edgesNo = 15000;
                    }
                    break;
                    case 3: {
                        verticesNo = 1000;
                        edgesNo = 25000;
                    }
                    break;
                    case 4: {
                        verticesNo = 5000;
                        edgesNo = 15000;
                    }
                    break;
                    case 5: {
                        verticesNo = 5000;
                        edgesNo = 25000;
                    }
                    break;
                    case 6: {
                        verticesNo = 10000;
                        edgesNo = 15000;
                    }
                    break;
                    case 7: {
                        verticesNo = 10000;
                        edgesNo = 25000;
                    }
                    break;
                    default:
                        System.out.println("Option not found.");
                }
            } while (userInput > 7 || userInput < 1);

            // -------- IMPORTANT NOTE -------- //
            /**
             * As we have already seen in the analysis of the algorithms, both
             * of them require an undirected graph. While inputting a directed
             * graph does not automatically stop the algorithm, few examples can
             * show why we can not allow directed graphs. So, we will only work
             * on undirected graph.
             */
            BluePrintGraph phoneLine = new BluePrintGraph(verticesNo, edgesNo, false); // Create An Object of BluePrintGraph as CityMap 
            MSTAlgorithm MSTAlgorithm;
            System.out.println("\n***\nP.S. All generated graphs will remain undirected.\n***\n");

            // --------------------------------------------- KRUSKAL ------------------------------------------------ //
            System.out.println("""
                               
                               The phone network (minimum spanning tree) generated by Kruskal algorithm is as follows""");

            MSTAlgorithm = new KruskalAlg(phoneLine); // Chose Kruskal as the MST Object now
            double KruskalstartTime = System.currentTimeMillis(); // Start time of Kruskal      
            MSTAlgorithm.findMST(phoneLine); // Calculate the MST result
            double KruskalfinishTime = System.currentTimeMillis();// End time of Kruskal  
            double kruskalFinalTime = KruskalfinishTime - KruskalstartTime; // Final time  
            MSTAlgorithm.displayResultingMST();// Get the MST-Cost of Kruskal
            System.out.println("Running time  for Kruskal Algorithm: " + kruskalFinalTime);

            //--------------------------------------------- MHPRIM ------------------------------------------------- //
            System.out.println("\n\nThe phone network (minimum spanning tree) generated by MinHeap Prim algorithm");

            MSTAlgorithm = new MHPrimAlg(phoneLine); // Chose MHPrimAlg as the MST Object now
            double MHPrimstartTime = System.currentTimeMillis();//start time of MHPrim 
            MSTAlgorithm.findMST(phoneLine); // Calculate the MST result
            double MHPrimfinishtTime = System.currentTimeMillis();//start time of MHPrim  
            double MHPrimlFinalTime = MHPrimfinishtTime - MHPrimstartTime; // Final time  
            MSTAlgorithm.displayResultingMST();// Get the MST-Cost of Prim
            System.out.println("Running time for Min-heap Prim Algorithm: " + MHPrimlFinalTime);

        }

        input.close();
        System.out.println("Build Successful.");

    }
}
