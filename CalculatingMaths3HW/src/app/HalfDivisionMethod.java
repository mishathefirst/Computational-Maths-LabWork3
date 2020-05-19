package app;

class HalfDivisionMethod {

    private double x;
    private String warningText = " ";
    private int n = 0;
    private int previousN = -1;

    EquationResult solve (int selectedEquation, double upperIntervalPoint, double lowerIntervalPoint, double accuracy){
        Function function = new Function();

        if(function.getValue(selectedEquation, upperIntervalPoint) * function.getValue(selectedEquation, lowerIntervalPoint) > 0){
            warningText = "Warning: the interval contains no roots or more than one. The result can contain wrong values.";
        }

        while(true) {

            if (n > previousN) {
                x = (lowerIntervalPoint + upperIntervalPoint) / 2;
            }
            previousN = n;

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

        return new EquationResult(x, n, "Half-Division Method.", warningText);

    }

}
