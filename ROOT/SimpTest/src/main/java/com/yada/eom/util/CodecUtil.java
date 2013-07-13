package com.yada.eom.util;

import java.nio.ByteBuffer;

/**
 * Utility class to perform HEX encoding/decoding of values.
 * 
 * @author fengming.jiang
 * 
 */
public class CodecUtil {

	static final char[] HEX_UPPER = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	static final char[] HEX_LOWER = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String hexEncode(byte[] buffer) {
		if (buffer.length == 0) {
			return "";
		}
		int holder = 0;
		char[] chars = new char[buffer.length * 2];
		for (int i = 0; i < buffer.length; i++) {
			holder = (buffer[i] & 0xf0) >> 4;
			chars[i * 2] = HEX_UPPER[holder];
			holder = buffer[i] & 0x0f;
			chars[(i * 2) + 1] = HEX_UPPER[holder];
		}
		return new String(chars);
	}

	public static byte[] hexDecode(String hex) {
		// A null string returns an empty array
		if (hex == null || hex.length() == 0) {
			return new byte[0];
		} else if (hex.length() < 3) {
			return new byte[] { (byte) (Integer.parseInt(hex, 16) & 0xff) };
		}
		// Adjust accordingly for odd-length strings
		int count = hex.length();
		int nibble = 0;
		if (count % 2 != 0) {
			count++;
			nibble = 1;
		}
		byte[] buf = new byte[count / 2];
		char c = 0;
		int holder = 0;
		int pos = 0;
		for (int i = 0; i < buf.length; i++) {
			for (int z = 0; z < 2 && pos < hex.length(); z++) {
				c = hex.charAt(pos++);
				if (c >= 'A' && c <= 'F') {
					c -= 55;
				} else if (c >= '0' && c <= '9') {
					c -= 48;
				} else if (c >= 'a' && c <= 'f') {
					c -= 87;
				}
				if (nibble == 0) {
					holder = c << 4;
				} else {
					holder |= c;
					buf[i] = (byte) holder;
				}
				nibble = 1 - nibble;
			}
		}
		return buf;
	}

	public static String hexEncodeLower(byte[] buffer) {
		if (buffer.length == 0) {
			return "";
		}
		int holder = 0;
		char[] chars = new char[buffer.length * 2];
		for (int i = 0; i < buffer.length; i++) {
			holder = (buffer[i] & 0xf0) >> 4;
			chars[i * 2] = HEX_LOWER[holder];
			holder = buffer[i] & 0x0f;
			chars[(i * 2) + 1] = HEX_LOWER[holder];
		}
		return new String(chars);
	}


	/**
	 * pin �?pinBlock
	 * 
	 * @param pin
	 * @return
	 */
	public static byte[] pin2PinBlock(String pin) {
		int tPinLen = pin.length();
		ByteBuffer allocate = ByteBuffer.allocate(8);
		allocate.put((byte) tPinLen);
		if (tPinLen % 2 == 0) {
			allocate.put(CodecUtil.hexDecode(pin));
		} else {
			allocate.put(CodecUtil.hexDecode(new StringBuilder().append(pin).append("F").toString()));
		}
		for (int i = allocate.position(); i < 8; i++) {
			allocate.put((byte) 0xFF);
		}

		return allocate.array();
	}

	/**
	 * 格式化主账号
	 * 
	 * @param aPan
	 * @return
	 */
	private static byte[] formatPan(String aPan) {
		StringBuilder sb = new StringBuilder();
		int tPanLen = aPan.length();
		for (int i = 0; i < 13 - tPanLen; i++) {
			sb.append("0");
		}
		sb.append(aPan);
		ByteBuffer byteBuffer = ByteBuffer.allocate(8);
		int temp = sb.length() - 13;
		byteBuffer.put((byte) 0x00);
		byteBuffer.put((byte) 0x00);
		byteBuffer.put(CodecUtil.hexDecode(sb.toString().substring(temp, sb.length() - 1)));
		return byteBuffer.array();
	}

	/**
	 * 
	 * @param pin
	 * @param cardNo
	 * @return
	 */
	public static byte[] pin2PinBlockWithCardNO(String pin, String cardNo) {
		byte[] tPinByte = pin2PinBlock(pin);
		byte[] tPanByte = formatPan(cardNo);
		ByteBuffer byteBuffer = ByteBuffer.allocate(8);
		for (int i = 0; i < 8; i++) {
			byteBuffer.put((byte) (tPinByte[i] ^ tPanByte[i]));
		}
		return byteBuffer.array();
	}

}
