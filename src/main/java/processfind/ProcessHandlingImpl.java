package processfind;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.*;
import static org.assertj.core.api.Assertions.*;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessHandlingImpl implements ProcessHandling{

    public int getProcessIdFromMaple() {
        return getProcessIdFromMaple1();
    }

    private static int getProcessIdFromMaple1() {
        String cuttedText = "";
        try {
            String line;
            List<String> processList = new ArrayList();
            //get processes from taskmanager
            Process p = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            //search for MapleRoyals.exe process
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                if (line.contains("MapleRoyals.exe")){
                        processList.add(line);
                    break;
                    }
            }
            //process not found notice
            if (processList.isEmpty()){
                System.out.println("================================");
                System.out.println("MapleRoyals process not found!");
                System.exit(1);
            }
            //do some magic with Strings to cut PID (processId)
            System.out.println("================================");
            System.out.println("This is the single process line: " + processList);
            cuttedText = StringUtils.deleteWhitespace(processList.get(0));
            cuttedText = substringBefore(cuttedText, "C");
            cuttedText = substringAfter(cuttedText, ".exe");
            System.out.println("This is the process Id of MapleRoyals: " + cuttedText);
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        //parse processId String to int
        String numberString = cuttedText;
        int numberInt = Integer.parseInt(numberString);

    return numberInt;
    }



}
