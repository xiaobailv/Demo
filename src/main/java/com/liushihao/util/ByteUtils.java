package com.liushihao.util;

import java.io.ByteArrayOutputStream;

public class ByteUtils {
	private final static char[] mChars = "0123456789ABCDEF".toCharArray();
	public static byte[] strToBcd(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}

		byte[] abt = new byte[len];
		if (len >= 2) {
			len /= 2;
		}

		byte[] bbt = new byte[len];
		abt = asc.getBytes();

		for (int p = 0; p < asc.length() / 2; ++p) {
			int j;
			if (abt[2 * p] >= 97 && abt[2 * p] <= 122) {
				j = abt[2 * p] - 97 + 10;
			} else if (abt[2 * p] >= 65 && abt[2 * p] <= 90) {
				j = abt[2 * p] - 65 + 10;
			} else {
				j = abt[2 * p] - 48;
			}

			int k;
			if (abt[2 * p + 1] >= 97 && abt[2 * p + 1] <= 122) {
				k = abt[2 * p + 1] - 97 + 10;
			} else if (abt[2 * p + 1] >= 65 && abt[2 * p + 1] <= 90) {
				k = abt[2 * p + 1] - 65 + 10;
			} else {
				k = abt[2 * p + 1] - 48;
			}

			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}

	/**
	 *  十六进制转成二进制
	 * @param src
	 * @return
	 */
	public static byte[] hexStrToBytes(String src) {
		int m = 0, n = 0;
		int l = src.length() / 2;
		byte[] ret = new byte[l];
		for (int i = 0; i < l; i++) {
			m = i * 2 + 1;
			n = m + 1;
			ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
		}
		return ret;
	}

	/**
	 * 字符串转换成十六进制字符串
	 * @param str String 待转换的ASCII字符串
	 * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
	 */
	public static String str2HexStr(String str){
		StringBuilder sb = new StringBuilder();
		byte[] bs = str.getBytes();

		for (int i = 0; i < bs.length; i++){
			sb.append(mChars[(bs[i] & 0xFF) >> 4]);
			sb.append(mChars[bs[i] & 0x0F]);
//            sb.append(' ');
		}
		return sb.toString().trim();
	}


	/**
	 * 十六进制转换字符串
	 * @param String str Byte字符串(Byte之间无分隔符 如:[616C6B])
	 * @return String 对应的字符串
	 */
	public static String hexStr2Str(String hexStr)
	{
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;

		for (int i = 0; i < bytes.length; i++)
		{
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}


	private static byte uniteBytes(String src0, String src1) {
		byte b0 = Byte.decode("0x" + src0).byteValue();
		b0 = (byte) (b0 << 4);
		byte b1 = Byte.decode("0x" + src1).byteValue();
		byte ret = (byte) (b0 | b1);
		return ret;
	}

	/**
	 * 十六进制字符串转换成byte[]
	 * @param hexStr
	 * @return
	 */
	public static byte[] hexStrToBytesForDes3(String hexStr) {

		// 因为3DES是对称加密算法，key是24位，当只有16位时，后8位取key的前8位
		StringBuffer sb=new StringBuffer(hexStr);
		sb.append(hexStr.substring(0,16));//字符串是16位， 就是8位byte
		hexStr=sb.toString();

		// 转换的过程
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return bytes;
	}



	/**
	 * bytes转换成十六进制字符串
	 */
	public static String byteToHexStr(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	/**
	 * 组合字节
	 * @param src0
	 * @param src1
	 * @return
	 */
	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

	/**
	 * 单字节异或
	 *
	 * @param src1
	 * @param src2
	 * @return
	 */
	public static byte byteXOR(byte src1, byte src2) {
		return (byte) ((src1 & 0xFF) ^ (src2 & 0xFF));
	}

	/**
	 * 字节数组异或
	 *
	 * @param src1
	 * @param src2
	 * @return
	 */
	public static byte[] bytesXOR(byte[] src1, byte[] src2) {
		int length = src1.length;
		if (length != src2.length) {
			return null;
		}
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			result[i] = byteXOR(src1[i], src2[i]);
		}
		return result;
	}
	/**
	 * bcd压缩
	 * @param s
	 * @return
	 */
	public static byte[] str2cbcd(String s) {
		if (s.length() % 2 != 0) {
			s = "0" + s;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i += 2) {
			int high = cs[i] - 48;
			int low = cs[i + 1] - 48;
			baos.write(high << 4 | low);
		}
		return baos.toByteArray();
	}
	/**
	 * bcd解压
	 * @param b
	 * @return
	 */
	public static String cbcd2string(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			int h = ((b[i]&0xff) >> 4) + 48;
			sb.append((char) h);
			int l = (b[i] & 0x0f) + 48;
			sb.append((char) l);
		}
		return sb.toString();
	}
	/**
	 * bcd压缩后的字符串
	 * @param s
	 * @return
	 */
	public static String str2cbcdstr(String s){
		return new String(str2cbcd(s));
	}
}
