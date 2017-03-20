package com.zeetcode.string;

/**
 * <script></script>
 * <script .... />
 * @author dij052
 *
 */
public class RemoveScriptTag {
	public String remove(String s) {
		StringBuffer sb = new StringBuffer();
		int start = 0;
		int openTag = s.indexOf("<script>");
		int closeTag = s.indexOf("</script>");
		while (openTag != -1 && closeTag != -1  && openTag < closeTag) {
			sb.append(s.substring(start, openTag));
			start = closeTag + "</script>".length();
			openTag = s.indexOf("<script>", start);
			closeTag = s.indexOf("</script>", start);
		}
		
		if (start < s.length())
			sb.append(s.substring(start));
		
		return sb.toString();
	}
	
	public String removeScriptTag(String s) {
		StringBuffer sb = new StringBuffer();
		int start = 0;
		int tag = s.indexOf("<script");
		while (tag != -1) {
			sb.append(s.substring(start, tag));
			
		}
		
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		RemoveScriptTag r = new RemoveScriptTag();
		
		String s = "sdfa<script>dfsadf</script> dfsdf <script> 222 </script>sdf";
		System.out.println(r.remove(s));
	}
}
