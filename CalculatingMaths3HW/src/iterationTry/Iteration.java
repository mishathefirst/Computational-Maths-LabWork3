package iterationTry;

public class Iteration {
    public static void main(String[] args) {

        double X1, X2, previousX1, previousX2;
        double accuracy = 0.0001;

        X1 = 8;
        X2 = 3;

        while(true){
            previousX1 = X1;
            previousX2 = X2;

            X2 = (Math.sqrt(previousX1 - 2 * previousX2 + 3));
            X1 = ((2 * Math.pow(previousX2, 2) / 2 + 4 * previousX2 / 3 - 2));


            if ((Math.abs(X1 - previousX1) <= accuracy)
                    && (Math.abs(X2 - previousX2) < accuracy)) {
                break;
            }
        }

        System.out.println(X1);
        System.out.println(X2);

    }



}


/*
    double getValueX1(double x1, double x2){
        return (2 * Math.pow(x2, 2) / 2 + 4 * x2 / 3 - 2);
    }

    double getValueX2(double x1, double x2){
        return Math.sqrt(x1 - 2 * x2 + 3);
    }
    */

