package app;

class SystemOfEquations {

    private int selectedSystem;

    private ListOfSystems listOfSystems = new ListOfSystems();

   SystemOfEquations(int selectedSystem){
        this.selectedSystem = selectedSystem;
    }

    SystemOfEquations(){}


    double getXValue(double x, double y){
        switch(selectedSystem){
            case(1): return listOfSystems.getXFunction1(x, y);
            case(2): return listOfSystems.getXFunction2(x, y);
            //case(3): return listOfSystems.get31Function(x);
            default: return 0;
        }
    }

    double getYValue(double x, double y){
        switch(selectedSystem){
            case(1): return listOfSystems.getYFunction1(x, y);
            case(2): return listOfSystems.getYFunction2(x, y);
            //case(3): return listOfSystems.get32Function(x);
            default: return 0;
        }
    }


    double getPrimaryYValue(double x){
        switch(selectedSystem){
            case(1): return listOfSystems.getPrimaryY1(x);
            case(2): return listOfSystems.getPrimaryY2(x);
            //case(3): return listOfSystems.getPrimaryY3(x);
            default: return 0;
        }
    }


    double getX0(){
        switch(selectedSystem){
            case(1): return listOfSystems.get1X0();
            case(2): return listOfSystems.get2X0();
            //case(3): return listOfSystems.get3X0();
            default: return 0;
        }
    }


    double getY0(){
        switch(selectedSystem){
            case(1): return listOfSystems.get1Y0();
            case(2): return listOfSystems.get2Y0();
            //case(3): return listOfSystems.get3Y0();
            default: return 0;
        }
    }

    /*
    String getFirstEquationAsString(){
        switch(selectedSystem){
            case(1): return listOfSystems.get11FunctionAsString();
            case(2): return listOfSystems.get21FunctionAsString();
            case(3): return listOfSystems.get31FunctionAsString();
            default: return 0;
        }
    }


    String getSecondEquationAsString(){
        switch(selectedSystem){
            case(1): return listOfSystems.get12FunctionAsString();
            case(2): return listOfSystems.get22FunctionAsString();
            case(3): return listOfSystems.get32FunctionAsString();
            default: return 0;
        }
    }
    */






}
