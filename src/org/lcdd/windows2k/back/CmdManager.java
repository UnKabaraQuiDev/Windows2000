package org.lcdd.windows2k.back;

import java.io.File;
import java.util.*;

public class CmdManager {

    private HashMap<String, String> randomCommands = new HashMap<>();
    private List<String> command = Arrays.asList("dir", "cd", "help", "echo");
    public File activeDirectory = new File(System.getProperty("user.home"));

    public CmdManager() {
        randomizeCommands();
    }

    public String executeCommand(String command, String argument) {
        if (randomCommands.containsKey(command)) {
            String cmd = randomCommands.get(command);
            System.out.println(command + "\n" + argument);
            switch (cmd) {
                case "dir":
                    ArrayList<String> ret = new ArrayList<>();
                    for (File f : activeDirectory.listFiles()) {
                        if (f.isDirectory()) {
                            ret.add(f.getName() + "    <DIR>");
                        } else {
                            ret.add(f.getName());
                        }
                    }
                    return command + " " + argument + "\n" + ret.toString().replace('[', ' ').replace(']', ' ').replaceAll(",", "\n");
                case "echo":
                    return command + " " + argument + "\n" + argument;
                case "help":
                    return command + "\nCommands:\n dir: Displays the list of files and subdirectories of a directory.\necho: print the argument.\ncd: go to a subdirectory.";
                case "cd":
                    if (argument.equals("..")) {
                        activeDirectory = activeDirectory.getParentFile();
                        return command+" "+argument;
                    } else {
                        File newActive = new File(activeDirectory.getAbsolutePath() + File.separator + argument);
                        if (newActive.exists() && newActive.isDirectory()) {
                            activeDirectory = newActive;
                            return command + " " + argument;
                        } else {
                            return command + " " + argument + "\nThis directory doesn't exist";
                        }
                    }
                default:
                    return "This command doesn't exist";

            }
        } else {
            return "Command not found";
        }
    }

    private void randomizeCommands() {
        Random r = new Random();
        int random = r.nextInt(4 - 1) + 1;

        System.out.println(random);
        for (int i = 0; i < command.size(); i++) {
            int add = random + i;
            System.out.println("r+i " + (random + i));
            if (random + i > 4) {
                add = random + i - 4;
            }
            System.out.println(add);
            randomCommands.put(command.get(add - 1), command.get(i));
        }
    }
}
