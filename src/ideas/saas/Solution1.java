package ideas.saas;

import java.io.IOException;

public class Solution1 {

	public static void main(String[] args) throws IOException {
		System.out.println(findMinDistance(5, 1, 1));
    }
	
	static int findMinDistance(int w, int h, int n) {
        int dist = 0;
        
        if(h == 1){
        	return (w - h) / (h+n);
        }
        
        return dist;

    }
}
