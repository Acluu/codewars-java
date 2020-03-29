package snail;

import java.util.Arrays;

public class Snail {
	
	public static int[] snail(int[][] array) {
		int direction = 0; // 0 右 1 下 2 左 3 上
		int side = array.length;
		int[] a = new int[side*side];
		int count=0;
		if ((side == 0)||(side==1)) {
			return array[0];
		}
		int[][] graph = new int[side + 2][side + 2];
		for (int i = 0; i < side + 2; i++) {
			for (int j = 0; j < side + 2; j++) {
				if ((i == 0) || (j == 0) || (i == side + 1) || (j == side + 1)) {
					graph[i][j] = -114514;
				} else {
					graph[i][j] = array[i - 1][j - 1];
				}
			}
		}
		int co=0;
		int y = 1, x = 1;
		while (++co<=side*side) {
			if (direction==0) {
				for(;graph[y][x]!=-114514;x++) {
					a[count++]=graph[y][x];
					graph[y][x]=-114514;
				}
				x--;y++;
			}
			if (direction==1) {
				for(;graph[y][x]!=-114514;y++) {
					a[count++]=graph[y][x];
					graph[y][x]=-114514;
				}
				y--;x--;
			}
			if (direction==2) {
				for(;graph[y][x]!=-114514;x--) {
					a[count++]=graph[y][x];
					graph[y][x]=-114514;
				}
				x++;y--;
			}
			if (direction==3) {
				for(;graph[y][x]!=-114514;y--) {
					a[count++]=graph[y][x];
					graph[y][x]=-114514;
				}
				y++;x++;
			}
			
			direction=(direction+1)%4;
		}
		
		return a;

	}

	public static void main(String[] args) {
		int[][] a ={{}};
		System.out.println(Arrays.toString(snail(a)));

	}

}
