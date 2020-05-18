package app;

class EquationResult {

    private double result;
    private long numberOfPartitions;
    private double inaccuracy;
    private String methodName;

    EquationResult(double result, long numberOfPartitions, String methodName){
        this.result = result;
        this.numberOfPartitions = numberOfPartitions;
        this.inaccuracy = inaccuracy;
        this.methodName = methodName;
    }

    double getResult() {
        return result;
    }

    long getNumberOfPartitions() {
        return numberOfPartitions;
    }

    double getInaccuracy() {
        return inaccuracy;
    }

    String getNameOfTheMethod(){
        return methodName;
    }

}
