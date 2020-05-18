package app;

class Function {
    private ListOfFunctions listOfFunctions = new ListOfFunctions();

    double getValue(int selectedFunction, double x) {
        switch(selectedFunction){
            case(1): return listOfFunctions.getFirstFunction(x);
            case(2): return listOfFunctions.getSecondFunction(x);
            //case(3): return listOfFunctions.getThirdFunction(x);
            //case(4): return listOfFunctions.getForthFunction(x);
            //case(5): return listOfFunctions.getFifthFunction(x);
            //case(6): return listOfFunctions.getSixthFunction(x);
            default: return 0;
        }
    }

    double getFirstDerivative(int selectedFunction, double x) {
        switch(selectedFunction){
            case(1): return listOfFunctions.get1F1D(x);
            case(2): return listOfFunctions.get2F1D(x);
            //case(3): return listOfFunctions.get3F1D(x);
            //case(4): return listOfFunctions.get4F1D(x);
            //case(5): return listOfFunctions.get5F1D(x);
            //case(6): return listOfFunctions.get6F1D(x);
            default: return 0;
        }
    }

    double getSecondDerivative(int selectedFunction, double x) {
        switch(selectedFunction){
            case(1): return listOfFunctions.get1F2D(x);
            case(2): return listOfFunctions.get2F2D(x);
            //case(3): return listOfFunctions.get3F2D(x);
            //case(4): return listOfFunctions.get4F2D(x);
            //case(5): return listOfFunctions.get5F2D(x);
            //case(6): return listOfFunctions.get6F2D(x);
            default: return 0;
        }
    }
}
