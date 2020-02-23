public class II {
    Perceptron[] pers = new Perceptron[16];
    public int findMax(){
        for (int i = 0; i < pers.length; i++) {
            double bigger = pers[i].sum();
            if(pers[i+1].sum() > bigger){
                bigger = pers[i+1].sum();
            }
        }
        return 0;
    }
}
class Perceptron{
    public static double value;
    public static double weight;
    public static int threshold = 0;

    public Perceptron(String is) {
        int value = is.charAt(0) == ' '? 0 : is.charAt(0) == 'X'? 1 : 0;

    }

    public static double sum() {
        double p = value  * weight;
        return p;
    }
    public static void porog(){
        if(value < 0.5){
            threshold = 0;
        } else if (value >= 0.5) {
            threshold = 1;
        }
    }
}
