package centralunit;

import alarmcomponents.*;
import house.House;
import house.Room;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        House erlichBachmansHus = new House("Erlich Bachman's house");

        Room garage = new Room("garage", "garage port", "garage window");
        Room livingroom = new Room("livingroom", "slide door", "first livingroom window", "second livingroom window");
        Room kitchen = new Room("kitchen", "kitchen window");
        Room erlichsBedroom = new Room("Erlich's bedroom", "first window in Erlich's bedroom");
        erlichsBedroom.getWindows().add("second window in Erlich's bedroom");
        Room jiansBedroom = new Room("Jian's bedroom", "window in Jian's bedroom");
        Room richardsBedroom = new Room("Richard's bedroom", "window in Richard's bedroom");
        Room bertramsBedroom = new Room("Bertram's bedroom", "first window in Bertram's bedroom");
        bertramsBedroom.getWindows().add("second window in Bertram's bedroom");
        Room dineshsbedroom = new Room("Dinesh's bedroom", "window in Dinesh's bedroom");
        Room hallway = new Room("hallway", "front door", "hallway window");
        Room garden = new Room("backyard");

        erlichBachmansHus.addRoom(garage);
        erlichBachmansHus.addRoom(livingroom);
        erlichBachmansHus.addRoom(kitchen);
        erlichBachmansHus.addRoom(erlichsBedroom);
        erlichBachmansHus.addRoom(jiansBedroom);
        erlichBachmansHus.addRoom(richardsBedroom);
        erlichBachmansHus.addRoom(bertramsBedroom);
        erlichBachmansHus.addRoom(dineshsbedroom);
        erlichBachmansHus.addRoom(hallway);

        NoisyAlarm noisyAlarm = new NoisyAlarm("alarm");

        for (int i = 0; i < 3; i++) {
            DoorDetector doorDetector = new DoorDetector("doordetector " + i);
            noisyAlarm.getListOfDoorDetectors().add(doorDetector);
        }
        for (int i = 0; i < 11; i++) {
            WindowDetector windowDetector = new WindowDetector("windowdetector " + i);
            noisyAlarm.getListOfWindowDetectors().add(windowDetector);
        }

        MovementDetector movementDetectorHallway = new MovementDetector("hallway detector");
        MovementDetector movementDetectorLivingroom = new MovementDetector("livingroom detector");
        MovementDetector movementDetectorBackyaard = new MovementDetector("backyard detector");
        noisyAlarm.getListOfMovementDetectors().add(movementDetectorHallway);
        noisyAlarm.getListOfMovementDetectors().add(movementDetectorLivingroom);
        noisyAlarm.getListOfMovementDetectors().add(movementDetectorBackyaard);

        SmokeDetector smokeDetectorGarage = new SmokeDetector("garage smoke detector", garage);
        SmokeDetector smokeDetectorLivingroom = new SmokeDetector("livingroom smoke detector", livingroom);
        SmokeDetector smokeDetectorKitchen = new SmokeDetector("kitchen smoke detector", kitchen);
        SmokeDetector smokeDetectorErlich = new SmokeDetector("Erlich's bedroom smoke detector", erlichsBedroom);
        SmokeDetector smokeDetectorJian = new SmokeDetector("Jian's bedroom smoke detector", jiansBedroom);
        SmokeDetector smokeDetectorRichard = new SmokeDetector("Richard's bedroom smoke detector", richardsBedroom);
        SmokeDetector smokeDetectorBertram = new SmokeDetector("Bertram's bedroom smoke detector", bertramsBedroom);
        SmokeDetector smokeDetectorDinesh = new SmokeDetector("Dinesh's bedroom smoke detector", dineshsbedroom);
        SmokeDetector smokeDetectorHallway = new SmokeDetector("hallway smoke detector", hallway);

        erlichBachmansHus.addSmokeDetectors(smokeDetectorBertram);
        erlichBachmansHus.addSmokeDetectors(smokeDetectorDinesh);
        erlichBachmansHus.addSmokeDetectors(smokeDetectorHallway);
        erlichBachmansHus.addSmokeDetectors(smokeDetectorErlich);
        erlichBachmansHus.addSmokeDetectors(smokeDetectorJian);
        erlichBachmansHus.addSmokeDetectors(smokeDetectorKitchen);
        erlichBachmansHus.addSmokeDetectors(smokeDetectorLivingroom);
        erlichBachmansHus.addSmokeDetectors(smokeDetectorRichard);
        erlichBachmansHus.addSmokeDetectors(smokeDetectorGarage);



        Sprinklers sprinklerGarage = new Sprinklers("garage sprinkler", garage, smokeDetectorGarage);
        Sprinklers sprinklerLivingroom = new Sprinklers("livingroom sprinkler", livingroom, smokeDetectorLivingroom);
        Sprinklers sprinklerKitchen = new Sprinklers("kitchen sprinkler", kitchen, smokeDetectorKitchen);
        Sprinklers sprinklerErlich = new Sprinklers("Erlich's bedroom sprinkler", erlichsBedroom, smokeDetectorErlich);
        Sprinklers sprinklerJian = new Sprinklers("Jian's bedroom sprinkler", jiansBedroom, smokeDetectorJian);
        Sprinklers sprinklerRichard = new Sprinklers("Richard's bedroom sprinkler", richardsBedroom, smokeDetectorRichard);
        Sprinklers sprinklerBertram = new Sprinklers("Bertram's bedroom sprinkler", bertramsBedroom, smokeDetectorBertram);
        Sprinklers sprinklerDinesh = new Sprinklers("Dinesh's bedroom sprinkler", dineshsbedroom, smokeDetectorDinesh);
        Sprinklers sprinklerHallway = new Sprinklers("hallway sprinkler", hallway, smokeDetectorHallway);

        erlichBachmansHus.addSprinklers(sprinklerGarage);
        erlichBachmansHus.addSprinklers(sprinklerLivingroom);
        erlichBachmansHus.addSprinklers(sprinklerKitchen);
        erlichBachmansHus.addSprinklers(sprinklerErlich);
        erlichBachmansHus.addSprinklers(sprinklerJian);
        erlichBachmansHus.addSprinklers(sprinklerRichard);
        erlichBachmansHus.addSprinklers(sprinklerBertram);
        erlichBachmansHus.addSprinklers(sprinklerDinesh);
        erlichBachmansHus.addSprinklers(sprinklerHallway);


        System.out.println("Welcome to the larm menu for " + erlichBachmansHus.getHouseName());

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userChoice;

        do {
            userChoice = startMenu(scanner);
            switch (userChoice) {
                case 1:
                    for (int i = 0; i < noisyAlarm.getListOfDoorDetectors().size(); i++) {
                        noisyAlarm.getListOfDoorDetectors().get(i).enableAlarm();
                    }
                    for (int i = 0; i < noisyAlarm.getListOfMovementDetectors().size(); i++) {
                        noisyAlarm.getListOfMovementDetectors().get(i).enableAlarm();
                    }
                    for (int i = 0; i < noisyAlarm.getListOfWindowDetectors().size(); i++) {
                        noisyAlarm.getListOfWindowDetectors().get(i).enableAlarm();
                    }
                    System.out.println("-----");
                    System.out.println("Alarm is active");
                    break;
                case 2:
                    for (int i = 0; i < noisyAlarm.getListOfDoorDetectors().size(); i++) {
                        noisyAlarm.getListOfDoorDetectors().get(i).disableAlarm();
                    }
                    for (int i = 0; i < noisyAlarm.getListOfMovementDetectors().size(); i++) {
                        noisyAlarm.getListOfMovementDetectors().get(i).disableAlarm();
                    }
                    for (int i = 0; i < noisyAlarm.getListOfWindowDetectors().size(); i++) {
                        noisyAlarm.getListOfWindowDetectors().get(i).disableAlarm();
                    }
                    System.out.println("-----");
                    System.out.println("Alarm is disabled");
                    break;
                case 3:
                    for (int i = 0; i < noisyAlarm.getListOfDoorDetectors().size(); i++) {
                        noisyAlarm.getListOfDoorDetectors().get(i).restoreAlarm();
                    }
                    for (int i = 0; i < noisyAlarm.getListOfMovementDetectors().size(); i++) {
                        noisyAlarm.getListOfMovementDetectors().get(i).restoreAlarm();
                    }
                    for (int i = 0; i < noisyAlarm.getListOfWindowDetectors().size(); i++) {
                        noisyAlarm.getListOfWindowDetectors().get(i).restoreAlarm();
                    }
                    System.out.println("-----");
                    System.out.println("Alarm is restored");
                    break;
                case 4:
                    occurranceMenu(scanner, noisyAlarm, random, movementDetectorBackyaard, erlichBachmansHus);
                    break;
                case 5:
                    System.out.println("Exiting program");
                    break;

                default:
                    System.out.println("Invalid choice, try again. Only enter a single digit");
                    break;
            }
        } while (userChoice != 5);

    }

    private static int startMenu(Scanner scanner) {
        System.out.println("-----");
        System.out.println("Make a choice below");
        System.out.println("1. Enable the larm system");
        System.out.println("2. Disable the larm system");
        System.out.println("3. Restore the alarm");
        System.out.println("4. Simulate an occurance");
        System.out.println("5. Exit");
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        return userChoice;
    }

    private static void occurranceMenu(Scanner scanner, NoisyAlarm noisyAlarm, Random random, MovementDetector movementDetector, House house) {
        System.out.println("-----");
        System.out.println("1. Simulate break in");
        System.out.println("2. Simulate fire");
        System.out.println("3. Simulate movement in the backyard");
        System.out.println("4. Return to main menu");
        System.out.println("5. Exit program");
        int occurranceChoice = scanner.nextInt();
        scanner.nextLine();

        switch (occurranceChoice) {
            case 1:
                int randomDetectorType = random.nextInt(3);
                if (randomDetectorType == 0) {
                    int randomDetector = random.nextInt(noisyAlarm.getListOfDoorDetectors().size());
                    noisyAlarm.getListOfDoorDetectors().get(randomDetector).triggerAlarm();
                    noisyAlarm.checkAlarmStatus();
                } else if (randomDetectorType == 1) {
                    int randomDetector = random.nextInt(noisyAlarm.getListOfMovementDetectors().size());
                    noisyAlarm.getListOfMovementDetectors().get(randomDetector).triggerAlarm();
                    noisyAlarm.checkAlarmStatus();
                } else {
                    int randomDetector = random.nextInt(noisyAlarm.getListOfWindowDetectors().size());
                    noisyAlarm.getListOfWindowDetectors().get(randomDetector).triggerAlarm();
                    noisyAlarm.checkAlarmStatus();
                }
                break;
            case 2:
                int randomRoom = random.nextInt(house.getRooms().size());
                Room room = house.getRooms().get(randomRoom);
                SmokeDetector correspondingSmokeDetector = null;
                Sprinklers correspondingSprinkler = null;
                for (SmokeDetector smokeDetector : house.getListOfSmokeDetectors())
                    if (smokeDetector.getRoom() == room){
                        correspondingSmokeDetector = smokeDetector;
                        break;
                    }
                for (Sprinklers sprinkler : house.getListOfSprinklers())
                    if (sprinkler.getRoom() == room){
                        correspondingSprinkler = sprinkler;
                        break;
                    }
                correspondingSmokeDetector.simulateFire(room);
                correspondingSprinkler.listenToSmokeDetector(correspondingSmokeDetector);


                break;
            case 3:
                movementDetector.simulateYardMovement(movementDetector);
                noisyAlarm.checkAlarmStatus();
                break;
            case 4:
                startMenu(scanner);
                break;
            case 5:
                break;
        }



    }


}
