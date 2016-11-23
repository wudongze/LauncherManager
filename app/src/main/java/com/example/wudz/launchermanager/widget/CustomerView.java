package com.example.wudz.launchermanager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.wudz.launchermanager.R;

/**
 * USER：wudz on 2016/11/21 14:31
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class CustomerView extends View {
    private Paint paint;
    private Path path;
    private Point startPoint, endPoint, assistPoint;

    public CustomerView(Context context) {
        super(context);
    }

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        path = new Path();
        startPoint = new Point(0, 500);
        endPoint = new Point(200, 500);
        assistPoint = new Point(100, 300);
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(getContext().getResources().getColor(R.color.colorAccent));
        paint.setStrokeWidth(4.0f);
        paint.setStyle(Paint.Style.STROKE);
        path.reset();
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
//        path.moveTo(startPoint.x, startPoint.y);
//        path.quadTo(assistPoint.x, assistPoint.y, endPoint.x, endPoint.y);
//        canvas.drawPath(path, paint);
//        canvas.drawPoint(assistPoint.x, assistPoint.y, paint);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.ic_menu_camera);
        for (int i = 0; i < 5; i++) {
            float y = 700f;
            if (i % 2 == 0) {
                y = 700f;
            } else {
                y = 300f;
            }

            path.moveTo(i * (width / 5), 500);
            path.quadTo((2 * i * (width / 5) + width / 5) / 2, y, i * (width / 5) + (width / 5), 500);
            canvas.drawPath(path, paint);
            canvas.drawPoint((i * 200 + 100), y, paint);
            TranslateAnimation animation = new TranslateAnimation(i * (width / 5), (2 * i * (width / 5) + width / 5) / 2, 500, y);
            animation.setDuration(3000);
            animation.setRepeatCount(Animation.INFINITE);//循环显示
            animation.setFillAfter(true);//当动画结束后 动画停留在结束位置
            imageView.startAnimation(animation);
        }
    }
}
