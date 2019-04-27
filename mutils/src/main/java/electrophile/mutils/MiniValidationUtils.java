package electrophile.mutils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.TextView;

import java.util.regex.Pattern;

/**
 * Copyright 2019 @author Prakash Sharma
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


public class MiniValidationUtils {

    //This will provide the role of Marker Interface for text watcher
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

    public boolean isValidPhone(CharSequence phoneNumber) {
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

    public boolean isValidEmail(CharSequence emailId) {
        return !TextUtils.isEmpty(emailId) &&
                Patterns.EMAIL_ADDRESS.matcher(emailId).matches();
    }

    /**
     * This will return the valid name with unicode standard and having length greater than or equal to 3
     */
    public boolean isValidName(String name) {
        return !TextUtils.isEmpty(name) && Pattern.matches("^[\\p{L} .'-]+$", name) && name.length() >= 3;
    }

    //This will validate the indian sixDigit Pin code
    public boolean isValidPincode(String pincode) {
        return !TextUtils.isDigitsOnly(pincode) && pincode.length() == 6 && !TextUtils.isEmpty(pincode);
    }

}
