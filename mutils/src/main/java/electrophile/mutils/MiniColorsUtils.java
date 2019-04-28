package electrophile.mutils;

import android.graphics.Color;

/**
 * Copyright 2019 Prakash Sharma
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


public class MiniColorsUtils {

    private static int color(String color) {
        return Color.parseColor(color);
    }

    public static int getHexColor(String hexStrg) {
        return Color.parseColor(hexStrg);
    }

    public static int getRgbColor(int red, int green, int blue) {
        return Color.rgb(red, green, blue);
    }

    public static final int WHITE = color("#ffffff");
    public static final int IVORY = color("#fffff0");
    public static final int LIGHT_YELLOW = color("#ffffe0");
    public static final int YELLOW = color("#ffff00");
    public static final int SNOW = color("#FFFAFA");
    public static final int FLORAL_WHITE = color("#FFFAF0");

    public static final int LEMON_CHIFFON = color("#FFFACD");
    public static final int CORN_SILK = color("#fff8dc");
    public static final int SEA_SHELL = color("#fff5ee");
    public static final int LAVENDARISH_BLUE = color("#fff0f5");
    public static final int PAPAYA_WHIP = color("#ffffd5");
    public static final int BLANCHED_ALMONDS = color("#FFEBCD");
    public static final int MISTY_ROSE = color("#FFE4E1");
    public static final int BISQUE = color("#FFE4C4");
    public static final int MOCASSIN = color("#FFE4B5");
    public static final int NAVAJO_WHITE = color("#FFDEAD");
    public static final int PEACH_PUFF = color("#FFDAB9");
    public static final int GOLD = color("#FFD700");
    public static final int PINK = color("#FFC0CB");
    public static final int LIGHT_PINK = color("#FFB6C1");
    public static final int ORANGE = color("#FFA500");
    public static final int LIGHT_SALMON = color("#FFA07A");
    public static final int DARK_ORANGE = color("#FF8C00");
    public static final int CORAL = color("#FF7F50");
    public static final int HOT_PINK = color("#FF69B4");
    public static final int TOMATO = color("#FF6347");
    public static final int ORANGE_RED = color("#FF4500");
    public static final int DEEP_PINK = color("#FF1493");
    public static final int MAGENTA = color("#FF00FF");
    public static final int RED = color("#FF0000");
    public static final int OLD_LACE = color("#FDF5E6");
    public static final int LIGHT_GOLDEN_YELLOW = color("#FAFAD2");
    public static final int LINEN = color("#FAF0E6");
    public static final int ANTIQUE_WHITE = color("#FAEBD7");
    public static final int SALMON = color("#FA8072");
    public static final int GHOST_WHITE = color("#F8F8FF");
    public static final int MINT_CREAM = color("#F5FFFA");
    public static final int WHITE_SMOKE = color("#F5F5F5");
    public static final int BEIGE = color("#F5F5DC");
    public static final int WHEAT = color("#F5DEB3");
    public static final int SANDY_BROWN = color("#F4A460");
    public static final int AZURE = color("#F0FFFF");
    public static final int HONEY_DEW = color("#F0FFF0");
    public static final int ALICE_BLUE = color("#F0F8FF");
    public static final int KHAKI = color("#F0E68C");
    public static final int LIGHT_CORAL = color("#F08080");
    public static final int PALE_GOLDEN_ROD = color("#EEE8AA");
    public static final int VIOLET = color("#EE82EE");
    public static final int DARK_SELMON = color("#E9967A");
    public static final int LAVENDAR = color("#E6E6FA");
    public static final int LIGHT_CYAN = color("#E0FFFF");
    public static final int BURLY_WOOD = color("#DEB887");
    public static final int PLUM = color("#DDA0DD");
    public static final int GAINSBORO = color("#DCDCDC");
    public static final int CRIMSON = color("#EE82EE");
    public static final int PLAE_VIOLET_RED = color("#DB7093");
    public static final int GOLDEN_ROD = color("#DAA520");
    public static final int ORCHID = color("#DA70D6");
    public static final int THISTLE = color("#D8BFD8");
    public static final int LIGHT_GREY = color("#D3D3D3");
    public static final int TAN = color("#D2B48C");
    public static final int CHOCOLATE = color("#D2691E");
    public static final int PERU = color("#CD853F");
    public static final int INDIAN_RED = color("#CD5C5C");
    public static final int MediumVioletRed = color("C71585");
    public static final int Silver = color("C0C0C0");
    public static final int DarkKhaki = color("BDB76B");
    public static final int RosyBrown = color("BC8F8F");
    public static final int MediumOrchid = color("BA55D3");
    public static final int DarkGoldenrod = color("B8860B");
    public static final int FireBrick = color("B22222");
    public static final int PowderBlue = color("B0E0E6");
    public static final int LightSteelBlue = color("B0C4DE");
    public static final int PaleTurquoise = color("AFEEEE");
    public static final int GreenYellow = color("ADFF2F");
    public static final int LightBlue = color("ADD8E6");
    public static final int DarkGray = color("A9A9A9");
    public static final int Brown = color("A52A2A");
    public static final int Sienna = color("A0522D");
    public static final int YellowGreen = color("9ACD32");
    public static final int DarkOrchid = color("9932CC");
    public static final int PaleGreen = color("98FB98");
    public static final int DarkViolet = color("9400D3");
    public static final int MediumPurple = color("9370DB");
    public static final int LightGreen = color("90EE90");
    public static final int DarkSeaGreen = color("8FBC8F");
    public static final int SaddleBrown = color("8B4513");
    public static final int DarkMagenta = color("8B008B");
    public static final int DarkRed = color("8B0000");
    public static final int BlueViolet = color("8A2BE2");
    public static final int LightSkyBlue = color("87CEFA");
    public static final int SkyBlue = color("87CEEB");
    public static final int Gray = color("808080");
    public static final int Olive = color("808000");
    public static final int Purple = color("800080");
    public static final int Maroon = color("800000");
    public static final int Aquamarine = color("7FFFD4");
    public static final int Chartreuse = color("7FFF00");
    public static final int LawnGreen = color("7CFC00");
    public static final int MediumSlateBlue = color("7B68EE");
    public static final int LightSlateGray = color("778899");
    public static final int SlateGray = color("708090");
    public static final int OliveDrab = color("6B8E23");
    public static final int SlateBlue = color("6A5ACD");
    public static final int DimGray = color("696969");
    public static final int MediumAquamarine = color("66CDAA");
    public static final int CornflowerBlue = color("6495ED");
    public static final int CadetBlue = color("5F9EA0");
    public static final int DarkOliveGreen = color("556B2F");
    public static final int Indigo = color("4B0082");
    public static final int MediumTurquoise = color("48D1CC");
    public static final int DarkSlateBlue = color("483D8B");
    public static final int SteelBlue = color("4682B4");
    public static final int RoyalBlue = color("4169E1");
    public static final int Turquoise = color("40E0D0");
    public static final int MediumSeaGreen = color("3CB371");
    public static final int LimeGreen = color("32CD32");
    public static final int DarkSlateGray = color("2F4F4F");
    public static final int SeaGreen = color("2E8B57");
    public static final int ForestGreen = color("228B22");
    public static final int LightSeaGreen = color("20B2AA");
    public static final int DodgerBlue = color("1E90FF");
    public static final int MidnightBlue = color("191970");
    public static final int Aqua = color("00FFFF");
    public static final int Cyan = color("00FFFF");
    public static final int SpringGreen = color("00FF7F");
    public static final int Lime = color("00FF00");
    public static final int MediumSpringGreen = color("00FA9A");
    public static final int DarkTurquoise = color("00CED1");
    public static final int DeepSkyBlue = color("00BFFF");
    public static final int DarkCyan = color("008B8B");
    public static final int Teal = color("008080");
    public static final int Green = color("008000");
    public static final int DarkGreen = color("006400");
    public static final int Blue = color("0000FF");
    public static final int MediumBlue = color("0000CD");
    public static final int DarkBlue = color("00008B");
    public static final int Navy = color("000080");
    public static final int Black = color("000000");

}
