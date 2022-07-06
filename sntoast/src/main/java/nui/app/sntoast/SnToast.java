package nui.app.sntoast;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SnToast {

    private LinearLayout toastLayout;
    private ImageView toastIcon;
    private TextView toastMessage;

    private void init (
        @NonNull Context context,
        @NonNull String message,
        @Nullable Type type,
        @Nullable Typeface typeface,
        boolean animation,
        boolean cancelable,
        int duration,
        int textSize,
        int iconSize,
        int backgroundColor,
        int textColor,
        int icon
    ) {
        
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(cancelable);
        dialog.setContentView(R.layout.toast_layout);
        toastLayout = dialog.findViewById(R.id.toast_layout);
        toastIcon = dialog.findViewById(R.id.toast_icon);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) toastIcon.getLayoutParams();
        params.width = dpToPx(iconSize, context);
        params.height = dpToPx(iconSize, context);
        toastIcon.setLayoutParams(params);

        toastMessage = dialog.findViewById(R.id.toast_msg);
        toastMessage.setText(message);

        toastMessage.setTextSize(textSize);
        toastMessage.setTypeface(typeface);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setAttributes(wlp);

        if (type == null)
            setCustomDesign(backgroundColor, textColor, icon, context);
        else
            setDesign(type, context);

        if (animation)
            startAnimation();

        dialog.show();

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (dialog.isShowing())
                dialog.dismiss();
        }, duration);

    }

    private void setDesign(@NonNull Type type, @NonNull Context context) {
        if (Type.INFORMATION == type) {
            toastLayout.setBackgroundColor(context.getColor(R.color.infoColor));
            toastIcon.setImageResource(R.drawable.ic_information);
        } else if (Type.ERROR == type) {
            toastLayout.setBackgroundColor(context.getColor(R.color.errorColor));
            toastIcon.setImageResource(R.drawable.ic_error);
        } else if (Type.SUCCESS == type) {
            toastLayout.setBackgroundColor(context.getColor(R.color.successColor));
            toastIcon.setImageResource(R.drawable.ic_success);
        } else if (Type.WARNING == type) {
            toastLayout.setBackgroundColor(context.getColor(R.color.warningColor));
            toastIcon.setImageResource(R.drawable.ic_warning);
        }
    }

    private void setCustomDesign(int backgroundColor, int textColor, int icon, @NonNull Context context) {
        toastMessage.setTextColor(context.getColor(textColor));
        toastLayout.setBackgroundColor(context.getColor(backgroundColor));
        toastIcon.setImageResource(icon);
    }

    private void startAnimation() {
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                toastIcon,
                PropertyValuesHolder.ofFloat("scaleX", 1.1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.1f));
        scaleDown.setDuration(500);
        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.start();
    }

    private int dpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public static class Standard {
        private Context context;
        private String message;
        private Type type;
        private Typeface typeface = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
        private boolean animation = true;
        private boolean cancelable = false;
        private int duration = 3000;
        private int textSize = 18;
        private int iconSize = 34;

        public Standard() {
        }

        public Standard context(Context context) {
            this.context = context;
            if (context == null)
                throw new AssertionError("SnToast - Context cannot be null !!!");
            else
                return this;
        }

        public Standard message(String message) {
            this.message = message;
            if (message == null)
                throw new AssertionError("SnToast - Message cannot be null !!!");
            else
                return this;
        }

        public Standard type(Type type) {
            this.type = type;
            if (type == null)
                throw new AssertionError("SnToast - Type cannot be null !!!");
            else
                return this;
        }

        public Standard typeface(Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        public Standard animation(boolean animation) {
            this.animation = animation;
            return this;
        }

        public Standard cancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Standard duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Standard textSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Standard iconSize(int iconSize) {
            this.iconSize = iconSize;
            return this;
        }

        public void build() {
            if (context == null)
                throw new AssertionError("Context assignment is required.");
            if (message == null)
                throw new AssertionError("Message assignment is required.");
            if (type == null)
                throw new AssertionError("Type assignment is required.");

            SnToast snToast = new SnToast();
            snToast.init(context, message, type, typeface, animation, cancelable,
                    duration, textSize, iconSize, 0, 0, 0);
        }
    }

    public static class Custom {
        private Context context;
        private String message;
        private int backgroundColor = 0;
        private int textColor = 0;
        private int icon = 0;
        private Typeface typeface = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
        private boolean animation = true;
        private boolean cancelable = false;
        private int duration = 3000;
        private int textSize = 18;
        private int iconSize = 34;


        public Custom() {
        }

        public Custom context(Context context) {
            this.context = context;
            if (context == null)
                throw new AssertionError("SnToast - Context cannot be null !!!");
            return this;
        }

        public Custom message(String message) {
            this.message = message;
            if (message == null)
                throw new AssertionError("SnToast - Message cannot be null !!!");
            else
                return this;
        }

        public Custom backgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            if (backgroundColor == 0)
                throw new AssertionError("SnToast - BackgroundColor cannot be null !!!");
            else
                return this;
        }

        public Custom textColor(int textColor) {
            this.textColor = textColor;
            if (textColor == 0)
                throw new AssertionError("SnToast - TextColor cannot be null !!!");
            else
                return this;
        }

        public Custom icon(int icon) {
            this.icon = icon;
            if (icon == 0)
                throw new AssertionError("SnToast - Icon cannot be null !!!");
            else
                return this;
        }

        public Custom typeface(Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        public Custom animation(boolean animation) {
            this.animation = animation;
            return this;
        }

        public Custom cancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Custom duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Custom textSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Custom iconSize(int iconSize) {
            this.iconSize = iconSize;
            return this;
        }

        public void build() {
            if (context == null)
                throw new AssertionError("SnToast - Context assignment is required.");
            if (message == null)
                throw new AssertionError("SnToast - Message assignment is required.");
            if (backgroundColor == 0)
                throw new AssertionError("SnToast - BackgroundColor assignment is required.");
            if (textColor == 0)
                throw new AssertionError("SnToast - TextColor assignment is required.");
            if (icon == 0)
                throw new AssertionError("SnToast - Icon assignment is required.");

            SnToast snToast = new SnToast();
            snToast.init(context, message, null, typeface, animation, cancelable,
                    duration, textSize, iconSize, backgroundColor, textColor, icon);
        }
    }

}