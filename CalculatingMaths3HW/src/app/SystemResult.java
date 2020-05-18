package app;

class SystemResult {

    private double resultX1;
    private double resultX2;
    private long numberOfPartitions;
    private double inaccuracy;
    private String methodName;

    SystemResult(double resultX1, double resultX2, long numberOfPartitions, String methodName){
        this.resultX1 = resultX1;
        this.resultX2 = resultX2;
        this.numberOfPartitions = numberOfPartitions;
        this.inaccuracy = inaccuracy;
        this.methodName = methodName;
    }

    double getX1Result() {
        return resultX1;
    }

    double getX2Result() {
        return resultX2;
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
