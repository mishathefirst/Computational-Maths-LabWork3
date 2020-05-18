package app;

class ListOfFunctions {


    double getFirstFunction (double x){
        return (Math.pow(x, 3) - x + 4);
    }

    String getFirstFunctionAsString(){
        return "x^3 - x + 4";
    }

    double get1F1D(double x){
        return (3*Math.pow(x, 2) - 1);
    }

    double get1F2D(double x){
        return (6*x);
    }

    double getSecondFunction (double x){
        return (Math.pow(x, 2) + 2 * x - 3);
    }

    String getSecondFunctionAsString(){
        return "x^2 + 2x - 3";
    }

    double get2F1D(double x){
        return (2*x + 2);
    }

    double get2F2D(double x){
        return 2;
    }


}
