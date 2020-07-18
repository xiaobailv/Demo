package com.liushihao.util;


import com.liushihao.entity.TLV;

import java.util.List;

public class TLVData {	
	
	// zhao add 给字符串后面补足空格， len 填充后的总长度 , 如果len小于数据本身总长度，则返回原字符串 
	public static String getStringFilledBlank(String str,int len){
		
		for(int i = str.length(); i < len; i++){
			str += " ";
		}			
		return str;
	}
	
	// zhao 获取55域具体某一个tag的值，入口参数是 55域数据和具体的tag值，均为ascii码 
	public static String getTagValue(String strf55,String strTag) {
		
		String strTagValue = null;
		
		strf55 = strf55.toUpperCase();

		List<TLV> list = SAXUnionFiled55Utils.saxUnionField55_2List(strf55);

		for (TLV tlv : list) {

			if (tlv.getTag().equals(strTag)) {
				strTagValue = tlv.getValue();
				break;
			}
		}		
		return strTagValue;
	}
	

	public static String getARQCString(String strf55) {

		String strAQRC = null;

		String str9F02 = null;
		String str9F03 = null;
		String str9F1A = null;
		String str95 = null;
		String str5F2A = null;
		String str9A = null;
		String str9C = null;
		String str9F37 = null;
		String str82 = null;
		String str9F36 = null;
		String str9F10 = null;

		strf55 = strf55.toUpperCase();

		List<TLV> list = SAXUnionFiled55Utils.saxUnionField55_2List(strf55);

		for (TLV tlv : list) {
			//System.out.println(tlv);

			if (tlv.getTag().equals("9F02")) {
				str9F02 = tlv.getValue();
			}

			if (tlv.getTag().equals("9F03")) {
				str9F03 = tlv.getValue();
			}

			if (tlv.getTag().equals("9F1A")) {
				str9F1A = tlv.getValue();
			}

			if (tlv.getTag().equals("95")) {
				str95 = tlv.getValue();
			}

			if (tlv.getTag().equals("5F2A")) {
				str5F2A = tlv.getValue();
			}

			if (tlv.getTag().equals("9A")) {
				str9A = tlv.getValue();
			}
			if (tlv.getTag().equals("9C")) {
				str9C = tlv.getValue();
			}

			if (tlv.getTag().equals("9F37")) {
				str9F37 = tlv.getValue();
			}

			if (tlv.getTag().equals("82")) {
				str82 = tlv.getValue();
			}

			if (tlv.getTag().equals("9F36")) {
				str9F36 = tlv.getValue();
			}

			if (tlv.getTag().equals("9F10")) {
				str9F10 = tlv.getValue();
			}
		}

		strAQRC = str9F02 + str9F03 + str9F1A + str95 + str5F2A + str9A + str9C + str9F37 + str82 + str9F36
				+ str9F10.substring(6, 14);
		return strAQRC;
	}
	
	public static String getTermInfoString(String str) {
//		deviceType=02|serialNum=G8101030755|encryptRandNum=269314|appVersion=20170614

		StringBuilder termInfo = new StringBuilder();

		str = str.toUpperCase();

		List<TLV> list = SAXUnionFiled55Utils.saxUnionField55_2List(str);

		for (TLV tlv : list) {

			if (tlv.getTag().equals("04")) {
				termInfo.append("deviceType=").append(ByteUtils.hexStr2Str(tlv.getValue())).append("|");
			}

			if (tlv.getTag().equals("05")) {
				termInfo.append("serialNum=").append(ByteUtils.hexStr2Str(tlv.getValue())).append("|");
			}

			if (tlv.getTag().equals("06")) {
				termInfo.append("encryptRandNum=").append(ByteUtils.hexStr2Str(tlv.getValue())).append("|");
			}

			if (tlv.getTag().equals("08")) {
				termInfo.append("appVersion=").append(ByteUtils.hexStr2Str(tlv.getValue())).append("|");
			}

		}
		
		termInfo.deleteCharAt(termInfo.length()-1);
		return termInfo.toString();
	}
	
//	public static void main(String[] args) {
//		String s = "413230333504023032050B4738313031303330373535060633383634333408083230313730363134";
//		String s1 = s.substring(10);
//		
//		System.out.println(getTermInfoString(s1));
//	}
//	
	
	public static void main(String[] args) {
		String s1 = "413230333504023032050B4738313031303330373535060635363834323408083230313730363134";
		
		for(int pos=0;pos<s1.length();){
			String tag = ByteUtils.hexStr2Str(s1.substring(pos,pos+4));
			pos += 4;
			System.out.println("tag:"+tag);
			String tagLen = ByteUtils.hexStr2Str(s1.substring(pos, pos+6));
			System.out.println("tagLen:"+tagLen);
			pos += 6;
			String tagContent = s1.substring(pos, pos + Integer.valueOf(tagLen)*2);
			System.out.println("tagContent:"+tagContent);
			pos += Integer.valueOf(tagLen)*2;

			if("A2".equals(tag)){
				System.out.println(getTermInfoString(tagContent));
			}
		}
		
		
	}
}
