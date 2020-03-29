package maxcommonstring;

import java.util.Arrays;

//动态规划解决最长子序列
public class Solution {

	public static String lcs(String x, String y) {
		String longcs = "";
		if (("".equals(x))||("".equals(y)))
			return longcs;
    int xl = x.length();
		int yl = y.length();
		int[][] dtghb = new int[xl + 1][yl + 1]; // x row y col dtghb=动态规划表
		for (int i = 0; i < xl; i++) {
			for (int j = 0; j < yl; j++) {
				if (x.charAt(i) == y.charAt(j)) {
					dtghb[i + 1][j + 1] = dtghb[i][j] + 1;
				} else {
					dtghb[i + 1][j + 1] = dtghb[i + 1][j] > dtghb[i][j + 1] ? dtghb[i + 1][j] : dtghb[i][j + 1];
				}
			}
		}
		int xp = xl;
		int yp = yl;
		if (dtghb[xp][yp] == 0) {
			return longcs;
		}
		int tpt=dtghb[xp][yp];
		while((xp>0)||(yp>0)) {
			for (;dtghb[xp][yp]==tpt;xp--) {
        if (xp==0)
        break;
      }
			xp++;
			for (;dtghb[xp][yp]==tpt;yp--) 
      {
        if (yp==0)
        break;
      }
			yp++;
			if (x.charAt(xp-1)==y.charAt(yp-1))
        {longcs=x.charAt(xp-1)+longcs;}
			xp--;yp--;tpt--;
		}
		return longcs;
		
	}

	public static void main(String[] args) {
		String a = "132535365";
		String b = "123456789";
		System.out.println(lcs(a, b));

	}

}
