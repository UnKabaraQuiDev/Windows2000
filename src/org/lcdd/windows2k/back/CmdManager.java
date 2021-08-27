package org.lcdd.windows2k.back;

import java.util.*;
import java.io.*;

public class CmdManager {

    private HashMap<String,String> randomCommands = new HashMap<>();
    private List<String> command = Arrays.asList("dir","cd","help","echo");
    public File activeDirectory = new File(System.getProperty("user.home"));

    public CmdManager(){
        randomizeCommands();
    }

    public String executeCommand(String command, String argument){
        if(randomCommands.containsKey(command)) {
            String cmd = randomCommands.get(command);
            switch (cmd){
                case "dir":
                    ArrayList<String> ret = new ArrayList<>();
                    for(File f : activeDirectory.listFiles()){
                        if(f.isDirectory()){
                            ret.add(f.getName() + "    <DIR>");
                        }else{
                            ret.add(f.getName());
                        }
                    }
                    return ret.toString().replace('[',' ').replace(']',' ').replaceAll(",","\n");
                case "echo":
                    return argument;
                case "help":
                    return "Commands:\n dir: Displays the list of files and subdirectories of a directory.\necho: print the argument.\ncd: go to a subdirectory.";
                case "cd":
                    File newActive = new File(activeDirectory.getAbsolutePath()+File.separator+argument);
                    if(newActive.exists()){
                        activeDirectory = newActive;
                        return "";
                    }else{
                        return "This directory doesn't exist";
                    }
                default:
                    return "This command doesn't exist";

            }
        }else{
            return "Command not found";
        }
    }

    private void randomizeCommands(){
        Random r = new Random();
        int random = r.nextInt(4-1)+1;

        System.out.println(random);
        for(int i = 0; i < command.size(); i++){
            int add = random+i;
            System.out.println("r+i "+(random+i));
            if(random+i >4){
                add = random+i-4;
            }
            System.out.println(add);
            randomCommands.put(command.get(add-1), command.get(i));
        }
    }
}
