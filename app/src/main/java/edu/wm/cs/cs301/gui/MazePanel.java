package edu.wm.cs.cs301.gui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Paint;


import androidx.annotation.Nullable;

public class MazePanel extends View {
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;

    public MazePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        //init();
    }

    public MazePanel(Context c) {
        this(c, null);
        //init();
    }

    void myTestImage(Canvas c) {

    }

    private void init() {
        paint = new Paint(0);
        paint.setColor(0xFF000000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint = new Paint(0);
        paint.setColor(Color.BLUE);

        float left = 0, top = 0; // basically (X1, Y1)

        float right = left + 400; // width (distance from X1 to X2)
        float bottom = top + 400; // height (distance from Y1 to Y2)

        RectF Rect = new RectF(left, top, right, bottom);
        canvas.drawRect(Rect, paint);
    }



}
