import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");  //factory method
        LocalTime alarmTime = null;
        String filePath = "Ayatul Kursi Full - Omar Hisham Alarabi.wav";

        while(alarmTime==null){
            try{
                System.out.print("Enter an alarm time(HH:MM:SS): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Your alarm is set for " + alarmTime);
            } catch(DateTimeParseException e){
                System.out.println("Invalid format. Please use HH:MM:SS");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}
