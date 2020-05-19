package app;

class SystemResult {

    private double resultX1;
    private double resultX2;
    private long numberOfPartitions;
    private double inaccuracy;
    private String methodName;
    ListOfSystems listOfSystems = new ListOfSystems();

    SystemResult(double resultX1, double resultX2, long numberOfPartitions, String methodName){
        this.resultX1 = resultX1;
        this.resultX2 = resultX2;
        this.numberOfPartitions = numberOfPartitions;
        this.inaccuracy = inaccuracy;
        this.methodName = methodName;
    }

    double getX1Result() {
        if (Double.isNaN(resultX1)){
            return listOfSystems.get2X0();
        }
        return resultX1;
    }

    double getX2Result() {
        if (Double.isNaN(resultX2)){
            return listOfSystems.get2Y0();
        }
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
