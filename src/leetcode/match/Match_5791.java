package leetcode.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName:
 * @ClassName: Match_5791
 * @Author: czf
 * @Description: 子岛屿
 * @Date: 2021/6/20 11:05
 * @Version: 1.0
 **/

public class Match_5791 {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};

        int[][] grid1a = {
                        {1, 1, 1, 1, 0, 0},
                        {1, 1, 0, 1, 0, 0},
                        {1, 0, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0, 1},
                        {1, 1, 1, 1, 1, 0},
                        {1, 0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1, 0},
                        {1, 1, 1, 1, 1, 0}
        };
        int[][] grid2a =
                {
                        {1, 1, 1, 1, 0, 1},
                        {0, 0, 1, 0, 1, 0},
                        {1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1},
                        {1, 1, 0, 1, 1, 1},
                        {1, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 1, 0, 0}
                };


        System.out.println(new Match_5791().countSubIslands(grid1a, grid2a));

    }


    public int countSubIslands(int[][] grid1, int[][] grid2) {
        final int n = grid1.length;
        final int m = grid1[0].length;
        List<List<Point>> aGird = new ArrayList<>();
        List<List<Point>> bGird = new ArrayList<>();
        Boolean[][] isSeek = new Boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isSeek[i][j] = false;
            }
        }

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                List<Point> points = seekIsland(null, grid1, i, j, isSeek);
                if (points != null) {
                    aGird.add(points);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isSeek[i][j] = false;
            }
        }

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                List<Point> points = seekIsland(null, grid2, i, j, isSeek);
                if (points != null) {
                    bGird.add(points);
                }
            }
        }
        int result = 0;
        for (List<Point> a : aGird) {
            for (List<Point> b : bGird) {
                if (a.containsAll(b)) {
                    result++;
                }
            }
        }
        return result;
    }


    List<Point> seekIsland(List<Point> islandList, int[][] island, int i, int j, Boolean[][] isSeek) {
        int n = island.length;
        int m = island[0].length;
        if (island[i][j] == 1 && !isSeek[i][j]) {
            if (islandList == null) {
                islandList = new ArrayList<Point>();
            }

            Point point = new Point(i, j);
            islandList.add(point);
            isSeek[i][j] = true;
            // FIXME 这里存在问题 这样遍历会遗漏
            if (i + 1 < n) {
                seekIsland(islandList, island, i + 1, j, isSeek);
            }
            if (j + 1 < m) {
                seekIsland(islandList, island, i, j + 1, isSeek);
            }

        }
        return islandList;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
        }

        @Override
        public int compareTo(Point o) {
            if (x == o.x) {
                return y - o.y;
            }
            return x - o.x;
        }

        @Override
        public boolean equals(Object obj) {
            Point obj1 = (Point) obj;
            return this.compareTo(obj1) == 0;
        }
    }
}
