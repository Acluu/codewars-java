package codewars_style_ranking_system_4;

public class User {
	final static int[] level = {-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8};
	final static int maxPro=100;
	public int ind;
	public int rank;
	public int progress;
	public User() {
		this.ind=0;
		this.rank=level[ind];
		this.progress=0;
	}
	
	public void incProgress(int act) {
		if ((act==0)||(act<=-9)||(act>=9)) throw new IllegalArgumentException();
		if (act>0) {
			act--;
		}
		int trank=rank;
		if (rank>0) {
			trank--;
		}
		if (act-trank==-1) {
			progress++;
		}
		else if ((act-trank)==0) {
			progress+=3;
		}
		else if (act-trank>0) {
			progress+=(10*(act-trank)*(act-trank));
		}
		
		while((progress>=maxPro)) {
			if (rank==8) {
				progress=0;
				break;
			}
			progress-=maxPro;
			ind++;
			rank=level[ind];
		}
	}
	public static void main(String[] args) {
		User user = new User();
		user.incProgress(-1);
		System.out.println(user.rank);
		System.out.println(user.progress);
		User user2 = new User();
		user2.incProgress(-7);
		System.out.println(user2.rank);
		System.out.println(user2.progress);

	}
}
