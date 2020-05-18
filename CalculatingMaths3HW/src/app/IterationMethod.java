package app;

class IterationMethod {

    private double X1, X2, previousX1, previousX2;
    private int n = 0;


    SystemResult solve(int selectedSystem, double upperIntervalPointX1, double lowerIntervalPointX1, double accuracy){

        SystemOfEquations systemOfEquations = new SystemOfEquations(selectedSystem);

        X1 = (upperIntervalPointX1 - lowerIntervalPointX1) / 2;
        X2 = systemOfEquations.getSecondEquationValue(X1);


        while(true){
            previousX1 = X1;
            previousX2 = X2;



            if ((Math.abs(X1 - previousX1) <= accuracy)
                    && (Math.abs(X2 - previousX2) < accuracy)) {
                break;
            }
        }



        return new SystemResult(X1, X2, n, "Iteration Method");
    }
}
