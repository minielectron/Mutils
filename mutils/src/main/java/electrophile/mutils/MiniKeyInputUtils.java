package electrophile.mutils;

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


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * This class will provide all the basic utility for keyboard input and touch input , it can be soft input of hard
 */

public class MiniKeyInputUtils {
    //Help to avoid object creation as we are using all class member (static methods)
    private MiniKeyInputUtils() {
        throw new AssertionError();
    }
    /**
     * This method closes the softKeyoboard on Touching anywhere in @Link @param view,
     * This supports in both activity and fragment just pass the context
     * @param view : this is the view group over which the touch will close the soft keyboard input
     * @param context : pass the activity on which we are handling the soft touch input
     * @return
     */

    @SuppressLint("ClickableViewAccessibility")
    public static void hideSoftKeyboarOnTouchOutside(ViewGroup view, final Context context) {
        view.setOnTouchListener((view1, motionEvent) -> {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        });
    }



}
