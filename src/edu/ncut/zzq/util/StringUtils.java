package edu.ncut.zzq.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class StringUtils {
	public static final CharsetEncoder GBK_ENCODER = Charset.forName("GBK").newEncoder();

	/**
	 * 字符串查找
	 * 
	 * @param str
	 * @param s1
	 * @return
	 */
	public static int find(final String str, final String s1) {
		try {
			int findx = 0;
			Pattern pt = Pattern.compile("(" + s1 + ")",
					Pattern.CASE_INSENSITIVE);
			Matcher m = pt.matcher(str);
			while (m.find()) {
				findx++;
			}
			return findx;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 将字符串str按splitlit切分，1.4已经有方法
	 * 
	 * @param str
	 * @param splitlit
	 * @return 一个数组
	 */
	public static String[] split(final String str, final String splitlit) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(str, splitlit);
			String[] out = new String[stringtokenizer.countTokens()];
			int i = 0;
			while (stringtokenizer.hasMoreTokens()) {
				out[i] = stringtokenizer.nextToken();
				i++;
			}
			return out;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 转换html特殊字符为html码
	 * 
	 * @param str
	 * @return
	 */
	public static String htmlSpecialChars(final String str) {
		try {
			if (str.indexOf('<') == -1 && str.indexOf('>') == -1
					&& str.indexOf('"') == -1 && str.indexOf('\'') == -1) {
				return str.trim();
			}
			StringBuilder sb = new StringBuilder();
			int length = str.length();
			char ch;
			for (int i = 0; i < length; i++) {
				ch = str.charAt(i);
				if (ch == '&') {
					sb.append("&amp;");
				} else if (ch == '<') {
					sb.append("&lt;");
				} else if (ch == '>') {
					sb.append("&gt;");
				} else if (ch == '"') {
					sb.append("&quot;");
				} else if(ch =='\''){
					sb.append("&#39;");
				}else {
					sb.append(ch);
				}
			}
			String value = sb.toString();
			if (value.replace("&nbsp;", "").replace("　", "").trim().length() == 0) {
				return "";
			}
			return value;
		} catch (Exception e) {
			return "";
		}
	}

	public static String escapeHTMLTags(final String str) {
		if (str == null) {
			return null;
		}
		//替换时先判断是否存在需要替换的字符,提高性能
		if (str.indexOf('<') == -1 && str.indexOf('>') == -1
				&& str.indexOf('"') == -1 && str.indexOf('\'') == -1) {
			return str;
		}
		int stringLength = str.length();
		//		StringBuilder buf = new StringBuilder();
		StringBuilder buf = new StringBuilder((int) (stringLength * 1.1));
		for (int i = 0; i < stringLength; ++i) {
			char c = str.charAt(i);

			switch (c) {
				case '<':
					buf.append("&lt;");
					break;
				case '>':
					buf.append("&gt;");
					break;
				case '"':
					buf.append("&quot;");
					break;
				case '\'':
					buf.append("&#39;");	//	&apos; 貌似都可以？
					break;
				default:
					buf.append(c);
			}
		}
		return buf.toString();
	}

	/**
	 * 判断字符串是否正常
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isFine(final String str) {
		try {
			return !(str == null || str.trim().length() == 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断一组字符串是否都正常
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isFine(final String[] str) {
		try {
			for (String aStr : str) {
				if (!isFine(aStr)) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isAllFine(String... strs) {
		try {
			for (String s : strs) {
				if (!isFine(s)) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isAllEmpty(String... strings) {
		try {
			for (String s : strings) {
				if (isFine(s)) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * s中的s1替换成s2
	 * 
	 * @return
	 */
	public static String replace(final String str, final String from,
			final String to) {
		char[] chars = str.toCharArray();
		char[] to_chars = to.toCharArray();
		char[] from_chars = from.toCharArray();
		StringBuilder sb = new StringBuilder();
		char from_first = from_chars[0];
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == from_first) {
				boolean isok = true;
				for (int k = 1; k < from_chars.length; k++) {
					if (i + k < chars.length && chars[i + k] != from_chars[k]) {
						isok = false;
						break;
					}
				}
				if (isok) {
					for (char to_char : to_chars) {
						sb.append(to_char);
					}
					i += from_chars.length - 1;
				}
			} else {
				sb.append(chars[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * URL解码
	 * 
	 * @param str
	 * @return
	 */
	public static String urlDecode(final String str,String enc) {
		try {
			return URLDecoder.decode(str, enc);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 转换字符串成boolean值
	 * 
	 * @param s
	 * @return
	 */
	public static boolean toBoolean(final String s) {
		return !(s == null || s.length() == 0 || s.equals("false") || s.equals("0")|| s.equals("5"));
	}

	/**
	 * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
	 * 
	 * @return boolean, 返回true,Ascill字符
	 */
	public static boolean isLetter(char c) {
		int k = 0x80;
		return c / k == 0;
	}

	/**
	 * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
	 * 
	 *            s ,需要得到长度的字符串
	 * @return int, 得到的字符串长度
	 */
	public static int length(String s) {
		if (s == null) {
			return 0;
		}
		char[] c = s.toCharArray();
		int len = 0;
		for (char aC : c) {
			len++;
			if (!isLetter(aC)) {
				len++;
			}
		}
		return len;
	}

	public static String escapeSQLParam(final String param) {
		int stringLength = param.length();
		StringBuilder buf = new StringBuilder((int) (stringLength * 1.1));
		for (int i = 0; i < stringLength; ++i) {
			char c = param.charAt(i);
			switch (c) {
				case 0: /* Must be escaped for 'mysql' */
					buf.append('\\');
					buf.append('0');
					break;
				case '\n': /* Must be escaped for logs */
					buf.append('\\');
					buf.append('n');
					break;
				case '\r':
					buf.append('\\');
					buf.append('r');
					break;
				case '\\':
					buf.append('\\');
					buf.append('\\');
					break;
				case '\'':
					buf.append('\\');
					buf.append('\'');
					break;
				case '"': /* Better safe than sorry */
					buf.append('\\');
					buf.append('"');
					break;
				case '\032': /* This gives problems on Win32 */
					buf.append('\\');
					buf.append('Z');
					break;
				default:
					buf.append(c);
			}
		}
		return buf.toString();
	}

	/**
	 * 调用String.format格式化字符串
	 * 
	 * @param format
	 * @param args
	 * @return
	 */
	public static String format(String format, Object... args) {
		return String.format(format, args);
	}

	/**
	 * 固定位数
	 * 
	 * @param number
	 *            int
	 * @param minlen
	 *            int
	 * @return String
	 */
	public static String fixed(final int number, final int minlen) {
		String result = String.valueOf(number);
		while (result.length() < minlen) {
			result = "0" + result;
		}
		return result;
	}

	/**
	 * String是否为null或则和为空字符串
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isEmpty(String val) {
		return (val == null || "".equals(val.trim()));
	}

	/**
	 * String是否不为null且不为空字符串
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNotEmpty(String val) {
		return !isEmpty(val);
	}

	public static int parseInt(final double num) {
		int result;
		String str = num + "";
		int index = str.indexOf(".");
		if (index >= 0) {
			result = parseInt(str.substring(0, index));
		} else {
			result = parseInt(str);
		}
		return result;
	}

	public static int parseInt(final String str) {
		return parseInt(str, 0);
	}

	public static int parseInt(final String str, final int custom) {
		return parseInt(str, custom, custom);
	}

	public static int parseInt(final String str, final int min, final int custom) {
		int result;
		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {
			result = custom;
		}
		if (result < min) {
			result = min;
		}
		return result;
	}

	public static String join(final String[] strs) {
		return StringUtils.join(strs, ", ");
	}

	public static String join(final String[] strs, final String delim) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			sb.append(delim).append(strs[i]);
		}
		return sb.toString();
	}

	//static Pattern emailPattern = Pattern.compile("^[a-z0-9]+[-_]?[a-z0-9\\.]+@(([a-z0-9]*[-_]?[a-z0-9]+)+[\\.]){1,4}[a-z]{2,3}([\\.][a-z]{2})?$");
	static Pattern emailPattern = Pattern.compile("^[a-z0-9-_—]+[a-z0-9\\.-_—]+@(([a-z0-9]*[-_]?[a-z0-9]+)+[\\.]){1,4}[a-z]{2,3}([\\.][a-z]{2})?$");
	public static boolean isEmail(String str) {
		return !isEmpty(str) && emailPattern.matcher(str).matches();
	}

	public static void main(String[] args) {
		boolean email = StringUtils.isEmail("ad11hn@qq.com");
		System.out.println(email);
	}
	
	static Pattern phonePattern = Pattern.compile("(1[34578][0-9][- ]?\\d{4}[- ]?\\d{4})|(\\d{3,4}[- ]?\\d{3,4}[- ]?\\d{4})");
	public static boolean isPhoneNo(String str) {
		return !isEmpty(str) && phonePattern.matcher(str).matches();
	}

	/**
	 * ((1[1-5])|(2[1-3])|(3[1-7])|(4[1-6])|(5[0-4])|(6[1-5])|71|(8[12])|91)\\d{4}
	 * ((19\\d{2}(0[13-9]|1[012])(0[1-9]|[12]\\d|30))|(19\\d{2}(0[13578]|1[02])31)|(19\\d{2}02(0[1-9]|1\\d|2[0-8]))|(19([13579][26]|[2468][048]|0[48])0229))
	 * \\d{3}
	 * (\\d|X|x)
	 */
	static Pattern idcardNoPattern = Pattern.compile("((1[1-5])|(2[1-3])|(3[1-7])|(4[1-6])|(5[0-4])|(6[1-5])|71|(8[12])|91)\\d{4}(((19|20)\\d{2}(0[13-9]|1[012])(0[1-9]|[12]\\d|30))|((19|20)\\d{2}(0[13578]|1[02])31)|((19|20)\\d{2}02(0[1-9]|1\\d|2[0-8]))|((19|20)([13579][26]|[2468][048]|0[048])0229))\\d{3}(\\d|X|x)");
	static Pattern passportPattern = Pattern.compile("[a-zA-Z0-9]{6,}");

	/**
	 * 全国组织机构代码由八位数字（或大写拉丁字母）本体代码和一位数字（或大写拉丁字母）校验码组成.
	 * xxxxxxxx-x
	 * 后增加18位数字和字母组合的形式

	 */
	static Pattern  organizationCodeNewPattern = Pattern.compile("[a-zA-Z0-9]{18}",Pattern.CASE_INSENSITIVE);
	static Pattern  organizationCodeOldPattern = Pattern.compile("[A-Z0-9]{8}-[A-Z0-9]");
	public static boolean isOrganizationCode(String str) {
		return !isEmpty(str) && (organizationCodeOldPattern.matcher(str).matches() || organizationCodeNewPattern.matcher(str).matches());
	}
	
	public static boolean isValidIdcardNo(String id,int type){
		if(isEmpty(id)){
			return false;
		}
		boolean isvalid;
		if (1 == type) {//身份证
			isvalid = idcardNoPattern.matcher(id).matches();
		} else {
			isvalid = 2 != type || passportPattern.matcher(id).matches();
		}
		return isvalid;
		
	}

	/**
	 * 中英文姓名
	 *
	 * @param str
	 * @return
	 */
	public static boolean isAllName(String str) {
		return !isEmpty(str) && str.length() >= 1 && str.length() <= 50;
	}

	public static Double parseDouble(String str) {
		Double result;
		try {
			result = Double.parseDouble(str);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean isQQ(String str) {
		return isFine(str);
	}

	/**
	 * 是否符合营业执照规则
	 * 15位连续数字构成。
                代码结构工商注册号由14位数字本体码和1位数字校验码组成，
                其中本体码从左至右依次为：6位首次登记机关码、8位顺序码，
      1位数字校验码组成

	 18位
	 1位登记管理部门代码+1位机构类型代码+6位登记管理机关行政区划码+9位主体识别码（组织机构代码）+1位校验码
	 * @param str
	 * @return
	 */
	public static boolean isLicense(String str) {
		return !isEmpty(str) && (str.length() == 15 || str.length() == 18);
	}

	public static String unescape(String src) {
		if(!isFine(src)){
			return "";
		}
        StringBuilder tmp = new StringBuilder();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src
                            .substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src
                            .substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }
	
	
	public static String nullToEmpty(String str){
		if(StringUtils.isEmpty(str)){
			return "";
		}
		return str;
	}

	/**
	 * 计算字符串md5返回32位字符串
	 *
	 * @param str
	 *            target str
	 * @return 32位字符串
	 */
	public static String md5hex(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			md5.update(str.getBytes());
			byte[] buffer = md5.digest();
			StringBuilder sb = new StringBuilder(buffer.length * 2);
			for (byte element : buffer) {
				sb.append(Character.forDigit((element & 240) >> 4, 16));
				sb.append(Character.forDigit(element & 15, 16));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
	}

	public static boolean is9001Docid(String docid) {
		return isFine(docid) && "9001".equals(docid.substring(8, 12));
	}

	public static String filterNonGBKChar(String str) {
		StringBuilder result = new StringBuilder("");
		if (StringUtils.isEmpty(str)) {
			return result.toString();
		}
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if (GBK_ENCODER.canEncode(c)) {
				result.append(c);
			}
		}
		return result.toString();
	}

	public static boolean isEquals(String s1, String s2) {
		return (s1 == null && s2 == null) || (s1 != null && s2 != null && s1.equals(s2));
	}

    // 按字节长度截取字符串，中文不会出现截断一半的情况
    public static String getSubStr(String str, int subSLength) throws UnsupportedEncodingException {
        if (str == null)
            return "";
        else {
            int tempSubLength = subSLength;// 截取字节数
            String subStr = str.substring(0, str.length() < subSLength ? str.length() : subSLength);// 截取的子串
            int subStrByetsL = subStr.getBytes("GBK").length;// 截取子串的字节长度
            // 说明截取的字符串中包含有汉字
            while (subStrByetsL > tempSubLength) {
                int subSLengthTemp = --subSLength;
                subStr = str.substring(0, subSLengthTemp > str.length() ? str.length() : subSLengthTemp);
                subStrByetsL = subStr.getBytes("GBK").length;
            }
            return subStr;
        }
    }

	public static Long parseLong(String longString) {
		Long longValue = null;
		try {
			longValue = Long.valueOf(longString);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return longValue;
	}

	public static String convertToUnicode(String str) {
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++)
		{
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>>8); //取出高8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
			j = (c & 0xFF); //取出低8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);

		}
		return (new String(sb));
	}

	public static String getURLEncodeStrFroUTF8(String str) {
		String result = str;
		try {
			if (StringUtils.isEmpty(result)) {
				return result;
			}
			result = URLEncoder.encode(str, "UTF-8");
		} catch (Exception e) {
			return result;
		}
		return result;
	}
}


