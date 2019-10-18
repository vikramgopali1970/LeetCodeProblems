package LeetProblem;

import java.util.*;

public class AmazonFullTime {

    public static void main(String[] args) {
        AmazonFullTime aft = new AmazonFullTime();
//        Scanner sc = new Scanner(System.in);
//        List<List<Integer>> a = new ArrayList<>();
//        List<List<Integer>> b = new ArrayList<>();
//        int an = sc.nextInt();
//        int bn = sc.nextInt();
//        for(int i=0;i<an;i++){
//            List<Integer> temp = new ArrayList<Integer>();
//            int num1 = sc.nextInt();
//            int num2 = sc.nextInt();
//            temp.add(num1);
//            temp.add(num2);
//            a.add(temp);
//        }
//        for(int i=0;i<bn;i++){
//            List<Integer> temp = new ArrayList<Integer>();
//            int num1 = sc.nextInt();
//            int num2 = sc.nextInt();4
//            temp.add(num1);
//            temp.add(num2);
//            b.add(temp);
//        }
//        int target = sc.nextInt();
//        aft.optimalUtilization(a,b,target);

//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
//        aft.MinCosttoConnectRopes(arr);


//        aft.treasureIsland(new char[][]{{'O','O','O','O'},{'D','O','D','O'},{'O','O','O','O'},{'X','D','D','O'}});


//        aft.treasureIslandII(new char[][]{{'S','O','O','S','S'},{'D','O','D','O','D'},{'O','O','O','O','X'},{'X','D','D','O','O'},{'X','D','D','D','O'}});

//        aft.PairSum(new int[]{1, 10, 25, 35, 60},90);
//        aft.PairSum(new int[]{20, 50, 40, 25, 30, 10},90);


//        String[] names = new String[]{"David","Emma"};
//        String[][] songs = new String[][]{{"song1", "song2", "song3", "song4", "song8"},{"song5", "song6", "song7"}};
//        String[][] songs = new String[][]{{"song1", "song2"},{"song3", "song4"}};
//        String[] genres = new String[]{"Rock","Dubstep","Techno","Pop","Jazz"};
//        String[] genres = new String[]{};
//        String[][] gsongs = new String[][]{{"song1", "song3"},{"song7"},{"song2", "song4"},{"song5", "song6"},{"song8", "song9"}};
//        Map<String,List<String>> userSongs = new HashMap<>();
//        for(int i=0;i<names.length;i++){
//            List<String> sarr = new ArrayList<>();
//            for(int j=0;j<songs[i].length;j++){
//                sarr.add(songs[i][j]);
//            }
//            userSongs.put(names[i],sarr);
//        }
//        Map<String,List<String>> songGenres = new HashMap<>();
//        for(int i=0;i<genres.length;i++){
//            List<String> sarr = new ArrayList<>();
//            for(int j=0;j<gsongs[i].length;j++){
//                sarr.add(gsongs[i][j]);
//            }
//            songGenres.put(genres[i],sarr);
//        }
//        aft.favouriteGenre(userSongs,songGenres);

//        aft.twoSumUnique(new int[]{1,1,2,45,46,46},47);
//        aft.twoSumUnique(new int[]{1,5,1,5},6);
    }


    public PairInt locationOfTargetValue(int rowCount, int columnCount, List<List<Integer>> matrix, int targetValue){
        int row = 0,col = columnCount-1;
        while(row >= 0 && col >= 0){
            if(matrix.get(row).get(col) == targetValue){
                return new PairInt(row,col);
            }else if(matrix.get(row).get(col) > targetValue){
                row--;
            }else{
                col++;
            }
        }
        return new PairInt(-1,-1);
    }

    class Graph {
        private int V;
        private LinkedList<Integer> adj[];
        int time = 0;
        List<PairInt> result;

        Graph(int v) {
            this.result = new ArrayList<PairInt>();
            this.V = v;
            this.adj = new LinkedList[v];
            for (int i=0; i<v; ++i){
                this.adj[i] = new LinkedList();
            }
        }

        void addEdge(int v, int w) {
            this.adj[v].add(w);
            this.adj[w].add(v);
        }

        void getConnectionHelper(int u, boolean visited[], int disc[], int low[], int parent[]) {
            visited[u] = true;
            disc[u] = low[u] = ++this.time;
            Iterator<Integer> i = this.adj[u].iterator();
            while (i.hasNext()){
                int v = i.next();
                if (!visited[v]){
                    parent[v] = u;
                    this.getConnectionHelper(v, visited, disc, low, parent);
                    low[u]  = Math.min(low[u], low[v]);
                    if (low[v] > disc[u]){
                        this.result.add(new PairInt((u+1),(v+1)));
                    }
                }else if (v != parent[u])
                    low[u]  = Math.min(low[u], disc[v]);
            }
        }

        List<PairInt> getCriticalConnection() {
            boolean visited[] = new boolean[this.V];
            int disc[] = new int[this.V];
            int low[] = new int[this.V];
            int parent[] = new int[this.V];

            for (int i = 0; i < this.V; i++) {
                parent[i] = -1;
                visited[i] = false;
            }

            for (int i = 0; i < V; i++){
                if (visited[i] == false){
                    this.getConnectionHelper(i, visited, disc, low, parent);
                }
            }
            return this.result;
        }
    }


    List<PairInt> criticalConnections(int numOfWarehouses, int numOfRoads, List<PairInt> roads){
        Graph g = new Graph(numOfWarehouses);
        for(PairInt edge : roads){
            g.addEdge(edge.first-1,edge.second-1);
        }
        g.getCriticalConnection();
        return g.result;
    }

    public class Node{
        int val;
        int ind;

        public Node(int val, int ind){
            this.val = val;
            this.ind = ind;
        }
    }

    public ArrayList<Integer> movie(ArrayList<Integer> movieDuration, int flightDuration){
        ArrayList<Node> m = new ArrayList<Node>();
        for(int i=0;i<movieDuration.size();i++){
            m.add(new Node(movieDuration.get(i),i));
        }
        Collections.sort(m, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.val,o2.val);
            }
        });
        int l = 0,h=m.size()-1;
        int i=-1,j=-1,maxx = Integer.MIN_VALUE;
        while(l<h){
            System.out.println("here "+(m.get(l).val + m.get(h).val)+" "+(flightDuration-30));
            if((m.get(l).val + m.get(h).val) <= (flightDuration-30)){
                if(maxx < (m.get(l).val + m.get(h).val)){
                    maxx = (m.get(l).val + m.get(h).val);
                    i=m.get(l).ind;
                    j=m.get(h).ind;
                }
                l++;
            }else{
                h--;
            }
        }
        System.out.println(i+" "+j);
        return null;
    }

    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letterlogs = new ArrayList<String>();
        ArrayList<String> digitlogs = new ArrayList<String>();
        for(int i=0;i<logs.length;i++){
            if(logs[i].split(" ")[1].charAt(0) >= '0' && logs[i].split(" ")[1].charAt(0) <= '9'){
                digitlogs.add(logs[i]);
            }else{
                letterlogs.add(logs[i]);
            }
        }
        Collections.sort(letterlogs,new Comparator<String>(){
            public int compare(String s1, String s2){
                String s11  = s1.split(" ")[0];
                String s22  = s2.split(" ")[0];
                if((s1.substring(s11.length())).equals(s2.substring(s22.length()))){
                    return (s11.compareTo(s22));
                }else{
                    return (s1.substring(s11.length())).compareTo(s2.substring(s22.length()));
                }

            }
        });
        String[] res = new String[logs.length];
        int ind=0;
        for(int i=0;i<letterlogs.size();i++){
            res[ind++] = letterlogs.get(i);
        }
        for(int i=0;i<digitlogs.size();i++){
            res[ind++] = digitlogs.get(i);
        }
        return res;
    }


    public void optimalUtilization(List<List<Integer>> a, List<List<Integer>> b, int target){
        TreeMap<Integer,List<List<Integer>>> res = new TreeMap<Integer, List<List<Integer>>>();
        Collections.sort(a, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(1) == o2.get(1)){
                    return Integer.compare(o1.get(0),o2.get(0));
                }else{
                    return Integer.compare(o1.get(1),o2.get(1));
                }

            }
        });
        Collections.sort(b, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(1) == o2.get(1)){
                    return Integer.compare(o1.get(0),o2.get(0));
                }else{
                    return Integer.compare(o1.get(1),o2.get(1));
                }

            }
        });
        int i=0,j=b.size()-1;
        while(i<a.size() && j>=0){
            int sum = a.get(i).get(1)+b.get(j).get(1);
            System.out.println(sum);
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(a.get(i).get(0));
            temp.add(b.get(j).get(0));
            List<List<Integer>> val = res.getOrDefault(sum, new ArrayList<List<Integer>>());
            val.add(temp);
            res.put(sum,val);
            if(sum == target){
                i++;
                j--;
            }else if(sum > target){
                j--;
            }else{
                i++;
            }
        }
        System.out.println(res);
        if(res.containsKey(target)){
            System.out.println(res.get(target));
        }else{
            System.out.println(res.get(res.floorKey(target)));
        }
    }

    public void MinCosttoConnectRopes(int[] ropes){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<ropes.length;i++){
            pq.offer(ropes[i]);
        }
        int sum = 0;
        while(pq.size() > 1){
            int min1 = pq.poll();
            int min2 = pq.poll();
            sum += min1+min2;
            pq.offer(min1+min2);
        }
        System.out.println((sum));
    }

    public class Coord{
        int x,y,dist;

        public Coord(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public void treasureIsland(char[][] island){
        Queue<Coord> q = new LinkedList<Coord>();
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        boolean[][] visited = new boolean[island.length][island[0].length];
        q.offer(new Coord(0,0,0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Coord cod = q.poll();
            for(int i=0;i<4;i++){
                int newX = cod.x+dx[i];
                int newY = cod.y+dy[i];
                int newD = cod.dist+1;
                if(newX >=0 && newX<island.length && newY >= 0 && newY<island[0].length && !visited[newX][newY] && island[newX][newY] != 'D'){
                    visited[newX][newY] = true;
                    if(island[newX][newY] == 'X'){
                        System.out.println(newD);
                        q.clear();
                        break;
                    }
                    q.offer(new Coord(newX,newY,newD));
                }
            }
        }
    }

    public void treasureIslandII(char[][] island){
        Queue<Coord> q = new LinkedList<Coord>();
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int[][] dist = new int[island.length][island[0].length];
        boolean[][] visited = new boolean[island.length][island[0].length];
        for(int i=0;i<dist.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<island.length;i++){
            for(int j=0;j<island[0].length;j++){
                if(island[i][j] == 'S'){
                    q.offer(new Coord(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Coord cod = q.poll();
            if(island[cod.x][cod.y] == 'X'){
                dist[cod.x][cod.y] = Math.min(dist[cod.x][cod.y],cod.dist);
            }
            for(int i=0;i<4;i++){
                int x = cod.x+dx[i];
                int y = cod.y+dy[i];
                int d = cod.dist+1;
                if(x>=0 && x < island.length && y >= 0 && y < island[0].length && !visited[x][y] && island[x][y] != 'D'){
                    visited[x][y] = true;
                    q.offer(new Coord(x,y,d));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[0].length;j++){
                res = Math.min(res,dist[i][j]);
            }
        }
        System.out.println(res);
    }


    public void PairSum(int[] nums, int target){
        Node[] nodes = new Node[nums.length];
        for(int i=0;i<nums.length;i++){
            nodes[i] = new Node(nums[i],i);
        }
        Arrays.sort(nodes, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return Integer.compare(n1.val,n2.val);
            }
        });
        int i=0,j=nodes.length-1;
        while(i<j){
            if(nodes[i].val + nodes[j].val == target-30){
                System.out.println("("+nodes[i].ind+","+nodes[j].ind+")");
                break;
            }else if(nodes[i].val + nodes[j].val < target-30){
                i++;
            }else{
                j--;
            }
        }
    }

    public void favouriteGenre(Map<String,List<String>> userSongs, Map<String,List<String>> songGenres){
        HashMap<String,String> songToGenre = new HashMap<String,String>();
        for(String genre : songGenres.keySet()){
            for(String song : songGenres.get(genre)){
                songToGenre.put(song,genre);
            }
        }
        HashMap<String,List<String>> res = new HashMap<String,List<String>>();
        HashMap<String,HashMap<String,Integer>> temp = new HashMap<String,HashMap<String,Integer>>();
        for(String name : userSongs.keySet()){
            HashMap<String,Integer> freq = new HashMap<>();
            for(String song : userSongs.get(name)){
                if(songToGenre.containsKey(song)){
                    int count = freq.getOrDefault(songToGenre.get(song),0);
                    freq.put(songToGenre.get(song),count+1);
                }
            }
            temp.put(name,freq);
        }
        for(String name : temp.keySet()){
            int max = Integer.MIN_VALUE;
            for(String genre : temp.get(name).keySet()){
                max = Math.max(max,temp.get(name).get(genre));
            }
            List<String> resarr = new ArrayList<String>();
            for(String genre : temp.get(name).keySet()){
                if(temp.get(name).get(genre) == max){
                    resarr.add(genre);
                }
            }
            res.put(name,resarr);
        }
        System.out.println(res);
    }


    public void twoSumUnique(int[] nums, int target){
        /*
        * Method 1 (sort-O(nlogn))
        * */
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        int s=0,e=nums.length-1;
        while(s < e){
            if(nums[s]+nums[e] == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[s]);
                temp.add(nums[e]);
                res.add(temp);
                s++;
                e--;
            }else if(nums[s]+nums[e] < target){
                s++;
            }else{
                e--;
            }
        }
        System.out.println(res+" "+res.size());


        /*
         * Method 2 (HashMap-O(n))
         * */
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int count = map.getOrDefault(nums[i],0);
            map.put(nums[i],count+1);
        }
        res = new HashSet<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){
                int count = map.get(diff);
                count--;
                if(count == 0){
                    map.remove(diff);
                }
                count = map.get(nums[i]);
                count--;
                if(count == 0){
                    map.remove(nums[i]);
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(Math.min(nums[i],diff));
                temp.add(Math.max(nums[i],diff));
                res.add(temp);
            }
        }
        System.out.println(res+" "+res.size());
    }

}


/*

optimalUtilization

3 1
1 2 2 4 3 6
1 2
7

4 4
1 3 2 5 3 7 4 10
1 2 2 3 3 4 4 5
10

3 3
1 8 2 7 3 14
1 5 2 10 3 14
20


3 3
1 8 2 15 3 9
1 8 2 11 3 12
20



MinCosttoConnectRopes

4
8 4 6 12

4
20 4 8 2

6
1 2 5 10 35 89

4
2 2 3 3
 */