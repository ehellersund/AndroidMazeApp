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

public class MazePanel extends View implements P7PanelS23 {
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;

    public MazePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        //init();
        //myTestImage(canvas);
    }

    public MazePanel(Context c) {
        this(c, null);
        //init();
        //myTestImage(canvas);
    }

    void myTestImage(Canvas c) {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(0, 0, 300, 300, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(50, 50, 450,450, paint);
        paint.setColor(Color.BLUE);
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


    @Override
    public void commit() {

    }

    @Override
    public boolean isOperational() {
        return false;
    }

    @Override
    public void setColor(int argb) {

    }

    @Override
    public int getColor() {
        return 0;
    }

    @Override
    public void addBackground(float percentToExit) {

    }

    @Override
    public void addFilledRectangle(int x, int y, int width, int height) {

    }

    @Override
    public void addFilledPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void addPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void addLine(int startX, int startY, int endX, int endY) {

    }

    @Override
    public void addFilledOval(int x, int y, int width, int height) {

    }

    @Override
    public void addArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

    }

    @Override
    public void addMarker(float x, float y, String str) {

    }

    @Override
    public void setRenderingHint(P7RenderingHints hintKey, P7RenderingHints hintValue) {

    }
}
