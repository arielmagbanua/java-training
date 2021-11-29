public class Main {
    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        er.addPatient(Injury.ABDOMINAL_PAIN, "18 year old says stomach hurts");
        er.addPatient(Injury.BURN, "Person burned hand while cooking dinner");
        er.addPatient(Injury.CHEST_PAIN, "62 year old has chest pain");
        er.addPatient(Injury.FRACTURE, "10 year old hurt knee while playing soccer, possible fracture");
        er.addPatient(Injury.HEMORRHAGE, "25 year old complaining of paper cut");
        er.addPatient(Injury.OTHER, "RIO student with a hangnail");

        System.out.println(er.nextPatient()); // prints "Injury: HEMORRHAGE, Description: 25 year old complaining of paper cut"
        System.out.println(er.nextPatient()); // prints "Injury: BURN, Description: Person burned hand while cooking dinner"
        System.out.println(er.nextPatient()); // prints "Injury: CHEST_PAIN, Description: 62 year old has chest pain"
        System.out.println(er.nextPatient()); // prints "Injury: FRACTURE, Description: 10 year old hurt knee while playing soccer, possible fracture"
        System.out.println(er.nextPatient()); // prints "Injury: ABDOMINAL_PAIN, Description: 18 year old says stomach hurts"
        System.out.println(er.nextPatient()); // prints "Injury: OTHER, Description: RIO student with a hangnail"
    }
}
