package electrophile.mutils.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.DialogFragment;
import android.widget.FrameLayout;

public class FullScreenBottomSheetDialogFragment  extends BottomSheetDialogFragment {
    // final will insure that child should not override this method
    @Override
    final public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog=(BottomSheetDialog)super.onCreateDialog(savedInstanceState);
        bottomSheetDialog.setOnShowListener(dialog -> {
            BottomSheetDialog dg = (BottomSheetDialog) dialog;
            FrameLayout bottomSheet =  dg.findViewById(android.support.design.R.id.design_bottom_sheet);
            BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            BottomSheetBehavior.from(bottomSheet).setSkipCollapsed(true);
            BottomSheetBehavior.from(bottomSheet).setHideable(true);
        });
        setStyle(android.R.style.Theme_Material_Light_NoActionBar_Fullscreen,0);
        return bottomSheetDialog;
    }
}
