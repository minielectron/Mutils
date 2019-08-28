package electrophile.mutils.components;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import electrophile.mutils.R;

public class BottomMenuHelper {
    public static void showBadgeRed(Context context, BottomNavigationView bottomNavigationView, @IdRes int itemId, String value) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        View badge = LayoutInflater.from(context).inflate(R.layout.badge_item_layout, bottomNavigationView, false);
        TextView text = badge.findViewById(R.id.badge_text_view);
        text.setText(value);
        if (itemView != null)
            itemView.addView(badge);
    }

    public static void showBadgeBlue(Context context, BottomNavigationView bottomNavigationView, @IdRes int itemId, String value) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        View badge = LayoutInflater.from(context).inflate(R.layout.badge_item_layout_blue, bottomNavigationView, false);
        TextView text = badge.findViewById(R.id.badge_text_view);
        text.setText(value);
        if (itemView != null)
            itemView.addView(badge);
    }

    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }

}
