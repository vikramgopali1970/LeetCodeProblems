package LeetProblem;

import java.util.*;

public class TeamSortEargo {

    public static void main(String[] args) {

    }

    public static class Node{
        String pname;
        String sname;
        String event;
        int time;
        int extra_time;
        String team;

        public Node(String pname1, String sname1, String event1, String team1, int time1, int extra_time1){
            pname = pname1;
            sname = sname1;
            event = event1;
            team = team1;
            time=time1;
            extra_time = extra_time1;
        }
    }

    private static void parseEvents(List<String> events, Node[] teams, String team,int gInd){
        for(int i=0;i<events.size();i++){
            String e = events.get(i);
            int ind = 0;
            while(e.charAt(ind) < '0' || e.charAt(ind) > '9'){
                ind++;
            }
            String name = e.substring(0,ind).trim();
            String remain = e.substring(ind);
            String[] remains = remain.split(" ");
            String stime = remains[0];
            String[] times = stime.split("\\+");
            int time = 0, extra_time = 0;
            if(times.length > 1){
                time = Integer.parseInt(times[0]);
                extra_time = Integer.parseInt(times[1]);
            }else{
                time = Integer.parseInt(times[0]);
            }
            String event = remains[1];
            StringBuilder sb = new StringBuilder();
            for(int j=2;j<remains.length;j++){
                sb.append(remains[j]+" ");
            }
            if(sb.length() > 0){
                sb.setLength(sb.length()-1);
            }
            String sname = sb.toString().trim();
            teams[gInd++] = new Node(name, sname, event, team, time,extra_time);
        }
    }

    public static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        // Write your code here
        Map<String, Integer> esort = new HashMap<String, Integer>();
        esort.put("G",0);
        esort.put("Y",1);
        esort.put("R",2);
        esort.put("S",3);
        Node[] t = new Node[events1.size()+events2.size()];
        parseEvents(events1, t, team1,0);
        parseEvents(events2, t, team2, events1.size());
        Arrays.sort(t, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if(n1.time == n2.time){
                    if(n1.extra_time == n2.extra_time){
                        if(esort.get(n1.event) == esort.get(n2.event)){
                            if(n1.team.equals(n2.team)){
                                return n1.pname.compareTo(n2.pname);
                            }else{
                                return n1.team.compareTo(n2.team);
                            }
                        }else{
                            return Integer.compare(esort.get(n1.event), esort.get(n2.event));
                        }
                    }else{
                        return Integer.compare(n1.extra_time, n2.extra_time);
                    }
                }else{
                    return Integer.compare(n1.time, n2.time);
                }
            }
        });
        List<String> res = new ArrayList<String>();
        for(int i=0;i<t.length;i++){
            StringBuilder sb1 = new StringBuilder();
            Node n = t[i];
            sb1.append(n.team+" ");
            sb1.append(n.pname+" ");
            sb1.append(n.time);
            if(n.extra_time > 0){
                sb1.append("+"+n.extra_time);
            }
            sb1.append(" ");
            sb1.append(n.event);
            if(n.sname.trim().length()>0){
                sb1.append(" "+n.sname);
            }
            res.add(sb1.toString());
        }
        return res;
    }
}
