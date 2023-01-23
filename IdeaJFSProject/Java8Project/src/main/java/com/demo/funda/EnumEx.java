package com.demo.funda;

import java.io.Serializable;

//INSTANT PRACTICE : STORE ANY 5 LANGUAGES IN ENUM AND PRINT THEM.
public class EnumEx {
    public static void main(String[] args) {
        ACSetting setting = ACSetting.HUMID;
        System.out.println(setting);
        String settingApplied = setting.toString();
        System.out.println(settingApplied);
        ACSetting setting1 = ACSetting.valueOf("TURBO");
        System.out.println(setting1);
        System.out.println(ACSetting.COOL);
    }
}

interface iTest {

}
//FOR UNDERSTANDING
enum ACSetting implements  iTest, Comparable<ACSetting>, Serializable {
    FAN, DRY, COOL, AUTO, TURBO, HUMID, SPEED
}

//enum ACAdvancedSetting extends ACSetting {
//
//}

