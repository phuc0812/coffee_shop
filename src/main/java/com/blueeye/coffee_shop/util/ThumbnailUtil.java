package com.blueeye.coffee_shop.util;

import java.util.Arrays;
import java.util.Base64;

public class ThumbnailUtil {
    public byte[] toByteArray(String str){
        return str.getBytes();
    }

    public String toString(byte[] bytes){
        return new String(bytes);
    }
}
