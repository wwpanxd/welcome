package com.bootdo.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.binary.Base64;

//使用gzip进行压缩解压
public class GzipUtils {

	// 压缩编码
	public static String ReduceEncode(String primStr) {

		if (primStr == null || primStr.length() == 0)
			return primStr;

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		GZIPOutputStream gzip = null;

		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(primStr.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				try {
					gzip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return Base64.encodeBase64String(out.toByteArray());

	}
	
	public static String gzppp(byte[] data)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;
		GZIPInputStream ginzip = null;
		String decompressed = null;
		
		try {
		in = new ByteArrayInputStream(data);
		ginzip = new GZIPInputStream(in);

		byte[] buffer = new byte[1024];
		int offset = -1;
		while ((offset = ginzip.read(buffer)) != -1) {
			out.write(buffer, 0, offset);
		}
		decompressed = out.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (ginzip != null) {
				try {
					ginzip.close();
				} catch (IOException e) {
				}
			}

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return decompressed;
	}
	
	// 解码解压decompression
	public static String DecodeDecompression(String compressedStr) {
		if (compressedStr == null || compressedStr.equals(""))
			return compressedStr;

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;
		GZIPInputStream ginzip = null;

		byte[] compressed = null;

		String decompressed = null;

		try {
//			compressed = Base64.decode(compressedStr, Base64.DEFAULT);
			compressed = Base64.decodeBase64(compressedStr);
			
			in = new ByteArrayInputStream(compressed);
			ginzip = new GZIPInputStream(in);

			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = ginzip.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ginzip != null) {
				try {
					ginzip.close();
				} catch (IOException e) {
				}
			}

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return decompressed;
	}
}
