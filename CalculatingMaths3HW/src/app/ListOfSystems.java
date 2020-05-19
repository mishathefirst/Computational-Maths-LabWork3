package app;

public class ListOfSystems {


    //first system
    double getFunction1(double x, double y){
        return ((-1 / ((64 * x * y) + (27 * Math.pow(x, 2) * Math.pow(y, 2)))) * (4 * Math.pow(x, 2)) - Math.pow(y, 3) + 28);
    }

    /*
    double getYFunction1 (double x, double y){
        return ((-1 / ((64 * x * y) + (27 * Math.pow(x, 2) * Math.pow(y, 2)))) * ((3 * Math.pow(x, 3)) + (4 * Math.pow(y, 2)) - 145));
    }
    */

    double getYFunction1 (double x, double y){
        return (Math.sqrt(((-3) * Math.pow(x, 3) + 145) / 4));
    }

    String get11FunctionAsString(){
        return "4 * x^2 - y^3 + 28 = 0";
    }

    /*
    double getXFunction1 (double x, double y){
        return ((-1 / ((64 * x * y) + (27 * Math.pow(x, 2) * Math.pow(y, 2)))) * ((4 * Math.pow(x, 2)) - Math.pow(y, 3) + 28));
    }
    */

    double getXFunction1 (double x, double y){
        return (Math.sqrt((Math.pow(y, 3) + 28) / 4));
    }

    String get12FunctionAsString(){
        return "3 * x^3 + 4 * y^2 - 145 = 0";
    }

    double getPrimaryY1(double x){
        return (1);
    }





    //second system
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




    //equations for graph
    double e11Graph(double x){
        return (Math.pow((4 * Math.pow(x, 2) + 28), 0.33334));
    }

    double e12Graph(double x){
        return (Math.sqrt(Math.abs(((-3) * Math.pow(x, 3) + 145)) / 4));
    }

    double e21Graph(double x){
        return (x + Math.sqrt(Math.pow(x, 2) + 48)) / 2;
    }

    double e22Graph(double x){
        return ((Math.pow(x, 2) + 3) / x);
    }














    double get1X0(){
        return 3.0;
    }

    double get1Y0(){
        return 4.0;
    }



    double get2X0(){
        return 1.0;
    }

    double get2Y0(){
        return 4.0;
    }


}
