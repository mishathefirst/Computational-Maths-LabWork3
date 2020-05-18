package app;

public class SystemOfEquations {

    private int selectedSystem;

    private ListOfSystems listOfSystems = new ListOfSystems();

    public SystemOfEquations(int selectedSystem){
        this.selectedSystem = selectedSystem;
    }


    double getFirstEquationValue(double x){
        switch(selectedSystem){
            case(1): return listOfSystems.get11Function(x);
            //case(2): return listOfSystems.get21Function(x);
            //case(3): return listOfSystems.get31Function(x);
            default: return 0;
        }
    }

    double getSecondEquationValue(double x){
        switch(selectedSystem){
            case(1): return listOfSystems.get12Function(x);
            //case(2): return listOfSystems.get22Function(x);
            //case(3): return listOfSystems.get32Function(x);
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
