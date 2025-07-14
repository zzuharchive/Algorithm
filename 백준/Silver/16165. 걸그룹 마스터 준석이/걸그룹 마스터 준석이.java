import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Set<String>> groupMap = new HashMap<>();
        Map<String, List<String>> mapForPrint = new HashMap<>();
        int n = input.nextInt();
        int m = input.nextInt();

        for (int i = 0; i < n; i++) {
            String groupName = input.next();
            Set<String> groupSet = new HashSet<>();
            List<String> groupList = new ArrayList<>();
            int memberCount = input.nextInt();
            for (int j = 0; j < memberCount; j++) {
                String memberName = input.next();
                groupSet.add(memberName);
                groupList.add(memberName);
            }
            groupMap.put(groupName, groupSet);
            groupList.sort(null);
            mapForPrint.put(groupName, groupList);
        }

        for (int i = 0; i < m; i++) {
            String question = input.next();
            int type = input.nextInt();

            switch (type) {
                case 0:
                    for (String memberName : mapForPrint.get(question)) {
                        System.out.println(memberName);
                    }
                    break;

                case 1:
                    for (String groupName : groupMap.keySet()) {
                        if (groupMap.get(groupName).contains(question)) {
                            System.out.println(groupName);
                        }
                    }
                    break;
            }
        }
    }
}
