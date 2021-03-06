/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floodit;

/**
 *
 * @author RaghadSalem
 */
public class FloodIt {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    static int bfsCount = 0;
    static int AsCount = 0;
    static int dfsCount = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 9;
        int[][] grid = new int[n][n];

        //  Blue    Pink    YELLOW   Yellow   Purple
        //    2       5       1        4       3
        /*
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 3;
        grid[0][3] = 2;
        grid[0][4] = 2;
        
        grid[1][0] = 1;   
        grid[1][1] = 2;     
        grid[1][2] = 3;
        grid[1][3] = 2;
        grid[1][4] = 2;
        
        grid[2][0] = 3;        
        grid[2][1] = 2;        
        grid[2][2] = 2;       
        grid[2][3] = 1;       
        grid[2][4] = 2;

        grid[3][0] = 1;       
        grid[3][1] = 3;        
        grid[3][2] = 3;        
        grid[3][3] = 2; 
        grid[3][4] = 1;
        
        grid[4][0] = 2;
        grid[4][1] = 2;
        grid[4][2] = 3;
        grid[4][3] = 2;
        grid[4][4] = 2;
        
        
        Obj[][] grid2 = new Obj[n][n];
        
        grid2[0][0] = new Obj(1);
        grid2[0][1] = new Obj(2);
        grid2[0][2] = new Obj(3);
        grid2[0][3] = new Obj(4);
        
        grid2[1][0] = new Obj(5);
        grid2[1][1] = new Obj(4); 
        grid2[1][2] = new Obj(1);
        grid2[1][3] = new Obj(5);
                
        grid2[2][0] = new Obj(3);      
        grid2[2][1] = new Obj(3);       
        grid2[2][2] = new Obj(1);   
        grid2[2][3] = new Obj(5);     


        grid2[3][0] = new Obj(2);       
        grid2[3][1] = new Obj(4);     
        grid2[3][2] = new Obj(2);      
        grid2[3][3] = new Obj(2);*/
        int c;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c = (int) (Math.random() * 100);
                if (c >= 0 && c < 35) {
                    grid[i][j] = 1;
                } else if (c >= 35 && c < 70) {
                    grid[i][j] = 2;
                } else // (c>=40 && c < 60){
                {
                    grid[i][j] = 3;
                }
                /*}
                else if (c>=60 && c< 80){
                    grid[i][j] = 4;
                }
                else if (c>=80 && c< 100){
                    grid[i][j] = 5;
                }*/
            }
        }

        Queue que = new Queue();
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        boolean[][] adj = new boolean[n][n];
        adj[0][1] = true;
        adj[1][0] = true;

        returned r = checkAdj(grid, adj, visited, n, grid[0][0], 0, 0);
        que.insert(r.getGrid(), r.getAdj(), r.getVisited(), 0, r.getDone(), 0);

        //----------------------------------  
        int[][] grid2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid2[i][j] = grid[i][j];
            }
        }

        PQueue que2 = new PQueue();
        boolean[][] visited2 = new boolean[n][n];
        visited2[0][0] = true;
        boolean[][] adj2 = new boolean[n][n];
        adj2[0][1] = true;
        adj2[1][0] = true;

        returned r2 = checkAdj(grid2, adj2, visited2, n, grid2[0][0], 0, 0);
        int h = (n * n) - r2.getDone();

        que2.insert(r2.getGrid(), r2.getAdj(), r2.getVisited(), 0, r2.getDone(), h, 0);
        //----------------------------------
        int[][] grid3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid3[i][j] = grid[i][j];
            }
        }

        Queue que3 = new Queue();
        boolean[][] visited3 = new boolean[n][n];
        visited3[0][0] = true;
        boolean[][] adj3 = new boolean[n][n];
        adj3[0][1] = true;
        adj3[1][0] = true;

        returned r3 = checkAdj(grid, adj, visited, n, grid[0][0], 0, 0);
        que3.insert(r3.getGrid(), r3.getAdj(), r3.getVisited(), 0, r3.getDone(), 0);

        System.out.println("Problem Grid:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switch (r.getGrid()[i][j]) {
                    case 1:
                        System.out.print(ANSI_YELLOW + "■ " + ANSI_YELLOW);
                        break;
                    case 2:
                        System.out.print(ANSI_CYAN + "■ " + ANSI_CYAN);
                        break;
                    case 3:
                        System.out.print(ANSI_PURPLE + "■ " + ANSI_PURPLE);
                        break;
                    //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                    //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                }
            }
            System.out.println("");
        }
        System.out.println("");

        long then = System.currentTimeMillis();

        LNode noFinal = AStar(que2, n, 0);
        System.out.println("number of dequeues: " + AsCount + "\n");

        long duration = System.currentTimeMillis() - then;
        System.out.println("Call took " + duration + " milliseconds.");

        LNode nodeFinal = BFS(que, n, 0);
        System.out.println("number of dequeues: " + bfsCount + "\n");
        //LNode nFinal = DFS(que3, n, 0);
        //System.out.println("number of dequeues: "+dfsCount+"\n");
    }

    public static LNode AStar(PQueue que, int n, int l) {
        LNode node = que.dequeue();
        AsCount++;

        // code to see the steps
        /*System.out.println("level: "+AsCount);
        for  (int f = 0 ; f<n ; f++)
                {
                    for (int r = 0 ; r<n ; r++)
                    {
                        switch (node.getGrid()[f][r]){
                            case 1: System.out.print(ANSI_YELLOW+"■ "+ANSI_YELLOW); break;
                            case 2: System.out.print(ANSI_CYAN+"■ "+ANSI_CYAN); break;
                            case 3: System.out.print(ANSI_PURPLE+"■ "+ANSI_PURPLE); break;
                           //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                            //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                        }
                    }
                    System.out.println("");
                }
        System.out.println("");*/
        returned re = new returned();
        int[][] grid = new int[n][n];
        boolean[][] adj = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        int done = node.getDone();
        int times = node.getTimes();

        returned re2 = new returned();
        int[][] grid2 = new int[n][n];
        boolean[][] adj2 = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];
        int done2 = node.getDone();
        int times2 = node.getTimes();

        returned re3 = new returned();
        int[][] grid3 = new int[n][n];
        boolean[][] adj3 = new boolean[n][n];
        boolean[][] visited3 = new boolean[n][n];
        int done3 = node.getDone();
        int times3 = node.getTimes();

        // use when having more than 3 colors
        /*returned re4 = new returned();
        int[][] grid4 = new int[n][n];
        boolean[][] adj4 = new boolean[n][n];
        boolean[][] visited4 = new boolean[n][n];
        int done4 = node.getDone();
        int times4 = node.getTimes();

        returned re5 = new returned();
        int[][] grid5 = new int[n][n];
        boolean[][] adj5 = new boolean[n][n];
        boolean[][] visited5 = new boolean[n][n];
        int done5 = node.getDone();
        int times5 = node.getTimes();*/
        boolean yess = true;
        one:
        for (int f = 0; f < n; f++) {
            for (int r = 0; r < n; r++) {
                if (!node.getVisited()[f][r]) {
                    yess = false;
                    break one;
                }

            }
        }
        if (yess) {
            System.out.println("Solved grid using A*:");
            for (int f = 0; f < n; f++) {
                for (int r = 0; r < n; r++) {
                    switch (node.getGrid()[f][r]) {
                        case 1:
                            System.out.print(ANSI_YELLOW + "■ " + ANSI_YELLOW);
                            break;
                        case 2:
                            System.out.print(ANSI_CYAN + "■ " + ANSI_CYAN);
                            break;
                        case 3:
                            System.out.print(ANSI_PURPLE + "■ " + ANSI_PURPLE);
                            break;
                        //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                        //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                        }
                }
                System.out.println("");
            }
            System.out.println("Color changed " + node.getTimes() + " times.");
            //System.out.println("Tree level: " + node.getLevel());

            return node;
        } else {

            if (done != (n * n)) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid[i][j] = node.getGrid()[i][j];
                        adj[i][j] = node.getAdj()[i][j];
                        visited[i][j] = node.getVisited()[i][j];

                    }
                }
                re = changeColor(grid, adj, visited, n, 1, que, (node.getLevel() + 1), done, times);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid2[i][j] = node.getGrid()[i][j];
                        adj2[i][j] = node.getAdj()[i][j];
                        visited2[i][j] = node.getVisited()[i][j];
                    }
                }

                re2 = changeColor(grid2, adj2, visited2, n, 2, que, (node.getLevel() + 1), done2, times2);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid3[i][j] = node.getGrid()[i][j];
                        adj3[i][j] = node.getAdj()[i][j];
                        visited3[i][j] = node.getVisited()[i][j];

                    }
                }
                re3 = changeColor(grid3, adj3, visited3, n, 3, que, (node.getLevel() + 1), done3, times3);

                /*for  (int i = 0 ; i<n ; i++)
                    for (int j = 0 ; j<n ; j++)
                    {
                        grid4[i][j] = node.getGrid()[i][j];
                        adj4[i][j] = node.getAdj()[i][j];
                        visited4[i][j] = node.getVisited()[i][j];
                        
                    } 
                re4 = changeColor(grid4, adj4, visited4, n, 4, que, l, done, times4);
                //System.out.println("done4"+done4);
                for  (int i = 0 ; i<n ; i++)
                    for (int j = 0 ; j<n ; j++)
                    {
                        grid5[i][j] = node.getGrid()[i][j];
                        adj5[i][j] = node.getAdj()[i][j];
                        visited5[i][j] = node.getVisited()[i][j];
                        
                    }  
                re5 = changeColor(grid5, adj5, visited5, n, 5, que, l, done, times5);  */
                AStar(que, n, l);
            } else {
                return node;
            }
            return node;
        }

    }

    public static LNode BFS(Queue que, int n, int l) {
        LNode node = que.dequeue();
        bfsCount++;

        // to see steps
        /*for  (int f = 0 ; f<n ; f++)
                {
                    for (int r = 0 ; r<n ; r++)
                    {
                         switch (node.getGrid()[f][r]){
                            case 1: System.out.print(ANSI_YELLOW+"■ "+ANSI_YELLOW); break;
                            case 2: System.out.print(ANSI_CYAN+"■ "+ANSI_CYAN); break;
                            case 3: System.out.print(ANSI_PURPLE+"■ "+ANSI_PURPLE); break;
                            //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                            //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                        }
                    }
                    System.out.println("");
                }
                System.out.println("level: "+node.getLevel());*/
        returned re = new returned();
        int[][] grid = new int[n][n];
        boolean[][] adj = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        int done = node.getDone();
        int times = node.getTimes();

        returned re2 = new returned();
        int[][] grid2 = new int[n][n];
        boolean[][] adj2 = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];
        int done2 = node.getDone();
        int times2 = node.getTimes();

        returned re3 = new returned();
        int[][] grid3 = new int[n][n];
        boolean[][] adj3 = new boolean[n][n];
        boolean[][] visited3 = new boolean[n][n];
        int done3 = node.getDone();
        int times3 = node.getTimes();

        // use when having more than 3 colors
        /*returned re4 = new returned();
        int[][] grid4 = new int[n][n];
        boolean[][] adj4 = new boolean[n][n];
        boolean[][] visited4 = new boolean[n][n];
        int done4 = node.getDone();
        int times4 = node.getTimes();

        returned re5 = new returned();
        int[][] grid5 = new int[n][n];
        boolean[][] adj5 = new boolean[n][n];
        boolean[][] visited5 = new boolean[n][n];
        int done5 = node.getDone();
        int times5 = node.getTimes();*/
        boolean yess = true;
        one:
        for (int f = 0; f < n; f++) {
            for (int r = 0; r < n; r++) {
                if (!node.getVisited()[f][r]) {
                    yess = false;
                    break one;
                }

            }
        }
        if (yess) {
            System.out.println("Solved grid using BFS:");
            for (int f = 0; f < n; f++) {
                for (int r = 0; r < n; r++) {
                    switch (node.getGrid()[f][r]) {
                        case 1:
                            System.out.print(ANSI_YELLOW + "■ " + ANSI_YELLOW);
                            break;
                        case 2:
                            System.out.print(ANSI_CYAN + "■ " + ANSI_CYAN);
                            break;
                        case 3:
                            System.out.print(ANSI_PURPLE + "■ " + ANSI_PURPLE);
                            break;
                        //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                        //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                        }
                }
                System.out.println("");
            }
            System.out.println("Color changed " + node.getTimes() + " times.");
            System.out.println("Tree level: " + node.getLevel());

            return node;
        } else {
            //l++;

            if (done != (n * n)) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid[i][j] = node.getGrid()[i][j];
                        adj[i][j] = node.getAdj()[i][j];
                        visited[i][j] = node.getVisited()[i][j];

                    }
                }
                re = changeColor(grid, adj, visited, n, 1, que, (node.getLevel() + 1), done, times);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        grid2[i][j] = node.getGrid()[i][j];
                        adj2[i][j] = node.getAdj()[i][j];
                        visited2[i][j] = node.getVisited()[i][j];

                    }
                }

                re2 = changeColor(grid2, adj2, visited2, n, 2, que, (node.getLevel() + 1), done2, times2);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid3[i][j] = node.getGrid()[i][j];
                        adj3[i][j] = node.getAdj()[i][j];
                        visited3[i][j] = node.getVisited()[i][j];

                    }
                }
                re3 = changeColor(grid3, adj3, visited3, n, 3, que, (node.getLevel() + 1), done3, times3);

                /*for  (int i = 0 ; i<n ; i++)
                    for (int j = 0 ; j<n ; j++)
                    {
                        grid4[i][j] = node.getGrid()[i][j];
                        adj4[i][j] = node.getAdj()[i][j];
                        visited4[i][j] = node.getVisited()[i][j];
                        
                    } 
                re4 = changeColor(grid4, adj4, visited4, n, 4, que, l, done, times4);
                //System.out.println("done4"+done4);
                for  (int i = 0 ; i<n ; i++)
                    for (int j = 0 ; j<n ; j++)
                    {
                        grid5[i][j] = node.getGrid()[i][j];
                        adj5[i][j] = node.getAdj()[i][j];
                        visited5[i][j] = node.getVisited()[i][j];
                        
                    }  
                re5 = changeColor(grid5, adj5, visited5, n, 5, que, l, done, times5);*/
                BFS(que, n, l);
            } else {
                return node;
            }
            return node;
        }

    }

    public static returned changeColor(int[][] grid, boolean[][] adj, boolean[][] visited, int n,
            int color, Queue que, int l, int done, int times) {
        times++;
        returned re = new returned(grid, adj, visited, done, times);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    grid[i][j] = color;

                    re = checkAdj(grid, adj, visited, n, color, done, times);

                    grid = re.getGrid();
                    adj = re.getAdj();
                    visited = re.getVisited();
                    done = re.getDone();
                    times = re.getTimes();

                }

            }
        }

        que.insert(grid, adj, visited, l, done, times);

        return re;
    }

    public static returned changeColor(int[][] grid, boolean[][] adj, boolean[][] visited,
            int n, int color, PQueue que, int l, int done, int times) {
        times++;
        returned re = new returned(grid, adj, visited, done, times);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    grid[i][j] = color;

                    re = checkAdj(grid, adj, visited, n, color, done, times);

                    grid = re.getGrid();
                    adj = re.getAdj();
                    visited = re.getVisited();
                    done = re.getDone();
                    times = re.getTimes();
                }

            }
        }
        int h = (n * n) - done;
        que.insert(grid, adj, visited, l, done, h, times);
        return re;
    }

    public static returned checkAdj(int[][] grid, boolean[][] adj, boolean[][] visited,
            int n, int color, int done, int times) {
        returned re = new returned(grid, adj, visited, done, times);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    if (grid[i][j] == color) {

                        visited[i][j] = true;
                        adj[i][j] = false;
                        done++;
                        re.setDone(done);
                        re = addAdjacent(grid, adj, visited, n, color, done, times);
                        grid = re.getGrid();
                        adj = re.getAdj();
                        visited = re.getVisited();
                        done = re.getDone();
                        times = re.getTimes();
                    }
                }

            }
        }
        return re;
    }

    public static returned addAdjacent(int[][] grid, boolean[][] adj, boolean[][] visited,
            int n, int color, int done, int times) {
        returned re = new returned(grid, adj, visited, done, times);
        int up, down, right, left; // for checking boundaries
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    if (i > 0) {
                        up = i - 1;
                        if (!visited[up][j]) // if not in my bound already
                        {
                            adj[up][j] = true;
                            re = checkAdj(grid, adj, visited, n, color, done, times);
                            grid = re.getGrid();
                            adj = re.getAdj();
                            visited = re.getVisited();
                            done = re.getDone();
                            times = re.getTimes();
                        }
                    }
                    if (i < (n - 1)) {
                        down = i + 1;
                        if (!visited[down][j]) {
                            adj[down][j] = true;
                            re = checkAdj(grid, adj, visited, n, color, done, times);
                            grid = re.getGrid();
                            adj = re.getAdj();
                            visited = re.getVisited();
                            done = re.getDone();
                            times = re.getTimes();
                        }
                    }
                    if (j > 0) {
                        left = j - 1;
                        if (!visited[i][left]) {
                            adj[i][left] = true;
                            re = checkAdj(grid, adj, visited, n, color, done, times);
                            grid = re.getGrid();
                            adj = re.getAdj();
                            visited = re.getVisited();
                            done = re.getDone();
                            times = re.getTimes();
                        }

                    }
                    if (j < (n - 1)) {
                        right = j + 1;
                        if (!visited[i][right]) {
                            adj[i][right] = true;
                            re = checkAdj(grid, adj, visited, n, color, done, times);
                            grid = re.getGrid();
                            adj = re.getAdj();
                            visited = re.getVisited();
                            done = re.getDone();
                            times = re.getTimes();
                        }

                    }
                }

            }
        }
        return re;
    }

    public static LNode DFS(Queue que, int n, int l) {
        LNode node = que.dequeue();
        dfsCount++;

        returned re = new returned();
        int[][] grid = new int[n][n];
        boolean[][] adj = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        int done = node.getDone();
        int times = node.getTimes();

        returned re2 = new returned();
        int[][] grid2 = new int[n][n];
        boolean[][] adj2 = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];
        int done2 = node.getDone();
        int times2 = node.getTimes();

        returned re3 = new returned();
        int[][] grid3 = new int[n][n];
        boolean[][] adj3 = new boolean[n][n];
        boolean[][] visited3 = new boolean[n][n];
        int done3 = node.getDone();
        int times3 = node.getTimes();

        /*returned re4 = new returned();
        int[][] grid4 = new int[n][n];
        boolean[][] adj4 = new boolean[n][n];
        boolean[][] visited4 = new boolean[n][n];
        int done4 = node.getDone();
        int times4 = node.getTimes();

        returned re5 = new returned();
        int[][] grid5 = new int[n][n];
        boolean[][] adj5 = new boolean[n][n];
        boolean[][] visited5 = new boolean[n][n];
        int done5 = node.getDone();
        int times5 = node.getTimes();*/
        boolean yess = true;
        one:
        for (int f = 0; f < n; f++) {
            for (int r = 0; r < n; r++) {
                if (!node.getVisited()[f][r]) {
                    yess = false;
                    break one;
                }

            }
        }
        if (yess) {
            System.out.println("Solved grid using DFS:");
            for (int f = 0; f < n; f++) {
                for (int r = 0; r < n; r++) {
                    switch (node.getGrid()[f][r]) {
                        case 1:
                            System.out.print(ANSI_YELLOW + "■ " + ANSI_YELLOW);
                            break;
                        case 2:
                            System.out.print(ANSI_CYAN + "■ " + ANSI_CYAN);
                            break;
                        case 3:
                            System.out.print(ANSI_PURPLE + "■ " + ANSI_PURPLE);
                            break;
                        //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                        //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                        }
                }
                System.out.println("");
            }
            System.out.println("Color changed " + node.getTimes() + " times.");

            return null;
        } else {
            //l++;

            yo:
            if (done != (n * n)) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid[i][j] = node.getGrid()[i][j];
                        adj[i][j] = node.getAdj()[i][j];
                        visited[i][j] = node.getVisited()[i][j];

                    }
                }
                if (node.getGrid()[0][0] != 1) {
                    re = changeColor2(grid, adj, visited, n, 1, que, l, done, times);
                    for (int f = 0; f < n; f++) {
                        for (int r = 0; r < n; r++) {
                            switch (re.getGrid()[f][r]) {
                                case 1:
                                    System.out.print(ANSI_YELLOW + "■ " + ANSI_YELLOW);
                                    break;
                                case 2:
                                    System.out.print(ANSI_CYAN + "■ " + ANSI_CYAN);
                                    break;
                                case 3:
                                    System.out.print(ANSI_PURPLE + "■ " + ANSI_PURPLE);
                                    break;
                                //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                                //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    DFS(que, n, l);
                    break yo;
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        grid2[i][j] = node.getGrid()[i][j];
                        adj2[i][j] = node.getAdj()[i][j];
                        visited2[i][j] = node.getVisited()[i][j];

                    }
                }

                if (node.getGrid()[0][0] != 2) {
                    re2 = changeColor2(grid2, adj2, visited2, n, 2, que, l, done2, times2);
                    for (int f = 0; f < n; f++) {
                        for (int r = 0; r < n; r++) {
                            switch (re2.getGrid()[f][r]) {
                                case 1:
                                    System.out.print(ANSI_YELLOW + "■ " + ANSI_YELLOW);
                                    break;
                                case 2:
                                    System.out.print(ANSI_CYAN + "■ " + ANSI_CYAN);
                                    break;
                                case 3:
                                    System.out.print(ANSI_PURPLE + "■ " + ANSI_PURPLE);
                                    break;
                                //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                                //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    DFS(que, n, l);
                    break yo;
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid3[i][j] = node.getGrid()[i][j];
                        adj3[i][j] = node.getAdj()[i][j];
                        visited3[i][j] = node.getVisited()[i][j];

                    }
                }
                if (node.getGrid()[0][0] != 3) {
                    re3 = changeColor2(grid3, adj3, visited3, n, 3, que, l, done3, times3);
                    for (int f = 0; f < n; f++) {
                        for (int r = 0; r < n; r++) {
                            switch (re3.getGrid()[f][r]) {
                                case 1:
                                    System.out.print(ANSI_YELLOW + "■ " + ANSI_YELLOW);
                                    break;
                                case 2:
                                    System.out.print(ANSI_CYAN + "■ " + ANSI_CYAN);
                                    break;
                                case 3:
                                    System.out.print(ANSI_PURPLE + "■ " + ANSI_PURPLE);
                                    break;
                                //case 4: System.out.print(ANSI_BLACK+"■ "+ANSI_BLACK); break;
                                //case 5: System.out.print(ANSI_RED+"■ "+ANSI_RED); break;
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    DFS(que, n, l);
                    break yo;
                }

                /*for  (int i = 0 ; i<n ; i++)
                    for (int j = 0 ; j<n ; j++)
                    {
                        grid4[i][j] = node.getGrid()[i][j];
                        adj4[i][j] = node.getAdj()[i][j];
                        visited4[i][j] = node.getVisited()[i][j];
                        
                    } 
                re4 = changeColor2(grid4, adj4, visited4, n, 4, que, l, done, times4);
                DFS(que, n,l);
                
                for  (int i = 0 ; i<n ; i++)
                    for (int j = 0 ; j<n ; j++)
                    {
                        grid5[i][j] = node.getGrid()[i][j];
                        adj5[i][j] = node.getAdj()[i][j];
                        visited5[i][j] = node.getVisited()[i][j];
                        
                    }  
                re5 = changeColor2(grid5, adj5, visited5, n, 5, que, l, done, times5);*/
                //DFS(que, n,l);
                //BFS(que, n, l);
            } else {
                return node;
            }
            return node;
        }

    }

    public static returned changeColor2(int[][] grid, boolean[][] adj, boolean[][] visited, int n,
            int color, Queue que, int l, int done, int times) {
        times++;
        returned re = new returned(grid, adj, visited, done, times);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    grid[i][j] = color;

                    re = checkAdj(grid, adj, visited, n, color, done, times);

                    grid = re.getGrid();
                    adj = re.getAdj();
                    visited = re.getVisited();
                    done = re.getDone();
                    times = re.getTimes();

                }

            }
        }

        que.insert(grid, adj, visited, l, done, times);

        return re;
    }

    public static returned checkAdj2(int[][] grid, boolean[][] adj, boolean[][] visited,
            int n, int color, int done, int times) {
        returned re = new returned(grid, adj, visited, done, times);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    if (grid[i][j] == color) {

                        visited[i][j] = true;
                        adj[i][j] = false;
                        done++;
                        re.setDone(done);
                        re = addAdjacent2(grid, adj, visited, n, color, done, times);
                        grid = re.getGrid();
                        adj = re.getAdj();
                        visited = re.getVisited();
                        done = re.getDone();
                        times = re.getTimes();
                    }
                }

            }
        }
        return re;
    }

    public static returned addAdjacent2(int[][] grid, boolean[][] adj, boolean[][] visited,
            int n, int color, int done, int times) {
        returned re = new returned(grid, adj, visited, done, times);
        int up, down, right, left; // for checking boundaries
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    if (i > 0) {
                        up = i - 1;
                        if (!visited[up][j]) // if not in my bound already
                        {
                            adj[up][j] = true;
                            re = checkAdj2(grid, adj, visited, n, color, done, times);
                            grid = re.getGrid();
                            adj = re.getAdj();
                            visited = re.getVisited();
                            done = re.getDone();
                            times = re.getTimes();
                        }
                    }
                    if (i < (n - 1)) {
                        down = i + 1;
                        if (!visited[down][j]) {
                            adj[down][j] = true;
                            re = checkAdj2(grid, adj, visited, n, color, done, times);
                            grid = re.getGrid();
                            adj = re.getAdj();
                            visited = re.getVisited();
                            done = re.getDone();
                            times = re.getTimes();
                        }
                    }
                    if (j > 0) {
                        left = j - 1;
                        if (!visited[i][left]) {
                            adj[i][left] = true;
                            re = checkAdj2(grid, adj, visited, n, color, done, times);
                            grid = re.getGrid();
                            adj = re.getAdj();
                            visited = re.getVisited();
                            done = re.getDone();
                            times = re.getTimes();
                        }

                    }
                    if (j < (n - 1)) {
                        right = j + 1;
                        if (!visited[i][right]) {
                            adj[i][right] = true;
                            re = checkAdj2(grid, adj, visited, n, color, done, times);
                            grid = re.getGrid();
                            adj = re.getAdj();
                            visited = re.getVisited();
                            done = re.getDone();
                            times = re.getTimes();
                        }

                    }
                }

            }
        }
        return re;
    }

    public static void DFS(Obj[][] grid, adjacent[][] adj, int n, int count, int color) {

        changeColor(grid, adj, n, color);
        //addAdjacent(grid, adj, n);
        //System.out.println("grid 0,0 visit "+grid[0][0].getVisit());
        count++;
        //System.out.println(count);
        //System.out.println(color);
        //System.out.println(color);
        switch (color) {
            case 1:
                DFS(grid, adj, n, count, 2);  // pink
                DFS(grid, adj, n, count, 3);  // YELLOW
                DFS(grid, adj, n, count, 4);  // yellow
                DFS(grid, adj, n, count, 5);  // purple
                break;
            case 2:
                //DFS(grid, adj, n, count, 1);  // blue
                DFS(grid, adj, n, count, 3);  // YELLOW
                DFS(grid, adj, n, count, 4);  // yellow
                DFS(grid, adj, n, count, 5);  // purple
                break;
            case 3:
                //DFS(grid, adj, n, count, 1);  // blue
                //DFS(grid, adj, n, count, 2);  // pink
                DFS(grid, adj, n, count, 4);  // yellow
                DFS(grid, adj, n, count, 5);  // purple
                break;
            case 4:
                //DFS(grid, adj, n, count, 1);  // blue
                //DFS(grid, adj, n, count, 2);  // pink
                //DFS(grid, adj, n, count, 3);  // YELLOW
                DFS(grid, adj, n, count, 5);  // purple
                break;
            case 5:
                DFS(grid, adj, n, count, 1);  // blue
                DFS(grid, adj, n, count, 2);  // pink
                DFS(grid, adj, n, count, 3);  // YELLOW
                DFS(grid, adj, n, count, 4);  // yellow
                break;
            default:
                break;
        }

    }

    public static void changeColor(Obj[][] grid, adjacent[][] adj, int n, int color) {
        //System.out.println("Change color is here");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].getVisit()) {
                    //System.out.println("visited");
                    grid[i][j].set(color);
                    System.out.println("color changed in " + i + ", " + j);
                    addAdjacent(grid, adj, n, color);
                    //checkAdj(grid, adj, n, color);
                }

            }
        }

    }

    public static void addAdjacent(Obj[][] grid, adjacent[][] adj, int n, int color) {
        int up, down, right, left; // for checking boundaries
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].getVisit()) {
                    if (i > 0) {
                        up = i - 1;
                        if (!grid[up][j].getVisit()) // if not in my bound already
                        {
                            if (grid[up][j].get() == color) {
                                grid[up][j].setVisit(true);
                                addAdjacent(grid, adj, n, color);
                            } else {
                                adj[up][j].set(true);
                            }
                        }
                    }
                    if (i < (n - 1)) {
                        down = i + 1;
                        if (!grid[down][j].getVisit()) {
                            if (grid[down][j].get() == color) {
                                grid[down][j].setVisit(true);
                                addAdjacent(grid, adj, n, color);
                            } else {
                                adj[down][j].set(true);
                            }
                        }
                    }
                    if (j > 0) {
                        left = j - 1;
                        if (!grid[i][left].getVisit()) {
                            if (grid[i][left].get() == color) {
                                grid[i][left].setVisit(true);
                                addAdjacent(grid, adj, n, color);
                            } else {
                                adj[i][left].set(true);
                            }
                        }

                    }
                    if (j < (n - 1)) {
                        right = j + 1;
                        if (!grid[i][right].getVisit()) {
                            if (grid[i][right].get() == color) {
                                grid[i][right].setVisit(true);
                                addAdjacent(grid, adj, n, color);
                            } else {
                                adj[i][right].set(true);
                            }
                        }

                    }
                }

            }
        }
    }

}
