package electrophile.mutils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.TextView;

import java.util.regex.Pattern;

/**
 * Copyright 2019 Prakash Sharma
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

public class MiniValidationUtils {

    //Helps to stop child creation
    private MiniValidationUtils() {
        throw new AssertionError();
    }

    /**
     *   This will provide the role of Marker Interface for text watcher
     */

    public abstract static class EditTextValidator implements TextWatcher {

        private TextView input;

        public EditTextValidator(TextView input) {
            this.input = input;
        }

        /**
         * This method we will implement in our class or activity.
         * @param text : this is the EditText or TextView instance on which validation to be performed
         * @param str  : This is the text to be validated
         */
        public abstract void validate(TextView text, String str);


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //Do nothing, as not required now
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Do nothing, as not required now
        }

        @Override
        public void afterTextChanged(Editable s) {
            String inputText = input.getText().toString();
            validate(input, inputText);
        }
    }

    /**
     * This method check the valid phone network
     * @param phoneNumber : Give input as phone number string
     * @return boolean
     */

    public static boolean isValidPhone(CharSequence phoneNumber) {
        ////matches numbers only
        //String regexStr = "^[0-9]*$"
        //
        ////matches 10-digit numbers only
        String regexStr = "^[0-9]{10}$";
        //
        ////matches numbers and dashes, any order really.
        //String regexStr = "^[0-9\\-]*$"
        //
        ////matches 9999999999, 1-999-999-9999 and 999-999-9999
        //String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$"
        //Patterns.PHONE.matcher(phoneNumber);

        return !TextUtils.isEmpty(phoneNumber) &&
                Pattern.matches(regexStr, phoneNumber);
    }

    /**
     * This validates the email id
     * @param emailId : Provide the email string
     * @return boolean
     */
    public static boolean isValidEmail(CharSequence emailId) {
        return !TextUtils.isEmpty(emailId) &&
                Patterns.EMAIL_ADDRESS.matcher(emailId).matches();
    }

    /**
     * This will return the valid name with unicode standard and having length greater than or equal to 3
     * @param name : provide the name string
     * @return boolean;
     */
    public static boolean isValidName(String name) {
        return !TextUtils.isEmpty(name) && Pattern.matches("^[\\p{L} .'-]+$", name) && name.length() >= 3;
    }

    /**
     *    This will validate the indian sixDigit Pin code
     * @param pincode : Provide the pincode as input
     * @return boolean;
     */

    public static boolean isValidPincode(String pincode) {
        return TextUtils.isDigitsOnly(pincode) && pincode.length() == 6 && !TextUtils.isEmpty(pincode);
    }

}
