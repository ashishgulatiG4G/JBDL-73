public class Vehicle {
    private String regNumber;
    private String color;
    private String make;

    public Vehicle() {
//        System.out.println("Vehicle created");
    }

//
//    public Vehicle(String regNumber, String color, String make) {
//        this.regNumber = regNumber;
//        this.color = color;
//        this.make = make;
//        System.out.println("Vehicle created");
//    }

    public void accelerate() {
        System.out.println("Accelerating vehicle");
    }

    public void applyBrake() {
        System.out.println("Brake Applied");
    }

}
