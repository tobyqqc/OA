import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
    // Write your code here
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(workHours, dayHours, pattern, res, path, 0, 0);
        return res;
    }
    private static void dfs(int w, int d, String s, List<String> res, StringBuilder path, int cur, int sum) {
        if (cur == s.length()) {
        	if (w == sum) {
        		res.add(path.toString());
        	}
        	return;
        }
        char c = s.charAt(cur);
        if (cur < s.length()) {
        	if (c != '?') {
            	sum += (c - '0');
            	path.append(c);
            	dfs(w, d, s, res, path, cur + 1, sum);
            	path.deleteCharAt(path.length() - 1);
            	System.out.print(path + " | sum: ");
            	System.out.println(sum);
            } else {
            	for (int i = 0; i <= d; i++) {
            		sum += i;
            		path.append(i + "");
            		dfs(w, d, s, res, path, cur + 1, sum);
            		path.deleteCharAt(path.length() - 1);
            		sum -= i;
            		System.out.print(path + " | sum: ");
                	System.out.println(sum);
            	}
            }
        }
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 24;
		int d = 8;
		String p = "08??840";
		System.out.println(findSchedules(w, d, p).toString());
	}

}
