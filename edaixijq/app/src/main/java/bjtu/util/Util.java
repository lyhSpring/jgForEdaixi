package bjtu.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private static String factoryId;
    private static int regionId;

    public static String getFactoryId() {
        return factoryId;
    }

    public static int getRegionId() {
        return regionId;
    }

    public static void setFactoryId(String factoryId) {
        Util.factoryId = factoryId;
    }

    public static void setRegionId(int regionId) {
        Util.regionId = regionId;
    }
}
