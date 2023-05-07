package edu.wm.cs.cs301.gui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Paint;

import java.lang.Integer;

import androidx.annotation.Nullable;

public class MazePanel extends View implements P7PanelS23 {
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;

    public MazePanel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MazePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MazePanel(Context context) {
        super(context);
        init();
    }

    void myTestImage(Canvas c) {
        //
    }

    private void init() {
        paint = new Paint();
        bitmap = Bitmap.createBitmap(400,400, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        //addBackground(0);
    }

    @Override
    public void commit() {
        invalidate(); //Makes panel redraw
    }

    @Override
    public boolean isOperational() {
        return false;
    }

    @Override
    public void setColor(int argb) {
        paint.setColor(argb);
    }

    @Override
    public int getColor() {
        return paint.getColor();
    }

    @Override
    public void addBackground(float percentToExit) {
/*
		gc.setColor(ColorTheme.getColor(MazeColors.FRAME_OUTSIDE));
        gc.fillRect(0, 0, Constants.VIEW_WIDTH, Constants.VIEW_HEIGHT);
        gc.setColor(ColorTheme.getColor(MazeColors.FRAME_MIDDLE));
        gc.fillRect(10, 10, Constants.VIEW_WIDTH-20, Constants.VIEW_HEIGHT-20);
        gc.setColor(ColorTheme.getColor(MazeColors.FRAME_INSIDE));
        gc.fillRect(15, 15, Constants.VIEW_WIDTH-30, Constants.VIEW_HEIGHT-30);
 */
        //Top
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, 200, 200, paint);
        //Bottom
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 200, 200, 200, paint);
    }

    @Override
    public void addFilledRectangle(int x, int y, int width, int height) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, width + x, height + y, paint);
    }

    @Override
    public void addFilledPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        paint.setStyle(Paint.Style.FILL);

        Path path = new Path();
        path.moveTo(xPoints[0], yPoints[0]); //start

        for (int i=1; i < nPoints; i++) {
            path.lineTo(xPoints[i], yPoints[i]); //iterate through points
        }

        path.lineTo(xPoints[0], yPoints[0]); //return back to origin
        canvas.drawPath(path, paint);
    }

    @Override
    public void addPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(xPoints[0], yPoints[0]); //start

        for (int i=1; i < nPoints; i++) {
            path.lineTo(xPoints[i], yPoints[i]); //iterate through points
        }

        path.lineTo(xPoints[0], yPoints[0]); //return back to origin
        canvas.drawPath(path, paint);
    }

    @Override
    public void addLine(int startX, int startY, int endX, int endY) {
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    @Override
    public void addFilledOval(int x, int y, int width, int height) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(x, y, width, height, paint);
    }

    @Override
    public void addArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        Path path = new Path();
        path.addArc(x, y, width, height, startAngle, arcAngle);
        canvas.drawPath(path, paint);
    }

    @Override
    public void addMarker(float x, float y, String str) {
        canvas.drawText(str, x, y, paint);
    }

    @Override
    public void setRenderingHint(P7RenderingHints hintKey, P7RenderingHints hintValue) {
        //TODO
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0,0,  paint);
    }
}
