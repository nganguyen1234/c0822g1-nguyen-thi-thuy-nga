//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//class LionDescription {
//    public String name;
//    public int height;
//}
//
//class LionSchedule {
//    public String name;
//    public int enterTime;
//    public int exitTime;
//}
//
//class LionCompetition {
//    private List<LionDescription> lions= new ArrayList<>();
//    private List<LionSchedule> schedule  = new ArrayList<>();
//    private List<String> lionInspect = new ArrayList<>();
//    public LionCompetition(List<LionDescription> lions, List<LionSchedule> schedule) {
//        /* Enter your code here. */
//        this.lions = lions;
//        this.schedule = schedule;
//    }
//
//    public void lionEntered(int currentTime, int height) {
//        String nameBaseSchedule = "";
//        /* Enter your code here. */
//        for (LionSchedule s:schedule          ) {
//            if (s.enterTime==currentTime){
//                nameBaseSchedule = s.name;
//            }
//        }
//        if (nameBaseSchedule == ""){
//            return;
//        }
//String nameBaseHeight ="";
//        for (LionDescription lion: lions) {
//            if (lion.height==height){
//                nameBaseHeight = lion.name;
//            }
//        }
//        if (nameBaseHeight==""){
//            return;
//        }
//        if (nameBaseHeight==nameBaseSchedule){
//         lionInspect.add(nameBaseSchedule);
//        }
//    }
//
//    public void lionLeft(int currentTime, int height) {
//        /* Enter your code here. */
//    }
//
//    public List<String> getBiggestLions()
//    {
//        /* Enter your code here. */
//        return new ArrayList<String>();
//        String max = lionInspect.get(0);
//        for (String name: lionInspect) {
//
//        }
//    }
//}
//
//public class Solution {
//    public static void main(String args[]) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        String operation;
//
//        List<LionDescription> descriptions = new ArrayList<LionDescription>();
//        List<LionSchedule> schedule = new ArrayList<LionSchedule>();
//
//        do
//        {
//            operation = scanner.next();
//
//            if (operation.equals("definition"))
//            {
//                LionDescription description = new LionDescription();
//                description.name = scanner.next();
//                description.height = scanner.nextInt();
//
//                descriptions.add(description);
//            }
//            if (operation.equals("schedule"))
//            {
//                LionSchedule scheduleEntry = new LionSchedule();
//                scheduleEntry.name = scanner.next();
//                scheduleEntry.enterTime = scanner.nextInt();
//                scheduleEntry.exitTime = scanner.nextInt();
//
//                schedule.add(scheduleEntry);
//            }
//        } while (!operation.equals("start"));
//
//        LionCompetition lionCompetition = new LionCompetition(descriptions, schedule);
//
//        do
//        {
//            int currentTime = scanner.nextInt();
//            operation = scanner.next();
//
//            if (operation.equals("enter"))
//            {
//                int size = scanner.nextInt();
//
//                lionCompetition.lionEntered(currentTime, size);
//            }
//            if (operation.equals("exit"))
//            {
//                int size = scanner.nextInt();
//
//                lionCompetition.lionLeft(currentTime, size);
//            }
//            if (operation.equals("inspect"))
//            {
//                List<String> lions = lionCompetition.getBiggestLions();
//
//                System.out.print(lions.size());
//
//                for (String name : lions) {
//                    System.out.print(" " + name);
//                }
//
//                System.out.println();
//            }
//        } while (!operation.equals("end"));
//    }
//}
