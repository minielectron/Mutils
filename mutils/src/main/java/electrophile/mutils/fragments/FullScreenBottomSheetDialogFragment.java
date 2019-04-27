package electrophile.mutils.fragments;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.widget.FrameLayout;

/**
 *   Copyright 2019 @author Prakash Sharma
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * This class will simply provide the full screen bottom sheet dialog behaviour
 * But the limitation is that u cannot use the onCreateDialog in child class
 * usage : Extend this fragment and use the onCreateView to create the UI logic
 */

public class FullScreenBottomSheetDialogFragment extends BottomSheetDialogFragment {
    // final keyword will insure that child should not override this method
    @NonNull
    @Override
    final public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        bottomSheetDialog.setOnShowListener(dialog -> {
            BottomSheetDialog dg = (BottomSheetDialog) dialog;
            FrameLayout bottomSheet = dg.findViewById(android.support.design.R.id.design_bottom_sheet);
            BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            BottomSheetBehavior.from(bottomSheet).setSkipCollapsed(true);
            BottomSheetBehavior.from(bottomSheet).setHideable(true);
        });
        setStyle(android.R.style.Theme_Material_Light_NoActionBar_Fullscreen, 0);
        return bottomSheetDialog;
    }
}
