package GA;


public class ZebraController {
   
    public static int maxGenerations = 1000;
    
    public static void main(String[] args) {
        
        Maze maze = new Maze(new int[][] {


                {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 3, 2, 0},
                {1, 0, 1, 1, 0, 1, 0, 0, 3, 3, 3, 1, 0, 1, 1, 3, 1, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 3, 1, 3, 1, 1, 0, 1, 3, 0, 0},
                {0, 1, 1, 0, 1, 3, 3, 3, 3, 1, 3, 1, 1, 3, 3, 3, 1, 1},
                {1, 0, 1, 0, 1, 3, 1, 0, 1, 0, 3, 3, 1, 3, 1, 0, 1, 0},
                {0, 1, 3, 3, 3, 3, 1, 0, 0, 1, 1, 3, 3, 3, 1, 1, 1, 1},
                {1, 1, 3, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1},
                {1, 1, 3, 1, 3, 3, 3, 3, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 3, 3, 1, 3, 1, 1, 3, 1, 0, 1, 1, 1, 3, 3, 3, 3, 1},
                {1, 3, 1, 0, 3, 3, 1, 3, 3, 3, 3, 1, 1, 3, 1, 1, 3, 1},
                {1, 3, 1, 1, 1, 3, 1, 1, 0, 1, 3, 1, 1, 3, 1, 1, 3, 1},
                {1, 3, 3, 1, 3, 3, 1, 1, 0, 1, 3, 3, 3, 3, 1, 3, 3, 0},
                {0, 1, 3, 1, 3, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 3, 1, 0},
                {1, 0, 3, 1, 3, 1, 1, 0, 1, 1, 1, 1, 1, 1, 3, 3, 0, 1},
                {0, 1, 3, 3, 3, 1, 1, 0, 3, 3, 3, 3, 3, 3, 3, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1, 1, 1, 0, 3, 3, 3, 3, 1, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 4, 1, 0, 1, 0, 1, 1}

        });

        GeneticAlgorithm ga = new GeneticAlgorithm(1000, 0.05, 10, 0.25, 0.75, 300);
        Population population = ga.initPopulation(128);
        

        ga.evalPopulation(population, maze);
        
        int generation =1;
       
        // evaluation
        while (ga.isTerminationConditionMet(generation, maxGenerations) == false) {
            
            Individual fittest = population.getFittest(0);
            
            System.out.println( fittest.getFitness()  );

            //+ fittest.toString()
            
            //Age +
            ga.addAge(population);
            //dead
            population = ga.deadPopulation(population);

            // crossover
            population = ga.crossoverPopulation(population);

            // mutation
            population = ga.mutatePopulation(population);

            
            ga.evalPopulation(population, maze);

            //next generation
            generation++;
        }

        System.out.println("Stopped after " + maxGenerations + " generations.");
        Individual fittest = population.getFittest(0);
        System.out.println("Best solution (" + fittest.getMaxFitness() + "): "
                + fittest.toString());

    }
    
}
