package app;

class EquationResult {

    private double result;
    private long numberOfPartitions;
    private double inaccuracy;
    private String methodName;
    private String warningText;

    EquationResult(double result, long numberOfPartitions, String methodName, String warningText){
        this.result = result;
        this.numberOfPartitions = numberOfPartitions;
        this.inaccuracy = inaccuracy;
        this.methodName = methodName;
        this.warningText = warningText;
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

    String getWarningText(){
        return warningText;
    }

}
