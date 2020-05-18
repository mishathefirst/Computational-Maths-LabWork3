package app;

class HalfDivisionMethod {

    //private double lowerIntervalPoint = -1000000000;
    //private double upperIntervalPoint = 1000000000;
    //private double lowerIntervalPoint = -2;
    //private double upperIntervalPoint = -1;
    private double x;
    private int n = 0;
    private int previousN = -1;

    EquationResult solve (int selectedEquation, double upperIntervalPoint, double lowerIntervalPoint, double accuracy){
        Function function = new Function();

        while(true) {

            if (n > previousN) {
                x = (lowerIntervalPoint + upperIntervalPoint) / 2;
            }
            previousN = n;
            //TODO: PROCESSING OF INTERVAL ERRORS (RECURSION?)
            //TODO: 1. Lower and upper limits have to be reversed by the user in case of a wrong input
            //TODO: 2. Wrong characters and numbers are forbidden
            //TODO: 3. If found, an interval with more than one root (f(a)*f(b)>0) has to display an error
            if ((function.getValue(selectedEquation, upperIntervalPoint) * function.getValue(selectedEquation, x)) > 0) {
                upperIntervalPoint = x;
                n++;
            } else {
                if ((function.getValue(selectedEquation, upperIntervalPoint) * function.getValue(selectedEquation, x)) < 0) {
                    lowerIntervalPoint = x;
                    n++;
                }
                else{
                    x = x + 0.000000000001;
                    upperIntervalPoint = upperIntervalPoint + 0.000000000001;
                }
            }

            if ((Math.abs(upperIntervalPoint - lowerIntervalPoint) <= accuracy)
                    || (Math.abs(function.getValue(selectedEquation, x)) < accuracy)) {
                break;
            }
        }

        x = (upperIntervalPoint + lowerIntervalPoint) / 2;

        return new EquationResult(x, n, "Half-Division Method.");

    }

}
