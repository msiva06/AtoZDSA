package Strings;

// Reverse String
public class Problem_09 {
    // Stack<String> st = new Stack<>();
		// String s = "";
		// for(int i = 0; i < str.length(); i++){
		// 	if(str.charAt(i) == ' '){
		// 		st.push(s.trim());
		// 		s = "";
		// 	}
		// 	else{
		// 		s += str.charAt(i);
		// 	}
		// }
		// st.push(s.trim());
		// s = "";
		// while(!st.isEmpty()){
		// 	String temp = st.pop();
		// 	if(temp == "")
		// 		continue;
		// 	if(s == ""){
		// 		s += temp;
		// 	}
		// 	else{
		// 		s = s + " " + temp;
		// 	}
		// }
		// return s;
		String ans = "";
		String temp = "";
		for(int i = str.length()-1; i>=0 ; i--){
			
			if(str.charAt(i) == ' '){
				temp = temp.trim();
				if(temp != ""){
					StringBuilder sb = new StringBuilder(temp);
					sb.reverse();
					
					if(ans == ""){
						ans += sb.toString();
					}
					else{
						ans = ans + " " + sb.toString();
					}
					temp = "";
				}

			}
			else{
				temp += str.charAt(i);
			}
		}
		if(temp != ""){
					StringBuilder sb = new StringBuilder(temp);
					sb.reverse();
					
					if(ans == ""){
						ans += sb.toString();
					}
					else{
						ans = ans + " " + sb.toString();
					}
				}
		return ans;
}
