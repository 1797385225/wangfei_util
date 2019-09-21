package com.wangfei.utils;

import java.util.HashSet;
import java.util.Random;

public class RandomUtil {
	/**
	 * 
	 * @Title: random
	 * @Description: //方法1：返回min-max之间的随机整数（包含min和max值），
	 *               例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分) //min =1 max =3
	 * @param min
	 * @param max
	 * @return
	 * @return: int
	 */
	public static int random(int min, int max) {
		Random r = new Random();
		int i = r.nextInt(max - min + 1) + min;

		return i;
	}

	/**
	 * 
	 * @Title: subRandom
	 * @Description: //方法2：在最小值min与最大值max之间截取subs个不重复的随机数。
	 *               例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。
	 *               //应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
	 * @param min
	 * @param max
	 * @param subs
	 * @return
	 * @return: int[]
	 */
	// 1~~10
	public static int[] subRandom(int min, int max, int subs) {
		// 创建要截取的随机的个人数的数组
		int dest[] = new int[subs];
		// 定义set.用来过滤重复的数据
		HashSet<Integer> set = new HashSet<Integer>(subs);
		// 循环产生随机数,直到集合满足个数
		while (set.size() != subs) {
			set.add(random(min, max));
		}
		// 遍历set放入数组
		int i = 0;
		for (Integer integer : set) {
			dest[i] = integer;
			i++;
		}

		return dest;
	}

	/**
	 * 
	 * @Title: randomCharacter
	 * @Description: //方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
	 * @return
	 * @return: char
	 */
	public static char randomCharacter() {
		// 定义1-9,a-Z的字符
		String str = "123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		return str.charAt(random(0, str.length() - 1));

	}

	/**
	 * 
	 * @Title: randomString
	 * @Description: //方法4：返回参数length个字符串(5分)， 方法内部要调用randomCharacter()方法 (4分)
	 * @param length
	 * @return
	 * @return: String
	 */
	public static String randomString(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += randomCharacter();
		}
		return str;

	}

}
