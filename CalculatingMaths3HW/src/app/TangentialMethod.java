package app;

class TangentialMethod {



    EquationResult solve(int selectedEquation, double upperIntervalPoint, double lowerIntervalPoint, double accuracy){
        Function function = new Function();
        boolean flag = false;
        double x, x0;
        int numberOfPartitions = 0;

        //TODO: improve the graph display in the app

        for (int i = 0; i < (upperIntervalPoint - lowerIntervalPoint - 1); i++){

            if ((function.getValue(selectedEquation, (lowerIntervalPoint + i)) < 0) && (function.getValue(selectedEquation, (lowerIntervalPoint + i + 1)) > 0)){
                flag = true;
            }

            if ((function.getValue(selectedEquation, (lowerIntervalPoint + i)) > 0) && (function.getValue(selectedEquation, (lowerIntervalPoint + i + 1)) < 0)) {
                flag = true;
            }

            if (function.getValue(selectedEquation, (lowerIntervalPoint + i)) == 0){
                x = lowerIntervalPoint + i;
                return new EquationResult(x, 0, "Tangential Method.");
            }

            if (flag){
                lowerIntervalPoint = lowerIntervalPoint + i;
                upperIntervalPoint = upperIntervalPoint + i;
            }
            else{
                //return "Root not found on the interval";
                //TODO: error warning!
            }
        }

        //System.out.println(lowerIntervalPoint);
        //System.out.println(upperIntervalPoint);

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

        return new EquationResult(x, numberOfPartitions, "Tangential Method.");
    }

}
