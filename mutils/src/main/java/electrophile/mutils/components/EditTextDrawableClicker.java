package electrophile.mutils.components;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public abstract class EditTextDrawableClicker implements View.OnTouchListener {

    private TextView editText;
    final public static int DRAWABLE_LEFT = 0;
    final public static int DRAWABLE_TOP = 1;
    final public static int DRAWABLE_RIGHT = 2;
    final public static int DRAWABLE_BOTTOM = 3;
    private int drawablePosition;

    public EditTextDrawableClicker(TextView editText,int drawablePosition) {
        this.editText = editText;
        this.drawablePosition = drawablePosition;
    }

    public abstract void onClick();

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_UP) {
            if(event.getRawX() >= (editText.getRight() - editText.getCompoundDrawables()[drawablePosition].getBounds().width())) {
                onClick();
                return true;
            }
        }
        return false;
    }
}
