package tororo1066.musiccreateplugin.Utils;

import org.bukkit.Material;

public class BaseUtils {

    public static boolean isInt(String testing){
        try{
            Integer.parseInt(testing);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isFloat(String testing){
        try{
            Float.valueOf(testing);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isDouble(String testing){
        try{
            Double.valueOf(testing);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isLong(String testing){
        try{
            Long.valueOf(testing);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isBoolean(String testing){
        return "true".equalsIgnoreCase(testing) || "false".equalsIgnoreCase(testing);
    }

    public static String priceString(int price){
        return String.format("%,d", price);
    }

    public static String booleanToJapaneseText(boolean bool){
        if(bool){
            return "有効";
        }
        return "無効";
    }


    public static String weekToString(int week){
        return new String[]{"日曜日", "月曜日", "火曜日", "水曜日","木曜日", "金曜日", "土曜日"}[week];
    }

}
