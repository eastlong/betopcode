package com.pitaya.string;

/**
 * @Description: 将整型数字转换为中文大写表示。这个算法会处理从0到任意大（在Java的int类型范围内，即-231-1，但考虑到实际情况，我们主要处理非负整数）的整数，并将其转换为中文大写形式。
 * @Date 2024/10/27 06:02:00
 **/
public class IntegerToChinese {
    private static final String[] CN_NUMBERS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CN_UNITS = {"", "十", "百", "千"};
    private static final String[] CN_BIG_UNITS = {"", "万", "亿", "兆"}; // 扩展到兆以支持更大的数

    // 辅助方法：将小于10000的数字转换为中文
    private static String convertLessThanTenThousand(int num) {
        if (num == 0) {
            return CN_NUMBERS[0];
        }

        StringBuilder sb = new StringBuilder();
        int unitPos = 0;
        boolean zeroFlag = false; // 标记是否遇到了零

        while (num > 0) {
            int digit = num % 10;// 取出最后一位数字
            if (digit != 0) { // 如果数字不为0，才会加入中文，否则遇到0，zeroFlag置为true，然后跳过
                if (zeroFlag) { // 如果之前遇到了零，补一个“零”
                    sb.insert(0, CN_NUMBERS[0]);
                }
                sb.insert(0, CN_NUMBERS[digit] + CN_UNITS[unitPos]); // 拼接数字和单位，比如：八十
                zeroFlag = false; // 因为digit != 0，所以zeroFlag一定要及时更新
            } else {
                zeroFlag = true; // 遇到了零，但不立即添加，因为要考虑连续零的情况
            }
            num /= 10;
            unitPos++;
        }

        // 处理“一十X”的情况，去掉“一”
        if (sb.length() > 1 && sb.charAt(0) == CN_NUMBERS[1].charAt(0) && sb.charAt(1) == CN_UNITS[1].charAt(0)) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    // 主方法：将整型数字转换为中文大写
    public static String numberToChinese(int num) {
        if (num == 0) {
            return CN_NUMBERS[0];
        }

        StringBuilder sb = new StringBuilder();
        int unitPos = 0; // 当前处理的大单位（万、亿、兆）
        boolean zeroFlag = false; // 标记当前段是否为零（用于处理连续的零段）

        while (num > 0) {
            int part = num % 10000;// 取出当前段的数字（每段4位）
            String partInChinese = convertLessThanTenThousand(part);// 将当前段转换为中文

            // 如果当前段不为零，或者之前段为零但当前段不为零（即不是连续的零段），则添加到结果中
            if (!partInChinese.equals(CN_NUMBERS[0]) || !zeroFlag) {
                sb.insert(0, partInChinese + CN_BIG_UNITS[unitPos]);
                zeroFlag = false;
            } else {
                zeroFlag = true; // 当前段为零，标记为连续的零段
            }

            num /= 10000;
            unitPos++;
        }

        // 去掉结果末尾可能存在的“零万”、“零亿”、"零"等
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == CN_NUMBERS[0].charAt(0)) {
            int lastIndex = sb.length() - 1;
            if (lastIndex > 0 && (sb.charAt(lastIndex - 1) == CN_BIG_UNITS[1].charAt(0) || sb.charAt(lastIndex - 1) == CN_BIG_UNITS[2].charAt(0))) {
                sb.delete(lastIndex - 1, sb.length());
            } else {
                sb.deleteCharAt(lastIndex);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] testNumbers = {0, 32567, 1001, 10001, 100000001, 1234567890};

        int[] lessNumbers = {0, 100, 1001, 2345,78,1, 1000};

        for (int num : testNumbers) {
            System.out.println(numberToChinese(num));
        }
    }
}
