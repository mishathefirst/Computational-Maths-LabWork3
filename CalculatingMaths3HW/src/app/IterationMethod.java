package app;

class IterationMethod {

    SystemResult solve(int selectedSystem, double upperIntervalPointX, double lowerIntervalPointX, double accuracy){

        double X, Y, previousX, previousY;
        int n = 0;

        SystemOfEquations systemOfEquations = new SystemOfEquations(selectedSystem);

        X = (upperIntervalPointX - lowerIntervalPointX) / 2;
        Y = systemOfEquations.getPrimaryYValue(X);

        System.out.println(X);
        System.out.println(Y);


        while(true){
            previousX = X;
            previousY = Y;

            X = systemOfEquations.getXValue(previousX, previousY);
            Y = systemOfEquations.getYValue(previousX, previousY);


            if (n % 50 == 0) {
                System.out.println("X = " + X);
                System.out.println("Y = " + Y);
            }

            n++;

            if ((Math.abs(X - previousX) <= accuracy)
                    && (Math.abs(Y - previousY) <= accuracy)) {
                break;
            }
        }



        //TODO: convert this into a return statement
        if(X == Double.POSITIVE_INFINITY || Y == Double.POSITIVE_INFINITY ||
                X == Double.NEGATIVE_INFINITY || Y == Double.NEGATIVE_INFINITY){
            System.out.println("Function does not converge on the interval.");
        }
        else{
            System.out.println(X);
            System.out.println(Y);
        }


        return new SystemResult(X, Y, n, "Iteration Method");
    }
}
