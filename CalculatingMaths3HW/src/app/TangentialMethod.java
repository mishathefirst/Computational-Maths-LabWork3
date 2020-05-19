package app;

class TangentialMethod {

    EquationResult solve(int selectedEquation, double upperIntervalPoint, double lowerIntervalPoint, double accuracy){
        Function function = new Function();
        boolean flag = false;
        double x, x0;
        int numberOfPartitions = 0;

        for (int i = 0; i < (upperIntervalPoint - lowerIntervalPoint - 1); i++){

            if ((function.getValue(selectedEquation, (lowerIntervalPoint + i)) < 0) && (function.getValue(selectedEquation, (lowerIntervalPoint + i + 1)) > 0)){
                flag = true;
            }

            if ((function.getValue(selectedEquation, (lowerIntervalPoint + i)) > 0) && (function.getValue(selectedEquation, (lowerIntervalPoint + i + 1)) < 0)) {
                flag = true;
            }

            if (function.getValue(selectedEquation, (lowerIntervalPoint + i)) == 0){
                x = lowerIntervalPoint + i;
                return new EquationResult(x, 0, "Tangential Method.", " ");
            }

            if (flag){
                lowerIntervalPoint = lowerIntervalPoint + i;
                upperIntervalPoint = upperIntervalPoint + i;
            }
            else{
                //return new EquationResult(-99999999999.0, 0, "Tangential Method.", "Root not found on the interval");
            }
        }

        if (function.getValue(selectedEquation, upperIntervalPoint)
                * function.getSecondDerivative(selectedEquation, upperIntervalPoint) > 0){
            x0 = upperIntervalPoint;
            }
            else{
                x0 = lowerIntervalPoint;
        }

        while(true){
            x = x0 - (function.getValue(selectedEquation, x0) / function.getFirstDerivative(selectedEquation, x0));

            if (Math.abs(x - x0) < accuracy){
                break;
            }

            x0 = x;
            numberOfPartitions++;
        }

        return new EquationResult(x, numberOfPartitions, "Tangential Method.", " ");
    }

}
