package GA;

public class Individual {
   
    private int[] chromosome;
    private static int[] maxchromosome;
    private int age;
    private double fitness = -1;
    private  static double maxfitness = -1;
    private boolean isDead = false;
    
    public Individual(int[] chromosome){
        this.chromosome = chromosome;
        this.age = 0;
    }
    
    /*
     *  random create a individual
     * */
    public Individual(int chromosomeLength){
        this.chromosome = new int[chromosomeLength];
        this.age = 0;
        for (int gene = 0; gene < chromosomeLength; gene++) {
            if(0.5<Math.random()){
                this.setGene(gene, 1);
            }
            else {
                this.setGene(gene, 0);
            }
        }
    }
    
    public int[] getChromosome(){
        return this.chromosome;
    }
    public int getAge(){
    	return this.age;
    }
    
    public void setAge(int age){
    	this.age = age;
    }
  
    public boolean getisDead(){
    	return this.isDead;
    }
    
    public void setisDead(boolean isDead){
    	this.isDead = isDead;
    }
    public int getChromosomeLength(){
        return this.chromosome.length;
    }
   
    public void setGene(int offset,int gene){
        this.chromosome[offset] = gene;
    }
    
    
    public int getGene(int offset){
        return this.chromosome[offset];
    }
   
    public void setFitness(double fitness){
        this.fitness = fitness;
        if(maxfitness <= fitness){
        	maxfitness = fitness;
        	this.maxchromosome = this.chromosome;
        }
    }
   
    public double getMaxFitness(){
    	return this.maxfitness;
    }
    public double getFitness(){
        return this.fitness;
    } 
    
    public String toMaxString(){
        String output = "";
        for (int gene = 0; gene < this.maxchromosome.length; gene++) {
            output +=this.maxchromosome[gene];
        }
        return output;
    }
    
    public String toString(){
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output +=this.chromosome[gene];
        }
        return output;
    }
}