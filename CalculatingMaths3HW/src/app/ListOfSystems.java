package app;

public class ListOfSystems {

    //TODO: mind non-linear equations to be solved


    //first system

    //TODO: rewrite the functions
    double getYFunction1 (double x, double y){
        return (Math.pow(x, 2) + 2 * x - 3);
    }

    String get11FunctionAsString(){
        return "x^2 + 2x - 3";
    }

    double getXFunction1 (double x, double y){
        return (x - 1);
    }

    String get12FunctionAsString(){
        return "x - 1";
    }

    double getPrimaryY1(double x){
        return (1);
    }



    //second system
    //TODO: write appropriate expressions and their string versions
    double getYFunction2 (double x, double y){
        return (Math.sqrt(x * y + 12));
    }

    String get21FunctionAsString(){
        return "y^2 - xy - 12 = 0";
    }

    double getXFunction2 (double x, double y){
        return (Math.sqrt(x * y - 3));
    }

    String get22FunctionAsString(){
        return "x^2 - xy + 3 = 0";
    }

    double getPrimaryY2(double x){
        return ((Math.pow(x, 2) + 3) / x);
    }

    //third system


}
